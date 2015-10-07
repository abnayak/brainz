//https://leetcode.com/problems/two-sum/
#include <iostream>
#include <vector>
#include <algorithm>
#include <unordered_map>

using namespace std;

class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        unordered_map<int,int> remainingSum;
        int remaining;

        for(int i=0; i < nums.size(); i++) {
			remaining = target - nums[i];
			if(remainingSum.find(nums[i]) != remainingSum.end()) {
				auto it = remainingSum.find(nums[i]);
				vector<int> result = {(*it).second+1, i+1};
				return result;
			}
			remainingSum[remaining] = i;
        }
    }
};

int main() {
	vector<int> test ={3,2,4};
	Solution solution;
	auto result = solution.twoSum(test,6);

	cout << result[0] << " " << result[1] << endl;

	return 0;
}
