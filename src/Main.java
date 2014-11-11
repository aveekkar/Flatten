import java.util.ArrayList;


public class Main {

	public static void main(String[] args) {
		
		System.out.println("starting flattening of list...");
		
		ListContainer<Integer> rootContainer = new ListContainer<Integer>();
		IContainer<Integer> elem = new ElemContainer<Integer>(1);
		rootContainer.add(elem);
		ListContainer<Integer> listElem = new ListContainer<Integer>();
		Integer[] dataArray = {12, 23, 33, 34, 999};
		makeList(listElem, dataArray);
		ListContainer<Integer> innerList = new ListContainer<Integer>();
		dataArray = new Integer[] {100, 200, 300, 400};
		makeList(innerList, dataArray);
		ListContainer<Integer> innerInnerList = new ListContainer<Integer>();
		dataArray = new Integer[] {1000, 2000, 3000, 4000, 5000, 6000};
		makeList(innerInnerList, dataArray);
		ListContainer<Integer> innerInnerInnerList = new ListContainer<Integer>();
		dataArray = new Integer[] {10000, 20000, 30000, 40000};
		makeList(innerInnerInnerList, dataArray);
		innerInnerList.add(innerInnerInnerList);
		innerList.add(2, innerInnerList);
		listElem.add(innerList);
		rootContainer.add(listElem);
		elem = new ElemContainer<Integer>(55);
		rootContainer.add(elem);
		
		ContainerIterator<Integer> iter = new ContainerIterator<Integer>(rootContainer);
		while(iter.hasNext()){
			System.out.println("Elem: " + iter.next());
		}
		
	}
	
	public static <T> void makeList(ListContainer<T> list, T[] data){
		for(int i = 0; i < data.length; ++i){
			ElemContainer<T> tempContainer = new ElemContainer<T>(data[i]);
			list.add(tempContainer);
		}
		
	}

}
