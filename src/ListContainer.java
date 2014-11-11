import java.util.ArrayList;


public class ListContainer<T> extends ArrayList<IContainer<T>> implements IContainer<T> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8198998758007296571L;
	
	public ListContainer(){
	}
	
	public ListContainer(IContainer<T>[] arr){
		for(int i = 0; i < arr.length; ++i){
			this.add(arr[i]);
		}
	}

	@Override
	public boolean isElem() {
		return false;
	}

	@Override
	public boolean isList() {
		return true;
	}

	@Override
	public T value() {
		return null;
	}

	@Override
	public IContainer<T> value(int index) {
		return this.get(index);
	}
	

}
