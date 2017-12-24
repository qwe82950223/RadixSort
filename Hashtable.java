import java.io.PrintWriter;
/**
 * class for hash table
 * @author xiao lin
 *
 */
public class Hashtable{
	int size;
	Queue array[];
	
	public Hashtable(){
		size=10;
		array=new Queue[size];
		for(int i=0;i<size;i++){
			array[i]=new Queue();
		}
	}
	/**
	 * insert data to queue array
	 * @param index
	 * @param data
	 */
	public void insert(int index, String data){
		array[index].addTail(data);
	}//end insert
	/**
	 * delete data from queue array
	 * @param index
	 * @return
	 */
	public String deleteQ(int index){
		return array[index].deleteHead();
	}//end deleteQ
	/**
	 * get Queue from hash table
	 * @param index
	 * @return
	 */
	public Queue getQueue(int index){
		return array[index];
	}//end getQueue
	/**
	 * print the whole hash table
	 * @param printer
	 */
	public void printHashtable(PrintWriter printer){
		printer.println("-----------------------------");
		for(int i=0;i<size;i++){
			printer.print(i+"| ");
			array[i].printQueue(printer);
		}
		printer.println("-----------------------------");
	}//end printHashtable
}//end hashtable class