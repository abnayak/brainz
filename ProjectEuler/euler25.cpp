#include <iostream>
#include <vector>
#include <iterator>
#include <algorithm>

using namespace std;

void sum (vector<int> &, vector<int> &, vector<int> &);
void printVec(vector<int> &);

int main(int argc, char const *argv[])
{
	vector<int> t1, t2, result;
	t1.push_back(1);
	t2.push_back(1);
	int count = 2;

	while (1){
		sum ( t1, t2, result);
		count++;
		if ( result.size() >= 1000){
			cout << "fibonacci sequence: " << count << endl;
			cout << "Actual fibonacci no: ";
			printVec(result);
			break;
		}
		
		t1.clear();
		t1 = t2;
		t2.clear();
		t2 = result;
		result.clear();

	}
	return 0;
}

void printVec(vector<int>& vec){
	copy(vec.rbegin(), vec.rend(), ostream_iterator<int>(cout,""));
	cout << endl;
}

void sum (vector<int>& t1, vector<int>& t2, vector<int>& result){
	vector<int>::iterator it1, it2, ir;
	it1 = t1.begin();
	it2 = t2.begin();
	ir = result.begin();
	int carry = 0 ;
	int sum = 0 ;

	while ( it1 != t1.end() && it2 != t2.end()){
		sum = *it1 + *it2 + carry;
		carry = sum / 10;
		result.push_back(sum%10);
		it1++;
		it2++;
	}
	if (it1 != t1.end()){
		sum = *it1 + carry ;
		carry = sum / 10;
		result.push_back(sum%10);
		it1++;
	}else if (it2 != t2.end()){
		sum = *it2 + carry ;
		carry = sum / 10;
		result.push_back(sum%10);
		it2++;
	}

	while (carry){
		result.push_back(carry%10);
		carry /= 10;
	}
}