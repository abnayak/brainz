// Algorithm link:
//http://www.cs.mtu.edu/~shene//COURSES/cs201/NOTES/chap04/factor.html

#include <stdio.h>

int main()
{
	long long int j=600851475143;
	//long long int j=13195;
	long long int big=0;
	long long int div=3;
	
	while ( (j%2 == 0) && (j > 1) )
	{
		j=j/2;
		big=2;
		//printf("%d  ", big);
	}
	while ( div <= (j) )
	{
		while ( (j%div == 0 ) && (j>1 ) ){
			j=j/div;
			big=div;
			//printf (" %d  ", big);
		}
		div=div+2;
	}
	printf("\n\n%I64d", big );
	return 0;
	
}
