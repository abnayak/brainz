#include <iostream>
using namespace std;

long CollatzLen(long n){
	long count=0;
	while ( n != 1){
		if ( n % 2 == 0 ){
			n = n/2;
		}else{
			n = 3*n + 1;
		}
		count++;
	}
	return count;
}

int main(int argc, char const *argv[])
{
	long limit = 1000000;
	long result=1;
	long count=0;

	for (int i = 2; i < limit; ++i){
		long tempCount = CollatzLen(i);
		if ( tempCount > count){
			result = i;
			count = tempCount;
		}
	}
	cout << result << endl;
	return 0;
}