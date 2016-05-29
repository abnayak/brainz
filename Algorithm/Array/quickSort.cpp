#include <iostream>
#include <algorithm>
#include <iterator>

using namespace std;

int partition(int arr[], int low, int high){
	int pivot = arr[low];
	int j = low;
	for (int i = low+1; i <= high; ++i){
		if ( arr[i] <= pivot){
			j++;
			swap(arr[j],arr[i]);
		}
	}
	swap(arr[low],arr[j]);
	return j;
}

void quickSort(int arr[], int low , int high){
	int pivot;
	if (low >= high)
		return;

	pivot = partition(arr,low,high);

	quickSort(arr,low,pivot-1);
	quickSort(arr,pivot+1,high);
}

int main(int argc, char const *argv[])
{
	int arr[] = {10, 1,3,20, 101, 22};
	int len = sizeof(arr)/sizeof(arr[0]);
	quickSort(arr,0,len-1);

	//print the array
	copy(arr,arr+len,ostream_iterator<int>(cout," "));
	return 0;
}