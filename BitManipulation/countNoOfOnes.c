#include <stdio.h>

int countOnes(int n){
	unsigned int count = 0 ;
	while (n){
		count ++;
		n &= (n-1);
	}
	return count;
}

int parity1 (unsigned int i ){
	short int count =0;
	while ( i){
		count += 1;
		i &= (i-1) ;
	}
	return count;
}


int main(int argc, char const *argv[])
{
	//printf("%d", countOnes(10));
	unsigned int  a = 5;
	printf("%d", parity1(a));
	return 0;
}