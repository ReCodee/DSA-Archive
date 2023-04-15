#include <iostream>
#include <vector>
using namespace std;

void printAllSubsequences(vector< int > arr, vector< int > res, int index) {
    if ( index >= arr.size() ) {
        for ( auto e : res ) {
            cout << e << " ";
        }
        cout << endl;
        return;
    }
    res.push_back(arr[index]);
    printAllSubsequences(arr, res, index + 1);
    res.pop_back();
    printAllSubsequences(arr, res, index + 1);
}
int main() {
    int n;
    cin >> n;
    vector < int > arr(n), res;
    for ( int i = 0 ; i < n ; i++ ) {
        cin >> arr[i];
    }
    printAllSubsequences(arr, res, 0);
}