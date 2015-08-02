#include <iostream>
#include <algorithm>

using namespace std;

int Solution::paint(int A, int B, vector<int> &C) {
  int start = 0;
  int end = accumulate(C.begin(), C.end()) * B;

  int mid = (start + end) / 2
  while (1) {
    int individualTime = mid/B;
    int currentMaxSum = 0;
    int painter = 0;
    int newSum=0;
    for(auto board : C){
      if(newSum+board < individualTime){
        newSum += board;
      }else {
        painter++;
      }
      if (newSum > currentMaxSum)
        currentMaxSum = newSum;
    }
    if(painter)
  }
   if isPossible(mid):
     start = mid + 1
   else
   end = mid - 1

}
int main() {


  return 0;
}
