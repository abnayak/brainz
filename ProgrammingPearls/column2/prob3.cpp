#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

int main() {
  vector<char> array {'a','b','c','d','e'};
  // Rotate this vetor by two places counter clockwise
  reverse(array.begin(),array.begin()+2);
  reverse(array.begin()+3, array.end());
  reverse(array.begin(),array.end());
  for(char i : array) {
    cout << i << " ";
  }
  cout << endl;
  return 0;
}
