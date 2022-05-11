package lib;
import java.util.Comparator;

public class WordComparator implements Comparator<WordRecord> {
	public int compare(WordRecord w1, WordRecord w2)
	{
		return w1.getWordAtIndex(0).compareTo(w2.getWordAtIndex(0));
	}
}
