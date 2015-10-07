//https://leetcode.com/problems/add-two-numbers/
#include <iostream>
#include <vector>

using namespace std;

struct ListNode {
    int val;
    ListNode *next;
    ListNode(int x) : val(x), next(NULL) {}
};

class Solution {
	vector<int> solution;
public:
    ListNode* addTwoNumbers(ListNode* l1, ListNode* l2) {
    	add(l1,l2);
		ListNode *result = NULL;
		for(int i =0 ; i< solution.size(); i++) {
			if ( result == NULL) {
				result = new ListNode(solution[i]);
			} else {
				result->next = new ListNode(solution[i]);
			}
		}
		return result;
    }

    int carry = 0;
    void add(ListNode* l1, ListNode* l2) {
    	if (l1 != NULL && l2 != NULL) {
    		int sum = l1->val + l2->val + carry;
    		if (sum>=10) {
    			carry = 1;
    			solution.push_back(sum%10);
    		} else {
    			carry = 0;
    			solution.push_back(sum);
    		}
    		add(l1->next,l2->next);
    	} else if (l1 != NULL) {
			int sum = l1->val + carry;
    		if (sum>=10) {
    			carry = 1;
    			solution.push_back(sum%10);
    		} else {
    			carry = 0;
    			solution.push_back(sum);
    		}
    		add(l1->next,NULL);
    	} else if (l2 != NULL) {
			int sum = l2->val + carry;
    		if (sum>=10) {
    			carry = 1;
    			solution.push_back(sum%10);
    		} else {
    			carry = 0;
    			solution.push_back(sum);
    		}
    		add(NULL,l2->next);
    	}
   	}
};

void main () {
	Solution solution;
	ListNode *result = solution
	return 0;
}