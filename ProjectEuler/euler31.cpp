#include <iostream>
#include <algorithm>
#include <cmath>
#include <string>


using namespace std;

int coins[] = { 1, 2, 5, 10, 20, 50, 100, 200 };

void CountWays(int index, int sum, int & count) {

	if ( sum == 200 ){
		count++;
		return;
	}
	
	if ( sum > 200 || index >= 8)
		return;
		
	for(int i = index ; i < 8 ; i++) {
		CountWays(i , sum + coins[i], count);
	}

}


int main(){
	int count=0;
	CountWays(0,0, count);
	cout << "Total ways: " << count << endl;
	return 0;
}