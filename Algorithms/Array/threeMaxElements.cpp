#include <iostream>
#include <climits>

using namespace std;

int main(int argc, char const *argv[])
{
	int arr[]= {1,2,3,4,19,3,4,23, 20, 3,3,3,3,3,3,3};
	int len = sizeof(arr)/sizeof(arr[0]);
	int first= INT_MIN;
	int second = INT_MIN;
	int third = INT_MIN;

	for (int i = 0; i < len; ++i){
		if(arr[i] > first){
			third = second;
			second = first;
			first = arr[i];
		}else if ( arr[i] > second){
			third = second;
			second = arr[i];
		}else if ( arr[i] > third){
			third = arr[i];
		}
	}

	cout << "First: " << first << " Second: " << second << " Third: " << third << endl;
	return 0;
}