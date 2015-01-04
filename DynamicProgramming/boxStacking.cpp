#include <iostream>

bool compareBox(box b1, box b2){
	if ( b1 < b2 )
		return true;
	else
		false;
}

vector<box> maxHeight(vector<box> solution, int index , int size, box boxes[]){
	if ( index == size)
		return boxes;

	solution.push_back(boxes[index]);

	if (index > 0 && compareBox(solution[index-1], boxes[index])){
		vector<box> left = maxHeight(boxes, index +1 , size, boxes )
		solution.pop_back();
	
	}

	vector<box> right  = maxHeight(boxes, index+1, size, boxes)
	if (    )
}