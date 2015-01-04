#include <iostream>

using namespace std;

int reverseBits(int i){
	int j = 0;
	int result=0;

	unsigned int mask =1;
	mask <<= 32;

	cout << "mask: " << mask << endl;

	while (i){
		j = i & mask;
		i <<= 1;

		result <<=1;
		result |= i;

		cout << j  << " ";
	}
	cout << endl;
	cout << result ;
	cout << endl;
	return 00;
}

int main(int argc, char const *argv[]) {
	int i = 13;

	cout << "After bit reverse " << i <<" becomes: " << reverseBits(i) << endl;
	return 0;
}
