package Collections.ArrayLists;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;


public class Runner {

	public static void testArrayList() {
		List<Integer> list = new ArrayList<Integer>();
		list.add(3);
		list.add(4);
		list.add(55);
		list.add(222);
		list.add(123);
		
		for (Integer integer : list) {
			System.out.println(integer);
		}
		
		System.out.println("---------------------------------");
		
		// generics - creating integer lterator
		Iterator<Integer> iterator = list.iterator();
		
		while (iterator.hasNext()) {
			int i = iterator.next();
			System.out.println(i);
		}
		
		System.out.println("---------------------------------");
		
		iterator.forEachRemaining(System.out::println);
		
	}
	

	public static void removeAllItemsFromList(List<String> strList) {
		
		Iterator<String> iterator = strList.iterator();
		
		while (iterator.hasNext()) {
			iterator.next();
			iterator.remove();
			System.out.println(strList.size());
			System.out.println(strList);
		}
		
	}
	
	public static void testRemoveAllItemsFromList() {
		List<String> list = new ArrayList<String>();
		list.add("1");
		list.add("2");
		list.add("3");
		list.add("4");
		list.add("5");
		list.add("6");
		list.add("7");
		list.add("8");
		list.add("9");
		System.out.println(list);
		
		removeAllItemsFromList(list);
	}

	//--------------------------------------------------------------------------------------
	
	public static ArrayList<Integer> makeArrayList(int start, int end){
		int size = end-start;
		ArrayList<Integer> list = new ArrayList<Integer>(size);
		for (int i=start; i<end; i++)
			list.add(i);
		
		return list;
	}
	
	public static void testMakeArrayList() {
		ArrayList<Integer> list = makeArrayList(1, 10);
		System.out.println(list);	
	}
	
	public static ArrayList<Integer> makeDoubleValueList(ArrayList<Integer> inputList){
		ArrayList<Integer> list = new ArrayList<Integer>(inputList);
		
		ListIterator<Integer> iterator = list.listIterator();
		
		while (iterator.hasNext()) {
			int num = iterator.next();
			iterator.set(num*2);
		}
		
		return list;
	}
	
	public static void testMakeDoubleValueList() {
		ArrayList<Integer> list = makeArrayList(1, 10);
		ArrayList<Integer> newList = makeDoubleValueList(list);
		System.out.println(newList);
	}
	
	public static int complexify(int num) {
		return num*4+3;
	}
	
	public static ArrayList<Integer> makeComplexValueList(ArrayList<Integer> inputList){
		ArrayList<Integer> newList = new ArrayList<Integer>(inputList);
		
		ListIterator<Integer> iterator = newList.listIterator();
		
		int num;
		while (iterator.hasNext()) {
			num = iterator.next();
			iterator.set(complexify(num));
		}
		
		return newList;
	}
	
	public static void testMakeComplexValueList() {
		ArrayList<Integer> list = makeArrayList(1, 11);
		ArrayList<Integer> complexList = makeComplexValueList(list);
		System.out.println(complexList);
	}
	
	public static void main(String[] args) {
		//testMakeArrayList();
		//testMakeDoubleValueList();
		testMakeComplexValueList();
	}

}
