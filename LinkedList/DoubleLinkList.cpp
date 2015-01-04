#include <iostream>
#include <malloc.h>

using namespace std;

struct node {
	struct node *next;
	struct node *prev;
	int data;
};

node* insert ( node *, int);
node* deleteElem (node *, int);
void print(node * head);
void printReverse(node* head);
node * doubleLLtoTree(node* head);
node *convertToTree(node * head, node* end);
void printBinaryTree(node * head);

int main(int argc, char const *argv[])
{
	int array[] = {1,2,3,4,5,6};
	int len = sizeof(array)/sizeof(array[0]);
	node * head=NULL;

	for (int i = 0; i < len; ++i){
		head = insert(head, array[i]);
	}

	//Delete a element
	//head = deleteElem(head, 6);


	//print(head);
	//cout << endl;
	//printReverse(head);
	head = doubleLLtoTree(head);
	printBinaryTree(head);


	return 0;
}

node * insert(node * head, int data){
	if ( head == NULL){
		head = (struct node *)malloc(sizeof(struct node));
		head->data = data;
		head->next = NULL;
		head->prev = NULL;
		return head;
	}

	node * temp = (struct node*)malloc(sizeof(struct node));

	temp->data = data;
	temp->next = head;
	head->prev = temp;
	temp->prev = NULL;

	return temp;
}

void print(node * head){
	while ( head != NULL){
		cout << head->data << " ";
		head = head->next;
	}
}

void printReverse(node * head){
	while ( head->next != NULL ){
		head = head->next;
	}

	while (head != NULL){
		cout << head->data << " ";
		head=head->prev;
	}
}

node * deleteElem(node* head, int data){
	node* temp = head;
	while ( temp != NULL && temp->data != data)
		temp = temp->next;

	//if the element is not present in the linklist
	if ( temp == NULL)
		return head;

	//If the element is the head of the link list
	if (temp == head){
		head = head->next;
		head->prev = NULL;
		free(temp);
		return head;
	}

	//If the element is the last element
	if ( temp->next == NULL){
		temp->prev->next = NULL;
		free(temp);
		return head;
	}

	//If the element is any element inside the linklist
	temp->prev->next = temp->next;
	temp->next->prev = temp->prev;
	free (temp);

	return head;
}

void printBinaryTree(node * head){
	if (head == NULL)
		return;

	printBinaryTree(head->prev);
	cout << head->data << " ";
	printBinaryTree(head->next);
}

node * doubleLLtoTree(node* head){
	node* end = head;

	while(end->next != NULL)
		end = end->next;


	return convertToTree(head,end);
}

node *convertToTree(node * head, node* end){
	node *slow, *fast;
	slow=head;
	fast=head;

	if(head == end){
		head->prev = NULL;
		head->next = NULL;
		return head;
	}

	while (fast != end && fast->next != end ){
		fast = fast->next->next;
		slow = slow->next;
	}

	if (slow->next != NULL)
		slow->next = convertToTree(slow->next,end);
	if( slow->prev != NULL)
		slow->prev = convertToTree(head,slow->prev);

	return slow;
}