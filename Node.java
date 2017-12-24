/**
 * class for Node 
 * @author xiao lin
 *
 */
public class Node{
	String data;
	Node next;
	/**
	 * empty node 
	 */
	public Node(){
		data=null;
		next=null;
	}
	/**
	 * node with data
	 * @param number
	 */
	public Node(String number){
		data=number;
		next=null;
	}
}//end Node class