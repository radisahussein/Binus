#include <iostream>
#include "assignment1.h"
using namespace std;

int main()
{
    int rows;
    cout << "Enter number of rows [1-6]: ";
    cin >> rows;
    if(rows > 6 || rows < 1)
    {
        main();
    }

    else
    {
        mainProgram(rows);
        cout << "Try again? (y/n): ";
        char again;
        cin >> again;
        if(again == 'y')
        {
            main();
        }
        else
        {
            return 0;
        }
    }
    
    
}
