#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

int maximumGap(const vector<int> &A) {
  vector<pair<int,int> > vec;
  for(int i=0; i<A.size(); i++){
    vec.push_back(pair<int,int>(A[i],i));
  }

  // Sort the vector
  sort(vec.begin(), vec.end(), [](pair<int,int> a, pair<int,int> b) {
    return a.first < b.first;
  });

  // populate this vector such that it will hold max index starting from end.
  vector<int> maxIndex(vec.size());
  maxIndex[vec.size()-1] = vec.back().second;

  for(int i=vec.size()-2; i>= 0 ; i--) {
    if (maxIndex[i+1] < vec[i].second) {
      maxIndex[i] = vec[i].second;
    } else {
      maxIndex[i] = maxIndex[i+1];
    }
  }

  int maxDiff=-1;
  for(int i= 0; i < vec.size() ; i++) {
      if (maxIndex[i] - vec[i].second > maxDiff){
        maxDiff = maxIndex[i] - vec[i].second ;
      }
  }
  return maxDiff;
}

int main() {
  int array[] = {9, 3, 5, 10, 1, 4};
  vector<int> A(array, array+6);
  cout << maximumGap(A) << endl;
  return 0;
}
