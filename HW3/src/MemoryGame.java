/** @author Michael Groot*/

/** importing packages so I can do stuff*/
import java.util.*;

/** here is the class*/
public class MemoryGame {
	
	/** main method*/
    public static void main(String[] args){
    	
    	/** initializing string for is the user wants to continue*/
        String keepGoing = null;
        
        /** new scanner for inputs*/
        Scanner input=new Scanner(System.in);
        
        /** Instructions to user for inputs*/
        System.out.println("Enter the coordinate of the desired card when prompted.");
        System.out.println("e.g '12' gives row 1 column 2, etc.  Numbers from 1-4 only are allowed");
        System.out.println();
        
        /** loop to make a new board and run the game as long as the user wants to continue*/
        do {
            printBoard();
            System.out.println("Yay!  You won!  You have a great memory!");
            System.out.println("Do you want to play again? Yes/No(Y/N)");
            keepGoing=input.next();
        }
        
        while (keepGoing.equals("y")||keepGoing.equals("Y"));
        
        /** closing scanner*/
        input.close();
        
    /** thanks for playing*/    
    System.out.println("Thank You for playing");
    
    
    }
 
 
    /** method for printing the board*/
    public static void printBoard(){
    	
    	/** creating array for card numbers*/
        int cards[][]=new int[4][4];
        
        /** creating array for if the card is flipped or not*/
        boolean cardFlipped[][]=new boolean[4][4];
        
        /** shuffling cards*/
        cards=shuffleCards();
        
        /** this is just printing the general top row of the board, no cards*/
        System.out.println("   | 1 2 3 4 ");
        System.out.println("---+---------");
        
        /** this starts printing the left side of the board */
        for(int i=0;i<4;++i){
        	
            System.out.print(" " +(i+1) +" | ");
            
            /** and this prints the cards face down*/
            for(int j=0;j<4;++j){
            	
                System.out.print("* ");
        
                cardFlipped[i][j]=false;
            }
            
            System.out.println();
        }
        
        System.out.println();
        cardFlipper(cardFlipped,cards);
}
 
 
    /** this is where the actual game starts*/
    public static void cardFlipper(boolean[][] cardFlipped,int[][] cards){
       
    	/** boolean variable to determine if game is complete*/
    	boolean gameComplete=false;
    	
    	/** scanner for input from user*/
        Scanner input=new Scanner(System.in);
 
        char userPickRow1,userPickRow2,userPickColumn1,userPickColumn2;
        int row1,column1;
        int row2=0,column2=0;
        do
        {
        	
        	/** time for the user to make some choices*/
            do
            {
            	
            	/** ask for input*/
                System.out.println("Please insert the 1st card:");
                
                /** set the input to a string*/
                String userPick1=new String(input.next());
                
                /** separate the two numbers from the input into different values for row and column*/
                userPickRow1=userPick1.charAt(0);userPickColumn1=userPick1.charAt(1);
                
                /** changing the char value to a numerical value*/
                row1=Character.digit(userPickRow1,5);column1=Character.digit(userPickColumn1,5);
                
                /** determining if selected card is already flipped*/
                if(cardFlipped[row1-1][column1-1] == true)
                {
                    System.out.println("This card is already flipped! Select another card.");
                }
                
                
            }
            
            /** */
            while(cardFlipped[row1-1][column1-1]!= false);
            
            
            do
            {
            	
            	/** same kind of deal for the second card selection*/
                System.out.println("Please insert the 2nd card:");
                
                String userPick2=new String(input.next());
                
                userPickRow2=userPick2.charAt(0);userPickColumn2=userPick2.charAt(1);
                
                row2=Character.digit(userPickRow2,5);column2=Character.digit(userPickColumn2,5);
                
                /** process if card is already flipped*/
                if(cardFlipped[row2-1][column2-1] == true)
                {
                    System.out.println("This card is already flipped! Select another card.");
                }
                
                /** process if card was duplicate of first choice*/
                if((row1==row2)&&(column1==column2)){
                    System.out.println("This card is already chosen! Select another card.");
                }
            }
            
            while((cardFlipped[row2-1][column2-1]!= false)||((row1==row2)&&(column1==column2)));
            
            /** subtracting one from the variables*/
            row1--;
            column1--;
            row2--;
            column2--;
            
            /** printing the top half of the board*/
            System.out.println();
            System.out.println("   | 1 2 3 4 ");
            System.out.println("---+---------");
            
            /** r indicates row, c indicates column*/
            for (int r=0; r<4; r++)
            {
            	/** printing the left side of the board*/
                System.out.print(" " +(r+1) +" | ");
                
                /** taking card inputs and flipping them if chosen, or showing card backs if they arent*/
                for (int c=0; c<4; c++)
                {
                	/** showing the first choice card*/
                    if ((r==row1)&&(c==column1))
                    {
                        System.out.print(cards[r][c] +" ");
                    }
                    /** showing the second choice card*/
                    else if((r==row2)&&(c==column2))
                    {
                        System.out.print(cards[r][c] +" ");
                    }
                    /** showing cards that are already matched*/
                    else if (cardFlipped[r][c] == true)
                    {
                        System.out.print(cards[r][c] +" ");
                    }
                    /** card back if card is not chosen*/
                    else
                    {
                        System.out.print("* ");
                    }
                }
                System.out.println();
            }
            System.out.println();
            
            /** This is to keep cards flipped if they match*/
            if (cards[row1][column1]==cards[row2][column2]) 
            {
                System.out.println("Cards Matched!");
 
                cardFlipped[row1][column1] = true;
                cardFlipped[row2][column2] = true;
            }
            
            /** this is so there is a short delay for the user to see their selections before moving on*/
            try
            {
                Thread.sleep(2000);
 
            }catch (InterruptedException ie)
            {
                System.out.println(ie.getMessage());
            }
            
            /** now reprinting the board for a new guess*/
            for (int b=0; b<=20; b++){
                System.out.println();
            }
            
            /** top of board*/
            System.out.println("   | 1 2 3 4 ");
            System.out.println("---+---------");
            
            /** resetting chosen cards if they dont match*/
            for (int r=0; r<4; r++) 
            {
                System.out.print(" " +(r+1) +" | ");
                for (int c=0; c<4; c++)
                {
                	
                	/** if matching, they stay flipped*/
                    if (cardFlipped[r][c] == true)
                    {
                        System.out.print(cards[r][c] +" ");
                    }
                    
                    /** if not, the card back is shown*/
                    else
                    {
                        System.out.print("* ");
                    }
                }
                System.out.println();
            }
            System.out.println();
            
            /** variable for if game is finished*/
            gameComplete = true;
            
            /** checking to see if all the cards are matched and flipped to end game*/
            for (int r=0; r<4; r++)
            {
            	
            	/** going through all the cards*/
                for (int c=0; c<4; c++)
                {
                	
                	/** if a card isn't flipped, game isn't finished*/
                    if(cardFlipped[r][c]==false)
                    {
                      gameComplete = false;
                      c=5;
                    }
                }
                
                /** shortcut if game isn't finished to end loop*/
                if(gameComplete == false)
                {
                    r=5;
                }
            }
        }
        
        /** this is the loop so that the game continues to run until all the cards are finished*/
        while(gameComplete != true);
    
        input.close();
    
    }
 
 
 
    /** this is a method to shuffle the cards*/
    public static int[][] shuffleCards(){
    	
    	/** getting card numbers*/
        int start[]={1,2,3,4,5,6,7,8,1,2,3,4,5,6,7,8};
        
        /** new 2d array*/
        int cards[][]=new int[4][4];
        
        /** new random object*/
        Random ran=new Random();
        int tmp,i;
        for (int s=0; s<=20; s++)
        {
        	
        	/** this is to randomize where the cards are placed*/
            for (int x=0; x<16; x++)
            {
                i=ran.nextInt(100000)%15;
                tmp=start[x];
                start[x]=start[i];
                start[i]=tmp;
            }
        }
        i=0;
        
        /** this is to put the values in the cards*/
        for (int r=0; r<4; r++)
        
        {
            for (int c=0; c<4; c++)
            {
                cards[r][c]=start[i];
                i=i+1;
            }
        }
        return cards;
    }
	
	
}
