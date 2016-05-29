#include <iostream>
#include <algorithm>
#include <iterator>
#include <vector>

using namespace std;

void sets(int arr[], int i, vector<int> v, int size){
	if ( v.size() == 2 && i < size){
		cout << "(" << v[0] << "," << v[1] << ")" ;
		return ;
	}
	v.push_back(arr[i]);
	sets(arr[i], i+1, v , size);
	v.pop_back();
	sets(arr[i], i+1, v , size);
}

int main(int argc, char const *argv[]){
	vector<int> v;
	int arr[5]={1,2,3,4,5};
	sets(arr,0,v,5);
	return 0;
}