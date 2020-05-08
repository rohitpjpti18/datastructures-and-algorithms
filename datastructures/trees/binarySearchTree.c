#include<stdio.h>

typedef struct Node{
	int data;
	int slope;
	struct Node* left;
	struct Node* right;
	struct Node* parent;
}Node;

void inorder(Node* current_node){
	if(current_node != NULL){
		inorder(current_node->left);
		printf("%d ", current_node->data);
		inorder(current_node->right);
	}
}

void preorder(Node* current_node){
	if(current_node != NULL){
		printf("%d ", current_node->data);
		preorder(current_node->left);
		preorder(current_node->right);
	}
}

void postorder(Node* current_node){
	if(current_node != NULL){
		postorder(current_node->left);
		postorder(current_node->right);
		printf("%d ", current_node->data);
	}
}

Node* find(Node* current_node, int value){
	if (current_node == NULL)
		return NULL;
	else if (current_node->data == value)
		return current_node;
	else if (value < current_node->data)
		return find(current_node->left, value);
	else
		return find(current_node->right, value);
}

Node* maximum(Node* current_node){
	while(current_node->right != NULL){
		current_node = current_node->right;
	}

	return current_node;
}

Node* minimum(Node* current_node){
	while(current_node->left != NULL)
		current_node = current_node->left;

	return current_node;
}

Node* successor(Node* current_node){
	if(current_node->right != NULL)
		return minimum(current_node->right);

	Node* parent_node = current_node->parent;

	while(parent_node != NULL && current_node == parent_node->right){
		current_node = parent_node;
		parent_node = parent_node->parent;
	}

	return parent_node;
}

Node* predeccesor(Node *current_node){
	if(current_node->left != NULL)
		return maximum(current_node->left);

	Node* parent_node = current_node->parent;

	while(parent_node != NULL && current_node == parent_node->left){
		current_node = parent_node;
		parent_node = parent_node->parent;
	}

	return parent_node;
}

Node* insert_node(Node *current_node, int value, Node* new_node){
	if(current_node->data == value)
		return NULL;

	else if(current_node->data > value){
		if(current_node->left == NULL){
			new_node->data = value;
			new_node->left = NULL;
			new_node->right = NULL;
			new_node->parent = current_node;
			current_node->left = new_node;
			return new_node;
		}
		return insert_node(current_node->left, value, new_node);
	}
	else{
		if(current_node->right == NULL){
			new_node->data = value;
			new_node->left = NULL;
			new_node->right = NULL;
			new_node->parent = current_node;
			current_node->right = new_node;
			return new_node;
		}
		return insert_node(current_node->right, value, new_node);
	}
}

void delete_node(Node *current_node){
	if(current_node->left == NULL && current_node->right == NULL){
		if(current_node->parent->left == current_node)
			current_node->parent->left = NULL;
		else
			current_node->parent->right = NULL;
		return;
	}
	else if(current_node->left == NULL || current_node->right == NULL){
		if(current_node->left==NULL){
			current_node->right->parent = current_node->parent;
			if(current_node == current_node->parent->right)
				current_node->parent->right = current_node->right;
			else
				current_node->parent->left = current_node->right;
			return;
		}
		else{
			current_node->left->parent = current_node->parent;
			if(current_node == current_node->parent->right)
				current_node->parent->right = current_node->left;
			else
				current_node->parent->left = current_node->left;
			return;
		}
	}
	else{
		Node* pred = predeccesor(current_node);
		current_node->data = pred->data;
		delete_node(pred);
		return;
	}
}

int main(){
	Node one, two, three, four, five, six, seven, eight, nine, ten;

	one.data = 1;
	two.data = 2;
	three.data = 3;
	four.data = 4;
	five.data = 5;
	six.data = 6;
	seven.data = 7;
	eight.data = 8;
	nine.data = 9;
	ten.data = 10;

	five.left = &three;
	five.right = &seven;
	five.parent = NULL;
	five.slope = 0;

	three.left = &one;
	three.right = &four;
	three.parent = NULL;
	three.slope = 1;

	one.right = &two;
	one.left = NULL;
	one.parent = &three;
	one.slope = -1;

	two.right = NULL;
	two.left = NULL;
	two.parent = &one;
	two.slope = 0;

	four.left = NULL;
	four.right = NULL;
	four.parent = &three;
	four.slope = 0;

	seven.left = &six;
	seven.right = &ten;
	seven.parent = &five;
	seven.slope = -1;

	six.left = NULL;
	six.right = NULL;
	six.parent = &seven;
	six.slope = 0;

	nine.left = NULL;
	nine.right = NULL;
	nine.parent = &eight;
	nine.slope = 0;

	ten.left = &eight;
	ten.right = NULL;
	ten.parent = &seven;
	ten.slope = 2;

	eight.left = NULL;
	eight.right = &nine;
	eight.parent = &ten;
	eight.slope = 0;


	inorder(&five);
	printf("\n");

	Node* find_node = find(&five, 8);
	if(find_node != NULL) printf("found %d \n", find_node->data);
	else printf("not found\n");

	Node* maximum_node = maximum(&five);
	if(maximum_node != NULL) printf("found maximum %d \n", maximum_node->data);

	Node* minimum_node = minimum(&five);
	if(minimum_node != NULL) printf("found minimum %d \n", minimum_node->data);

	Node* successor_node = successor(&three);
	if(successor_node  != NULL) printf("found successor %d \n", successor_node->data);

	Node* predeccesor_node = predeccesor(&three);
	if(predeccesor_node  != NULL) printf("found predeccesor %d \n", predeccesor_node->data);

	Node new_node;
	insert_node(&five, 0, &new_node);

	inorder(&five);
	printf("\n");

	delete_node(&nine);

	inorder(&five);
	printf("\n");



	return 0;
}
