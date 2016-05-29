#include <iostream>

using namespace std;

unsigned long long combinations (unsigned k, unsigned long long *arr, unsigned n);

int main(int argc, char const *argv[])
{
	unsigned long long arr[10] = {1,2,3,4,5,6};
	unsigned n = 6;
	unsigned k=2;
	cout << combinations(k,arr,n);
	return 0;
}

unsigned long long combinations(unsigned k, unsigned long long *arr, unsigned n){
	unsigned counts[k]={0};
	for (unsigned i=0; i<n; i++)	{
		counts[arr[i] % k]++;
	}
	unsigned count=0;
	
}