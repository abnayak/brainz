/*
ID: maroon
LANG: C++
TASK: test
*/

#include <iostream>
#include <fstream>

using namespace std;

int main(){

	int a , b;
	ofstream out ("test.out");
	ifstream in("test.in");
	in >> a >> b;
	out << a+b << endl;
	out.close();
	in.close();
	return 0;
}