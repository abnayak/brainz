#include <iostream>
#include <vector>
#include <iterator>
#include <algorithm>

using namespace std;

int table[100]={-1};

int coinChangeCTC(int amnt, int denom){
	int nextDenom=0;

	switch(denom){
		case 25:
		nextDenom=10;
		break;
		case 10:
		nextDenom=5;
		break;
		case 5:
		nextDenom=1;
		case 1:
		nextDenom=1;
		return 1;
	}
	int ways=0;

	for (int i = 0; i * denom <= amnt ; ++i)
	{
		ways += coinChangeCTC(amnt - i*denom, nextDenom);
	}
	return ways;
}



int coinChangeMy( int n , int denoms[]){

    if ( n < 0 ) return -1;
    if ( n == 0) return 0;

    if (table[n] != -1) return table[n];

    int ans = -1;
    for (int i = 0; i < 4; ++i)
    {
    	ans = min(ans, coinChangeMy(n-denoms[i], denoms));
    }
    return table[n] = ans +1 ;
}

int table[100];
void myCoinChange(int sum, int denoms[], int index, int n, int &count, vector<int> v){
	if ( sum == 0){
		count++;
		copy(v.begin(), v.end(), ostream_iterator<int>(cout, " " ));
		cout << endl;
		return;
	}
	if ( sum < 0 )
		return;

	if ( index < 0 || index > n)
		return;

	v.push_back(denoms[index]);
	myCoinChange(sum-denoms[index], denoms, index, n, count,v);
	v.pop_back();
	myCoinChange(sum , denoms, index+1, n, count,v);
}

int main(int argc, char const *argv[])
{
	vector<int> v;
	cout << coinChangeCTC(100,25) << endl;	
	int denoms[]={25,10,5,1};
	cout <<coinChangeMy(100, denoms);
	cout << endl ;
	int count=0;
	myCoinChange(100,denoms,0,3, count, v);
	cout << count << endl;
	
	return 0;
}