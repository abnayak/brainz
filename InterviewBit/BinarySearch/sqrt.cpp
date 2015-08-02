#include <cmath>
#include <iostream>

using namespace std;

int sqrt(int A) {
    long double max = A;
    long double min = 0;
    long double mid = (max+min)/2;
    if ( A == 1)
       return 1;
    if ( A == 0)
      return 0;

    while (1) {
      long double mul = mid * mid;
      long double diff = mul - A;
      if (diff > 0.1) {
        max = mid;
        //cout << "greater: " << mid << endl;
      } else if (diff < -0.000001) {
        min = mid;
        //cout << "small: " << mid << endl;
      } else if ( diff >= -0.000001 && diff <= 0.1){
        break;
      }
      mid = (max+min)/2;
    }
    //cout << "mid: " << mid << endl;;
    return floor(mid);
}

int main() {
  cout << sqrt(9999999) << endl;
  return 0;
}
