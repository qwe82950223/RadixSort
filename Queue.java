import java.io.PrintWriter;
/**
 * class for Queue
 * @author xiao lin
 *
 */
public class Queue{
	Node dummyNode;
	Node tail;
	
	public Queue(){
		dummyNode=new Node();
		tail=null;
	}
	/**
	 * add data to the next of last element of Queue
	 * @param data
	 */
	public void addTail(String data){
		Node newnode = new Node(data);
		if(isEmpty()){//add data become head's next 
			dummyNode.next=newnode;
			tail=newnode;
			return;
		}//end if 
		tail.next=newnode;
		tail=newnode;//make new node to the next of tail
	}//end addTail
	/**
	 * delete the first element of Queue
	 * @return old first element 
	 */
	public String deleteHead(){
		if(isEmpty()){
			return null;
		}
		Node temp = dummyNode.next;
		dummyNode.next=temp.next;//make head equal to head.next
		return temp.data;
		
	}//end deleteHead
	/**
	 * check Queue is Empty or not 
	 * @return true 
	 */
	public boolean isEmpty(){
		if(dummyNode.next==null){
			return true;
		}//end if
		return false;
	}//end isEmpty
	/**
	 * print whole queue
	 * @param printer to output file
	 */
	public void printQueue(PrintWriter printer){
		Node temp = dummyNode;
		while(temp.next!=null){
			printer.print(temp.next.data+" ");
			temp=temp.next;
		}//end while
		printer.println();
	}//end printQueue
	
}//end Queue class