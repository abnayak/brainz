#include <iostream>
#include <algorithm>

using namespace std;

vector<int> plusOne(vector<int> &A) {
  int carry = 0;

  for(int i = A.size()-1; i >= 0; i--) {
    if( i == A.size()-1){
      A[i] += 1;
    }else {
      A[i] += carry;
      carry = 0;
    }

    if(A[i] > 9){
      A[i] = 0;
      carry = 1;
    }
  }

  if(carry == 1){
    A.insert(A.begin(),carry);
  }

  while (A[0] == 0){
      A.erase(A.begin());
  }

  return A;
}

int main() {
  vector<int> A{ 0, 6, 0, 6, 4, 8, 8, 1};
  vector<int> result = plusOne(A);
  for(auto i: result) {
    cout << i ;
  }
  cout << endl;
  return 0;
}
