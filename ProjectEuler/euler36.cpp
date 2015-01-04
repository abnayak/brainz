#include <iostream>
#include <vector>
#include <string>

using namespace std;

int main(int argc, char const *argv[])
{
	int n = 1000000;
	unsigned long long sum=0;

	for (int i = 0; i < n; ++i) {
		
		vector<int> binary;
		string sn = to_string(i);
		int temp = i ;
		bool binaryPallindrom=false, noPallindrom=false;

		do {
			binary.push_back('0' + (temp & 1) );
		}while ( temp >>= 1);

		vector<int>::iterator vi;
		vector<int>::reverse_iterator vri;
		
		for ( vi = binary.begin(), vri = binary.rbegin(); *vi == *vri && vi != binary.end() ; vi++, vri++);
		
		if ( vi == binary.end())
			binaryPallindrom=true;

		string::iterator si;
		string::reverse_iterator sri;

		for ( si = sn.begin(), sri= sn.rbegin() ; *si == *sri && si != sn.end(); si++, sri++);

		if ( si == sn.end())
			noPallindrom= true;

		if ( noPallindrom && binaryPallindrom )
			sum += i ;

	}
	cout << "Sum: " << sum << endl;
	return 0;
}