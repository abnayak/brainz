#include <iostream>
#include <cstdlib>
#include <algorithm>
#include <queue>

using namespace std;


typedef struct node {
	int data;
	struct node* left;
	struct node* right;
}node;

struct node * insertToBST(struct node* root, int data);
int heightRecursive(node *root);
int heightIterative(node *root);
void printLevelwise(node *root);
bool compareTwoBSTs(node *, node*);

int main(int argc, char const *argv[]){
	int arr[9]= {5,3,2,4,7,6,9,8,10};
	node *root = NULL;
	node *root1 = NULL;
	for (int i = 0; i < 9; ++i){
		root=insertToBST(root,arr[i]);
		root1=insertToBST(root1,arr[i]);			
	}
	cout << "height of bst recursive: " << heightRecursive(root) << endl;
	cout << "height of bst iterative: " << heightIterative(root) << endl;

	cout << "Print the tree level wise: \n";
	printLevelwise(root);

	//print if both trees are same
	compareTwoBSTs(root,root1)? cout <<"Both are same\n": 
								cout << "Trees are different";

	return 0;
}

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

int heightRecursive(node * root){
	if (!root)
		return 0;

	return 1+ max( heightRecursive(root->right), heightRecursive(root->left));
}

int heightIterative(node * root){
	queue<node *> q;
	if (!root)
		return 0;

	q.push(root);
	q.push(NULL);
	node *temp;
	int count=0;

	while (!q.empty()){
		temp = q.front();
		q.pop();

		if ( temp == NULL){
			count++;
			if(!q.empty()){
				q.push(NULL);
			}
		}else{
			if(temp->left)
				q.push(temp->left);
			if(temp->right)
				q.push(temp->right);
		}
	}

	return count;
}

void printLevelwise(node *root){
	queue<node *> q;

	if (!root)
		return;

	q.push(root);
	q.push(NULL);

	while(!q.empty()){
		node *temp;
		temp = q.front();
		q.pop();

		//if its null
		if (temp == NULL){
			cout << "\n";
			if (!q.empty())
				q.push(NULL);
		}else{
			cout << temp->data << " ";
			if (temp->left)
				q.push(temp->left);
			if (temp->right)
				q.push(temp->right);
		}

	}
}

bool compareTwoBSTs(node *root, node *root1){
	if (root == NULL && root1 == NULL)	
		return true;
	else if ( root == NULL || root1 == NULL)
		return false;

	return ( root->data == root1->data && compareTwoBSTs(root->left,root1->left) && compareTwoBSTs(root->right,root->right));

}