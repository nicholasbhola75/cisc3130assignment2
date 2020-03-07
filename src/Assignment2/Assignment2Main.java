package Assignment2;
import java.util.*;
import java.io.*;
/*
 * Assignment2Main creates an instantiation of the Files class, which builds an arraylist containing filenames
 * a Scanner takes filenames from a text file and reads them into WeeklyFiles
 * WeeklyQueue creates an arraylist of MuQueue, each MyQueue holds a playlist of songs
 * the files from WeeklyFiles are the csv files containing viral songs weekly
 * a filename for one of the csv files is taken from the Files arraylist and used to make a MyQueue
 * the MyQueue is added to the WeeklyQueue arraylist
 * then, mergingFunction is used to build a large MyQueue containing all the songs from all of the playlists from-
 * other myQueues in the WeeklyQueue arraylist
 * Songs are then played from allData and the stack SongHistoryList keeps track of each song being removed and played
 * SongHistoryList then prints this data
 * the data is read in incorrectly though, output shows that it loops and repeats null a few times. I'm not sure if- 
 * something is wrong with the file.
 */
public class Assignment2Main {
	public static void main(String[] args) throws FileNotFoundException {
		File output = new File("C:\\Users\\nickb\\Desktop\\out.txt");
	    PrintWriter outputfile = new PrintWriter(output);
		Files WeeklyFiles = new Files();
		File myFiles = new File("C:\\Users\\nickb\\eclipse-workspace\\CISC3130\\src\\Assignment2\\Files.txt");
		Scanner filereader = new Scanner(myFiles);
		while(filereader.hasNext()) {
			String f = filereader.nextLine();
			WeeklyFiles.addFileName(f);
		}
		WeeklyQueue allTheWeeks = new WeeklyQueue();
		for(int i = 0; i < WeeklyFiles.getSize(); i++) {
			MyQueue dataExtract = new MyQueue(WeeklyFiles.getFileName(i));
			dataExtract.read();
			allTheWeeks.addQueue(dataExtract);
		}
		MyQueue allData = mergingFunction(allTheWeeks, outputfile);
		SongHistoryList History = new SongHistoryList();
		while(allData.isEmpty() == false) {
			History.addSong(allData.getPlayList().listenToSong());		
		}
		History.displayList(outputfile);
	}
	/*
	 * to create the MyQueue containing information from every MyQueue until this point, a for loop-
	 * goes through the WeeklyQueue arraylist and remove each individual MyQueue
	 * Each playlist has their songs added to allData's playlist
	 */
	public static MyQueue mergingFunction(WeeklyQueue allTheWeeks, PrintWriter outputFile) {
		MyQueue allData = new MyQueue();
		for(int y = 0; y < allTheWeeks.size(); y++) {
			MyQueue q = allTheWeeks.getQueue(y);
			while(q.getPlayList().isEmpty() == false) {
				Song s = q.getPlayList().listenToSong();
				allData.add(s);
			}
			allData.print(outputFile);
		}
		return allData;
	}
	
}
