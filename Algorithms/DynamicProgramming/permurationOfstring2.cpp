#include <stdio.h>
void printAllSet(char *arr, char *aux, int start, int depth, int length)
{
	int j;
	if(start< length)
	{
		aux[depth]='\0';
		printf("%s",aux);
		printf("\n");
	}
	for(j=start; j<length; j++)
	{
			aux[depth] = arr[j];
			printAllSet(arr, aux, j+1, depth+1, length);
	}
}
int main()
{
char arr[]="ABC";
int length=sizeof(arr)/sizeof(arr[0]);
char aux[length];
printAllSet(arr, aux, 0, 0,  length);
return 0;
}