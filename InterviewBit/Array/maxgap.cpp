#include <iostream>
#include <algorithm>
#include <limits>
#include <bitset>
#include <vector>

using namespace std;

int maximumGap(const vector<int> &A) {
  if(A.size() <2)
    return 0;

  const unsigned int base = 2;
  const int size = base^32;
  bitset<size> hash;
  for(unsigned int i = 0; i < A.size(); i++){
    hash[A[i]] = 1;
  }
  int maxGap=0;
  int back=0;
  int front=0;

  unsigned int i;
  for(i =0 ; i < A.size(); i++){
    if( A[i] == 1){
      back = i;
      break;
    }
  }

  for(int j=i+1; j< A.size(); j++ ){
    if(A[j] == 1) {
      front = j;
      if ( maxGap < A[j] - A[i] ){
        maxGap = A[j] - A[i];
      }
      back = front;
    }
  }

  return maxGap;
}

int main() {
  vector<int> A{10,1,7,9,5};
  cout << maximumGap(A) << endl;
  return 0;

}
