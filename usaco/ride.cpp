/*
ID: bapuni1
LANG: C++
TASK: ride
*/

#include <iostream>
#include <fstream>

using namespace std;

int main(){
	ifstream input("ride.in");
	ofstream output("ride.out");
	string s1;
	string s2;

	while (input >> s1){
		input >> s2;

		long int sum1=1;
		long int sum2=1;

		const char* first = s1.c_str();
		const char* second = s2.c_str();

		for (int i=0; first[i] != '\0' ; i++){
			sum1 *= ((first[i]-'A') + 1);
		}
		//cout << sum1 << endl;
		for (int i=0; second[i] != '\0' ; i++){	
			sum2 *= ((second[i]-'A') + 1);
		}
		//cout << sum2 << endl;
		if ( (sum1 % 47 ) == (sum2 % 47)){
			output << "GO" << endl;
		}else{
			output << "STAY" << endl;
		}
	}

	return 0;
}