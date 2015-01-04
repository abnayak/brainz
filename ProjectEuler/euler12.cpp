#include <iostream>
#include <algorithm>
#include <string>
#include <set>
#include <cmath>

using namespace std;

int findDivisors(unsigned long long n  );


int main(){
	
	unsigned long long count = 2;
	unsigned long long nextTriangleNum = 1;
	
	while (1){
		set<int> s;
		nextTriangleNum += count;
		count++;
		
		int divisors = findDivisors(nextTriangleNum);
		
		if ( divisors >= 500 ){
			cout << nextTriangleNum << endl;
			break;
		}		
	}
	return 0;
}

int findDivisors(unsigned long long n  ){
	unsigned int count=0;
	
	for	(unsigned long long i=1; i <= sqrt(n); i ++){
		if ( n % i == 0 ){
			count += 2;
		}
	}
	return count;
}
