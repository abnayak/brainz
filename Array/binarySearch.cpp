#include <iostream>
#include <algorithm>
#include <iterator>

using namespace std;

int binarySearchIterative(int [], int, int, int);
int binarySearchRecursive(int [], int, int, int);
int compareFunction(const void *, const void*);

int main(int argc, char const *argv[])
{
	int arr[]={10,2,5,11,22,112,20};
	int len = sizeof(arr)/sizeof(arr[0]);

	cout << "Search in array: " ;

	//Sort the array
	qsort(arr,len,sizeof(int),compareFunction);

	//Print the array
	copy(arr,arr+len, ostream_iterator<int>(cout, " "));
	
	cout << "\nUsing iterative method: " << binarySearchIterative(arr,10,0,len-1) << endl;
	cout << "Using recursive method: " << binarySearchRecursive(arr,10,0,len-1) << endl;
	return 0;
}

int binarySearchIterative(int arr[], int search, int start, int end){
	int mid;

	while ( start <= end){
		mid = (start+end)/2;
		if ( arr[mid] == search)
			return mid;
		else if (search < arr[mid])
			end = mid-1;
		else
			start = mid+1;
	}
	return -1;
}

int binarySearchRecursive(int arr[], int search, int start,int end){
	if (start > end )
		return -1;

	int mid = (start + end)/2;

	if ( search == arr[mid])
		return mid;
	else if ( search < arr[mid])
		return binarySearchRecursive(arr,search,start,mid-1);
	else
		return binarySearchRecursive(arr,search,mid+1,end);
}

int compareFunction(const void* num1, const void* num2){
	int i1 = *(const int *)num1;
	int i2 = *(const int *)num2;
	return i1 - i2;
}