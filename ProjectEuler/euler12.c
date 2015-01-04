#include <stdio.h>
#include <limits.h>


int countDivisors(long long int i ){
	long long int j;
	int count=0;
	for(j=2;j<=i/2;j++){
		if(i%j == 0 )
			count++;
	}
	return count+2;
}

int main(){
	long long int i=0;
	long long int j;
	int count;
	for( j=1;j<=LLONG_MAX;j++){
		i += j;
		count = countDivisors(i);
		printf("\n%I64d , %d", i, count );
		if ( count == 500 )
			break;
	}
	printf("\nnumber: %I64d\n", i);
	return 0;
}
