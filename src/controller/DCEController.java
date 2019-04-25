package controller;

import java.io.File;
import java.io.FileNotFoundException;

import model.DCEModel;

public class DCEController {
	
	private DCEModel model;
	
	public DCEController() {
		
		
	}
	
	public boolean readFile(File newFile) throws FileNotFoundException {
		
		if(newFile.exists()) {
			this.model = new DCEModel(newFile);
			
		}
		return false;
	}
}