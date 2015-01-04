#include <iostream>
#include <malloc.h>
#include <stack>
#include <queue>

using namespace std;

struct node {
	int data;
	struct node* left;
	struct node* right;
};

struct node* insertToBST(struct node*,int);
struct node* removeFromBST(struct node*);

//Recursive solutioins
struct node* insertRecursiveToBST(struct node*,int);
void deleteRecursiveBST(struct node*);
void inorderRecursivePrintBST(struct node*);
void postorderRecursivePrintBST(struct node*);
int RecursiveSizeofBST(struct node*);

//Non Recursive Solutions
void printInorder(struct node*);
void printPostorder(struct node*);
void printPreorder(struct node*);
int sizeOfBST(struct node *);

int main(int argc, char const *argv[]){
	int arr[10]= {5,1,4,2,7,3,8,9,10,6};
	struct node *root= NULL;
	for (int i = 0; i < 10; ++i){
		//root=insertToBST(root,arr[i]);
		root=insertRecursiveToBST(root,arr[i]);
	}

	//inorderRecursivePrintBST(root);
	//postorderPrintBST(root);

	cout << "Output from iterative inorder traversal : ";
	printInorder(root);
	cout << "\nOutput from iterative preorder traversal : ";
	printPreorder(root);

	cout << "\nNo of nodes in tree using iterative method: " << sizeOfBST(root);
	cout << "\nNo of nodes in tree using recursive method: " << RecursiveSizeofBST(root) << endl;

	//Delete the tree
	deleteRecursiveBST(root);
	root=NULL;


	return 0;
}

// ******************************************************
//Iterative Solutions
// ******************************************************

struct node * insertToBST(struct node* root, int data){
	
	if (root == NULL){
		root = (struct node*)malloc(sizeof(struct node));
		root->data =data;
		root->left = NULL;
		root->right = NULL;
		return root;
	}
	struct node *prev;
	struct node* originalRoot = root;
	while ( root != NULL){
		prev = root;
		if (data > root->data)
			root = root->right;
		else
			root = root->left;
	}
	if (data > prev->data){
		prev->right = (struct node*)malloc(sizeof(struct node));
		prev->right->data = data;
		prev->right->right = NULL;
		prev->right->left = NULL;
	}else{
		prev->left = (struct node*)malloc(sizeof(struct node));
		prev->left->data = data;
		prev->left->right = NULL;
		prev->left->left = NULL;
	}
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
}

void printPreorder(struct node * root){
	stack<struct node*> stk;
	while (1){
		
		while (root){
			cout << root->data << " ";
			stk.push(root);
			root=root->left;
		}
		if(stk.empty())
			break;
		root = stk.top();
		stk.pop();
		root=root->right;

	}

}

void printPostorder(struct node *root){
	stack<struct node*> stk;
	while(1){
		while (root){
			stk.push(root);
			root=root->left;
		}
		if (stk.empty())
			break;
		stk.push(root->right);
		cout << root->data << " ";
	}

}

int sizeOfBST(struct node * root){
	queue<struct node*> que;

	if (root)
		que.push(root);

	int count=0;

	while (!que.empty()){
		struct node * temp = que.front();
		count++;
		que.pop();

		if (temp->left)
			que.push(temp->left);
		if (temp->right)
			que.push(temp->right);
	}
	return count;
}

//===========================================
//Recursive Solutions
//===========================================

void inorderRecursivePrintBST(struct node *root){
	if (root == NULL)
		return;

	inorderRecursivePrintBST(root->left);
	cout << root->data << " ";
	inorderRecursivePrintBST(root->right);

}

void postorderRecursivePrintBST(struct node *root){
	if (root == NULL)
		return;

	inorderRecursivePrintBST(root->right);
	
	inorderRecursivePrintBST(root->left);
	cout << root->data << " ";
	
}

void deleteRecursiveBST(struct node *root){
	if ( root == NULL)
		return;

	deleteRecursiveBST(root->left);
	deleteRecursiveBST(root->right);
	free(root);
}

struct node* insertRecursiveToBST(struct node* root, int data){
	if ( root == NULL){
		root = (struct node*)malloc(sizeof(struct node));
		root->data =data;
		root->left = NULL;
		root->right = NULL;
		return root;
	}
	if ( data > root->data )
		root->right=insertRecursiveToBST(root->right,data);
	else
		root->left=insertRecursiveToBST(root->left,data);

	return root;
}

int RecursiveSizeofBST(struct node* root){
	if (!root)
		return 0;
	else
		return ( RecursiveSizeofBST(root->left)+1+RecursiveSizeofBST(root->right));
}