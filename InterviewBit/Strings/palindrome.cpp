#include <iostream>
#include <algorithm>
#include <vector>
#include <cctype>

using namespace std;

int isPalindrome(string A) {
  vector<char> str;
  for(int itr = 0; itr != A.size(); itr++) {
    if(isalpha(A[itr])) {
      str.push_back(tolower(A[itr]));
    } else if (isdigit(A[itr])) {
      str.push_back(A[itr]);
    }
  }

  if (str.size() == 0)
    return 1;

  for (int begin = 0, end=str.size()-1; begin <= end ; begin++, end--) {
      if (str[begin] != str[end]) {
        return 0;
      }
  }
  return 1;
}

int main() {

  cout<< isPalindrome("1    man, a plan, a canal: Panam1") << endl;

  return 0;
}
