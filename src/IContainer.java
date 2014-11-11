
public interface IContainer <T> {
	public boolean isElem();
	public boolean isList();
	public int size();
	public T value();
	public IContainer<T> value(int index);
}
