package list.linkedlist.implementaion;


public class Main {
	public static void main(String args[])
	{
		LinkedList numbers=new LinkedList();
		numbers.addFirst(5);
		numbers.addFirst(10);
		numbers.addFirst(2);
		numbers.addLast(11);
		numbers.addLast(12);
		numbers.addLast(9);
		System.out.println(numbers.node(0));
		System.out.println(numbers.node(1));
		
	}
}
