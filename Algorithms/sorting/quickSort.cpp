#include <iostream>

using namespace std;

void quickSort(int [], int , int);

int main(int argc, char const *argv[])
{
	int arr[10]= {5,2,3,10,4,7,8,6,9,1};
	int n = 10;
	quickSort(arr,0, 9);
	for (int i = 0; i < 10; ++i){
		cout << arr[i] << " ";
	}
	return 0;
}

int partition(int arr[], int start , int end){
	const int pivot = start;
	int j = start;
	for (int i = start+1; i <= end; ++i)	{
		if ( arr[i] <= arr[pivot] ){
			j++;
			swap(arr[j],arr[i]);
		}
	}
	swap(arr[pivot],arr[j]);
	return j;
}

void quickSort(int arr[], int start, int end){
	if ( start >= end)
		return;
	int mid = partition(arr,start,end);
	quickSort(arr,start,mid-1);
	quickSort(arr,mid+1, end);
}