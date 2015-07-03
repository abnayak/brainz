#include <iostream>

using namespace std;

int gcd(int A, int B) {
  int min = A >= B? B : A;
  int max = A >= B? A : B;
  while ( min > 0 ){
    int temp = max - min;
    if( temp >= min){
      max = temp;
    } else {
      max = min;
      min = temp;
    }
  }
  return max;
}

int main() {
  cout << gcd(100,50) << endl;
  return 0;
}
