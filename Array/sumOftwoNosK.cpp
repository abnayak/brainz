#include <iostream>
#include <algorithm>

using namespace std;

void usingSortedArray(int[],int,int);
void usingArrayHack(int[],int,int);

int main(){
	int arr[8]={3,6,2,8,5,7,1,4};
	int k = 8;
	int n = 8;
	
	usingSortedArray(arr,n,k);
	return 0;
}

void usingSortedArray(int arr[], int n , int k){
	int buf[n];
	for (int i = 0; i < n; buf[i]=arr[i], ++i);
	sort(buf,buf+n);
	
	int i = 0;
	int j = n-1;

	while(i < j )	{
		if(buf[i]+buf[j] == k){
			cout << "(" << buf[i] << "," << buf[j]  << ")";
			j--;
			i++;
		}
		else if (buf[i]+buf[j] < k)
			i++;
		else if (buf[i]+buf[j] > k)
			j--;
	}
}

//Version -1
//This method only works when we have positve nos. 
//Check the 

void usingArrayHack(int arr[], int n, int k){
	int buf[k];

	for (int i = 0; i < k; ++i){
		buf[i]=0;
	}
	
	for (int i = 0; i < n; ++i)	{
		if (k-arr[i] >= 0 && buf[arr[i]] != 0){
			cout << "(" << k-arr[i] << "," << arr[i]  << ")";
			buf[arr[i]]=0;
		}else{
			buf[k-arr[i]]=1;
		}

	}
}