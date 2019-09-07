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
			
			String datetime = elements[5] + ' ' + elements[6];
			
			float amps = Float.valueOf(elements[7].substring(1,elements[7].length() - 1));
			
			System.out.println(amps);
			
			
		}
	}
	
	private class Pdu {
		
		private String name, ip, time;
		private int currReading;
		
		public Pdu(String name, String ip, String time, int currReading) {
			
			this.name = name;
			this.ip = ip;
			this.time = time;
			this.currReading = currReading;
			
		}
		
		public String getName() {
			
			return this.name;
			
		}
		
		public String getIp() {
			
			return this.ip;
			
		}
		
		public String getTime() {
			
			return this.time;
			
		}
		
		public int getReading() {
			
			return this.currReading;
			
		}
		
		public void setTime(String time) {
			
			this.time = time;
			
		}
		
		public void setReading(int reading) {
			
			this.currReading = reading;
			
		}
		
	}
	
}