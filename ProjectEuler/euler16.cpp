#include <iostream>
#include <iterator>
#include <algorithm>
#include <vector>

using namespace std;

int main(int argc, char const *argv[])
{

	std::vector<int> number;
	number.push_back(1);
	vector<int>::iterator i;
	int carry=0;

	for (int ii = 1; ii <= 1000; ++ii){
		i = number.begin();
		
		int n = *i;

		n *= 2;
		carry = n/10;
		*i = n%10;
		i++;
		while (i != number.end()){
			n = *i;
			n *= 2;
			n += carry;
			*i = n%10;
			carry = n/10;
			i++;
		}
		if (carry){
			number.push_back(carry);
			carry=0;
		}
	}
	if (carry)
		number.push_back(carry);

	vector<int>::reverse_iterator ri;

	cout << "Final no: ";
	for (ri=number.rbegin();ri != number.rend(); ri++){
		cout << *ri;
	}

	cout << endl;

	long long sum = 0 ;
	int digits=0;
	for (ri=number.rbegin();ri != number.rend(); ri++){
		sum += *ri;
		digits++;
	}

	cout << "sum of digits: " << sum << endl;
	cout << "Total no of digits in 2*1000 :" << digits << endl;

	return 0;
}