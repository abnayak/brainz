#include <iostream>
#include <cstdlib>
#include <stack>
#include <queue>
#include <algorithm>
#include <iterator>

using namespace std;

typedef struct node {
	int data;
	struct node* left;
	struct node* right;
}node;

struct node* insertToBST(node*,int);
void printInorder(node * );
void printPreorder(node *);
void printLevelwise(node *);
node * inorderToBST(int [], int[], int , int);


int main(int argc, char const *argv[]){
	int arr[10]= {5,1,4,2,7,3,8,9,10,6};
	
	int inOrder[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
	int preOrder[] = {5, 1, 4, 2, 3, 7, 6, 8, 9, 10};
	int size = (sizeof(inOrder)/sizeof(inOrder[0]))-1;

	cout << "Inorder array before creating the tree: ";
	copy(inOrder,inOrder+size+1, ostream_iterator<int>(cout, " "));

	node *root1 = inorderToBST(preOrder,inOrder,0,size);

	cout << endl;
	cout << "Inorder array after creating the tree: ";
	printInorder(root1);
	cout << endl;

	return 0;
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

int search ( int array[], int data , int start , int end){
	for (int i = start; i <= end; ++i)
		if (array[i] == data)
			return i;	
}	


node * inorderToBST(int preOrder[], int inOrder[], int inStart, int inEnd){
	static int preIndex = 0;

	if ( inStart > inEnd)
		return NULL;

	int rootdata = preOrder[preIndex++];
	node * root = makeNode(rootdata);
	
	//if ( inStart == inEnd)
	//	return root;

	int index = search(inOrder,rootdata,inStart,inEnd);

	root->left = inorderToBST(preOrder,inOrder,inStart, index-1);
	root->right = inorderToBST(preOrder,inOrder, index+1, inEnd);

	return root;
}
