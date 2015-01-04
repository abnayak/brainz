
#include <iostream>
#include <algorithm>

using namespace std;


/*
This method works like quick sort. 
Use kth as the pivot point and do quick sort.
*/

int partition(int arr[], int low, int high){
	int pivotVal = arr[low]; //select low as pivot point

	int j = low;
	for (int i = low+1; i <= high; ++i){
		if( arr[i] < pivotVal){
			j++;
			swap(arr[i],arr[j]);
		}
	}
	swap(arr[low],arr[j]);
	return j;
}

void kthQuickSort(int arr[], int k, int low, int high, int &result){
	
	int pivot;

	if (low >= high)
		return;
	
	pivot = partition(arr, low, high);
		
	if ( pivot == k-1){
		//cout << arr[k] << endl;
		result = arr[k-1];
		return;
	}
	
	if ( k < pivot)
		kthQuickSort(arr,k,low,pivot-1,result);
	else
		kthQuickSort(arr,k,pivot+1,high,result);
	
}

/*
End of quick sort kth pivot element search
*/

int main(int argc, char const *argv[])
{
	int result;
	int arr[] = {10, 1,3,20, 101, 22};
	int len = sizeof(arr)/sizeof(arr[0]);
	kthQuickSort(arr,6,0,len-1,result);
	cout << "Kth smallest element: " << result << endl;
	
	return 0;
}