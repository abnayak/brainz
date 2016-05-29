#include <iostream>
#include <algorithm>
#include <cstring>
#include <vector>
#include <iterator>

// http://stackoverflow.com/questions/11483060/stdnext-permutation-implementation-explanation

using namespace std;

template<typename It>
bool find_next_perm(It begin, It end){
	if ( begin == end)
		return false;

	It i;
	i = begin;
	i++;

	if (i == end)
		return false;

	i = end;
	i--;
	
	while (true){
		It j = i;
		i--;

		if ( *i < *j){
			It k = end;
			while (!(*--k > *i));
			
			iter_swap(i,k);
			reverse(j,end);
			return true;
		}

		if (i == begin){
			reverse(i,end);
			return false;
		}
	}
}

int main(int argc, char const *argv[])
{
	char arr[] = "CABC";
	int len = strlen(arr);
	vector<char> v(arr,arr+len);
	sort(v.begin(),v.end());
	do{
		copy(v.begin(),v.end(), ostream_iterator<char>(cout, ""));
		cout << endl;
	}while (::find_next_perm(v.begin(),v.end()));
	return 0;
}