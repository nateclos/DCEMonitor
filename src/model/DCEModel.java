package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class DCEModel {
	
	String fname;
	
	public DCEModel(String fileName) throws FileNotFoundException {
		
		this.fname = fileName;
		Scanner s = new Scanner(new File(fname));
		String[] line = s.nextLine().split(",");
		System.out.println(Arrays.toString(line));
		line = s.nextLine().split(",");
		System.out.println(Arrays.toString(line));
	}
	
	private class pdu {
		
		private String name, ip, time;
		private int currReading;
		
		public pdu(String name, String ip, String time, int currReading) {
			
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