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
void deleteNode(Node **head_ref, int position)
{
    //if linked list is empty
    if(*head_ref ==  NULL)
    {
        return;
    }
    
    //store head node
    Node* temp = *head_ref;

    //if head needs to be removed
    if (position == 0)
    {
        *head_ref = temp->next; //change head
        free(temp);             //free oldhead
        return;
    }

    //find previous node of the node to be deleted
    for (int i = 0; temp!=NULL && i<position-1;i++)
        temp = temp->next;
    
    //if position is more than number of nodes
    if(temp == NULL || temp->next ==NULL)
        return;
    
    //store ointer to the next of node to be deleted
    Node *next = temp->next->next;

    //unlink node from linked list
    free(temp->next); //free memory

    temp->next = next; //unlink delteed node from list
    

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

//Push node, given head and data int
void push(Node** head_ref, int new_data)
{
    //allocate node
    Node* new_node = new Node();

    //put in data
    new_node->data = new_data;

    //linking old list off the new node
    new_node->next = (*head_ref);

    //move head to point to the new node
    (*head_ref) = new_node;
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