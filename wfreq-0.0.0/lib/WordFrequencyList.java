package lib;
import java.util.List;
import java.util.ArrayList;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.Collection;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Comparator;
import java.util.Collections;

public class WordFrequencyList extends Object implements WordDictionary<WordFrequencyRecord>,Cloneable {
	public enum FreqType {
		AFREQ,	/* Absolute frequency */
		CFREQ,	/* Cumulative frequency */
		TFREQ,	/* Total frequency */
		RFREQ,	/* Relative frequency */
		RCFREQ,	/* Relative cumulative frequency */
		PFREQ	/* Percentage frequency. */
	};
	String name;
	private List<WordFrequencyRecord> data;

	public WordFrequencyList(String name)
	{
		this.setName(name);
		this.data = new ArrayList<WordFrequencyRecord>();
	}

	public boolean add(WordFrequencyRecord wfr)
	{
		return this.data.add(wfr);
	}

	public WordFrequencyRecord get(int index)
	{
		return (WordFrequencyRecord) this.data.get(index).clone();
	}

	public int compWFreq(WordList list, FreqType ftype)
	{
		int res = 0;

		switch (ftype) {
		case AFREQ:
			res = this.compFreq(list);
			break;
		case CFREQ:
			break;
		case RFREQ:
			break;
		case RCFREQ:
			break;
		case PFREQ:
			break;
		default:
			return 1;
		}
		return 0;
	}


	private int compFreq(WordList wList)
	{
		int i, n, j;
		String regexp, w, t;
		WordFrequencyRecord wfr;

		if (wList == null)
			return 1;

		n = wList.size();
		for (i = 0; i < n; i++) {
			w = wList.get(i).getWordAtIndex(0);
			if ((j = this.find("^"+w+"$")) >= 0) {
				wfr = this.data.get(j);
				wfr.incFreq(1.0);
			} else if (j == -1) {
				wfr = new WordFrequencyRecord(w, 1.0);
				this.data.add(wfr);
			} else {}
		}
		return 0;
	}

	public double getTotalFrequency()
	{
		int i,n;
		double total;

		total = 0;
		n = this.data.size();
		for (i = 0; i < n; i++)
			total += this.data.get(i).getFrequency();
		return total;
	}

	public int find(String regexp)
	{
		Matcher matcher;
		Pattern pattern = Pattern.compile(regexp);
		int i, n;

		n = this.data.size();
		for (i = 0; i < n; i++) {
			matcher = pattern.matcher(this.data.get(i).getWordContent());
			if (matcher.find())
				return i;
		}
		return -1;
	}

	public void sort(Comparator<? super WordFrequencyRecord> c)
	{
		Collections.sort(this.data, c);
	}

	public void print()
	{
		int i, n;
		System.out.print(this.getName()+"\n");
		n = this.data.size();
		if (n > 0)
			System.out.print("\n");
		for (i = 0; i < n; i++) {
			this.data.get(i).print();
			System.out.print("\n");
		}
		if (n > 0)
			System.out.print("\n");
		System.out.print("Total Frequency: "+this.getTotalFrequency()+"\n");
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getName()
	{
		return this.name;
	}

	public void add(int index, WordFrequencyRecord wfr)
	{
		this.data.add(index, wfr);
	}

	public boolean addAll(Collection<? extends WordFrequencyRecord> c)
	{
		return this.data.addAll(c);
	}

	public boolean addAll(int index, Collection<? extends WordFrequencyRecord> c)
	{
		return this.data.addAll(index, c);
	}

	public WordFrequencyRecord remove(int index)
	{
		return this.data.remove(index);
	}

	public boolean removeAll(Collection<?> c)
	{
		return this.data.removeAll(c);
	}

	public boolean contains(Object o)
	{
		return this.data.contains(o);
	}

	public boolean containsAll(Collection<?> c)
	{
		return this.data.containsAll(c);
	}

	public Iterator<WordFrequencyRecord> iterator()
	{
		return this.data.iterator();
	}

	public int hashCode()
	{
		return this.data.hashCode();
	}

	public WordFrequencyRecord set(int index, WordFrequencyRecord wfr)
	{
		return this.data.set(index, wfr);
	}

	public boolean equals(Object o)
	{
		return this.data.equals(o);
	}

	public boolean retainAll(Collection<?> c)
	{
		return this.data.retainAll(c);
	}

	public boolean remove(Object o)
	{
		return this.data.remove(o);
	}

	public Object[] toArray()
	{
		return this.data.toArray();
	}

	public <WordRecord> WordRecord[] toArray(WordRecord[] a)
	{
		return this.data.toArray(a);
	}

	public void clear()
	{
		this.data.clear();
	}

	public int size()
	{
		return this.data.size();
	}

	public boolean isEmpty()
	{
		return this.data.isEmpty();
	}

	public ListIterator<WordFrequencyRecord> listIterator(int index)
	{
		return this.data.listIterator(index);
	}

	public int lastIndexOf(Object o)
	{
		return this.data.lastIndexOf(o);
	}

	public int indexOf(Object o)
	{
		return this.data.indexOf(o);
	}

	public ListIterator<WordFrequencyRecord> listIterator()
	{
		return this.data.listIterator();
	}

	public List<WordFrequencyRecord> subList(int fromIndex, int toIndex)
	{
		List<WordFrequencyRecord> wrList = new ArrayList<WordFrequencyRecord>();
		return wrList;
	}

	public Object clone()
	{
		try {
			return super.clone();
		} catch (CloneNotSupportedException e) {
			return null;
		}
	}
}
