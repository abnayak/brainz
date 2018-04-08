#include <iostream>
#include <algorithm>
#include <iterator>

using namespace std;
void permutation(char arr[], int size ,int i);

int main(int argc, char const *argv[]){
	char arr[10] = "abc";
	permutation(arr,0,2);
	return 0;
}

void permutation(char arr[], int start, int end){
	if ( start == end){
		copy ( arr, arr+end+1, ostream_iterator<char>(cout , " "));
		cout << endl;
		return ;
	}
	for (int i = start; i <= end; ++i){
		swap(arr[start],arr[i]);
		permutation(arr,start+1, end);
		swap(arr[start],arr[i]);
	}
}