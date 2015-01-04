#include <iostream>
#include <algorithm>
#include <string>
#include <cmath>
#include <vector>
#include <climits>
#include <iterator>

using namespace std;

unsigned int factorial(int n ){
	unsigned int result = 1;
	for ( int i=1 ; i <= n ; i ++ ){
		result *= i;
	}
	return result;
}

int main(){

	unsigned int factorials[10];
	vector<unsigned int> nos;
	
	for	(int i = 0 ; i <= 9 ; i++ )
		factorials[i] = factorial(i);
		
	for (unsigned int i= 3 ; i <= UINT_MAX ; i++){
		unsigned long sum = 0 ;
		unsigned int n = i ;
		while ( n ){
			sum += factorials[n%10];
			n /= 10;
			if ( sum > i ) 
				break;
		}
		
		if ( sum == i ){
			nos.push_back(i);
			cout << i << endl;
			}
	}

	copy ( nos.begin(), nos.end(), ostream_iterator<unsigned int>(cout , " "));
	

	return 0;
}


 