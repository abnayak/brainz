#include <iostream>
#include <algorithm>
#include <string>
#include <numeric>

using namespace std;

int main(){

	int numerator[4]= { 0 };
	int denominator[4] = { 0 };
	int index=0;

	for(int i = 10 ; i <= 98 ; ++i){
		for(int j = i +1; j <= 99 ; ++j){
		
			int ia = i/10;
			int ib = i%10;
			int ja = j/10;
			int jb = j%10;
			
			if ( ib != 0 && jb != 0 ){
			
				if ( ia == ja && jb != 0){
					if ( i * jb == j * ib ) {
						numerator[index] = ib;
						denominator[index] = jb;
						index++;
					}
				}
				
				if ( ia == jb && ja != 0){
					if ( i * ja == j * ib ){
						numerator[index] = ib;
						denominator[index] = ja;
						index++;
					}
				
				}
				
				if ( ib == jb && ja != 0){
					if ( i * ja == j * ia ){
						numerator[index] = ia;
						denominator[index] = ja;
						index++;
					}
				
				}
				
				if ( ib == ja && jb != 0){
					if ( i * jb == j * ia ){
						numerator[index] = ia;
						denominator[index] = jb;
						index++;
					}
				}
			}
		}
	}
	
	int a=1,b=1;
	for (int i =0; i < 4 ; ++i ) a *= numerator[i];
	for (int i =0; i < 4 ; ++i ) b *= denominator[i];
	
	cout << b / a << endl;

	return 0;
}

