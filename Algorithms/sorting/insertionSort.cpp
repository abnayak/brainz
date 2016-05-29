#include <iostream>
#include <algorithm>

using namespace std;
void insertionSort(int [], int);

int main(int argc, char const *argv[])
{
	int arr[10]= {5,2,3,10,4,7,8,6,9,1};

	insertionSort(arr,10);

	for (int i = 0; i < 10; ++i)
	{
		cout << arr[i] << " ";
	}
	
	return 0;
}

void insertionSort(int arr[],int n){
	int temp;
	int j;
	for (int i = 1; i < n; ++i)
	{
		temp=arr[i];
		j=i-1;
		while(j>=0 && temp < arr[j]){
			swap(arr[j],arr[j+1]);
			j--;
		}
	}
	arr[j]=temp;
}