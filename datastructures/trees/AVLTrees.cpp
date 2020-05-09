#include<iostream>
using namespace std;

class Node{
public:
    int data;
    Node* parent;
    Node* left;
    Node* right;

    // constructors
    Node(){
        this.data = -1;
        this.parent = NULL;
        this.left = NULL;
        this.right = NULL;
    }
    Node(int data){
        this.data = data;
        this.parent = NULL;
        this.left = NULL;
        this.right = NULL;
    }
};


rebalance(Node* head)
