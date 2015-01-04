#include <iostream>

using namespace std;

typedef struct node {
	int data;
	struct node *next;
	int flag;
}node;

bool findLoop(node *root){
	if (!root)
		return true;
	node *prev = NULL;
	node *curr = root;
	node *next = curr->next;

	while (root->next != NULL){
		root->next = prev;
		prev = root;
		root = next;
		next = next->next;
	}
	curr->next = prev;


	// if ( curr == root)
	// 	return true;
	// else
	// 	return false;


	//find the node which is the begining of the loop
	if ( curr == root){
		while(1){
			if ( root->flag == 1){
				break;
			}
			root->flag=1;
			root=root->next;
		}
		cout << "Node at which loop begins: " << root->data << endl;
		return true;
	}else{
		return false;
	}


}

node * makenode(int data){
	node * temp = new node ();
	temp->data = data;
	temp->next = NULL;
	temp->flag = 0;
	return temp;
}

int main(int argc, char const *argv[])
{
	node *n1,*n2,*n3,*n4,*n5,*n6;
	
	n1 = makenode(10);
	n2 = makenode(20);
	n3 = makenode(30);
	n4 = makenode(40);
	n5 = makenode(50);
	n6 = makenode(60);

	n1->next = n2;
	n2->next = n3;
	n3->next = n4;
	n4->next = n5;
	n5->next = n6;
	n6->next = n3;

	if ( findLoop(n1))
		cout << "Loop present" << endl;
	else
		cout << "Loop not present" << endl;

	return 0;
}