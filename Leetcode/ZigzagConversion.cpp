#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
    string convert(string s, int numRows) {
    	char **grid = new char*[numRows];
    	for (int i = 0; i < numRows; ++i) {
			grid[i] = new char[s.size()];
    	}

        for (int i = 0; i < numRows; ++i) {
        	for (int j = 0; j < s.size(); ++j) {
        		grid[i][j]  = NULL;
        	}
        }

      	int row = 0;
      	int col = 0;
        for (int i = 0; i < s.size();) {
        	while(row < numRows && i < s.size()) {
        		grid[row][col] = s[i];
        		row++;
        		i++;
        	}
        	row -= 2;
        	col++;
        	while(row >= 0 && i < s.size()) {
        		grid[row][col] = s[i];
        		col++;
        		row--;
        		if (row>=0)
        			i++;
        	}
        	row=0;
        	col--;
        	
        }

        string solution ;
        for (int i = 0; i < numRows; ++i) {
        	for (int j = 0; j < s.size(); ++j) {
        		if ( grid[i][j] != NULL) {
        			solution += grid[i][j];
        		}
        	}
        }
        return solution;
    }
};


int main() {
	Solution solution;
	cout << solution.convert("twckwuyvbihajbmhmodminftgpdcbquupwflqfiunpuwtigfwjtgzzcfofjpydjnzqysvgmiyifrrlwpwpyvqadefmvfshsrxsltbxbziiqbvosufqpwsucyjyfbhauesgzvfdwnloojejdkzugsrksakzbrzxwudxpjaoyocpxhycrxwzrpllpwlsnkqlevjwejkfxmuwvsyopxpjmbuexfwksoywkhsqqevqtpoohpd", 2) << endl;
	return 0;
}
