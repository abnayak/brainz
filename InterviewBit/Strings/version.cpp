#include <iostream>
#include <algorithm>
#include <sstream>
#include <vector>
#include <iterator>

using namespace std;

int compareVersion(string A, string B) {
  stringstream sa(A);
  stringstream sb(B);
  vector<string> a;
  vector<string> b;

  string item;
  char delim='.';

  while(getline(sa, item, delim)) {
    a.push_back(item);
  }

  while (getline(sb, item, delim)) {
    b.push_back(item);
  }
  // make both the vector of same size
  if (a.size() > b.size()) {
    for(int j=1; j <= a.size() - b.size() ; j++) {
          b.push_back("0");
    }
  } else if (a.size() < b.size()) {
      for(int j=1; j <= b.size() - a.size() ; j++) {
        a.push_back("0");
      }
  }

  for(int i=0; i<a.size() && i<b.size();i++) {
      string stra = a[i];
      string strb = b[i];
      int j;
      for(j=0; j < stra.size() && stra[j] == '0'; j++);
      stra = stra.substr(j);
      for(j=0; j < strb.size() && strb[j] == '0'; j++);
      strb = strb.substr(j);

      int len = stra.size() >= strb.size() ? stra.size(): strb.size();

      if (stra.size() > strb.size()) {
        return 1;
      } else if ( strb.size() > stra.size()) {
        return -1;
      } else {
          for(int j= 0; j< len ; j++) {
            if (stra[j] > strb[j]) {
              return 1;
            } else if( strb[i] > stra[i]) {
              return -1;
            }
          }
      }
    }
  return 0;
}

int main() {
  cout << compareVersion("01", "1") << endl;
  return 0;
}
