#include <iostream>
#include <algorithm>

using namespace std;

int main(int argc, char *argv[])
{
	int array[10] = {1,2,3,4,5,6,7,8,9,10};
	int *buf; 
	buf = new int[sizeof(array)/sizeof(array[0])];
	copy(array,array+(sizeof(array)/sizeof(array[0]), buf);
	return 0;
}

