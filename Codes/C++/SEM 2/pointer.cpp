#include <iostream>

using namespace std;

template <class T>
class Swap
{
    T *pointer1, *pointer2, temp;

    public:
        // Swapping Function
        swapPointer(T number1, T number2)
        {   

            // Assigning pointers
            pointer1 = &number1;
            pointer2 = &number2;

            // Swapping Pointers
            temp = number1;
            *pointer1 = number2;
            *pointer2 = temp;

            cout << "Numbers after swap: " << number1 << " and " << number2 << endl;;
            
            return 0;
        }

};


int main()
{
    // Creating variables
    int number1,number2;

    //Input User Data
    cout << "Enter first number : ";
    cin >> number1;

    cout << "Enter second number : ";
    cin >> number2;
    

    cout << "Numbers before swap : " << number1 << " and " << number2 << endl;
    

    // Calling Class
    Swap <int> swapNumbers;
    swapNumbers.swapPointer(number1,number2);

}
