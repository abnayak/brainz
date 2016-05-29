#include <iostream>
#include <vector>
#include <algorithm>
#include <iterator>

using namespace std;

void subsets(int arr[], vector<int> v, int i , int size );

int main(int argc, char const *argv[])
{
	int arr[]= {1,2,3,4,5};
	vector<int> v;
	subsets(arr,v,0,sizeof(arr)/sizeof(arr[0]));
	return 0;
}

void subsets(int arr[], vector<int> v, int i , int size ){
	if ( i >= size){
		cout << endl;
		copy ( v.begin(), v.end(), ostream_iterator<int>(cout, " "));
		return;
	}
	v.push_back(arr[i]);
	subsets(arr, v, i+1, size);
	v.pop_back();
	subsets(arr, v, i+1, size);
}