#include <iostream>
#include <algorithm>
#include <vector>
#include <set>
#include <cmath>

using namespace std;
bool isAbundant(int);

int main(int argc, char const *argv[])
{
	int limit = 28123;
	set<int> abundantNumbers;
	unsigned long long sumOfNonAbundantNumbers=0;
	set<int>::iterator it;
	bool is_abundant_sum= false;

	for (int i = 1; i <= limit ; ++i){
		if (isAbundant(i)){
			abundantNumbers.insert(i);
		}
	}
	
	for (int i = 1; i <= limit ; ++i){
		for (it = abundantNumbers.begin(); it != abundantNumbers.end() && *it != i && *it <= i/2; it++){
				int rest = i - *it;
				if ( abundantNumbers.count(rest))
					is_abundant_sum=true;
		}
		if (!is_abundant_sum){
			sumOfNonAbundantNumbers += i;
		}else{
			is_abundant_sum=false;
		}
	}		
	cout << sumOfNonAbundantNumbers << endl;
	return 0;
}

bool isAbundant(int n){
	unsigned long long sum = 1;

	for (int i = 2; i <= sqrt(n); ++i){
		if ( n % i == 0 ){
			sum += i;
			int counterPart = n / i;
			if ( counterPart != i )
				sum += counterPart;
		}
	}
	return sum > n ? true: false;
}

