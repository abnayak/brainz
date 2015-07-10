#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

int Solution::searchMatrix(vector<vector<int> > &A, int B) {
    int rowLen = A.size();;
    int columnlen = A[0].size();

    for (int i = 0, j=0; i < rowLen && j < columnlen; ) {
        if (A[i][j] == B)
          return 1;
        if(B <= A[i][columnlen-1]) {
          j++;
        } else {
          i++;
        }
    }
    return 0;
}

int main() {

  int a[7][1] = { {3} , {29}, {36}, {63}, {67}, {72},{74} };
  cout << searchMatrix(a, 41) << endl;
  return 0;
}
