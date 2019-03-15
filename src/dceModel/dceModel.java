package dceModel;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class dceModel {
	
	String fname;
	
	public dceModel(String fileName) throws FileNotFoundException {
		
		this.fname = fileName;
		Scanner s = new Scanner(new File(fname));
		String[] line = s.nextLine().split(",");
		System.out.println(Arrays.toString(line));
		line = s.nextLine().split(",");
		System.out.println(Arrays.toString(line));
	}
	
}