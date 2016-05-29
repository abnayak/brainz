#include <iostream>
#include <malloc.h>

using namespace std;

typedef struct node {
	int data;
	struct node * next;

} node;

node * insert ( node *head, int data);
void print(node * head);
node * kthElementSwap(node*, int);

int main(int argc, char const *argv[])
{
	node *head = NULL;

	int arr[]= {1,2,3,4};

	for (int i = 0; i < sizeof(arr)/sizeof(arr[0]) ; ++i){
		head = insert(head, arr[i]);
	}

	cout << "list before swap"	<< endl;
	print(head);

	cout << "after 3rd swap" << endl;

	head=kthElementSwap(head,2);

	print(head);

	return 0;
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


node * kthElementSwap(node * head, int k){

	node *p1, *p2;
	node* temp, *tempnext ;
	node *prevp1,*prevtemp, *nextP1;
	p1=p2=head;

	for (int i = 0; i < k-1; ++i)
	{
		if ( p2->next != NULL){
			prevtemp = p2;
			p2=p2->next;
		}
	}

	temp = p2;
	tempnext = p2->next;

	//cout << "\nPre temp: " << prevtemp->data << " temp: "<< temp->data << "temp next: " << tempnext->data << endl;

	while ( p2->next != NULL){
		prevp1 = p1;
		p1=p1->next;
		p2=p2->next;
	}

	nextP1 = p1->next;


	//cout << "\nPre p1: " << prevp1->data << " p1: " << p1->data << " p1 next: " << nextP1->data << "\n" << endl;
	//cout << endl;

	//swap temp and p1

	prevtemp->next = p1;
	p1->next = tempnext;

	prevp1->next = temp;
	temp->next = nextP1;


	return head;

}






















