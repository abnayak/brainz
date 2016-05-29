#include <iostream>
#include <cassert>

#ifndef INT_MAX
#define INT_MAX 10000
#endif

#ifndef INT_MIN
#define INT_MIN -10000
#endif

using namespace std;

int findKthSmallest(int A[], int m, int B[], int n, int k);

int main(int argc, char const *argv[])
{
  int a[5]={1, 3, 7, 8, 11};
  int b[5]={2, 4, 6, 9, 10};
  int k =5;
  cout << findKthSmallest(a,5,b,5,5) << endl;

  return 0;
}
int findKthSmallest(int A[], int m, int B[], int n, int k) {
  assert(m >= 0); assert(n >= 0); assert(k > 0); assert(k <= m+n);
  
  int i = (int)((double)m / (m+n) * (k-1));
  int j = (k-1) - i;
 
  assert(i >= 0); assert(j >= 0); assert(i <= m); assert(j <= n);
  // invariant: i + j = k-1
  // Note: A[-1] = -INF and A[m] = +INF to maintain invariant
  int Ai_1 = ((i == 0) ? INT_MIN : A[i-1]);
  int Bj_1 = ((j == 0) ? INT_MIN : B[j-1]);
  int Ai   = ((i == m) ? INT_MAX : A[i]);
  int Bj   = ((j == n) ? INT_MAX : B[j]);
 
  if (Bj_1 < Ai && Ai < Bj)
    return Ai;
  else if (Ai_1 < Bj && Bj < Ai)
    return Bj;
 
  assert((Ai > Bj && Ai_1 > Bj) || 
         (Ai < Bj && Ai < Bj_1));
 
  // if none of the cases above, then it is either:
  if (Ai < Bj)
    // exclude Ai and below portion
    // exclude Bj and above portion
    return findKthSmallest(A+i+1, m-i-1, B, j, k-i-1);
  else /* Bj < Ai */
    // exclude Ai and above portion
    // exclude Bj and below portion
    return findKthSmallest(A, i, B+j+1, n-j-1, k-j-1);
}