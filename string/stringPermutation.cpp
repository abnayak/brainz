#include <iostream>
#include <cstring>

using namespace std;


void printPermutation(char *str, int begin , int end){
	if ( begin == end)
		cout << str << endl;
	else{
		for (int i = begin; i <= end; ++i){
			if ( begin != i && str[begin] == str[i])
				continue;

			swap(str[begin],str[i]);
			printPermutation(str,begin+1,end);
			swap(str[begin],str[i]);
		}
	}
}

int main(int argc, char const *argv[])
{
	char arr[4]="abc";
	printPermutation(arr,0,2);
	return 0;
}