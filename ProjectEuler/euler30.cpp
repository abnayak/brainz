#include <iostream>
#include <algorithm>
#include <cmath>
#include <climits>


using namespace std;

unsigned long long fivePowOfnos(unsigned long long n);	

int main(){
	unsigned long long sum = 0;
	unsigned long long limit= ULLONG_MAX;

	for (unsigned long long i = 2; i <= limit; i++ ){
		unsigned long long temp = fivePowOfnos(i);
		if ( temp == i ){
			sum += i;	
			cout << "i: " << i << " sum: " << sum << endl;
		}
	}
	cout << sum << endl;
	return 0;
}

unsigned long long fivePowOfnos(unsigned long long n){
	unsigned long long sum=0;
	while ( n ){
		sum += pow ( (n%10), 5 );
		n /= 10;
	}
	return sum ;

}