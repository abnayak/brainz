#include <stdio.h>

int fun(int );

int main(int argc, char const *argv[])
{
	int size = 10;
	printf("%d", fun(size));
	int array[size];
	printf("\n%d\n", sizeof(array));

	return 0;
}

int fun(int size){
	int array[size];
	return sizeof(array);

}