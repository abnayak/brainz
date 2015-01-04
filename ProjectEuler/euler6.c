/* The sum of the squares of the first ten natural numbers is,
12 + 22 + ... + 102 = 385

The square of the sum of the first ten natural numbers is,
(1 + 2 + ... + 10)2 = 552 = 3025

Hence the difference between the sum of the squares of the first ten natural numbers and the square of the sum is 3025 − 385 = 2640.

Find the difference between the sum of the squares of the first one hundred natural numbers and the square of the sum.   */

#include <stdio.h>

long int square( long int i ){
	return i*i ;
}

int main(){
    int i=100;
    long int squareOfSum=0, sumOfSquare=0;
	int j;
	long int buf=0;
	for(j=1;j<=100;j++){
        buf += j;
	}
	squareOfSum = square(buf);

	for(j=1;j<=100;j++){
        sumOfSquare += square(j);
	}

    printf("%ld", sumOfSquare-squareOfSum);

	return 0;
}
