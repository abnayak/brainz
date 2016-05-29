#include <iostream>

using namespace std;

int findPicot(int arr[], int low , int high){
	if ( low == high)
		return low;
	if ( low == high-1){
		if ( arr[low]  > arr[high])
			return low;
		else
			return high;
	}

	int mid = ( low + high ) /2;

	if ( arr[mid] > arr[mid-1] && arr[mid] > arr[mid])
		return mid;
	if ( arr[mid] < arr[low])
		findPicot(arr,low, mid-1);
	else
		findPicot(arr,mid+1,high);
}

int binarySearch(int arr[], int start, int end, int x){
	if ( start > end )
		return -1;
	int mid = ( start + end)/2;

	if ( arr[mid] == x)
		return mid;
	if ( x > arr[mid])
		binarySearch(arr,mid+1,end, x);
	else
		binarySearch(arr,start,mid-1,x);
}


int rotatedBinarySearch(int arr[], int start , int end, int x){
	int mid = findPicot(arr, start , end);

	if ( arr[mid] == x )
		return mid;
	else if ( x < arr[mid])
		binarySearch(arr,start,mid-1,x);
	else
		binarySearch(arr,mid+1,end,x);
}


int main(int argc, char const *argv[])
{
	int arr[] = { 40,50,1,2,3,4,5 };
	int len = sizeof(arr)/sizeof(arr[0]);

	cout << rotatedBinarySearch(arr,0, len-1,1);
	return 0;
}