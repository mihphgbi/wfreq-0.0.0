package lib;
import java.util.List;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordRecord extends Object implements Cloneable {
	private List<Word> data;

	public WordRecord()
	{
		this.data = new ArrayList<Word>();
	}

	public boolean add(Word w)
	{
		return this.data.add(w);
	}

	public boolean add(String w)
	{
		return this.data.add(new Word(w));
	}

	public void add(int index, Word w)
	{
		this.data.add(index, w);
	}

	public void clear()
	{
		this.data.clear();
	}

	public Word remove(int index)
	{
		return this.data.remove(index);
	}

	public String getWordAtIndex(int index)
	{
		if (index < 0 || index >= this.data.size())
			return null;
		return this.data.get(index).getWord();
	}

	public ArrayList<String> get()
	{
		int i;
		ArrayList<String> list;
		list = new ArrayList<String>();
		for (i = 0; i < this.data.size(); i++)
			list.add(this.data.get(i).getWord());
		return list;
	}

	public void print()
	{
		int i;
		for (i = 0; i < this.data.size(); i++) {
			this.data.get(i).print();
			System.out.print(",");
		}
	}

	public Object clone()
	{
		try {
			return super.clone();
		} catch (CloneNotSupportedException e) {
			return null;
		}
	}

	public int find(String regexp)
	{
		Matcher matcher;
		Pattern pattern = Pattern.compile(regexp);
		int i, n;
		n = this.data.size();
		for (i = 0; i < n; i++) {
			matcher = pattern.matcher(this.data.get(i).getWord());
			if (matcher.find())
				return i;
		}
		return -1;
	}
}
