#include <iostream>
using namespace std;

//http://en.wikipedia.org/wiki/Longest_common_substring_problem

void commonSubString(string a, string b){
  int arr[b.length()+1][a.length()+1];
  int maxj=0, maxi=0, maxlen=0;
  
  for (int i = 0; i <= a.length(); ++i)
    arr[0][i]=0;
  for (int i = 0; i <= b.length(); ++i)
    arr[i][0]=0;

  for (int i = 1; i <= b.length(); ++i){
    for (int j = 1; j <= a.length(); ++j){
      if ( a[i-1] == b[j-1]){
        arr[i][j] = arr[i-1][j-1] + 1;
        if ( arr[i][j] > maxlen){
          maxlen = arr[i][j];
          maxi = i-1;
          maxj = j-1;
        }
      }else{
        arr[i][j] = 0 ;
      }
    }
  }

  for (int i = 0; i <= b.length(); ++i){
    for (int j = 0; j <= a.length(); ++j){
      cout << arr[i][j] << " ";
    }
    cout << endl;
  }
  
  cout << "\nmaxi " << maxi << endl;
  cout << "\nmax len : " << maxlen << endl;
  cout << "Common Substring: " << a.substr(maxi-maxlen+1,maxlen);

}

int main(int argc, char const *argv[])
{
  string a = "AMAZON";
  string b = "NOZAMA";
  commonSubString(a,b);
  return 0;
}