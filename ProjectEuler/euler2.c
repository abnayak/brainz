#include <stdio.h>

int main(){
	long long int upperBound = 4000000, sum ;
	int i=10;
	int first , second, next;
	first =1;
	second =2;
	sum = second;
	while ( next < upperBound ){
		i--;
		next = first+second;
		first=second;
		second=next;
		
		if ( next % 2 == 0 )
			sum = sum + next;
	}
	printf("total sum is: %I64d\n", sum);
	return 0;
}

	
	
