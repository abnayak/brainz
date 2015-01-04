#include <iostream>
using namespace std;

void combinations(char arr[], int leftParen, int rightParen, int index){
	if (leftParen == 0 && rightParen == 0 ){
		cout << arr << endl;
		return;
	}
	if ( leftParen > 0 ){
		arr[index] = '(';
		combinations(arr,leftParen-1,rightParen+1,index+1 );
	}
	if (rightParen > 0){
		arr[index] = ')';
		combinations(arr,leftParen,rightParen-1,index+1 )	;
	}

}

int main(int argc, char const *argv[])
{
	int count = 3; // ((()))
	char arr[7];
	arr[6]='\0';
	combinations(arr,count,0,0);
	return 0;
}