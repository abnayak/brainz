#include <iostream>
#include <unordered_map>

using namespace std;

class Solution {
public:
    int lengthOfLongestSubstring(string s) {
  		unordered_map<char, int> hash;
  		int begin = 0;
  		int maxLen = 1;
  		hash.insert({s[0],0});

  		if (s.size() == 0) {
  			return 0;
  		}

  		for(int i = 1; i < s.size(); i++) {
  			auto itr = hash.find(s[i]);
  			if ( itr != hash.end() ) {
  				if (itr->second >= begin) {
	  				cout << s[i] << " found at: " << itr->second<<endl;
	  				begin = itr->second + 1;
	  			} 
	  			itr->second = i;
  			} else {
  				hash.insert({s[i],i});
  			}

  			int tempLen = i - begin + 1;
  			if ( tempLen > maxLen) maxLen = tempLen;
  		}
	  	return maxLen;
    }
};


int main() {
	Solution solution;
	cout << solution.lengthOfLongestSubstring("abba");
	return 0;
}