
public class ElemContainer<T> implements IContainer<T> {
	
	T elem;
	
	

	public ElemContainer(){
	}
	
	public ElemContainer(T elem){
		this.elem = elem;
	}

	@Override
	public boolean isElem() {
		return true;
	}

	@Override
	public boolean isList() {
		return false;
	}
	
	public T getElem() {
		return elem;
	}

	public void setElem(T elem) {
		this.elem = elem;
	}

	@Override
	public int size() {
		return (elem == null) ? 0 : 1;
	}

	@Override
	public T value() {
		return elem;
	}

	@Override
	public IContainer<T> value(int index) {
		return this;
	}

}
