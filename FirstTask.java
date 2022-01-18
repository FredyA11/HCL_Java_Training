public class FirstTask {
	
	 public static void firstSegment(){
        int k =4;
        for(int i =1; i<= 5; i++) {
            int lastJCount =0;
            for(int j=0; j<k; j++) {
                System.out.print("*");
                lastJCount = j;
            }
            if(k==0) lastJCount=-1;
            for(int a = lastJCount+1; a<5; a++) {
                if(i%2 == 0) System.out.print("E");
                else System.out.print("O");
            }
            k--;
            System.out.println();
        } 
	 }

    public static void secondSegment(){
        for(int i=0;i<5;i++){ //Iterate through each row
            if(i%2==0) System.out.println("******"); //If i is even then print first pattern
            else System.out.println(" **** "); //Else print second pattern
        }
    }

    public static void thirdSegment(){
        
        //First way (simplest way, constant complexity O(1))
        for(int i=0;i<5;i++){
            if(i%2==0) System.out.println("OO**OO");
            else System.out.println("**EE**");
        }

        //Second way (more logic and constant complexity O(1))
        /*
        for(int i=0;i<5;i++){ //Rows
            String letter = "O"; 
            boolean isLetters = true; //Variable to determine if letters or * should be printed
            if(i%2!=0){ //If number is even paint * first
                isLetters= false;
                letter="E";
            }
            int auxCounter = 0; //Counter to change print element every 2 positions
            for(int j=0;j<6;j++){
                if(auxCounter<2){ //If the counter is less than 2 and letters should be printed, print letters, else print *
                    if(isLetters) System.out.print(letter);
                    else System.out.print("*");
                } //If the counter is more than 2 then that means we should swap what is printed (instead of letters print * and viceversa)
                else{
                    if(isLetters){ //If letters were being printed, now print * 
                        System.out.print("*");
                        isLetters=false;
                    }
                    else{ //Else print letters
                        System.out.print(letter);
                        isLetters=true;

                    }
                    auxCounter=0; //Reset the counter
                }
                auxCounter++; //Increase the counter
            }
            System.out.println();
        }*/
    }



    public static void main(String[] args) {
        firstSegment();
        System.out.println("------------------");
        secondSegment();
        System.out.println("------------------");
        thirdSegment();
    }
}
