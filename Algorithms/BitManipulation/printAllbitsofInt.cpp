#include <iostream>
using namespace std;

unsigned int getbit(const unsigned int i, int pos){
	return ( (i & (1 << pos)) != 0  );
}

unsigned int setbit(const unsigned int i , int pos, int val){
	return (  i | (1 << pos)  );
}

int main(){
	unsigned int num = 16;
	unsigned int bit;
	unsigned int result = 0;

	cout << "sizeof: " << sizeof(unsigned int) << endl;
	int i , j;
	for (i = 31,j = 0; i >= 0 ; i--, j++) {
		bit = getbit(num,i);
		if ( bit == 1)
			result = setbit(result,j,bit);
	}

	for (i = 31; i >= 0 ; i--) {
		cout << getbit(num,i);
	 }
	 cout << endl;

	for (i = 31; i >= 0 ; i--) {
		cout << getbit(result,i);
	 }
    
	return 0;
}