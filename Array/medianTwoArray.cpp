#include <iostream>
#include <algorithm>

using namespace std;

/*
Find the median of two sorted array after the are merged together. 
Trivial solution will be to merge to sorted array and print the no when you encounter median position.
For better performance you can use binary search type algorithm to find the median.
*/
void medianTwoArray(int [], int, int, int [], int, int);

int main(int argc, char const *argv[])
{

	
	return 0;
}

void medianTwoArray(int a[], int abegin, int aend, int b[], int bbegin, int bend){
	int amid = (abegin+aend)/2;
	int bmid = (bbegin+bend)/2;
	
	//If both have same median value then print the median no need to search
	if ( a[amid] == b[bmid]){
			cout << "Median : " << a[amid] << endl;
			return ;
	}

	if ( a[amid] > b[bmid])
		medianTwoArray(a, abegin, amid, b, bmid, bend);
	else
		medianTwoArray(a, amid, aend, b, abegin, bmid);


	if ( aend - abegin == 1 || bend - bbegin == 1){
		int begin;
		int end;
		begin = max ( abegin, bbegin);
		end = min ( aend, bend);

		cout << 


	}


}