#include <iostream>
#include <cstdlib>
#include <stack>

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
bool recursivePallindromCheck(node *);

int main(int argc, char const *argv[])
{
	int arr[]={1,2,1};
	node * root = NULL;

	for (int i = 0; i < 3; ++i)
		root = insert ( root , arr[i]);

	//root = reverse(root);
	//cout << "List in reverse order: ";
	//recursiveReverse(&root, NULL, root);

	if ( checkPalindrom(root) )
		cout << "\nlinked list is a pallindrom" << endl;
	else
		cout << "\nlinked list is not a pallindrom" << endl;

	cout << "check pallindrom using recursive method: " ;

	if ( recursivePallindromCheck(root) )
		cout << "\nlinked list is a pallindrom" ;
	else
		cout << "\nlinked list is not a pallindrom" << endl;

	//print ( root);
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


node * reverse( node * root){
	node * prev, *curr, *next;
	curr = root;
	if (!curr->next)
		return curr;

	prev = NULL;
	while (curr){
		next = curr->next;
		curr->next = prev;
		prev = curr;
		curr=next;
	}
	return prev;
}

void recursiveReverse(node **root, node *prev, node *curr){
	if (!curr)
		return;

	*root = curr;
	recursiveReverse(root, curr, curr->next);
	curr->next = prev;

}

bool checkPalindrom(node *root){
	stack<node *> stk;
	node *slow = root;
	node *fast = root;
	node *temp = root;
	int count=0;

	if ( root->next == NULL)
		return true;

	while ( temp ){
		count++;
		temp = temp->next;
	}

	while ( fast->next && fast->next->next ){
		slow = slow->next;
		fast = fast->next->next;
	}

	temp = slow->next;
	while ( temp ){
		stk.push(temp);
		temp = temp->next;
	}

	while (!stk.empty()){
		if ( (stk.top())->data != root->data){
			return false;
		}
		root = root->next;
		stk.pop();
	}
	return true;
}

bool recursivePallindromCheckUtil(node **head, node *tail){
	if ( tail == NULL)
		return true;

	bool ret = recursivePallindromCheckUtil(head, tail->next);

	if ( !ret )
		return false;

	bool ret1 = (*head)->data == tail->data;
	*head = (*head)->next;
	return ret1;
}

bool recursivePallindromCheck(node *head){
	node *dummyHead = head;
	return recursivePallindromCheckUtil (&dummyHead, head);
}












