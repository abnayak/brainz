#include <iostream>

using namespace std;

int find ( int arr[], int start ,int end){
	int mid = (start+end)/2;

	if ( start > end )
		return -1;

	if ( mid == arr[mid])
		return mid;

	if ( arr[mid] < mid)
		find ( arr, mid+1,end);
	else
		find ( arr, start , mid-1);

}

int main(int argc, char const *argv[])
{
	int arr[5]={-1,0,1,2,4};
	cout << find(arr,0,4);
	return 0;
}