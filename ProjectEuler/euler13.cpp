#include <iostream>

using namespace std;

int main( int argc, char *argv[]){
    int len = 100;
    string nos[len];
    
    for (int i = 0 ; i < len ; i++){
        cin >> nos[i];
    }
    
    int result[50];
    int carry = 0;
    
    for ( int j = 49 ; j >= 0 ; j--){
              
        for ( int i = 0 ; i < len ; i++){
            carry += ( (nos[i][j]) - '0');
        }
                
        result[j] = carry % 10;
        carry = carry / 10;
    }

    if ( carry > 0 )
        cout << carry ;


    for (int i = 0 ; i < 49 ; i++){
        cout << result[i] ;
    }
    
        
    return 0;
}