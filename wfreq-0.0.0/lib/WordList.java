package lib;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Collection;
import java.util.Comparator;
import java.util.ListIterator;
import java.util.Iterator;

public class WordList extends Object implements WordDictionary<WordRecord>,Cloneable {
	private String name;
	private List<WordRecord> data;

	public WordList(String name)
	{
		this.setName(name);
		data = new ArrayList<WordRecord>();
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getName()
	{
		return this.name;
	}

	public boolean add(WordRecord wr)
	{
		return this.data.add(wr);
	}

	public void add(int index, WordRecord wr)
	{
		this.data.add(index, wr);
	}

	public boolean addAll(Collection<? extends WordRecord> c)
	{
		return this.data.addAll(c);
	}

	public boolean addAll(int index, Collection<? extends WordRecord> c)
	{
		return this.data.addAll(index, c);
	}

	public WordRecord remove(int index)
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

	public Iterator<WordRecord> iterator()
	{
		return this.data.iterator();
	}

	public int hashCode()
	{
		return this.data.hashCode();
	}

	public WordRecord set(int index, WordRecord wr)
	{
		return this.data.set(index, wr);
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

	public WordRecord get(int index)
	{
		return this.data.get(index);
	}

	public boolean isEmpty()
	{
		return this.data.isEmpty();
	}

	public ListIterator<WordRecord> listIterator(int index)
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

	public ListIterator<WordRecord> listIterator()
	{
		return this.data.listIterator();
	}

	public List<WordRecord> subList(int fromIndex, int toIndex)
	{
		List<WordRecord> wrList = new ArrayList<WordRecord>();
		return wrList;
	}

	public int find(String regexp)
	{
		int i;
		for (i = 0; i < this.data.size(); i++) 
			if (this.data.get(i).find(regexp) > -1)
				return i;
		return -1;
	}

	public void sort(Comparator<? super WordRecord> c)
	{
		Collections.sort(this.data, c);
	}

	public void print()
	{
		int i;
		for (i = 0; i < this.data.size(); i++) {
			this.data.get(i).print();
			System.out.print("\n");
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
}
