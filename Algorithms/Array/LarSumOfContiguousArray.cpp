#include <iostream>
#include <algorithm>

using namespace std;

void maxSum(int [], int size);

int main(int argc, char const *argv[])
{
	int array[] =  {-2, -3, 4, -1, -2, 1, 5, -3};

	int len = sizeof(array)/sizeof(array[0]);
	maxSum(array, len);
	
	return 0;
}

void maxSum(int arr[], int size){
	int MaxSum=0;
	int currSum=0;

	for (int i = 0; i < size; ++i)
	{
		currSum = max ( arr[i], currSum+arr[i]);
		if ( currSum > MaxSum)
			MaxSum = currSum;
	}

	cout << "Max sum of array : " << MaxSum << endl;

}