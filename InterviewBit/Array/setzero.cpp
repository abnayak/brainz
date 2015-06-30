#include <iostream>
#include <vector>
using namespace std;

void setZeroes(vector<vector<int> > &A) {
  vector<int> row(A.size(),1);
  vector<int> col(A[0].size(),1);

  for(int i = 0; i< A.size(); i++){
    for(int j=0 ; j< A[0].size(); j++){
      if(A[i][j] == 0){
        row[i] = 0;
        col[j] = 0;
      }
    }
  }
  for(int i = 0; i< A.size(); i++){
    if(row[i] == 0){
      for(int j=0 ; j< A[0].size(); j++){
        A[i][j] = 0;
      }
    }
  }

  for(int j = 0; j< A[0].size(); j++){
    if(col[j] == 0){
      for(int i=0 ; i < A.size(); i++){
        A[i][j] = 0;
      }
    }
  }
}

int main() {
  vector<vector<int>> array;
  vector<int> row1 {1,0,1};
  vector<int> row2 {1,1,1};
  vector<int> row3 {1,1,0};
  array.push_back(row1);
  array.push_back(row2);
  array.push_back(row3);

  setZeroes(array);

  for(int i = 0; i< array.size(); i++){
    for(int j=0 ; j< array[i].size(); j++){
      cout << array[i][j] << " ";
    }
    cout << endl;
  }
  return 0;
}
