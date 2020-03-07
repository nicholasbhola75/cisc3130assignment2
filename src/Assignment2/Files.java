package Assignment2;
import java.util.*;
import java.io.*;
/*
 * Arraylist data structure of filenames for csv files containing data on viral songs for WeeklyQueue
 * addFilename() adds filenames contained in the name reference into the arraylist
 * getSize() returns how many filenames are contained in the method
 * getFileName() returns the file at index i
 */
public class Files {
	private ArrayList<String> inputFiles;
	public Files() {
		inputFiles = new ArrayList<>();
	}
	public void addFileName(String name) {
		inputFiles.add(name);
	}
	public int getSize() {
		return inputFiles.size();
	}
	public String getFileName(int i) {
		return inputFiles.get(i);
	}
}
