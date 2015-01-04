#include <iostream>

using namespace std;

typedef struct node {
	struct node *next;
	int data;
}node;

bool checkPallindrom(node* &root, node *tail){
	if (tail == NULL )
		return true;

	//Go till the end of the link list
	bool ret = checkPallindrom(root,tail->next);
	
	//While returning from the recursive call increment the root
	int data = root->data;
	root = root->next;

	return ret && ( data == tail->data);

}

node * makenode(int data){
	node *temp = new node;
	temp->data = data;
	temp->next = NULL;
}

int main(int argc, char const *argv[])
{
	node *n1 = makenode(10);
	node *n2 = makenode(20);
	node *n3 = makenode(20);
	n1->next = n2;
	n2->next = n3;
	n3->next = NULL;
	node *temp= n1;

	if ( checkPallindrom(temp, n1) )
		cout << "yes it is pallindrom" << endl;
	else
		cout << "its not pallindrom" << endl;
	return 0;
}