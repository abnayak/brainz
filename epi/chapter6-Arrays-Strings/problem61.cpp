#include <iostream>

using namespace std;

void swap(int *array, int first, int second){
	int temp = array[first];
	array[first] = array[second];
	array[second] = temp;
}

void threeWaySort (int *array, int size , int k) {
	int start, middle, end;
	int pivot = array[k];

	for (start=0, end=size-1, middle=0; middle < end; ){
		if ( array[start] <  pivot){
			swap(array, start, middle);
			start++;
		}else if( array[end] > pivot){
			swap(array, middle, end);
			end++;
		}else{
			middle++;
		}
	}
}


int main (int argc, char **argv) {
	int array[] = { 7,3,9,6,5,8,1};
	int arraySize = sizeof(array)/sizeof(array[0]);

	threeWaySort(array, arraySize, 4);

	for (int i=0; i< arraySize; i++){
		cout << array[i] << " ";
	}
	cout << endl;
	return 0;
}



