
import java.util.ArrayList;

public class SecondTask {

	private static void findVowels(String str,int position) {
		if(position == 0) return;
		char[] stringChars= str.toCharArray();
		System.out.println("Original String: "+str);
		System.out.println();
		System.out.println("Vowels every "+ position+ " positions in string:");
		for(int i=position-1;i<stringChars.length;i+=position) {
			if(stringChars[i] == 'a' || stringChars[i] == 'e' || stringChars[i]=='i' || stringChars[i]=='o' || stringChars[i]=='u') {
				System.out.print(stringChars[i]+" ");
			}
		}
		System.out.println();
	}
	
	private static int findSoldierPosition(int n) {
		if(n<=0) {
			return -1;
		}
		//See if n is power of 2 because all power of 2 numbers the winner will always be first person
		if((n!=0) && ((n & (n-1))) == 0){
			 return 1;
		 }
		//Get the highest possible power of 2 number
		int highestPwrOf2Number = 0;
		for(int i=n;i>=1;i--) {
			if((i & (i-1)) == 0) {
				highestPwrOf2Number = i;
				break;
			}
		}
		//Store all soldiers in a list
		ArrayList<Integer> soldiers = new ArrayList<Integer>();
		for(int i=1;i<=n;i++) {
			soldiers.add(i);
		}
		//Get the remainder of number of soldiers minus highest possible power of 2 number
		int remainder = n-highestPwrOf2Number;
		int indexLastSoldier = 0;
		//Iterate from 0 to the remainder
		for(int i=0;i<remainder;i++) {
			soldiers.remove(i+1); //Kill the soldier next to me 
			indexLastSoldier = i+1; //Save the index
		}
		return soldiers.get(indexLastSoldier); //Return the soldier at the index saved
		
	}
	
	
	public static void main(String[] args) {
		String inputString = new String("happy new year 2022");
		findVowels(inputString,3);
		int numberOfSoldiers = 9;
		int result = findSoldierPosition(numberOfSoldiers);
		if(result==-1){
			System.out.println("Please enter a positive number greather than 0");
			return;
		}
		System.out.println("With "+ numberOfSoldiers + " soldiers, you need to sit at index "+result+ " to live");
	}
}
