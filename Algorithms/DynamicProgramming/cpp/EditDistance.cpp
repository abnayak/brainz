#include <iostream>
#include <algorithm>

using namespace std;

int findEditDistance(string first, string second){
    int lenFirst = first.size();
    int lenSecond = second.size();
    int array[lenFirst+1][lenSecond+1];

    const int costOfDeletion = 1;
    const int costOfInsertion = 1;
    const int costOfSubstitution = 1; 

    for (int i = 0; i <= lenFirst; ++i){
        for (int j = 0; j <= lenSecond; ++j){
            if (i == 0)
                array[i][j] = j;    
            if (j == 0)
                array[i][j] = i;
            else
                array[i][j] = 0;
        }
    }

    for (int i = 1; i <= lenFirst; ++i) {
        for (int j = 1; j <= lenSecond; ++j) {
            if ( first[i-1] == second[j-1])
                array[i][j] = array[i-1][j-1];
            else{
                int deletion = distances[i - 1][j] + costOfDeletion;
                int insertion = distances[i][j - 1] + costOfInsertion;
                int substitution = distances[i - 1][j - 1] + costOfSubstitution;

                array[i][j] = 1 + min( deletion,  min(insertion, substitution) );
            }
        }
    }

    return array[lenFirst][lenSecond];
}

int main(int argc, char const *argv[])
{
    string first = "Saturday";
    string second = "Sunday";
    cout << "Saturday -> Sunday: " << findEditDistance(first,second) << endl;
    return 0;
}
 