#ifndef HEADER_HEADER_H
#define HEADER_HEADER_H
#include <assert.h>

using namespace std;


// Linked list node
class Node
{
    public:
    int data;
    Node* next;
};

//remove a node given index
Node* deleteNode(Node* head)
{
    if (head == NULL)
        return NULL;
    
    //Move head pointer to next node
    Node* temp = head;
    head = head->next;

    delete temp;
    return head;
}

//Get length of linkedlist
int size(Node* head)
{
    int count = 0;
    Node* current = head;
    while (current != NULL)
    {
        count++;
        current = current->next;
    }

    return count;
}

//Append, adding node at the end
void append(Node** head_ref,int new_data)
{
    //allocate node
    Node* new_node = new Node();

    Node *last = *head_ref;

    //put in data
    new_node->data = new_data;

    //make next of node as NULL
    new_node->next = NULL;

    //if linked list is empty make new node as head
    if (*head_ref == NULL)
    {
        *head_ref = new_node;
        return;
    } 

    //else traverse till last node
    while (last->next != NULL)
        last = last->next;

    //change next of last node
    last->next = new_node;
    return;

}


//function to print data inside linkedlist
void printList(Node* head)
{
    while (head != NULL)
    {
        cout << head->data << " ";
        head = head->next;
    }
}

int getData(Node* head, int index)
{
    Node* current = head;

    int count = 0;
    while (current != NULL)
    {
        if(count == index)
        {
            return (current->data);
        }
        count++;
        current = current->next;
    }

    assert(0);
    
}

#endif