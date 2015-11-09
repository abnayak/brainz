#include <iostream>
using namespace std;

class Solution {
public:
	bool match(string s, string p, size_t i, size_t j) {
		if ( i > s.size() || j > p.size()){
	        return false;
	    }

    	// Success case
    	if (i == s.size() && j == p.size()) {
    		return true;
    	}

    	// return false if any one of index reaches end before the other
    	if ( (i == s.size() && j != p.size()) ) {
    		while(p[j+1] == '*') {
    			j += 2;
    		}
    		if (j == p.size()) {
    			return true;
    		} else {
    			return false;
    		}
    	}

    	if  (i != s.size() && j == p.size()) {
    		return false;
    	}

    	// When both charater match and there is no * star
    	if (s[i] == p[j]) {
    		if (p[j+1] != '*'){
    			return match(s, p, i+1, j+1);
    		} else {
    			if(match(s, p, i+1, j) ) return true;
    			return match (s, p, i+1, j+2);
    		}
    	}

    	// if the character is a dot then it will match any character
    	if (p[j] == '.') {
    		if (p[j+1] != '*'){
    			return match(s, p, i+1, j+1);
    		} else {
    			if (match(s, p, i+1, j) ) return true;
    			return match (s, p, i+1, j+2);
    		}	
    	}

    	// If character does not match then return false
    	if (s[i] != p[j]) {
    		if (p[j+1] == '*'){
    			return match(s, p, i, j+2);
    		} else {
    			return false;
    		}	
    	}
    	return false;
    }

    bool isMatch(string s, string p) {
    	return match(s, p, 0, 0);
    }
};


int main() {
	Solution solution;
	if( solution.isMatch("a","ab*")) {
		cout << "Match" << endl ;
	} else {
		cout << "Does not match" << endl;
	}
}