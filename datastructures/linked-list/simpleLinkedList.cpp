#include<stdio.h>
using namespace std;


typedef struct Node{
    int data;
    Node* next;
}Node;


void printList(Node* head){
    Node* ptr = head;
    while(ptr->next != NULL){
        cout<< ptr->data<< " ";
        ptr = ptr->next;
    }
    cout<< endl;
}

Node* appendLinkedList(Node* head, int data){
    Node* newNode=new Node();
    newNode->data=data;
    if(head == NULL){
        return newNode;
    }

    Node* ptr = head;
    while(ptr->next != NULL){
        ptr = ptr->next;
    }
    ptr->next = newNode;

    return newNode;
}


int main(){
    return 0;
}
