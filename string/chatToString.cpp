#include <iostream>
#include <algorithm>

using namespace std;

int main(int argc, char const *argv[])
{
	char ch='a';
	string str = "";
	str += ch;
	cout << str << endl;
	str.clear();
	cout << str.max_size() << endl;
	return 0;
}