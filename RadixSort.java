import java.io.PrintWriter;
/**
 * class for RadixSort
 * @author xiao lin
 *
 */
public class RadixSort{
	
	int currentTable;
	int previousTable;
	int index;//current index
	int totalDigit;//total index
	Hashtable array[];//array for hashtable
	
	public RadixSort(int n){
		totalDigit=n;//total digit
		currentTable=0;//index of current table
		previousTable=0;//index of previous table
		index=1;//current index
		array=new Hashtable[2];//make two hashtable
		for(int i=0;i<2;i++){
			array[i]=new Hashtable();
		}
	}
	/**
	 * get the number of specified index
	 * @param number
	 * @param index
	 * @return number of that index
	 */
	public int getNumber(int number, int index){
		int currentDigit=index;
		while(currentDigit!=1){
			number=number/10;
			currentDigit--;
		}//end while
		return number%10;
	}//end getNumber
	/**
	 * insert data to the current hashtable
	 * @param data
	 */
	public void insertRadix(String data){
		int insertNumber=Integer.parseInt(data);
		int number = getNumber(insertNumber,index);
		array[currentTable].insert(number,data);
	}//end insertRadix
	/**
	 * swap current table and previous table
	 */
	public void swapTable(){
		if(currentTable==previousTable){
			currentTable=1;
			return;
		}//end if
		else{
			int temp=currentTable;
			currentTable=previousTable;//swap
			previousTable=temp;
		}//end else
	}//en swapTable
	/**
	 * delete the element of previous table and move them to current table
	 * @param printer
	 */
	public void swap(PrintWriter printer){
		index++;
		while(index<4){
			swapTable();
			for(int i=0;i<10;i++){
				while(!array[previousTable].getQueue(i).isEmpty()){
					String data=array[previousTable].deleteQ(i);//swap table with next index
					insertRadix(data);
				}
			}
			index++;
			print(printer);
		}//end while
	}//end swap
	
	public void print(PrintWriter printer){
		array[currentTable].printHashtable(printer);//print current hashtable
	}//end print
	
}//end RadixSort class