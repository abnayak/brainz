#include <iostream>
#include <iterator>
#include <algorithm>
#include <vector>

using namespace std;


unsigned long sumOfDigits(std::vector<int> &v);

int main(int argc, char const *argv[])
{

	std::vector<int> number;
	number.push_back(1);
	vector<int>::iterator i;
	int carry=0;

	for (int ii = 2; ii <= 100; ++ii){
		i = number.begin();
		int n = *i;
		n *= ii;
		carry = n/10;
		*i = n%10;
		i++;
		while (i != number.end()){
			n = *i;
			n *= ii;
			n += carry;
			*i = n%10;
			carry = n/10;
			i++;

		}

		if (carry){
			number.push_back(carry);
			carry=0;
		}

		vector<int>::iterator ti;
		vector<int> numbuf;

		for(ti=number.begin(); ti != number.end(); ti++){
			int temp = *ti;
			if ( temp > 9 ){
				while ( temp){
					numbuf.push_back(temp%10);
					temp /= 10;
				}
			}else{
				numbuf.push_back(temp);
			}
		}
		number.clear();
		number = numbuf;
	}

	if (carry)
		number.push_back(carry);

	vector<int>::reverse_iterator ri;

	cout << "Final no: ";
	for (ri=number.rbegin();ri != number.rend(); ri++){
		cout << *ri;
	}

	cout << "\nSum of digits in 100! : " << sumOfDigits(number) << endl;
	return 0;
}

unsigned long sumOfDigits(std::vector<int> &v){
	std::vector<int>::iterator i;
	unsigned long totalSum=0;

	for (i= v.begin(); i != v.end(); ++i){
		int n = *i ;

		while (n ){
			totalSum += n%10;
			n /= 10;
		}
	}
	return totalSum;
}