#include <iostream>
#include <malloc.h>
#include <stack>
#include <queue>

using namespace std;

typedef struct node {
	int data;
	struct node* left;
	struct node* right;
}node;

//Functions to handle tree operations
struct node* insertToBST(struct node*,int);
void printInorder(struct node*);
void printreverseInorder(node *, int &);
void printLevelOrder(node *);
node* makeNode(int);
//Add you new functions

int main(int argc, char const *argv[]){
	int arr[]= {5,3,1,4,2,7,6,8,9};
	struct node *root= NULL;
	for (int i = 0; i < sizeof(arr)/sizeof(arr[0]); ++i){
		root=insertToBST(root,arr[i]);
	}
	cout << "inorder print: smallest -> largest" << endl;
	printInorder(root);
	cout << "reverse inorder : largest -> smallest" << endl;
	int i=0;
	printreverseInorder(root,i);
	return 0;
}

void printreverseInorder(node * root, int &count){
	if (!root)
		return;
	printreverseInorder(root->right, count);

	count++;
	cout << count << " : "  << root->data << endl;

	printreverseInorder(root->left , count);
}

node *makeNode(int data){
	node *temp = new node ();
	temp->data = data;
	temp->left = NULL;
	temp->right = NULL;
	return temp;
}

struct node * insertToBST(struct node* root, int data){
	
	if (root == NULL){
		return makeNode(data);
	}
	if( data > root->data)
		root->right = insertToBST(root->right,data);
	else
		root->left = insertToBST(root->left,data);
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
	if (!root)
		return;
	printInorder(root->left);
	cout << root->data << " " ;
	printInorder(root->right);
}