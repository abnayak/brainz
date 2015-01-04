#include <stdio.h>
#define SIZE 2000000

int main(){
	char arr[SIZE+1];
	int i,j;
	int loop;
	int loc;
	long long int sum=0;
	for (i=1;i<=SIZE;i++)
		arr[i]=1;
	
	for(i=2;i<=SIZE/2;i++){
		if( arr[i] != 0 ){
			loop = (int)SIZE/i;
			for(j=2;j<=loop;j++){
				loc=i*j;
				arr[loc]=0;
				
			}
		}
	}
	for( i =2;i<=SIZE;i++){
		if ( arr[i] != 0 )
			sum += i;
	}
	printf("\nSum = %I64d" , sum );
	return 0;
}
