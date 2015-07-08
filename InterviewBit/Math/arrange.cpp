#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

void arrange(vector<int> &A) {
    if(A.size() == 0)
      return;
    for(int i = 0; i< A.size(); i++) {
      while (A[A[i]] != A[i]) {
        swap(A[A[i]],A[i]);
      }
  }
}



int main() {
  vector<int> A{2,3,0,1,4};
  arrange(A);
  for(auto i : A){
    cout << i << " ";
  }
  cout << endl;
  return 0;
}
