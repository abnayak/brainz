#include <iostream>
#include <vector>
#include <string.h>
#include <unordered_map>
#include <map>

using namespace std;

unsigned long long sumOfDivisors(unsigned int n);

int main(int argc, char const *argv[])
{
	int limit=10000;
	unsigned long long amicableSum=0;
	unordered_map<int,int> hash;
	unordered_map<int,int>::iterator it;

	int marked[limit+1];
	memset(marked, 0, sizeof(int) * ( limit+1));

	hash[1]=1;
	for (int i = 2; i <= limit; ++i){
		hash[i] = sumOfDivisors(i);
	}

	for (int i = 2; i <= limit; ++i){
		int sum = hash[i];
		it = hash.find(sum);

		if ( it != hash.end() && (*it).second == i && marked[sum] != 1 && i != sum){
			amicableSum += sum ;
			amicableSum += i;
			marked[i]=1;
			marked[sum]=1;
		}
	}

	cout << amicableSum << endl;

	return 0;
}

unsigned long long sumOfDivisors(unsigned int n){
	unsigned long long sum=0;
	for (int i = 1; i <= n/2; ++i){
		if ( n % i == 0 )
			sum += i;
	}
	return sum;
}