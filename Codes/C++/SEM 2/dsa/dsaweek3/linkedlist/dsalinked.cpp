#include <iostream>
#include "headerlinked.h"

using namespace std;

int main()
{
    Node *head = NULL;

    //USER INTERFACE
    bool start = true;
    while (true)
    {
        //input
        int inputData;

        cout << "========================" << endl;
        cout << "LINKEDLIST" << endl;
        cout << "========================" << endl;
        
        cout << "Current Linked List : " << endl;
        if(size(head) == 0)
        {
            cout << "Linked List is currently empty!" << endl;
        } 

        else
        {
            printList(head);

        }

        cout << "\n" << endl;

        cout << "Commands : " << endl;
        cout << "1. Append (add at tail)" << endl;
        cout << "2. Push (add at front)" << endl;
        cout << "3. Remove node" << endl;
        cout << "4. Get data" << endl;
        cout << "5. Get Size" << endl;
        cout << "6. Print List" << endl;
        cout << "7. Exit" << endl;
        cout << "========================" << endl;

        cout << "Selection : ";
        int selection;
        cin >> selection;

        //If else selections
        if(selection == 1)
        {
            //append
            cout << "Input Data to be inserted : ";
            cin >> inputData;
            append(&head,inputData);
        }

        else if (selection == 2)
        {
            //push
            cout << "Input data to be pushed : ";
            cin >> inputData;
            push(&head,inputData);

        }

        else if (selection == 3)
        {
            //delete node
            int positionNode;
            
            cout << "Which node to be deleted? : ";
            cin >> positionNode;
            deleteNode(&head,positionNode);
        }

        else if (selection == 4)
        {
            //get data
            int selectNode;
            cout << "Which node to get data(start from 0) : ";
            cin >> selectNode;

            cout << "Node at " << selectNode << " is " << getData(head,selectNode) << endl;

        }

        else if (selection == 5)
        {
            //GET SIZE
            cout << "\nSize of Linked List : " << size(head) << endl;

        }

        else if (selection == 6)
        {
            //PRINT LIST
            cout << "Linked List : ";
            printList(head);
        }

        else if (selection == 7)
        {
            //Exit
            cout << "Bye!" << endl;
            start = false;
            break;
        }
        
        else
        {
            cout << "That is not an option!" << endl;
            break;
        }
        
    }
    
    
    
    
    
    
    
    
    
}

