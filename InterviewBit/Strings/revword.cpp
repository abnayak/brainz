#include <iostream>
#include <locale>
#include <vector>
#include <functional>
#include <cctype>
#include <algorithm>

using namespace std;

void reverseWords(string &A) {
  vector<char> reverse;
  string result = "";

  for(int i = A.size()-1; i>= 0 ;i--) {
    reverse.push_back(A[i]);
  }

  for(int i=0;i<reverse.size();) {
    if(isspace(reverse[i])) {
      i++;
    } else if(isalpha(reverse[i])) {
      int begin = i;
      while (isalpha(reverse[++i]) && i < reverse.size());
      int end = i-1;
      // reverse the word
      for(int j= end; j>=begin; j--) {
        result += reverse[j];
      }
      result += " ";
    }
  }
  result.erase(result.begin(), find_if(result.begin(), result.end(), not1(ptr_fun<int, int>(isspace))));
  result.erase(find_if(result.rbegin(), result.rend(), not1(ptr_fun<int, int>(isspace))).base(), result.end());
  A = result;
}

int main() {
  string str = "  abhijeet  ";
  reverseWords(str);
  cout << str << endl;
  cout << "size: " << str.size() << endl;
  return 0;
}
