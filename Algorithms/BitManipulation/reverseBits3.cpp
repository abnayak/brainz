#include <iostream>

using namespace std;

int reverseBits(unsigned int n){
	unsigned int result =0;
	int len = sizeof(unsigned int) * 8;
	cout << endl;

	for (int i = 0; i < len; ++i){

		if( n & ( 1 << (len-1-i) ) ){
			cout << 1 ;
			result = result | (1 << i);
		}else{
			cout << 0 ;
		}

	}
	//ct << endl << result << endl;
	return result;
}

int main(int argc, char const *argv[])
{
	unsigned i = 11;
	unsigned j;
	//cout <<
	 j =  reverseBits(i);
	 reverseBits(j);
	return 0;
}