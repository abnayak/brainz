#include <iostream>
using namespace std;

void merge_sort(int data[], int size);

int main(){
	int arr[10]= {5,2,3,10,4,7,8,6,9,1};
	int n = 10;
	merge_sort(arr,n);
	for (int i = 0; i < 10; ++i){
		cout << arr[i] << " ";
	}
	return 0;
}

void merge(int data[], int start, int mid, int end, int size){
	int i = start;
	int j = mid +1;
	int b=0;
	int buf[size];

	while ( i <= mid && j <= end){
		if ( data[i] <= data[j]){
			buf[b] = data[i];
			i++;
		}
		else{
			buf[b] = data[j];
			j++;
		}
		b++;
	}

	while (i <= mid){
		buf[b] = data[i]; i++; b++;
	}
	while (j <= end){
		buf[b] = data[j]; j++; b++;
	}

	for(i=start, j =0; i<=end ; i++, j++)
		data[i]=buf[j];
}

void merge_sort_driver(int data[], int start, int end , int size){
	if ( start < end){
		int mid = (start + end)/2;
		merge_sort_driver(data, start, mid, size);
		merge_sort_driver(data, mid+1, end, size);
		merge(data,start,mid,end, size);
	}
}

void merge_sort(int data[], int size){
	merge_sort_driver(data, 0, size-1, size);
}