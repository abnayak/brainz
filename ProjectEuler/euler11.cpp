#include <iostream>
#include <fstream>
#include <climits>
#include <algorithm>

using namespace std;

long mulHorizotal(int x, int y);
long mulVertical(int x, int y);
long mulDiagRight(int x, int y);
long mulDiagLeft(int x, int y);

long arr[20][20];

long max ( long a, long b){
	return ( a > b ? a: b);
}

int main(int argc, char const *argv[])
{
	ifstream file;
	file.open("Input11.txt");
	long maxResult = LONG_MIN;
	long tempMax = LONG_MIN;
	long intVal;

	if (!file.is_open()) {
		cout << "failed to open the file " << endl;
		return -1;
	}

	for (int i = 0; i < 20; ++i){
		for (int j = 0; j < 20; ++j){
			file >> intVal;
			arr[i][j] = intVal;
		}
	}	
	
	for (int i = 0; i < 20; ++i){
		for (int j = 0; j < 20; ++j){
			tempMax = max(max(mulHorizotal(i,j),mulVertical(i,j)),max(mulDiagRight(i,j), mulDiagLeft(i,j)));
			if ( tempMax > maxResult)
				maxResult = tempMax;
		}
	}

	cout << maxResult << endl;

	file.close();
	return 0;
}

long mulHorizotal(int x, int y){
	if ( y + 3 > 19)
		return LONG_MIN;
	long result = 0;
	result = arr[x][y] * arr[x][y+1] * arr[x][y+2] * arr[x][y+3];
	return result;
}

long mulVertical(int x, int y){
	if ( x + 3 > 19)
		return LONG_MIN;
	long result = 0;
	result = arr[x][y] * arr[x+1][y] * arr[x+2][y] * arr[x+3][y];
	return result;
}

long mulDiagRight(int x, int y){
	if ( y+3 <= 19 && x+3 <= 19){
		long result = 0;
		result = arr[x][y] * arr[x+1][y+1] * arr[x+2][y+2] * arr[x+3][y+3];
		return result;
	}
	return LONG_MIN;
}

long mulDiagLeft(int x, int y){
	if ( y >= 3 && x+3 <= 19 ){
		return arr[x][y] * arr[x+1][y-1] * arr[x+2][y-2] * arr[x+3][y-3];
	}
	return LONG_MIN;
}