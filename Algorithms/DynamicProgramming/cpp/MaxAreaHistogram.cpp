#include <iostream>
#include <vector>

using namespace std;

int maxSquarAreaInHistorgram(int *arr, int size){
	vector<int> result(size, 0);
	vector<int> heights(size,0);
	vector<int> count(size,0);

	if ( size == 0)
		return 0;

	result[0] = arr[0];
	heights[0] = arr[0];
	count[0] = 1;

	for (int i = 1; i < size; ++i){
		int area=0;

		if ( arr[i] >= heights[i-1]){
			area = (count[i-1]+1) * heights[i-1];
		}else{
			area = (count[i-1]+1) * arr[i];
		}

		if ( area > arr[i]){
			result[i] = area;
			heights[i] = heights[i-1];
			count[i] = count[i] + 1;
		}else{
			result[i] = arr[i];
			heights[i] = arr[i];
			count[i] = 1;
		}
	}

	return result[size-1];
}

int main(int argc, char const *argv[]) {
	int histograms[] = {6, 2, 5, 4, 5, 2, 6};
	cout << "Max Area: " << maxSquarAreaInHistorgram(histograms,sizeof(histograms)/sizeof(histograms[0])) << endl;;
	return 0;
}