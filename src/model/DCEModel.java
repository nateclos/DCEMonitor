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
		indexFile();
		
	}
	
	private void indexFile() throws FileNotFoundException {
		
		Scanner s = new Scanner(this.file);
		s.nextLine();
		while(s.hasNextLine()) {
			
			String line = s.nextLine();
						
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
		
	}
	
	public ArrayList<Pdu> getAllPdus() {
		
		ArrayList<Pdu> res = new ArrayList<Pdu>();
		for(String name : pdus.keySet()) {
			Pdu curr = pdus.get(name);
			res.add(curr);
		}
		return res;
	}
	
	public ArrayList<Pdu> getHighPdus() {
		
		ArrayList<Pdu> res = new ArrayList<Pdu>();
		for(String name : pdus.keySet()) {
			Pdu curr = this.pdus.get(name);
			if(curr.getReading() > 10.0) res.add(curr);
		}
		return res;
	}
	
}