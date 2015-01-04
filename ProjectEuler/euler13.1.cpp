#include<iostream>
#include<fstream>
#include<sstream>
using namespace std;

struct grid{
    int num[50];
};

int main()
{
    struct grid obj[100];
    char ch;
    ifstream myfile ("euler13input.txt");
    if (myfile.is_open())
    {
        for(int r=0; r<100; r++)
        {
            for(int c=0; c<50; c++)
            {
                myfile >> ch;
                obj[r].num[c] = ch - '0';
            }
        }
        myfile.close();
        int result[50],temp_sum = 0;
        for (int c = 49; c>=0; c--)
        {
            for (int r=0; r<100; r++)
            {
                temp_sum += obj[r].num[c];
            }
            result[c] = temp_sum%10;
            temp_sum = temp_sum/10;
        }
        string temp;
        ostringstream convert;
        convert << temp_sum;
        temp = convert.str();
        cout << temp_sum;
        for(unsigned int count = 0; count < (10 - temp.length()); count++)
        {
            cout << result[count];
        }
        cout << endl;
    }
    return 0;
}