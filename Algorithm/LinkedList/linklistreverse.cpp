#include <iostream>
#include <malloc.h>

using namespace std;

typedef struct node {
	int data;
	struct node * next;

} node;

node * insert ( node *head, int data);
void print(node * head);
node * reverse( node * );
void recursiveReverse(node **, node*, node*);
bool checkPalindrom(node *head);

int main(int argc, char const *argv[])
{
	node *head = NULL;

	int arr[]= {1,2,3};

	for (int i = 0; i < sizeof(arr)/sizeof(arr[0]) ; ++i){
		head = insert(head, arr[i]);
	}

	print ( head);
	cout << endl;

	recursiveReverse(&head,head,NULL);

	print(head);

	cout << "\n----------palindrom check-----------" << endl;

	int arr1[]= {1,2,3,4,4,3,2,1};
	node* palinHead=NULL;

	for (int i = 0; i < sizeof(arr1)/sizeof(arr1[0]) ; ++i){
		palinHead = insert(palinHead, arr1[i]);
	}
	print(palinHead);
	if ( checkPalindrom(palinHead) ){
		cout << " is palindrom" << endl;
	}else{
		cout << " is not palindrom" << endl
`
}

//recursive solutioin
void recursiveReverse( node **head, node *n, node * prev){

	if ( n == NULL){
		return;
	}

	*head = n;
	recursiveReverse(head,n->next,n);
	n->next = prev;
}

//Iterative solution
node * reverse ( node * head){

	if ( head == NULL){
		return NULL;
	}

	node *prev = NULL;
	node *curr=head;
	node *nex;

	if ( curr->next == NULL){
		return head;
	}else{

		nex = curr->next;

		do {
			curr->next= prev;
			prev = curr;
			curr=nex;
			nex=curr->next;

		}while(nex != NULL);
		curr->next= prev;
	}
	return curr;

}


void print ( node * head){
	while ( head != NULL){
		cout << head->data << " ";
		head= head->next;
	}
}

node* insert ( node * head , int data){

	node * temp;
	temp = head;

	if (head == NULL ){
		head = (node *)	malloc ( sizeof(node));
		head->data = data;
		head->next = NULL;
		return head;
	}
	else{
		while ( temp->next != NULL ){
			temp= temp->next;
		}
		temp->next = (node *)	malloc ( sizeof(node));
		temp->next->data = data;
		temp->next->next=NULL;
	}

	return head;
}


bool checkPalindrom(node *head){

node *slow;
node *fast;
slow = head;
fast = head;

while ( fast->next != NULL && fast->next->next != NULL){
	slow = slow->next;
	fast = fast->next->next;
}


	slow->next = reverse(slow->next);
	slow= slow->next;

	while (slow!= NULL){
		if( head->data == slow->data){
			head = head->next;
			slow = slow->next;
		}else{
			return false;
		}

	}
	return true;
}