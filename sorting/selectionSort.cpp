#include <iostream>
using namespace std;


void selection_sort(int data[], int size);

int main(int argc, char const *argv[])
{
	int arr[10]= {5,2,3,10,4,7,8,6,9,1};
	int n = 10;
	selection_sort(arr,n);
	for (int i = 0; i < 10; ++i){
		cout << arr[i] << " ";
	}
	return 0;
}


void selection_sort(int data[], int size){
	for (int i = 0; i < size; ++i){
		int k=i;
		for (int j = i+1; j < size; ++j){
			if( data[j] < data[k])
				k=j;
		}
		swap(data[i],data[k]);
	}
}