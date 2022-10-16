import java.io.*;
import java.util.*;

class SetMatrixZeroes {
    
    static void bruteForce(int[][] matrix) {
       int[][] dummy = Arrays.stream(matrix).map(int[]::clone).toArray(int[][]::new);

        for ( int i = 0 ; i < dummy.length ; i++ ) {
            for ( int j = 0 ; j < dummy[0].length ; j++ ) {
                
                if ( matrix[i][j] == 0 ) {
                    
                    for ( int k = 0 ; k < matrix.length ; k++ ) {
                        dummy[k][j] = 0;
                    }
    
                    for ( int k = 0 ; k < matrix[0].length ; k++ ) {
                        dummy[i][k] = 0;
                    }
                    
                }
                
            }
        }
        
        for ( int i = 0 ; i < matrix.length ; i++ ) {
            for ( int j = 0 ; j < matrix[0].length ; j++ ) {
                matrix[i][j] = dummy[i][j];
            }
        }

    }

    static void optimized(int[][] matrix) {
       int[] rowdummy = new int[matrix.length];
        int[] coldummy = new int[matrix[0].length];
        
        Arrays.fill(rowdummy, 1);
        Arrays.fill(coldummy, 1);
        
        for ( int i = 0 ; i < matrix.length ; i++ ) {
            for ( int j = 0 ; j < matrix[0].length ; j++ ) {
                if ( matrix[i][j] == 0 ) {
                    rowdummy[i] = 0;
                    coldummy[j] = 0;
                }
            }
        }
        
        for ( int i = 0 ; i < matrix.length ; i++ ) {
            for ( int j = 0 ; j < matrix[0].length ; j++ ) {
                if ( rowdummy[i] == 0 || coldummy[j] == 0 ) {
                   matrix[i][j] = 0;    
                }
            }
        }
    }

    static void optimal(int[][] matrix) {
     int corner = 1;
        
        for ( int i = 0 ; i < matrix.length ; i++ ) {
             if ( matrix[i][0] == 0 ) 
                 corner = 0;
            for ( int j = 1 ; j < matrix[0].length ; j++ ) {
                if ( matrix[i][j] == 0 ) {
                   matrix[0][j] = 0;
                   matrix[i][0] = 0;
                }
            }
        }
        
        for ( int i = matrix.length - 1 ; i >= 0 ; i-- ) {
            for ( int j = matrix[0].length - 1 ; j > 0 ; j-- ) {
                if ( matrix[i][0] == 0 || matrix[0][j] == 0 ) {
                   matrix[i][j] = 0;    
                }
            }
            if ( corner == 0 ) {
               matrix[i][0] = 0;
            }
        }
    }

    public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      int m, n;
      m = sc.nextInt();
      n = sc.nextInt();

      int[][] matrix = new int[m][n];

      for ( int i = 0 ; i < m ; i++ ) {
          for ( int j = 0 ; j < n ; j++ ) {
            int input = sc.nextInt();
            matrix[i][j] = input;
          }
      }

      optimal(matrix);

      for ( int i = 0 ; i < m ; i++ ) {
          for ( int j = 0 ; j < n ; j++ ) {
               System.out.print(matrix[i][j] + " ");       
           }    
           System.out.println(' ');  
        }
      }     
    }