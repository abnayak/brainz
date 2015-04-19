//http://www.geeksforgeeks.org/maximum-profit-by-buying-and-selling-a-share-at-most-twice/
#include <iostream>

using namespace std;

int main(){
	int prices[6] = {10, 22, 5, 75, 65, 80};
	int pos;
	int profit = 0;
	int profit1 = 0;
	int min1 = prices[0];
	for(int i = 2; i < 6; i++){
		if ( prices[i] < min1){
			min1 = prices[i];
			pos = i;
		}else if ( prices[i] - min1 > profit){
			profit = prices[i] - min1;
		}
	}
	profit1 = profit;
	profit = 0;
	if ( pos >= 3 ){
		min1 = prices[0];
		for(int i = 2; i < pos; i++){
			if (prices[i] < min1){
				min1 = prices[i];
			}else if (prices[i] - min1 > profit){
				profit = prices[i] - min1;
			}
		}
	}
	cout << "total profit: " << profit + profit1 << endl;
	return 0;
}