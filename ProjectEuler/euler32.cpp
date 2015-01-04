/*
This is problem is simple and interesting. Solution to this problem is to find different combinations of multiplicand/multiplier/product.
Real challenge lies finding the upper bound of the multiplicand and multipier, otherwise it will take lots of time.

Consider following;
i x j = k
According to question : lenght(i) + length(j) + length(k) = 9 

Lets figure out what could be upper limits of the i and j, that will automatically lead to k.
First take smallest value of i = 1. In this case maximum value of j could be 9999 which will result in k = 9999
length(1) + length(9999) + length(9999) = 9

Lets take i =1 and j = 10000, then k = 10000
=> length(1) + length(10000) + length(10000) = 11
=> Min value of i = 1 and max value of j = 9999

Since multiplication is associative in nature, we do not need to check all the combinations of i and j;

if i = n
=> Max of j = ceil ( k / n),  so that i * j = 9999
=> Min of j = i + 1;

Max value of i will be largest value which can divide k => i = ceil(sqrt(k))

Once we got all the limits we can generate all the combinations and check if letters 1-9 is present in whole ouput.

Is not it simple. :)

*/

#include <iostream>
#include <set>
#include <numeric>
#include <cmath>
#include <sstream>
#include <algorithm>
#include <iterator>

using namespace std;
bool checkForAllNos(int i , int j, int k);

int main(int argc, char const *argv[])
{
	set<int> nos;
	for (int i = 1; i <= ceil(sqrt(9999)) ; ++i) {
		for (int j = i+1; j <= ceil(9999/i); ++j) {
		 	if ( checkForAllNos(i, j , i*j) )
		 		nos.insert(i*j);
		} 	
	}

	cout << "Multiplications part of the result: ";
	copy(nos.begin(), nos.end(), ostream_iterator<int>(cout, " "));
	cout << endl;
	cout << "Result: " << accumulate(nos.begin(), nos.end(), 0) << endl;

	return 0;
}

bool checkForAllNos(int i , int j, int k){
	stringstream ss;
	ss << i ;
	ss << j ;
	ss << k;

	string result = ss.str();

	sort(result.begin(), result.end());

	int check = 49; //49 is ASCII value of 1

	if (result.length() != 9 )
		return false;

	for (string::iterator i = result.begin(); i != result.end(); ++i, ++check){
		if ( check != *i )
			return false;
	}

	return true;
}