#include <iostream>

using namespace std;

int fun(int , int);

int main(){
	cout << fun(2, 10) << endl;
}

int fun(int a ,int b){
	return a / b ? 1:0;
}