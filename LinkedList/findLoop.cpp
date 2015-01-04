#include <iostream>
#include <cstdlib>

using namespace std;

typedef struct node {
	int data;
	struct node *next;

}node;

node * makenode(int data){
	node * temp = new node ();
	temp->data = data;
	temp->next = NULL;
	return temp;
}

bool findLoop( node *head){
	node *fast=head;
	node *slow=head;

	if ( !head )
		return false;

	while ( fast->next != NULL){
		fast = fast->next;
	
		if ( slow == fast)
			return true;

		if ( fast->next != NULL)
			fast = fast->next;

		if ( slow == fast)
			return true;

		slow = slow->next;

	}

	return false;
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