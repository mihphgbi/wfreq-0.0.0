package lib;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.FileInputStream;
import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Collections;

public class WordAnalyzer extends Object {
	private WordList wList;
	private WordFrequencyList wfList;
	private List<String> delims;
	private FileInputStream dict;

	public WordAnalyzer(FileInputStream dict)
	{
		this.wList = new WordList("Word List");
		this.wfList = new WordFrequencyList("Frequency Table");
		this.delims = new ArrayList<String>();
		this.dict = dict;
	}

	public boolean addSeperator(String s)
	{
		this.delims.add(s);
		return true;
	}

	public WordList getWordList(InputStream stream)
	{
		Scanner sc;
		String delim, line, infw;
		String[] words;
		String w;
		WordRecord wr;
		int i, j, k, n;

		n = delims.size();
		delim = "[";
		for (j = 0; j < n; j++) {
			w = delims.get(j);
			if (w.compareTo(".") == 0 || w.compareTo("?") == 0
					|| w.compareTo("*") == 0
					|| w.compareTo("+") == 0
					|| w.compareTo("@") == 0
					|| w.compareTo("#") == 0
					|| w.compareTo("$") == 0
					|| w.compareTo("<") == 0
					|| w.compareTo(">") == 0
					|| w.compareTo("[") == 0
					|| w.compareTo("]") == 0
					|| w.compareTo("[") == 0
					|| w.compareTo("[") == 0
					|| w.compareTo("`") == 0
					|| w.compareTo("|") == 0
					|| w.compareTo("^") == 0
					|| w.compareTo("'") == 0
					|| w.compareTo("\\") == 0)
				w = "\\"+w;
			delim = delim+w;
		}
		delim = delim+"\\s]";

		sc = new Scanner(stream);
		while (sc.hasNextLine()) {
			line = sc.nextLine();
			words = line.split(delim);
			for (i = 0; i < words.length; i++) {
				w = words[i].toLowerCase();
				if ((k = this.checkValid(w)) == -1) {
					w = Word.toUpperCaseAtFirstWord(w);
					if ((k = this.checkValid(w)) == -1)
						continue;
				} else if (k == -2)
					return null;
				wr = new WordRecord();
				if ((infw = this.getWordInDictionary(k)) != null)
					wr.add(infw);
				else
					wr.add(w);
				this.wList.add(wr);
			}
		}
		return (WordList) this.wList;
	}

	public void sortWordList(Comparator<? super WordRecord> c)
	{
		wList.sort(c);
	}

	public int compFreqDistribTable(WordList wList, WordFrequencyList.FreqType ftype)
	{
		return this.wfList.compWFreq(wList, ftype);
	}

	public int compFreqDistribTable(WordFrequencyList.FreqType ftype)
	{
		return this.wfList.compWFreq(this.wList, ftype);
	}

	public void printWdFreqDistribTable()
	{
		wfList.print();
	}

	public void printWordsInDictionary()
	{
		String line;
		Scanner sc;
		String[] words;
		int i;

		try {
			dict.getChannel().position(0);
		} catch (IOException e) {
			return;
		}

		sc = new Scanner(dict);
		while (sc.hasNextLine()) {
			line = sc.nextLine();
			words = line.split(",");
			for (i = 0; i < words.length; i++)
				System.out.print(words[i] + "\n");
		}
	}

	public String getWordInDictionary(int index)
	{
		String line;
		String[] words;
		Scanner sc;
		int i;

		try {
			dict.getChannel().position(0);
		} catch (IOException e) {
			return null;
		}

		sc = new Scanner(dict);
		i = 0;
		while (sc.hasNextLine()) {
			line = sc.nextLine();
			if (i == index) {
				words = line.split(",");
				return words[0];
			}
			i++;
		}
		return null;
	}

	public int find(String regexp)
	{
		Scanner sc;
		String line;
		String[] words;
		WordRecord wr;
		int i, j;

		try {
			dict.getChannel().position(0);
		} catch (IOException e) {
			return -2;
		}

		wr = new WordRecord();
		sc = new Scanner(dict);
		i = 0;
		while (sc.hasNextLine()) {
			line = sc.nextLine();
			words = line.split(",");
			wr.clear();
			for (j = 0; j < words.length; j++)
				wr.add(words[j]);
			if (wr.find(regexp) > -1)
				return i;
			i++;
		}
		return -1;
	}

	public int checkValid(String w)
	{
		if (w.matches("\\s*\\n+"))
			return -1;
		String regexp = "^"+w+"$";
		return this.find(regexp);
	}
}
