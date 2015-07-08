#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

vector<vector<int> > prettyPrint(int A) {
  vector<vector<int> > result;
  int dimention = A * 2 - 1;
  int array[dimention][dimention];

  int START = 0 ;
  int END = dimention -1;

  for(int count = 0 ; count < A ; count++) {
    int newStart = START + count;
    int newEnd = END - count;
    int i , j;

    i = newStart;
    for(j = i ; j <= newEnd ; j++){
      array[i][j] = A - count;
    }

    i = newEnd;
    for(j = newStart ; j <= newEnd ; j++){
      array[i][j] = A - count;
    }

    j= newStart;
    for(i=j ; i <=newEnd ; i++)
      array[i][j] = A - count;

    j = newEnd;
    for(i=newStart ; i <=newEnd ; i++)
      array[i][j] = A - count;

  }

  int i , j;
  for( i = 0 ; i < dimention ; i ++) {
    vector<int> *row = new vector<int>();
    for( j = 0 ; j < dimention ; j ++){
      row->push_back(array[i][j]);
    }
    result.push_back(*row);
  }
  // for( i = 0 ; i < dimention ; i ++){
  //   for( j = 0 ; j < dimention ; j ++){
  //     cout << result[i][j] << " ";
  //   }
  //   cout << endl;
  // }
  return result;
}

int main() {
  prettyPrint(4);

  return 0;
}
