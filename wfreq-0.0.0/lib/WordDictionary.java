package lib;
import java.util.List;
import java.util.Comparator;

public interface WordDictionary<E> extends List<E> {
	public String getName();
	public void setName(String name);
	public int find(String regexp);
}
