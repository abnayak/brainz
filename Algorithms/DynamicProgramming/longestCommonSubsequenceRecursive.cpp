#include <iostream>
#include <algorithm>

using namespace std;

int longestSubsequence(const char *a, const char *b, int i , int j){
	if ( a[i] == '\0' || b[j] == '\0')
		return 0;

	if (a[i] == b[j])
		return 1 + longestSubsequence(a,b,i+1,j+1);
	else
		return max ( longestSubsequence(a,b,i+1, j), longestSubsequence(a,b,i,j+1));
}


int main(int argc, char const *argv[])
{
	string a = "AGGTAB";
	string b = "GXTXAYB";

	cout << "longest subsequence: " << longestSubsequence(a.c_str(), b.c_str(), 0 , 0);

	return 0;
}