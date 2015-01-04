#include <iostream>
#include <algorithm>

using namespace std;

int main(int argc, char const *argv[])
{
	int rows=100;
	int arraySize=(rows*(rows+1))/2;
	int array[arraySize];
	int resultArray[arraySize];
	int maxSum=0;

	for (int index=0, row = 1; row <= rows ; ++row){
		for (int column = 1; column <= row; ++column, index++){
			cin >>array[index] ;
		}
	}

	//print result array to check correct ness
	// cout << "------printing the result array--------" << endl;
	// for (int index =0, row = 1; row <= rows ; ++row){
	// 	for (int column = 1; column <= row; ++column, index++){
	// 		cout << array[index] << " ";
	// 	}
	// 	cout << endl;
	// }
	// cout << "------------------------------" << endl;

	resultArray[0]=array[0];

	for (int index=1, row = 2; row <= rows ; ++row){
		for (int column = 1; column <= row; ++column, index++){
			if ( column == 1 ){
				
				int prevIndex = (((row-1)*(row)/2)-1) - (row-2);
				resultArray[index] = array[index] + resultArray[prevIndex];

			} else if ( column == row){

				int prevIndex = ((row-1)*(row)/2)-1;
				resultArray[index] = array[index]+ resultArray[prevIndex];

			}
			else{
				int firstIndex = index - row;
				int secondIndex = index - row + 1;
				resultArray[index] = array[index] + max ( resultArray[firstIndex], resultArray[secondIndex]);
			}
		}
	}


	//print result array to check correct ness
	// cout << "printing the result array" << endl;
	// for (int index=0, row = 1; row <= rows ; ++row){
	// 	for (int column = 1; column <= row; ++column, index++){
	// 		cout << resultArray[index] << " ";
	// 	}
	// 	cout << endl;
	// }
	// cout << "End of result array::" << endl;

	//Find the max value;
	//last row starting index;
	int beginIndex = ((rows-1) * rows)/2;
	int endIndex = beginIndex + rows -1;

	for (int i = beginIndex; i <= endIndex; ++i){
		maxSum = maxSum > resultArray[i] ? maxSum : resultArray[i];
	}

	cout << "Max sum of nos from top to bottom: " << maxSum << endl;

	return 0;
}