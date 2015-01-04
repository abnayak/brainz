#include <iostream>
#include <queue>

using namespace std;

typedef struct node {
	int data;
	struct node *left;
	struct node *right;
}node;

node * makeNode(int data){
	node * temp = new node();
	temp->data = data;
	temp->right = NULL;
	temp->left = NULL;
	return temp;
}

node * insert (node * root, int data){
	if ( root == NULL )
		return makeNode(data);

	if ( data <= root->data)
		root->left = insert(root->left,data);
	else
		root->right = insert(root->right,data);

	return root;
}

void arraytoBST(int arr[], int left , int right, node* &root){
	if ( left > right )
		return;
	
	int mid = (left + right)/2;

	root = insert(root, arr[mid] );

	arraytoBST(arr,left,mid-1, root);
	arraytoBST(arr,mid+1,right, root);

}

void printLevelOrder(node *root){
	queue<node *> q;

	if (!root)
		return ;

	node *temp;

	q.push(root);
	q.push(NULL);

	while (!q.empty()){
		temp = q.front();
		q.pop();
		while(1){

			if (temp==NULL){
				if (!q.empty())
					q.push(NULL);
				break;
			}

			cout << temp->data << " ";
			if (temp->left)
				q.push(temp->left);
			if (temp->right)
				q.push(temp->right);
			
			temp = q.front();
			q.pop();

		}
		cout << endl;
	}
}

int main(int argc, char const *argv[])
{
	node *root=NULL;

	int arr[]={1,2,3,4,5,6,7};

	arraytoBST(arr,0,6,root);
	printLevelOrder(root);

	//cout << root->data << endl;
	return 0;
}