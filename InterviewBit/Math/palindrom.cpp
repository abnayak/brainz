#include <iostream>
#include <algorithm>
#include <cmath>

using namespace std;

int isPalindrome(int A) {
  int DEBUG=0;
  if(A < 0)
    return 0;

  if(A >=0  && A <= 9)
    return 1;

  int const orig = A;

  int digits = 0;
  while ( A ){
    A /= 10;
    digits++;
  }

  long int maxNumberBiggerIndigits=0;
  for(int i=digits-1;i>=0; i--){
    maxNumberBiggerIndigits += 9*pow(10,i);
  }
  if(DEBUG)
    cout << maxNumberBiggerIndigits << endl;

  int newNumber = maxNumberBiggerIndigits - orig;
  if( newNumber == 0 )
    return 1;

  if(DEBUG)
    cout << newNumber << endl;

  for(int i = 1; i <= digits/2; i++) {
    int temp = newNumber % 10;
    newNumber /= 10;
    newNumber += (temp*pow(10,digits-1));
    if(DEBUG)
      cout << newNumber << "**" << endl;
  }

  if(DEBUG)
    cout << newNumber << endl;

  if( newNumber == (maxNumberBiggerIndigits-orig))
    return 1;
  else
    return 0;
}

int main() {
  cout << isPalindrome(121);
  return 0;
}
