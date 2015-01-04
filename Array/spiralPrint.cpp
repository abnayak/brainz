//print the array in spiral order
/*
Arrary: 

1 2 3
4 5 6
7 8 9

Output: 1 2 3 6 9 8 7 4 5

*/

#include <iostream>
#include <algorithm>

using namespace std;

void spiralPrint(int arr[][3], int d){
	d = d-1;
	int i , j , r;
	for (i = 0; i <= d/2; ++i){
		//print the horizontal
		for ( j = i  ; j < d-i ; ++j)
			cout << arr[i][j] << " ";
		
		//print right vertical
		for ( r = i; r < d-i; ++r)
			cout << arr[r][j] << " ";

		//print bottom from right to left
		for ( ; j >= i ; j--)
			cout << arr[r][j] << " ";

		//Print the left column from button to top
		for ( r= r-1 ; r > i; r--)
			cout << arr[r][j+1] << " ";			
	}
}

int main(void){
	int array[3][3] = { {1,2,3},{4,5,6},{7,8,9} };
	spiralPrint( array, 3);
	return 0;
}