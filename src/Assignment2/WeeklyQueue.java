package Assignment2;
import java.util.*;
import java.io.*;
/*
 * the WeeklyQueue class contains an arraylist called alltheweeks containing several MyQueues
 * has methods to add and get MyQueues, as well as to get the size of the arraylist
 */
public class WeeklyQueue {
	private ArrayList<MyQueue> alltheweeks;
	public WeeklyQueue() {
		alltheweeks = new ArrayList<>();
	}
	public void addQueue(MyQueue x) {
		alltheweeks.add(x);
	}
	public int size() {
		return alltheweeks.size();
	}
	public MyQueue getQueue(int i) {
		return alltheweeks.get(i);
	}
}
