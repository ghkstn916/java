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
		
		Node node(int index) { // index 번호의 리스트 값 찾기
			Node x=head;
			for(int i=0;i<index;i++)
				x=x.next;
			return x;
		}
		
		public void add(int k, Object input) {
			if(k==0) {
				addFirst(input);
			}
			else {
				Node temp1=node(k-1);
				Node temp2=temp1.next;
				Node newNode=new Node(input);
				temp1.next=newNode;
				newNode.next=temp2;
				size++;
				if(newNode.next==null) {
					tail=newNode;
				}
			}
		}
		
		public String toString() {
			
			if(head==null) {
				return "[]";
			}
			
			Node temp=head;
			String str="[";
			
			while(temp.next != null) {
				str +=temp.data+",";
				temp=temp.next;
			}//이 구문은 마지막 노드가 포함안되기때문에
			str += temp.data;//마지막 노드를 추가시키고
			
			return str+"]";
			
		}
		
		public Object removeFirst() {
			Node temp=head;
			head=temp.next;
			Object returnData=temp.data;
			temp=null;
			size--;
			return returnData;
		}
		
		public Object remove(int k) {
			if(k==0)//k번째 데이터 삭제
				return removeFirst();
			Node temp=node(k-1);
			Node todoDeleted=temp.next;
			temp.next=temp.next.next;
			Object returnData=todoDeleted.data;
			if(todoDeleted==tail) {
				tail=temp;
			}
			
			todoDeleted=null;
			size--;
			return returnData;
		}
		
		public int size() {
			return size;
		}
		
		public Object get(int k) {//k번째 데이터 추출
			Node temp = node(k);
			return temp.data;
		}
		
		 public int indexOf(Object data) {
			 Node temp=head;
			 int index=0;
			 while(temp.data!=data) {
				 temp=temp.next;
				 index++;
				 
				 if(temp==null)
					 return -1;
			 }
			 return index;
		 }
		 
		 public ListIterator listIterator() {
			 return new ListIterator();
		 }
		 
		 public class ListIterator{
			 
			 private Node next;
			 private Node lastReturned;
			 private int nextIndex;
			 
			 ListIterator(){
				next=head; 
			 }
			 
			 public Object next() { //라스트 리턴드는 이전 노드를 가르키고
				 lastReturned=next; // 넥스트는 다음에 가르킬 노드에 미리 가 있는다.
				 next=next.next;
				 nextIndex++;
				 
				 return lastReturned.data;
			 }
			 
			 public boolean hasNext() {
				 return nextIndex<size();
			 }
			 
			 public void add(Object input) {
				 Node newNode=new Node(input);
				 
				 head=newNode;
				 newNode.next=next;
				 
				 lastReturned=newNode;
				 nextIndex++;
				 size++;
			 }
		 }
		
}
