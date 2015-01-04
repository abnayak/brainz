#include <iostream>
#include <algorithm>
#include <vector>
#include <string>
#include <fstream>
#include <iterator>

using namespace std;

int main(int argc, char const *argv[])
{
	vector<string> names;
	ifstream infile;
	infile.open("euler22input.txt");
	string buf;
	unsigned long long result=0;

	if ( infile.is_open()){
		while( infile.good() ){
			getline(infile,buf, ',');
			names.push_back(buf.substr(1,buf.length()-2));
		}
	}

	//sort the names alphabetically
	sort(names.begin(), names.end());

	for (int i = 0; i < names.size(); ++i) {
		//cout << i << " : " << names[i] << endl;
		unsigned long long sum=0;
		string name = names[i];
		string::iterator it;
		for (it = name.begin(); it != name.end(); it++){
			sum += (*it - 'A') + 1;
		}

		result += (sum * (i+1));
	}
	cout << result << endl;

	return 0;
}