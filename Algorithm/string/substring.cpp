#include <iostream>
#include <cstring>

using namespace std;

void subString(string a, string b){
	int cols = a.length();
	int rows = b.length();
	int arr[rows+1][cols+1];
	int maxlen=0, maxj, maxi;
	//Fill all the fields for of he array with zero
	memset(arr,0, sizeof(int)*(rows+1) *(cols+1));

	for (int i = 0; i <= rows; ++i)	{
		for (int j = 0; j <= cols; ++j)	{

			//This will fill the zeroth row and column
			if ( i == 0 || j == 0)
				arr[i][j] = 0;

			//Actual processing
			else{
				//If a[j] == b[i] set the corresponding matrix value to one
				if(b[i-1] == a[j-1]){
					arr[i][j] = arr[i-1][j-1] + 1;

					//Save the maxlen and maxj to print the common substing
					if ( arr[i][j] > maxlen){
						maxlen = arr[i][j];
						maxi = i;
						maxj = j;
					}
				}
			}
		}
	}
	//Print the substring:
	cout << a.substr(maxj-maxlen, maxlen);
}

int main(int argc, char const *argv[])
{
	string name="AMAZON";
	string str = "NOZAMA";
	subString(name,str);
	return 0;
}