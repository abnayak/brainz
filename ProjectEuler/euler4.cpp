#include <iostream>
#include <algorithm>
#include <cmath>
#include <sstream>
#include <string>

using namespace std;

int main(int argc, char** argv){
	unsigned int limit = 999;
	unsigned long mul = 0 ;
	unsigned int result = 0 ;

	for(int i = 100; i <= limit ; i++){
		for(int j= 100; j<=limit; j++){
		mul = i * j ;
		bool isPallindrom = true;
		stringstream ss;
		ss << mul ;
		string s = ss.str();
		
		string::iterator f;
		string::reverse_iterator b;
		string::iterator e;
		
		for(f = s.begin(), b = s.rbegin(), e = s.end(); f != e ; f++, b++){
			if ( *f != *b ){
				isPallindrom = false;
				break;
			}
		}
		
		if ( isPallindrom && mul > result){
			result = mul;
		}
	}
	}
	
	cout << result << endl;
	return 0;
}
