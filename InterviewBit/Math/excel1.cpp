#include <iostream>
#include <algorithm>
#include <vector>
#include <cmath>

using namespace std;

int titleToNumber(string A) {
  long long number  = 0 ;
  for(auto i = A.begin(); i != A.end(); ){
    number += (pow(26,(A.size()-1))) * (*i-'A'+1);
    A.erase(i);
    i = A.begin();
  }
  return number;
}

int main() {
  string A = "AA";
  cout << titleToNumber(A);
  return 0;
}
