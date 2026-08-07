import java.util.Scanner;
public class TicTacToe {
    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);

        System.out.println("=====================");
        System.out.println("     TIC TAC TOE");
        System.out.println("=====================");
        System.out.println();

        System.out.print("Enter Player 1 name (X): ");
       String player1 = sc.nextLine();

        System.out.print("Enter Player 2 name (O): ");
        String player2 = sc.nextLine();
          boolean playAgain=true;
        char currentPlayer='X';
        while(playAgain){

        
        boolean gameRunning = true;
        
        
        char[][] board = {
    {' ', ' ', ' '},
    {' ', ' ', ' '},
    {' ', ' ', ' '}
};
while(gameRunning){

    printBoard(board);

 if(currentPlayer == 'X'){

    System.out.println(player1 + "'s Turn (X)");

}
else{

    System.out.println(player2 + "'s Turn (O)");

}

 System.out.print("enter row(0-2) :");
 int row= sc.nextInt();

 System.out.print("Enter column (0-2): ");
 int col = sc.nextInt();


 if(row>=0 && row<board.length && col>=0 && col<board[0].length){

    if(board[row][col]==' '){

       board[row][col] = currentPlayer;

       if(checkWinner(board,currentPlayer)){

      System.out.println(getPlayerName(currentPlayer, player1, player2) + " Wins!");

        gameRunning=false;


       } else if(checkDraw(board)){
            System.out.println("Its a draw");
            gameRunning=false;
        }
       else{

       


       if (currentPlayer == 'X') {
    currentPlayer = 'O';
} else {
    currentPlayer = 'X';
}

       }

    }else{
        System.out.println("cell already occupied");
       
    }
    
 
 }else{
    System.out.println("Invalid Position!");
   


 }
 
 
    }

    System.out.println("Play again? (yes/no):");
    String answer= sc.next();

    if(answer.equalsIgnoreCase("no")){
        playAgain=false;
    }

        }
    }
    static void printBoard(char[][] board) {
       
        for(int i=0;i<board.length;i++){

            for(int j=0;j<board[i].length;j++){

              
                    System.out.print(" " + board[i][j] + " ");
                

                if(j<board.length-1){
                    System.out.print("|");
                }
               
            }
             System.out.println();
             if(i<board.length-1){
                System.out.println("-----------");
             }
             
           
        }
}


static boolean checkWinner(char[][] board, char currentPlayer){

     for(int i=0;i<board.length;i++){
             
      boolean rowWin=true;

      for(int j=0;j<board[0].length;j++){
          
        if(board[i][j]!=currentPlayer){

            rowWin=false;
        }

      }
        if(rowWin){
            return true;
        }
}

for(int j=0;j<board[0].length;j++){

    boolean colWin=true;
    
    for(int i=0;i<board.length;i++){

        if(board[i][j]!=currentPlayer){
            colWin=false;
        }
    }
    if(colWin){
        return true;
    }

}
boolean digWin=true;
for(int i=0;i<board.length;i++){

    if(board[i][i]!=currentPlayer){
        digWin=false;
    }
    
}

boolean antiDigWin=true;

for(int i=0;i<board.length;i++){
    if(board[i][board.length-i-1]!= currentPlayer){
        antiDigWin=false;
    }

}
if(antiDigWin){
    return true;
}

return false;





}


static boolean checkDraw(char[][] board){

   for(int i=0;i<board.length;i++){
         for(int j=0;j<board[0].length;j++){
             

            if(board[i][j]==' '){
                return false;
            }
         }
   }

   return true;
}

static String getPlayerName(char currentPlayer, String player1, String player2){

    if(currentPlayer == 'X'){
        return player1;
    }
    else{
        return player2;
    }

}


}
