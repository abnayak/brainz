#include <stdio.h>

int main(){
	int count=2,i;
	long int size=5;
	int isPrime=0;
	while ( count <= 10001 ){
		for( i =2;i<=size/2;i++)
		{
			if ( size%i == 0 ){
				isPrime=0;
				break;
			}
			isPrime=1;
		}
		if( isPrime ){
			count++;
			printf("prime no: %d", count);
			isPrime=0;
			if ( count == 10001 )
				break;
		}
		size++;
	}
	printf("10001th prime no is: %ld: ", size);
	return 0;
}
