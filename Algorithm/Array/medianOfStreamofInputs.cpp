#include <iostream>
#include <queue>
using namespace std;

struct minComparator{

	bool operator()(int a, int b){
		if ( a < b )		
			return false;
		else
			return true;
	}

};

int medianOfStream(int arr[], int);

int main(int argc, char const *argv[])
{
	int arr[] = {1,2,3,4,5};
	medianOfStream(arr,sizeof(arr)/sizeof(arr[0]));
	return 0;
}

/*Algorithm:
	We need the max of the left side and min of right side to calculate the median.
	1. if both have same no of elements Median = (max + min )/
	2. If both have diff size . take the max/min where size of heap greater than the other

	How to create the max and min heaps
	1. 
*/

int medianOfStream(int arr[] , int size){

	//Largest elements will go the minHeap
	static priority_queue<int , vector<int>, minComparator> minHeap;
	//Smallest elements will go the max heap
	static priority_queue<int> maxHeap;
	int median;

	for (int i = 0; i < size; ++i){
		
		switch ( minHeap.size() - maxHeap.size()){
			//When both are equal
			case 0:
				//Initially both will have zero elements or both have same no of elements
				//To hand first case
				if ( minHeap.size() == 0 && maxHeap.size() == 0){
					maxHeap.push(arr[i]);
				}else{
					if ( arr[i] < maxHeap.top()){
						maxHeap.push(arr[i]);
					}else{
						 
						 .push(arr[i]);
					}
				}

			break;

			case 1:
				//left side have one more element than right
				if ( arr[i] < maxHeap.top()){
					minHeap.push(maxHeap.top());
					maxHeap.pop();
					maxHeap.push(arr[i]);
				}else{
					minHeap.push(arr[i]);
				}

			break;
			case -1:
				//right side have one more element
				if ( arr[i] < maxHeap.top()){
					maxHeap.push(arr[i]);
				}
				else{
					maxHeap.push(minHeap.top());
					minHeap.pop();
					minHeap.push(arr[i]);
				}
			}
	}

	//Find the median from two heaps
	
	//If both of them have same no of elements: median = (minHeap.top+maxHeap())/2;
	//else take the top of the heap which has max no of elements
	if (minHeap.size() == maxHeap.size())
		median = (minHeap.top() + maxHeap.top())/2;
	else{
		if (minHeap.size() > maxHeap.size())
			median = minHeap.top();
		else
			median = maxHeap.top();
	}
	cout << "Median: " << median << endl;
}
