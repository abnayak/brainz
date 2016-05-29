#include <string>
#include <algorithm>
#include <iostream>
using namespace std;

int main(int argc, char const *argv[])
{
	string name = "bapuni";
	//string::iterator i = find(name.begin(), name.end(), 'b');
	//cout << name.find('a', 0);
	string name1 = "a";

	string::iterator i = name1.begin();
	name1.erase ( i );

	if ( name1.begin() == name1.end()){
		cout << "name1 is empty" << endl;
	}

	
	return 0;
}