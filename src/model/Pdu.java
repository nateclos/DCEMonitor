package model;

public class Pdu {
		
		private String name, datetime;
		private float currReading;
		
		public Pdu(String name, String datetime, float currReading) {
			
			this.name = name;
			this.datetime = datetime;
			this.currReading = currReading;
			
		}
		
		public String toString() {
			
			String res = "";
			return res += "Name: " + this.getName() + " Date & Time: " + this.getDateTime() + " Amps: " + this.getReading();
			
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