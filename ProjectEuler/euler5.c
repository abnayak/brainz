//2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.
//What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?

//20-10-5
//19
//18-9-6-3-2
//17
//16-8-4-2
//15
//14-7
//13
//12
//11

#include <stdio.h>


int main(){
	long int num=20;
	
	while ( (num%20) || (num%19) || (num%18) || (num%17) || (num%16) || (num%15) || (num%14) || (num%13) || (num%12) || (num%11) )
	{
		num+=20;
	}
	printf("Number is :  %ld\n" , num );
	return 0;
}



