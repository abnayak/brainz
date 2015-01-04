#include <iostream>
#include <malloc.h>
#include <stack>
#include <queue>
#include <cmath>

using namespace std;

typedef struct node {
	int data;
	struct node* left;
	struct node* right;
}node;

node *makeNode(int data){
	node *temp = new node ();
	temp->data = data;
	temp->left = NULL;
	temp->right = NULL;
	return temp;
}

struct node* insertToBST(struct node*,int);

void printInorder(struct node*);
void printLevelOrder(node *);
int checkBST(node *, bool &flag);

int main(int argc, char const *argv[]){
	int arr[7]= {5,4,2,7,6,8,10};
	struct node *root= NULL;
	for (int i = 0; i < 7; ++i){
		root=insertToBST(root,arr[i]);
	}
	printLevelOrder(root);
	cout << "-------------" << endl;
	
	bool flag=true;

	checkBST(root,flag);
	if (flag)
		cout << "this is a balanced BST" << endl;
	else
		cout << "this is not a balanced BST" << endl;

	return 0;
}

int checkBST(node *root, bool &flag){
	if ( !root )
		return 0;
	if ( !flag )
		return 0;

	int left = checkBST(root->left, flag);
	int right = checkBST(root->right, flag);

	if ( abs(left-right) > 1 ){
		flag = false;
		return 0;
	}
	return 1 + max ( left , right );
}

struct node * insertToBST(struct node* root, int data){
	
	if (root == NULL){
		return makeNode(data);
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
		prev->right = makeNode(data);
	}else{
		prev->left = makeNode(data);
	}
	return originalRoot;
}

void printLevelOrder(node *root){
	if (!root)
		return ;

	queue<node *> q;
	q.push(root);
	q.push(NULL);
	node * temp;

	while(!q.empty()){
		temp = q.front();
		q.pop();
		while(1){
			if (temp == NULL){
				if (!q.empty())
					q.push(NULL);
				break;
			}
			cout << temp->data << " ";
			if(temp->left)
				q.push(temp->left);
			if(temp->right)
				q.push(temp->right);

			temp = q.front();
			q.pop();
		}
		cout << endl;
	}
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