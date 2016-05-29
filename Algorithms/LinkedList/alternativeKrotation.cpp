#include <iostream>
#include <algorithm>
using namespace std;

typedef struct node {
	int data;
	struct node * next;

} node;

node * insert ( node *head, int data);
void print(node * head);
node * alternativeKrotations(node* begin, int alternative , int k);


int main(int argc, char const *argv[])
{
	node *head = NULL;

	int arr[]= {1,2,3,4,5,6,7,8,9};

	for (int i = 0; i < sizeof(arr)/sizeof(arr[0]) ; ++i){
		head = insert(head, arr[i]);
	}
	cout << "Before rotation: ";
	print(head);

	head = alternativeKrotations(head,0,3);
	cout << "After Rotation: " ;
	print(head);
	cout << endl;

	return 0;
}

node * alternativeKrotations(node* begin, int alternative , int k){
	if ( begin == NULL){
		return NULL;
	}

	node *end;
	node * temp;

	temp = begin;
	end = begin;

	for (int i = 1; i < k && end->next != NULL; ++i){
		end = end->next;
	}

	if ( alternative % 2 == 0 ){
				
		node *endNext = end->next;

		node *prev=begin;
		temp = begin->next;
		node * next=end;

		if ( begin != end){ //this is to handle if we have one element between end and begin
			while (temp != end ){
				next = temp->next;
				temp->next=prev;
				prev = temp;
				temp=next;
			}
			temp->next=prev;
		}

		begin->next = alternativeKrotations(endNext,++alternative, k);
		return end;
	}else{
		end->next = alternativeKrotations(end->next,++alternative,k);
		return begin;
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

void print ( node * head){
	while ( head != NULL){
		cout << head->data << " ";
		head= head->next;
	}
}
