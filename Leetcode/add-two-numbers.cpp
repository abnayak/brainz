//https://leetcode.com/problems/add-two-numbers/
#include <iostream>
#include <vector>

using namespace std;

struct ListNode {
    int val;
    ListNode *next;
    ListNode(int x) {
        val = x;
        next = NULL;
    }
};

class Solution {
    int carry;
    ListNode * result;
public:
    ListNode* addTwoNumbers(ListNode* l1, ListNode* l2) {
        carry=0;
        result = NULL;
    	add(l1,l2);
		return result;
    }

    
    void add(ListNode* l1, ListNode* l2) {
    	if (l1 != NULL && l2 != NULL) {
    		int sum = l1->val + l2->val + carry;
            cout << "sum: " << sum << endl;
    		if (sum>=10) {
    			carry = 1;
                cout << "adding: " << sum-10 << endl;
                addVal(sum-10);
    		} else {
    			carry = 0;
                addVal(sum);
    		}
    		add(l1->next,l2->next);
    	} else if (l1 != NULL) {
			int sum = l1->val + carry;
    		if (sum>=10) {
    			carry = 1;
                addVal(sum%10);
    		} else {
    			carry = 0;
                addVal(sum);
    		}
    		add(l1->next,NULL);
    	} else if (l2 != NULL) {
			int sum = l2->val + carry;
    		if (sum>=10) {
    			carry = 1;
                addVal(sum%10);
    		} else {
    			carry = 0;
                addVal(sum);
    		}
    		add(NULL,l2->next);
    	}
   	}

    void addVal(int val) {
        if(result == NULL) {
            result = new ListNode(val);
        } else {
            result->next = new ListNode(val);
        }
    }
};

int main () {
	Solution solution;
    ListNode *l1 = new ListNode(2);
    l1->next = new ListNode(4);
    l1->next->next = new ListNode(3);

    ListNode *l2 = new ListNode(5);
    l2->next = new ListNode(6);
    l2->next->next = new ListNode(4);

	ListNode *result = solution.addTwoNumbers(l1,l2);
    cout << result->val << " " << result->next->val << endl;
	return 0;
}