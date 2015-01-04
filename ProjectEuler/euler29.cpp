#include <iostream>
#include <set>
#include <cmath>
#include <vector>

using namespace std;

int main(int argc, char const *argv[])
{

	vector<set<int> > bases(101);

	for (int base = 2; base <= 100; ++base)	{
		for (int power = 2; power <= 100; ++power) {

			//find the prime factors of base 
			set<int> primeFactors;
			int n = base;
			for (int i = 2; i <= sqrt(n) ; ++i) {
				while ( n % i == 0 ){
					primeFactors.insert(i);
					n /= i;
				}
			}
			if ( n > 1 )
				primeFactors.insert(n);

			if (primeFactors.size() == 1){
				set<int>::iterator ii = primeFactors.begin();
				int primepower = base / *ii;
				bases[*ii].insert(power * primepower);
			}else  {
				bases[base].insert(power);
			}

		}//end of powerer for loop
	}// end of base for loop

	int totalCount=0;
	for (vector<set<int> >::iterator i = bases.begin(); i != bases.end() ; ++i)	{
		totalCount += (*i).size();
	}

	// for (int i = 0; i <= 100; ++i) {
	// 	set<int>::iterator ii;
		
	// 	if ( bases[i].size() > 0 ){
	// 		cout << i << " : ";
	// 		for (ii = bases[i].begin(); ii != bases[i].end(); ++ii)	{
	// 			cout << *ii << " ";
	// 		}
	// 		cout << endl;
	// 	}
	// }


	cout << "Result: " << totalCount << endl;
	return 0;
}