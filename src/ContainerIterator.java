import java.util.Iterator;
import java.util.Stack;


public class ContainerIterator <T> implements Iterator<T> {
	
	IContainer<T> container;
	int parentIndex;
	int currentPointer;
	int currentContainerSize;
	Stack<Tuple> parentPointerStack = new Stack<Tuple>();
	IContainer<T> currentContainer;
	
	public ContainerIterator(IContainer<T> container){
		this.container = container;
		parentIndex = -1;
		currentPointer = -1;
		currentContainer = this.container;
	}

	@Override
	public boolean hasNext() {
		if(currentPointer < currentContainer.size() - 1 || !parentPointerStack.isEmpty()){
			return true;
		}
		return false;
	}

	@Override
	public T next() {
		++currentPointer;
		if(currentPointer <= currentContainer.size() - 1){
			if(currentContainer.value(currentPointer).isElem()){
				return currentContainer.value(currentPointer).value();
			}
			else{
				parentPointerStack.push(new Tuple(currentContainer, currentPointer));
				currentContainer = currentContainer.value(currentPointer);
				currentPointer = -1;
				return next();
			}
			
		}
		else{
			if(!parentPointerStack.empty()){
				Tuple back = parentPointerStack.pop();
				currentContainer = back.container;
				currentPointer = back.index;
				return next();
			}
		}
		
		return null;
	}

	@Override
	public void remove() {
		System.out.println("operation not supported");
		
	}
	
	class Tuple{
		public Tuple(IContainer<T> container, int index){
			this.container = container;
			this.index = index;
		}
		public IContainer<T> container;
		public int index;
	}

}
