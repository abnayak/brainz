#include <iostream>

using namespace std;

int pow(int x, int n, int d) {
  if (n == 0)
    x = 1;

  int newx = x;

  while ( n >= 2) {
      long long int mul = newx*newx;
      cout << "Mul: " << mul << endl;
      n /=2;
      newx = mul % d;
    }

    return newx%d;
  }


int main() {
  cout << pow(-1,2,20);
  return 0;
}
