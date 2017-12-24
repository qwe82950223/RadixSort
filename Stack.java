import java.io.PrintWriter;
/**
 * class for stack
 * @author xiao lin
 *
 */
public class Stack{
	
	Node top;
	int count;//size of stack
	
	public Stack(){
		top=new Node();
		count=0;
	}
	/**
	 * get the top element
	 * @return top element
	 */
	public String Top(){
		if(IsEmpty()){
			return null;
		}
		return top.data;
	}//end Top
	/**
	 * insert data into top of stack
	 * @param number
	 */
	public void push(String number){
		Node newnode = new Node(number);
		newnode.next=top;
		top=newnode;
		count++;
	}//end push
	/**
	 * delete the toppest element from stack 
	 * @return delete element
	 */
	public String Pop(){
		if(IsEmpty()){
			System.out.println("Stack is empty");
			return null;
		}
		Node temp = top;
		top=top.next;
		count--;
		return temp.data;
	}//end Pop
	/**
	 * get size of stack
	 * @return
	 */
	public int Size(){
		return count;
	}//end Size
	/**
	 * print whole stack to output file
	 * @param printer
	 */
	public void print(PrintWriter printer){
		Node temp=top;
		while(temp.data!=null){
			printer.print(temp.data+" ");
			temp=temp.next;
		}
		printer.println();
	}//end Print
	/**
	 * check is stack empty
	 * @return true
	 */
	public boolean IsEmpty(){
		if(top.data==null){
			return true;
		}
		return false;
	}//end IsEmpty
}//end Stack class