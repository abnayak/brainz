
#include <iostream>
#include <malloc.h>

using namespace std;

typedef struct node {
	int data;
	struct node * next;

} node;

node* insert ( node * head , int data);
node* insertFront(node * node, int data);
void print(node *);
void addLists(node* , node*);
void addListsHelper(node *, node*);

int carry=0;
node* result;


int main(int argc, char const *argv[])
{
	result = NULL;
	node *num1 = NULL;
	int num1array[]={9,4,5,6};

	for (int i = 0; i < sizeof(num1array)/sizeof(num1array[0]); ++i){
		num1 = insert(num1, num1array[i]);
	}

	node* num2 = NULL;
	int num2array[]={9,2,4};
	
	for (int i = 0; i < sizeof(num2array)/sizeof(num2array[0]); ++i){
		num2 = insert(num2, num2array[i]);
	}


	addLists(num1,num2);

	print(result);

	return 0;
}

void addLists(node* list1, node* list2){
	node* temp = list1;
	int list1len=0;
	int list2len=0;
	int lenDiff;

	while(temp!=NULL){
		list1len++;
		temp=temp->next;
	}

	temp=list2;

	while(temp!=NULL){
		list2len++;
		temp=temp->next;
	}

	lenDiff = list1len - list2len;
	if (list1len < list2len){
		temp = list1;
		list1 = list2;
		list2 = temp;
		lenDiff *= -1 ;
	}

	node* list1temp=list1;
	node* list1tempPrev;

	int lenDiffTemp = lenDiff;

	while (lenDiff > 0  ){
		list1tempPrev = list1temp;
		list1temp = list1temp->next;
		lenDiff--;
	}

	addListsHelper(list1temp, list2);

	if ( lenDiffTemp > 0){
		list1tempPrev->next = result;
		result = list1;

	}

}

void addListsHelper(node* first, node* second){

	if ( first == NULL && second == NULL){
		return;
	}

	addListsHelper(first->next, second->next);

	int temp = first->data + second->data + carry;

	if (temp >= 10){
		carry = 1;
		temp %= 10;
		result = insertFront(result,temp);
	}else{
		carry=0;
		result = insertFront(result,temp);
	}

}

node* insertFront(node * head,int data){
	if ( head == NULL){
		head = (struct node* )malloc(sizeof(struct node));
		head->data = data;
		head->next=NULL;
		return head;
	}
	node* temp = (struct node* )malloc(sizeof(struct node));
	temp->data = data;
	temp->next = head;
	return temp;
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
