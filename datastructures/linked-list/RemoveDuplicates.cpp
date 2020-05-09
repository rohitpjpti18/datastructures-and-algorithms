// Write a program to remove all the nodes that have duplicate information
#include<iostream>
#include<vector>
using namespace std;

typedef struct Node{
    int data;
    Node* previous;
    Node* next;
}Node;


bool inVector(int data, Node& vect){
    for(int i = 0; i<vect.size(); i++){
        if(vect[i] == data){
            return true;
        }
    }
    return false;
}

deleteNode(Node* node){
    if(node->previous != NULL && node->next != NULL){
        // code for deleting node in the middle
    }
    else if(node->previous == NULL){
        // code for deleting node in the beginning
    }
    else if(node->next == NULL){
        // code for deleting node in the end
    }
}

Node* removeDuplicates(Node* Head){
    vector<int> set;
    while(ptr->next != NULL) {
        if(inVector(ptr->data, &set)){
            deleteMidNode(&ptr)
        }
        else{
            set.push_back(ptr->data);
        }
        ptr = ptr->next;
    }
}

int main(){
    return 0;
}
