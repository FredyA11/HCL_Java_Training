import java.util.ArrayList;
import java.util.LinkedList;

public class SecondTask {

	private static void findVowels(String str,int position) {
		if(position == 0) return;
		char[] stringChars= str.toCharArray();
		System.out.println("Original String: "+str);
		System.out.println();
		System.out.println("Vowels every "+ position+ " positions in string:");
		for(int i=position-1;i<stringChars.length;i+=position) {
			if(stringChars[i] == 'a' || stringChars[i] == 'e' || stringChars[i]=='i' || stringChars[i]=='o' || stringChars[i]=='u') {
				System.out.println(stringChars[i]+" at index "+i);
			}
		}
		System.out.println();
	}
	
	private static int findSoldierPosition(int n) {
		if(n<=0) return -1; //Validate positive numbers for n
		LinkedList<Integer> ll = new LinkedList<Integer>(); //List to store the soldiers
		for(int i=1;i<=n;i++) { //Add the numbers representing the soldiers to the list
			ll.add(i);
		}
		int index=0; //Define index
		while(ll.size() != 1) { //While there's more than 1 element on the list continue
			if(index > ll.size()-1) { //If the index is greater than the list size then reset to 0
				//This represents that a lap has been completed in the circle
				index=0;	
			}
			else {
				if(index+1 == ll.size()) { //If our current position is the same as the size of the list containing the soldiers that are alive
					//then kill the one at the beginning
					System.out.println("Soldier "+(ll.get(index))+  " killed soldier " + ll.getFirst());
					ll.removeFirst();
				}
				else {
					System.out.println("Soldier "+(ll.get(index))+  " killed soldier " + ll.get(index+1));
					ll.remove(index+1); //Kill the soldier to my right
				}
				index++; //Increase the index to move to next alive soldier
			}
			
		}
		System.out.println("Soldier left:"+ ll.getFirst()); 
		//At this point only one soldier is left so return the soldier that is alive
		return ll.getFirst();
	}
	
	public static void main(String[] args) {
		String inputString = new String("Hello world");
		findVowels(inputString,2);
		int numberOfSoldiers = 100;
		int result = findSoldierPosition(numberOfSoldiers);
		if(result==-1){
			System.out.println("Number of soldiers should be greater than 0");
			return;
		}

		System.out.println("With "+ numberOfSoldiers + " soldiers, you need to sit at position "+result+ " to live");
	}
}
