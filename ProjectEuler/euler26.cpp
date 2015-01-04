#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

int main(int argc, char const *argv[])
{
	int max = 0 ;
	int no=0;;
	
	for (int i = 2; i < 1000; ++i)
	{
		int found[1001] = {0};
		int num = 1;
		int sequence=1;

		while ( found[num] == 0 && num ){
			found[num]=sequence;
			num *= 10;
			num = num % i;
			sequence++;
		}

		if ( sequence - found[num] > max){
			 max =  sequence - found[num];
			 no = i;
		}
	}

	cout << no << endl;
	return 0;
}