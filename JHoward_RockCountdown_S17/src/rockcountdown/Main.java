package rockcountdown;

import java.io.*;
import java.util.*;

import org.apache.commons.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		// This is my second commit!
		// This will be shown only after I commit!

		Scanner scan = new Scanner(System.in); // scan in filename
		String input = scan.nextLine(); // get filename from input
		File file = new File(input); // the input is defined as a file
		String wholeFile = FileUtils.readFileToString(file); // the whole file
																// is written to
																// a string
		String[] songs = wholeFile.split("\r\n"); //
		ArrayList<Song> list = new ArrayList<Song>();
		for (int i = 0; i < songs.length; i++) {
			list.add(new Song(songs[i]));
		}
		StringBuilder outputText = new StringBuilder(); // this will hold the
														// output text
		for (int i = list.size() - 1; i >= 0; i--) {
			outputText.append(list.get(i).getRank());
			outputText.append("\t");
			outputText.append(list.get(i).getTitle());
			outputText.append("\r\n");
		}
		System.out.println(outputText.toString());
		System.out.println("Complete");
		scan.close();
	}

}
