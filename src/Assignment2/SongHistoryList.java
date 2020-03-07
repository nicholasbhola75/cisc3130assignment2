package Assignment2;
import java.util.*;
import java.io.*;
/*
 * SongHistoryList is a stack that tracks the last song being removed and listed to
 * it uses Song nodes like PlayList
 * Songs are added and removed at the front of the list
 * lastListened() removes the Song at the top of the list and returns it
 * displayList is used to print out the history of the Songs being played
 * isEmpty() tests if the stack is empty or not
 */
public class SongHistoryList {
	private Song first;
	public void SongHistoryList() {
		first = null;
	}
	public void addSong(Song s) {
		s.setNext(first);
		first = s;
	}
	public Song lastListened() {
		Song temp = first;
		first = first.getNext();
		return temp;
	}
	public boolean isEmpty(){
	    return (first == null);
	}
	public void displayList(PrintWriter outputFile) {
		Song current = first;
		while(current != null) {
			current.displaySong(outputFile);
			current = current.getNext();
		}
	}
	public int size() {
		int counter = 0;
		Song current = first;
		while(current != null) {
			counter+=1;
			current = current.getNext();
		}
		return counter;
	}
}
