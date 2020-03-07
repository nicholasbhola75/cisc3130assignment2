package Assignment2;
import java.util.*;
import java.io.*;
/*
 * the PlayList class is a linked list containing Song nodes
 * the constructor sets the first node to null by default
 * addSong() adds new Song nodes to the linkedList
 * listenToSong() removes and returns song nodes
 * isEmpty() tests if the list is empty or not
 * size() returns how many elements are in each arraylist
 */
public class PlayList {
	private Song first;
	public PlayList() {
		first = null;
	}
	public void addSong(Song s) {
		Song current = first;
		Song previous = null;
		//while (current != null && s.getArtist().compareTo(current.getArtist()) > 0)
		//this version is meant to sort the list, however the scanners reading null from the files is returning NullPointerException
		while (current != null) {
			previous = current;
			current = current.getNext();
		}
		if (previous == null) {
			first = s;
		}
		else {
			previous.setNext(s);
		}
		s.setNext(current);
	}
	public boolean isEmpty(){
	    return (first == null);
	   }
	public Song listenToSong() {
		Song temp = first;
		first = temp.getNext();
		return temp;
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
/*
 * the Song class represents a Node in the Playlist linked list
 * each Song node has a reference to an artist's name, the track's name, and the spotify lin
 * there is also a reference pointing to the next node
 * getters for artist and next
 * displaySong prints the information of each Song node
 */
class Song {
	private String artist;
	private String track;
	private String link;
	private Song next;
	public Song(String a, String t, String l) {
		artist = a;
		track = t;
		link = l;
		next = null;
	}
	public String getArtist() {
		return artist;
	}
	public Song getNext() {
		return next;
	}
	public void setNext(Song n) {
		next = n;
	}
	public void displaySong(PrintWriter outputFile) {
		outputFile.println(artist + " " + track + " " + link);
	}
}
