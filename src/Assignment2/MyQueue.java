package Assignment2;
import java.util.*;
import java.io.*;
public class MyQueue {
	/*
	 * the MyQueue class contains the data structure that works with the playlist linked list
	 * contains references to a File and a linked list playlist
	 * the no-arg constructor is used for the large MyQueue containing all the data across all the MyQueues
	 * the other constructor is used to build the small MyQueues with a String that instantiates file
	 */
	private File file;
	PlayList playlist;
	public MyQueue() {
		playlist = new PlayList();
	}
	public MyQueue(String filename) {
		file = new File(filename);
		playlist = new PlayList();
	}
	/*
	 * the read() method reads in data line by line from the file
	 * the data is used to create song objects for playlist
	 */
	public void read() throws FileNotFoundException {
		int i = 0;
		Scanner cFile = new Scanner(file);
		String[][] myList = new String[200][5];
		while(cFile.hasNext()) {
			String line = cFile.nextLine();
		    String line2 = line.replaceAll(", ", " ");
		    String line3 = line2.replaceAll(",0", "0");
		    if(line3 != null) {
		    String[] rows = line3.split(",");
		    for (int w = 0; w < rows.length; w++) {	    	  
		    	  myList[i][w] = rows[w];
		    	  Song song = new Song(myList[i][2], myList[i][1], myList[i][3]);
		    	  playlist.addSong(song);
		    }
		    i++;
		    }
		}
	}
	//getter for size
	public int getSize() {
		return playlist.size();
	}
	//getter for playlist
	public PlayList getPlayList() {
		return playlist;
	}
	//setter for playlist
	public void setPlayList(PlayList p) {
		playlist = p;
	}
	//print method removes a song from playlist and prints it to a text file
	//while loop prints out the whole list
	public void print(PrintWriter outputFile) {
		while (playlist.isEmpty() == false) {
			Song current = playlist.listenToSong();
			current.displaySong(outputFile);
		}
	}
	/*
	 * methods for adding and removing songs
	 */
	public void add(Song s) {
		playlist.addSong(s);
	}
	public void remove() {
		playlist.listenToSong();
	}
	//boolean method to determine if the playlist is empty or not
	public boolean isEmpty() {
		return playlist.isEmpty();
	}
	
}
	
	 

