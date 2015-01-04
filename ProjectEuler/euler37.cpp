#include <iostream>
#include <algorithm>
#include <string>
#include <sstream>
#include <climits>

using namespace std;


int main(){
//	const unsigned int n = UINT_MAX;
	const unsigned int n = 1000000;
	int *primes = new int[n];
	fill(primes, primes+n ,1);
	int truncablePrimes=0;
	unsigned int sumOfTruncablePrimes=0;
	
	
	for (unsigned int i = 2; i <= sqrt(n); ++i)	{
		if (primes[i])
			for (unsigned int j = i; j*i < n ; ++j)	{
				primes[j*i] = 0;
			}
	}
	//1 and 0 are not primes
	primes[0] = primes[1] = 0;
	
	for (unsigned int i = 10; i < n; i += 1) {
		if (primes[i]) {
			string sn = to_string(i);
			string::iterator ii;
			bool leftPrime=false;
			bool rightPrime=false;
			
			while (sn.begin() != sn.end()){
				sn.erase(sn.begin());
				
				if (sn.begin() != sn.end() && primes[stoi(sn)] == 0)
					break;
			}
			
			if (sn.begin() == sn.end()){
				leftPrime=true;
			}
			
			sn = to_string(i);
			
			while (sn.begin() != sn.end()){
				sn.erase(sn.end()-1);
				
				if (sn.begin() != sn.end() && primes[stoi(sn)] == 0)
					break;
			}
			
			if (sn.begin() == sn.end()){
				rightPrime = true;
			}
			
			if ( leftPrime && rightPrime){
				truncablePrimes++;
				cout << i <<" ";
				sumOfTruncablePrimes += i;
			}
		}
				
		if ( truncablePrimes == 11)
			break;
	}
	
	cout <<"\nFinal sum: " <<sumOfTruncablePrimes << endl;
	return 0;
}