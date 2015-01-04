// You are given an array of n integers which can contain integers from 1 to n only . 
// Some elements can be repeated multiple times and some other elements can be absent from the array .
// Write a running code on paper which takes O(1) space apart from the input array and O(n) time to 
// print which elements are not present in the array and the count of every element 
// which is there in the array along with the element number . 
// NOTE: The array isn't necessarily sorted.

#include <iostream>
#include <algorithm>
using namespace std;

//This algorithm works by moving the elements to respective positions in array
//Once the elements are in corresponding pos, start counting the occurance
//we will use -ve value for no of occurances
void printDuplicateAndMissing(int arr[], int len){
	int pos = 0;
	int actualPos;

	while( pos < len){
		actualPos = arr[pos]-1;

		if ( arr[pos] > 0 && arr[actualPos] > 0){
			swap(arr[pos],arr[actualPos]);
			arr[actualPos] = -1;
		}
		else if ( arr[pos] > 0){
			arr[actualPos]--;
			arr[pos++] = 0;
		}
		else{
			pos++;
		}
	}
	for (int i = 0; i < len; ++i){
		cout << "Element: " << i+1 << " occured " << abs(arr[i]) << " times"<<endl;
	}

}

int main(int argc, char const *argv[])
{
	int arr[] = {5,3,6,2,4,4,5};
	int len = sizeof(arr)/sizeof(arr[0]);
	printDuplicateAndMissing(arr,len);
	/* code */
	return 0;
}