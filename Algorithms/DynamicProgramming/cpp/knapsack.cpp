#include <iostream>
#include <algorithm>
#include <cstring>

using namespace std;
int table[3][3];

int knapSack(int val[], int wt[], int n , int index, int W){
	if (index >= n )
		return 0;

	if ( table[index][W] != -1)
		return table[index][W];

	if ( wt[index] > W)
	 	table[index][W] =knapSack(val, wt, n , index+1, W);
	else
		table[index][W]=  max ( val[index]+knapSack(val,wt,n, index+1, W-wt[index]) , knapSack(val,wt,n,index+1,W) );

	return table[index][W];
}

int knapSackRecursion(int *vals, int *wts, int maxIndex, int index , int w){
	if ( index >= maxIndex)
		return 0;

	if ( wts[index] <= w){
		return max (vals[index]+knapSackRecursion(vals,wts,maxIndex,index+1,w-wts[index]), 
					knapSackRecursion(vals,wts,maxIndex,index+1,w) );
	}else{
		return knapSackRecursion(vals,wts,maxIndex,index+1,w);
	}
}

int main()
{
    int val[] = {60, 100, 120};
    int wt[] = {10, 20, 30};

    const int  W = 30;

    const int vals = sizeof(val)/sizeof(val[0]);
    const int wts = sizeof(wt)/sizeof(wt[0]);
    const int size = sizeof(int)*(vals+1)*(W+1);
	
	for (int i = 0; i < vals+1; ++i)
    	for (int j = 0; j < W+1; ++j)
    		table[i][j]=-1;
        
    cout << knapSack(val, wt, vals, 0, W) << endl;
    cout << knapSackRecursion(val,wt,vals,0,W) << endl;
    
    return 0;
}