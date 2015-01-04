#include <iostream>
#include <algorithm>

using namespace std;

int main(int argc, char const *argv[])
{
	unsigned long int limit = 1001 * 1001; 
	unsigned long long sum = 0 ;
	unsigned long long p=1;

	for (unsigned long int i = 1, jump=2; i <= limit; jump += 2)
	{
		for (int j = 1; j <= 4 && i <= limit; ++j)
		{
			sum += i;
			i += jump;
		}
	}

	cout << sum << endl;

	return 0;
}