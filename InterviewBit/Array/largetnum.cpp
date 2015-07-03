#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

string largestNumber(const vector<int> &A) {
  vector<int> copy (A);
  while (copy.size() > 0 && copy[0] == 0){
    copy.erase(copy.begin());
  }

  if( copy.size() == 0){
    return to_string(0);
  }

  vector<string> numbers;
  for(auto i : A){
    numbers.push_back(to_string(i));
  }

  sort(numbers.begin(), numbers.end(), [](string a, string b){
    string pattern1 = a + b;
    string pattern2 = b + a;
    long long p1 = stol(pattern1);
    long long p2 = stol(pattern2);
    return p1 > p2;
  });

  string result = "" ;
  for(auto i : numbers) {
    result += i;
  }
  return result;
}

int main () {
  vector<int> A {2,1};
  cout << largestNumber(A) << endl;
  return 0;
}
