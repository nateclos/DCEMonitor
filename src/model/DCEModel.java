package model;

import java.io.File;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class DCEModel {
	
	File file;
	
	HashMap<String, Pdu> pdus = new HashMap<String, Pdu>();
	
	public DCEModel(File f) throws FileNotFoundException {
		
		this.file = f;
		Scanner s = new Scanner(file);
		
		s.nextLine();
		
		while(s.hasNextLine()) {
			
			String line = s.nextLine();
			
			System.out.println(line);
			
			String [] elements = line.split(",");
			
			String name = elements[0];
			
			String datetime = elements[5] + elements[6];
			
			float amps = Float.valueOf(elements[7].substring(1,elements[7].length() - 1));
			
			if(this.pdus.containsKey(name)) {
				
				Pdu curr = pdus.get(name);
				
				if(curr.getReading() < amps) {
					
					curr.setReading(amps);
					curr.setDateTime(datetime);
				}
				
			} else {
				
				Pdu newPdu = new Pdu(name, datetime, amps);
				this.pdus.put(name, newPdu);
			}
			
		}
		
		for(String name : pdus.keySet()) {
			Pdu curr = pdus.get(name);
			System.out.printf("Name: %s Date and Time: %s Amps: %f\n", curr.getName(), curr.getDateTime(), curr.getReading());
		}
	}
	
	private class Pdu {
		
		private String name, datetime;
		private float currReading;
		
		public Pdu(String name, String datetime, float currReading) {
			
			this.name = name;
			this.datetime = datetime;
			this.currReading = currReading;
			
		}
		
		public String getName() {
			
			return this.name;
			
		}
		
		public String getDateTime() {
			
			return this.datetime;
			
		}
		
		public float getReading() {
			
			return this.currReading;
			
		}
		
		public void setDateTime(String datetime) {
			
			this.datetime = datetime;
			
		}
		
		public void setReading(float reading) {
			
			this.currReading = reading;
			
		}
		
	}
	
}