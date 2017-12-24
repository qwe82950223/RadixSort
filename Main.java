import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
/**
 * project for radix sort
 * @author xiao lin
 *
 */
public class Main{
	public static void main(String[] args){
		File inFile = new File(args[0]); //input file
		File output = new File(args[1]); //output file
		Scanner scan = null;
		PrintWriter printer = null;
		int totalDigit=0;
		Stack stack = new Stack();
		try {
			scan = new Scanner(inFile);
			while(scan.hasNext()){//count the number of integer
				String data=scan.next();
				stack.push(data);
				int current=checkDigit(Integer.parseInt(data));
				if(totalDigit<current){
					totalDigit=current;
				}//end if
			}//end while
			printer=new PrintWriter(output);
			stack.print(printer);
			RadixSort radixsort=new RadixSort(totalDigit);
			while(!stack.IsEmpty()){
				String d = stack.Pop();
				radixsort.insertRadix(d);//insert data which stack pop
				printer.println("insert "+d);
				radixsort.print(printer);//print 
			}//end while
			radixsort.swap(printer);
			scan.close();//close input file
			printer.close();//close output file
			
		}//end try 
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//end catch
	}//end main
	/**
	 * get how many digit in the number
	 * @param number
	 * @return number of digit
	 */
	public static int checkDigit(int number){ //get the number of digit
		int count=0;
		while(number/10!=0){//count the digit until it is less than 10
			count++;
			number=number/10;
		}//end while
		return count+1;
	}//end checkDigit
}//end Main class