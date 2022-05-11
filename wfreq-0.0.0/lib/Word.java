package lib;

public class Word extends Object implements Cloneable {
	private String data;

	public Word()
	{
		this.setWord("");
	}

	public Word(String w)
	{
		this.setWord(w);
	}

	public void setWord(String word)
	{
		this.data = word;
	}

	public String getWord()
	{
		return this.data;
	}

	public void print()
	{
		System.out.print(this.data);
	}

	public Object clone()
	{
		try {
			return super.clone();
		} catch (CloneNotSupportedException e) {
			return null;
		}
	}

	public static String toUpperCaseAtFirstWord(String s)
	{
		String t, w;
		int l;

		l = s.length();
		if (l == 0)
			return s;
		w = s.substring(0, 1);
		w = w.toUpperCase();
		t = s.substring(1, l);
		t = t.toLowerCase();
		t = w+t;
		return t;
	}
}
