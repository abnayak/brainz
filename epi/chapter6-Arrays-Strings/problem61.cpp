#include <iostream>
#include <array>
#include <iostream>
#include <algorithm>

using namespace std;

int main(){

	std:array<int, 7> arr = {5,2,3,4,10,5,6};
	int begin=0; 
	int end=arr.size()-1;
	int mid=0;
	const int ref = 5;

	while ( mid < end){
		if(arr[mid] < ref){
			swap(arr[mid++], arr[begin++]);
		}
		else if(arr[mid] > ref){
			swap(arr[mid], arr[end--]);
		}else{
			mid++;
		}
	}
	copy(arr.begin(), arr.end(), ostream_iterator<int>(cout, " " ));
}