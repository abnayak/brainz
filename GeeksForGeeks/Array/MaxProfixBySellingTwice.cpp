//http://www.geeksforgeeks.org/maximum-profit-by-buying-and-selling-a-share-at-most-twice/
#include <iostream>

using namespace std;

int main(){
	const int arraySize = 7;
	int prices[arraySize] = {2, 30, 15, 10, 8, 25, 80};
	int maxProfits[arraySize];
	int curBuyingPrice[arraySize];
	int maxProfit = 0;
	int buyingPrice=prices[0];
	maxProfits[0] = 0;

	for(int i = 1 ; i < arraySize ; i++){
		if (buyingPrice > prices[i]){
			buyingPrice = prices[i];
		}else if ((prices[i] - buyingPrice) > maxProfit){
			maxProfit = prices[i] - buyingPrice;
		}
		maxProfits[i] = maxProfit;
		curBuyingPrice[i] = buyingPrice;
	}
	maxProfit = 0 ;
	int totalProfit = 0;
	for (int i = 0 ; i < arraySize ; i++){
		cout << maxProfits[i] << ", ";
	}
	cout << endl;
	
	for(int i=1 ; i < arraySize ; i++){
		if ( maxProfit < maxProfits[i]){
			maxProfit = maxProfits[i];
			totalProfit = maxProfit + maxProfits[i-1];
		}
	}
	cout << totalProfit << endl;
}