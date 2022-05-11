package lib;

public class WordFrequencyRecord extends Object {
	private Word word;
	private double freq;

	public WordFrequencyRecord(String w)
	{
		word = new Word(w);
		this.setFrequency(0.0);
	}

	public WordFrequencyRecord(String w, double freq)
	{
		word = new Word(w);
		this.setFrequency(freq);
	}

	public WordFrequencyRecord(Word w)
	{
		word = w;
		this.setFrequency(0.0);
	}

	public WordFrequencyRecord(Word w, double freq)
	{
		this.setWordContent(w);
		this.setFrequency(freq);
	}

	public void setWordContent(String w)
	{
		this.word.setWord(w);
	}

	public void setWordContent(Word w)
	{
		this.word = w;
	}

	public void setFrequency(double freq)
	{
		this.freq = freq;
	}

	public double getFrequency()
	{
		return this.freq;
	}

	public String getWordContent()
	{
		return this.word.getWord();
	}

	public double incFreq(double amount)
	{
		this.freq += amount;
		return this.freq;
	}

	public double decFreq(double amount)
	{
		this.freq -= amount;
		return this.freq;
	}

	public void print()
	{
		System.out.print(this.word.getWord() + "\t" + this.freq);
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
