// Palindrome program to check if the entered word is a palindrome

#include <iostream>
#include <cstring>

using namespace std;

int main() 
{
    string wordInput;
    cout << "Enter a word: ";
    cin >> wordInput;

    int wordLength = wordInput.length(); //Getting Length of input
    
    char wordList[wordLength];
    strcpy(wordList,wordInput.c_str()); //Splits string into char and copies into array

    char reversedList[wordLength];

    int counter = 0; //acts as a pointer for the for loop
    for (int i = wordLength - 1; i >= 0; i--)
    {
        reversedList[counter] = wordList[i];
        counter++;
    }

    reversedList[wordLength] = '\0'; // terminating the null-terminated strings

    //converting both arrays into string for comparison
    string wordString = wordList;
    string reversedString = reversedList;


    // If Else to determine if its a palindrome
    if (wordString == reversedString)
    {
        cout << "TRUE" << endl;
    }

    else
    {
        cout << "FALSE" << endl;
    }

}
