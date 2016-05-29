#include <iostream>
#include <algorithm>
#include <iterator>

using namespace std;

int main(int argc, char const *argv[])
{
	int arr[] = {8,5,3,2,1,7,6,4};
	int len = sizeof(arr)/sizeof(arr[0]);

	for (int i = 1; i < len; ++i){
		int temp = arr[i];
		int j=i-1;
		while (j >= 0 && arr[j]>temp ){
			arr[j+1]=arr[j];
			j--;
		}
		arr[j+1]=temp;
	}
	//Print the array
	copy(arr,arr+len , ostream_iterator<int>(cout , " "));
	return 0;
}