package Recursion.NQueens.Java;
import java.util.*;

public class NQueens {
    public static boolean isSafe(char[][] board, int n, int row, int col) {
        int trow = row, tcol = col;
        while ( trow >= 0 && tcol >= 0 ) {
           if ( board[trow][tcol] == 'Q' ) return false;
           trow--;
           tcol--;
        }
        trow = row;
        tcol = col;
        while ( tcol >= 0 ) {
          if ( board[trow][tcol] == 'Q' ) return false;
          tcol--;
        }
        trow = row;
        tcol = col;
        while ( tcol >= 0 && trow < n ) {
           if ( board[trow][tcol] == 'Q' ) return false;
           trow++;
           tcol--;
        }
 
        return true;
     }
 
     public static void fillBoard(List < List < String > > boards, char[][] board, int n, int index) {
         if ( index == n ) {
             boards.add(construct(board));
             return;
         }
 
         for ( int i = 0 ; i < n ; i++ ) {
             if ( isSafe(board, n, i, index)) {
                 board[i][index] = 'Q';
                 fillBoard(boards, board, n, index + 1);
                 board[i][index] = '.';
             }
         }
     }
 
     public static void fillBoardOptimized(List < List < String > > boards, char[][] board, int index, int[] leftRow, int[] upperDiagonal, int[] lowerDiagonal) {
 
        if ( board.length == index ) {
           boards.add(construct(board));
           return;
        }
 
        for ( int i = 0 ; i < board.length ; i++ ) {
           if ( leftRow[i] == 0 && lowerDiagonal[i + index] == 0 && upperDiagonal[board.length - 1 + index - i] == 0 ) {
             board[i][index] = 'Q'; 
             leftRow[i] = 1;
              lowerDiagonal[i + index] = 1;
              upperDiagonal[board.length - 1 + index - i] = 1;
              fillBoardOptimized(boards, board, index + 1, leftRow, upperDiagonal, lowerDiagonal);
              board[i][index] = '.';
              leftRow[i] = 0;
              lowerDiagonal[i + index] = 0;
              upperDiagonal[board.length - 1 + index - i] = 0;
           }
        }
 
     }
 
     public static List < String > construct(char[][] board) {
         List < String > output = new ArrayList<String>();
         for ( int i = 0 ; i < board.length ; i++ ) {
             output.add(new String(board[i]));
         }
         return output;
     }
 
     public static List<List<String>> solveNQueens(int n) {
         
         List < List < String > > boards = new ArrayList<>();
         char[][] board = new char[n][n]; 
         for ( int i = 0 ; i < n ; i++ ) {
             for ( int j = 0 ;  j < n ; j++ ) {
                 board[i][j] = '.'; 
             }
         }
         
         //fillBoard(boards, board, n , 0);
         fillBoardOptimized(boards, board, 0, new int[2 * n - 1], new int[2 * n - 1], new int[2 * n - 1]);
        return boards; 
     }

     public static void main(String[] args ) {
         Scanner sc = new Scanner(System.in);
         int n = sc.nextInt();
         List < List < String > > Boards = solveNQueens(n);
         for ( List < String > board : Boards ) {
            for ( String s : board ) {
                System.out.println(s);
            }
            System.out.println();
            System.out.println();
         }
         sc.close();
     }
 
}
