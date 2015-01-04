#include <iostream>

using namespace std;

int main(int argc, char const *argv[])
{
	int a ,b,c,d;

	for ( a = 0; a < 2; ++a)	{
		for ( b = 0 ; b < 2; b++)	{
			c = 2-a;
			d = 2-b;
			if ( a < c && b < d)
				cout << "( " << b << "," << d << ")" << "( " << a << "," << b << ")" << endl;
		}
	}
	return 0;
}