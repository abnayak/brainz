#include <iostream>
#include <cstdlib>
#include <algorithm>
#include <vector>
#include <iterator>

using namespace std;

string array[] = { "0", "1", "2" };
//string array[] = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};

void generateLexographicNos(string result, int index, int & count){
	if (result.length() == 3){
		count++;
		cout << result << endl;;
		// if (count == 100000){
		// 	cout << result << endl;
		// 	exit(1);
		// }
	}

	for (int i = index; i < 3; ++i)
	{
		//swap(array+index, array+i);
		generateLexographicNos(result + array[i], index + 1, count);
		//swap(array+index, array+i);
	}
}

void generatePermutation(char *arr, int index , int &count, vector<string> & nums){
	if (index == 10){
		count++;
		//cout << arr << endl;
		nums.push_back(string(arr));
		if ( count == 1000000 ){
			sort(nums.begin(), nums.end());
			vector<string>::reverse_iterator it;
			it = nums.rbegin();
			cout << *it << endl;
			exit(1);
		}
	}

	for (int i = index; i < 10; ++i){
		swap(arr[index], arr[i]);
		generatePermutation(arr, index + 1 , count, nums);
		swap(arr[index], arr[i]);
	}

}

int main(int argc, char const *argv[])
{
	int count= 0 ;
	//generateLexographicNos("", 0, count);
	char arr[10] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };
	//char arr[4] = { '0', '1', '2', '\0'};
	std::vector<char> nums(arr,arr+10);
	//generatePermutation(arr, 0, count, nums);
	

	do{
		count ++;
		//copy(nums.begin(), nums.end(), ostream_iterator<char>(cout, ""));	
		//cout << endl;
		if (count == 1000000){
			copy(nums.begin(), nums.end(), ostream_iterator<char>(cout, ""));	
			break;
		}
	}while ( next_permutation(nums.begin(), nums.end()));

	return 0;
}


