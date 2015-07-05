#include <iostream>
#include <climits>

using namespace std;

int reverse(int A) {
  int negative=1;
  if(A < 0){
    negative=-1;
    A *= -1;
  }
  long int rev=0;
  while(A) {
    int temp = A %10;
    A /= 10;
    rev *= 10;
    rev += temp;
  }
  rev *= negative;
  if( rev < INT_MIN || rev > INT_MAX)
    return 0;
  else
    return rev;
}

int main() {
  cout << INT_MAX <<endl;
  cout << reverse(INT_MAX) << endl;
  return 0;
}
