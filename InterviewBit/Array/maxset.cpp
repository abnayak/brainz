#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

vector<int> maxset(vector<int> &A) {
  vector<vector<int>> result;
  vector<int>* temp = new vector<int>();

  for(int i = 0 ; i<A.size(); i++) {
    auto a = A[i];
    if (a < 0 ){
      if(temp != NULL && temp->size() > 0){
        result.push_back(*temp);
      }
      temp = new vector<int>();
    }else if(i == A.size()-1){
      temp->push_back(a);
      result.push_back(*temp);
    }else {
      temp->push_back(a);
    }
  }

  long long int maxSum=-1;
  int length = 0;
  int index;
  int i=0;

  if ( result.size() == 0 ){
    return *temp;
  }

  for(auto v: result) {
    long long int tempSum = 0;
    for(int i; i < v.size() ; i++){
      tempSum += v[i];
    }

    if (tempSum > maxSum) {
      maxSum = tempSum;
      length = v.size();
      index = i;
    } else if (tempSum == maxSum){
      if(v.size() > length) {
        length = v.size();
        index = i;
      }
    }
    i++;
  }
  return result[index];
}

int main () {
  vector<int> A {-1,-1,-1};
  auto result = maxset(A);
  for (auto a: result ) { cout << a << " "; }

  return 0 ;
}
