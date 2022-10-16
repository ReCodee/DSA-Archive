#include <iostream>
#include <vector>
using namespace std;

void bruteForce(vector < vector < int > >& matrix) {
  vector < vector < int > > dummy(matrix);
        for ( int i = 0 ; i < matrix.size() ; i++ ) {
            for ( int j = 0 ; j < matrix[i].size() ; j++ ) {
                
                if ( matrix[i][j] == 0 ) {
                    for ( int k = 0 ; k < matrix[0].size() ; k++ ) 
                         dummy[i][k] = 0;
                    for ( int k = 0 ; k < matrix.size() ; k++ )
                        dummy[k][j] = 0;
                }
                
            }
        }
        
        for ( int i = 0 ; i < matrix.size() ; i++ ) {
            for ( int j = 0 ; j < matrix[i].size() ; j++ ) {
                matrix[i][j] = dummy[i][j];
            }
        }
}

void optimized(vector < vector < int > >& matrix) {
     vector < int > rowdummy(matrix.size(), 1);
        vector < int > coldummy(matrix[0].size(), 1);
        
        for ( int i = 0 ; i < matrix.size() ; i++ ) {
            for ( int j = 0 ; j < matrix[i].size() ; j++ ) {
                if ( matrix[i][j] == 0 ) {
                    rowdummy[i] = 0;
                    coldummy[j] = 0;
                }
            }
        }
        
        for ( int i = 0 ; i < matrix.size() ; i++ ) {
            for ( int j = 0 ; j < matrix[i].size() ; j++ ) {
         
                if ( rowdummy[i] == 0 or coldummy[j] == 0 ) {
                    matrix[i][j] = 0;
                }
                 
            }
        } 
}

void optimal(vector < vector < int > >& matrix) {
     int corner = 1;
        
        for ( int i = 0 ; i < matrix.size() ; i++ ) {
              if ( matrix[i][0] == 0 )
                   corner = 0;
            for ( int j = 1 ; j < matrix[i].size() ; j++ ) {
                if ( matrix[i][j] == 0 ) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }
        
        for ( int i = matrix.size() - 1 ; i >= 0 ; i-- ) {
            for ( int j = matrix[i].size() - 1 ; j > 0 ; j-- ) {
                
                if ( matrix[0][j] == 0 or matrix[i][0] == 0 ) {
                    matrix[i][j] = 0;
                }
            }
            if ( corner == 0 )
                    matrix[i][0] = 0;
        }
}

int main() {
  int m, n;
  cin >> m >> n;
  vector < vector < int > > matrix(m, vector < int >(n));
  for ( int i = 0 ; i < m ; i++ ) {
     for ( int j = 0 ; j < n ; j++ ) {
         cin >> matrix[i][j];
     }
  }
}