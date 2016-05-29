#include <iostream>
#include <climits>
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
void printLevelOrder(node *);
node* makeNode(int);
//Add you new functions

void MaxRootToLeafSum(node *root, int & maxSum, int currentSum){
	if ( !root )
		return;

	if ( root->data + currentSum > maxSum )
		maxSum = root->data + currentSum ;

	currentSum += root->data;

	MaxRootToLeafSum(root->left, maxSum, currentSum);
	MaxRootToLeafSum(root->right, maxSum, currentSum);
}

int main(int argc, char const *argv[]){
	int arr[]= {5,3,1,4,2,7,6,8,9};
	struct node *root= NULL;
	for (int i = 0; i < sizeof(arr)/sizeof(arr[0]); ++i){
		root=insertToBST(root,arr[i]);
	}
	//printLevelOrder(root);
	//printInorder(root);
	int maxSum = INT_MIN;
	MaxRootToLeafSum(root, maxSum , 0 );
	cout << "Maximum sum from root to leaf: " << maxSum << endl;
	return 0;
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