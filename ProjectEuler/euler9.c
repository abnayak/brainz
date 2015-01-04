#include <stdio.h>
#include <math.h>

int isFloat(float number){
	
    if ( ( number - (int)number ) == 0.0)
		return 0;
	else
		return 1;
}

int main(int argc, char * argv[]){
	int sumOfsquare;
	float squareRoot;
	int i,j;
	
	for ( i =1;i<1000;i++){
		for ( j=1; j< 1000 ; j++)
		{
			if ( i + j >= 1000 )
				break;
			sumOfsquare = pow(i,2) + pow(j,2);
			squareRoot = sqrt(sumOfsquare);
			if ( isFloat( squareRoot ) == 1 ){
				continue;
			}
			else{
				if ( (i + j + (int)squareRoot) == 1000 ){
					printf("\n%d  %d  %d\n", i , j , (int)squareRoot);
					printf("\nProduct : %d\n" , i*j*(int)squareRoot);
					return 0;
				}
			}
				
		}
	}
	
	return 0;
}
