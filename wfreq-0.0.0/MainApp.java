import gnu.getopt.Getopt;
import java.io.File;
import java.util.Scanner;
import java.io.InputStream;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.Reader;
import java.io.FileNotFoundException;

import lib.Word;
import lib.WordAnalyzer;
import lib.WordComparator;
import lib.WordRecord;
import lib.WordDictionary;
import lib.WordList;
import lib.WordFrequencyRecord;
import lib.WordFrequencyList;

public class MainApp {
	public static String dpathname = "./dict/words";

	public static void main(String[] argv)
	{
		Getopt g;
		int opt, i;
		InputStream stream;
		FileInputStream dict;
		WordFrequencyList.FreqType type;

		g = new Getopt(Cmd.program, argv, "hvf");
		type = WordFrequencyList.FreqType.AFREQ;
		while ((opt = g.getopt()) != -1) {
			switch (opt) {
			case 'h':
				Cmd.cmdUsage();
				System.exit(0);
				return;
			case 'v':
				Cmd.cmdVersion();
				System.exit(0);
				return;
			case 'f':
				type = WordFrequencyList.FreqType.AFREQ;
				break;
			case '?':
				System.out.print("Unknow options.\n");
				break;
			default:
				System.out.print("Unknown options.\n");
				break;
			}
		}

		try {
			File file;
			file = new File(dpathname);
			dict = new FileInputStream(file);
			if (g.getOptind() >= argv.length) {
				stream = System.in;
			} else {
				file = new File(argv[g.getOptind()]);
				stream = new FileInputStream(file);
			}
		} catch (FileNotFoundException e) {
			System.err.print("Either dictionary file or input text doesn't exist.\n");
			System.exit(1);
			return;
		}

		String[] sep = {" ", ".", ",", ";", "?", "/", "\\", "(", ")", "*", "@", "#", "[", "]", "<", ">", "!"};
		WordAnalyzer wa = new WordAnalyzer(dict);
		for (i = 0; i < sep.length; i++)
			wa.addSeperator(sep[i]);
		wa.getWordList(stream);
		wa.sortWordList(new WordComparator());
		if (wa.compFreqDistribTable(type) != 0) {
			System.out.print("Failed to compute the frequency of words in the input text\n");
			System.exit(2);
		}
		wa.printWdFreqDistribTable();
		System.exit(0);
	}
}
