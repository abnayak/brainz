#include <iostream>
#include <array>
#include <algorithm>
#include <iterator>

using namespace std;

int main(){
	array<int,7> prices = {5,4,3,8,9,2,6};
	array<int,7> profit;
	int minPrice = numeric_limits<int>::max();
	int maxPrice = numeric_limits<int>::min();

	profit[prices.size()-1] = 0;
	maxPrice = prices[prices.size()-1];

	//Calculate the profits in backward direction
	for(int i=prices.size()-2; i >= 0 ;i--){
		if(prices[i] > maxPrice) {
			maxPrice = prices[i];
		}
		profit[i] = max(profit[i+1], maxPrice - prices[i]);
	}
	copy(profit.begin(), profit.end(), ostream_iterator<int>(cout, " " ));

	minPrice = prices[0];
	for(int i = 1; i < prices.size() ; i++){

	}

	return 0;
}