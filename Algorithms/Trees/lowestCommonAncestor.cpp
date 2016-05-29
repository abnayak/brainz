#include <iostream>
#include <cstdlib>
#include <stack>
#include <queue>
#include <algorithm>

using namespace std;

typedef struct node {
	int data;
	struct node* left;
	struct node* right;
}node;

struct node* insertToBST(node*,int);
void printInorder(node * );
void printPreorder(node *);

//This will find the LCM in a bst
node * lcmBST(node * , int , int);

//This will find the LCM any binary tree
node * lcmBinaryTree(node *, int , int);


int main(int argc, char const *argv[]){
	int arr[10]= {5,1,4,2,7,3,8,9,10,6};
	struct node *root= NULL;
	for (int i = 0; i < 10; ++i){
		root=insertToBST(root,arr[i]);
	}

	node *result = lcmBST(root, 6, 8); //result shoiuld be 8
	cout << "Find LCM using BST property: " << result->data << endl;

	result = lcmBinaryTree(root, 6, 8);
	cout << "Find LCM using recursion: " << result->data << endl;


	return 0;
}

node * lcmBST(node * root, int first , int second){
	if (!root)
		return root;

	if ( root->data > first && root->data > second)
		return lcmBST(root->left,first,second);
	if ( root->data < first && root->data < second)
		return lcmBST(root->right,first,second);

	return root;
}

node * lcmBinaryTree(node * root, int first , int second){
	if (!root)
		return NULL;

	if ( root->data == first || root->data == second)
		return root;

	node *right = lcmBinaryTree(root->right, first, second);
	node *left = lcmBinaryTree(root->left, first, second);

	if ( right && left)
		return root;

	return left ? left : right;
}

node * makeNode(int data){
	node *temp = (node*)malloc(sizeof(node));
	temp->data = data;
	temp->left = NULL;
	temp->right = NULL;
	return temp;
}

struct node * insertToBST(struct node* root, int data){
	
	if (root == NULL)
		return root = makeNode(data);
	
	struct node *prev;
	struct node* originalRoot = root;
	while ( root != NULL){
		prev = root;
		if (data > root->data)
			root = root->right;
		else
			root = root->left;
	}

	if (data > prev->data)
		prev->right=makeNode(data);
	else
		prev->left=makeNode(data);
	
	return originalRoot;
}

void printInorder(struct node *root){
	stack<struct node*> stk;

	while (1){

		while (root){
			stk.push(root);
			root = root->left;
		}

		if (stk.empty())
			break;

		root = stk.top();
		stk.pop();

		cout << root->data << " " ;
		root = root->right;
	}
	cout << endl;
}

