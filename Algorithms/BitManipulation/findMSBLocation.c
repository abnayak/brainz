#include <stdio.h>
#include <math.h>

int main(int argc, char const *argv[])
{
	unsigned int i = 21;
	printf("%f", floor( log(i)/log(2) ) );

	return 0;
}