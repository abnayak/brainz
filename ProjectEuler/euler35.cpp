#include <iostream>
#include <algorithm>
#include <cmath>
#include <sstream>
#include <string>

using namespace std;

int main() {
	const unsigned int n = 1000000;	
	unsigned int *primes = new unsigned int[n];
	fill(primes, primes+n , 1);

	for (int i = 2; i <= (int)sqrt(n-1); ++i) {
		if(primes[i])
			for (int j = i; j*i < n ; ++j) primes[i*j] = 0;
	}
	
	int noOfCircularPrimes=0;
	for (int i = 2; i < n; ++i){
		stringstream ss;
		ss << i;
		string s = ss.str();
		bool isCircularPrime=true;
		string::iterator ii;
		for (int i = 1; i <= s.size(); ++i)	{
			ii=s.begin();
			s += *ii;
			s.erase(s.begin());
			if ( primes[stoi(s)] == 0){
				isCircularPrime=false;
				break;
			}
		}
		if ( isCircularPrime)
			noOfCircularPrimes++;
	}
		
	cout << noOfCircularPrimes << endl;
	delete[] primes;
	return 0;
}