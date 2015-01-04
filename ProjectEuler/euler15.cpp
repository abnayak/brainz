#include <iostream>
#include <cstring>

using namespace std;

int result[21][21];

int path(int x, int y , long& count){
	if ( x == 0 && y == 0)
		return 1;

	if ( x < 0 || y < 0)
		return 0;

	if (result[x][y] != 0)
		return result[x][y];

	result[x][y] = 	path(x-1,y,count) + path(x,y-1,count);

	return result[x][y];
}

int main(int argc, char const *argv[])
{
	int grid = 20;
	long count=0;
	memset(result , 0 , sizeof(result[0][0]) * grid * grid);
	path(grid,grid,count);

	cout << result[grid][grid] << endl;
	//cout << result[2][2] << endl;
	return 0;
}