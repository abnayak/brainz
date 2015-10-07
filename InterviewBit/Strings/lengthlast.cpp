#include <iostream>
#include <algorithm>
#include <cctype>

using namespace std;

int lengthOfLastWord(const string &A) {
    string lastWord = "";

    for (auto i=0; i < A.size(); ) {
      if (A[i] == ' ') {
        i++;
      }
      if (isalpha(A[i])) {
        int begin = i;
        while (isalpha(A[++i]) && i <= A.size());
        lastWord = A.substr(begin, i-begin);
      }
    }
    return lastWord.size();
}

int main() {
  cout << lengthOfLastWord("") << endl;
  return 0;
}
