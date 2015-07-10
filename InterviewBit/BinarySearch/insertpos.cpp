#include <iostream>
#include <vector>
using namespace std;

int searchInsert(vector<int> &A, int B) {
  vector<int> result{-1,-1};
  int mid;
  int insertPos = -1;

  int begin = 0;
  int end = A.size()-1;

  while (begin <= end) {
    mid = (begin+end)/2;

    if(A[mid] == B){
      break;
    }
    if(B > A[mid]){
      begin = mid+1;
      if(mid+1 > A.size()) {
        if( B<A[mid+1]) {
          insertPos = mid;
        }
      }
    } else if ( B < A[mid] ) {
      end = mid-1;
      if(mid-1 >= 0) {
        if( B>A[mid-1]) {
          insertPos = mid;
        }
      }
    }
  }

  if(A[mid] == B){
    return mid;
  }
  if (insertPos != -1){
    return insertPos;
  }
  if(B < A[0]){
    return 0;
  }
  return A.size();
}


int main() {
  vector<int> a{1,3,5,6};
  cout << searchInsert(a,2);
  return 0;
}
