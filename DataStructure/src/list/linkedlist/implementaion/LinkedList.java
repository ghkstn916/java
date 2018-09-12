package list.linkedlist.implementaion;

public class LinkedList {
	
		private Node head;
		private Node tail;
		private int size=0;
		private class Node{
			private Object data;
			private Node next;
			
			public Node(Object input) {
				this.data=input;
				this.next=null;
			}
			
			public String toString() {
				return String.valueOf(this.data);
			}
		}
		
		public void addFirst(Object input) { // 링크드 맨 앞에 자료를 추가하는 경우
			Node newNode=new Node(input);
			newNode.next=head;
			head=newNode;
			size++;
			if(head.next==null) {
				tail=head;
			}
		}
		
		public void addLast(Object input) { //링크드 맨 뒤에 자료를 추가하는 경우
			Node newNode=new Node(input);
			if(size==0) {
				addFirst(input);
			}
			else {
				tail.next=newNode;
				tail=newNode;
				size++;
			}
		}
		
		Node node(int index) {
			Node x=head;
			for(int i=0;i<index;i++)
				x=x.next;
			return x;
		}
		
	
}
