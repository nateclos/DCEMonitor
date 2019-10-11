package controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

import model.DCEModel;
import model.Pdu;

public class DCEController {
	
	private DCEModel model;
	
	public void readFile(File newFile) throws FileNotFoundException {
	
		this.model = new DCEModel(newFile);
		
	}
	
	public String getHighReadings() {
		
		if(this.model == null) return "A report has not yet been indexed";
		
		List<Pdu> highs = model.getHighPdus();
		String res = "PDUs over the 10 amp threshold:\n";
		int objNum = 1;
		for(Pdu curr : highs) {
			res += objNum++ + ": " + curr.toString() + "\n";
		}
		if(highs.isEmpty()) res = "There are no PDUs which are over the 10 amp threshold\n";
		return res;
	}
	
	public String getAllReadings() {
		
		if(this.model == null) return "A report has not yet been indexed";
		
		List<Pdu> highs = model.getAllPdus();
		String res = "Highest reading for each PDU:\n";
		int objNum = 1;
		for(Pdu curr : highs) {
			res += objNum++ + ": " + curr.toString() + "\n";
		}
		return res;
	}
	
}