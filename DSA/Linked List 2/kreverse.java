// Given a singly linked list of integers, reverse the nodes of the linked list 'k' at a time and return its modified list.
//  'k' is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of 'k,' then left-out nodes, in the end, should be reversed as well.
// Example :
// Given this linked list: 1 -> 2 -> 3 -> 4 -> 5

// For k = 2, you should return: 2 -> 1 -> 4 -> 3 -> 5

// For k = 3, you should return: 3 -> 2 -> 1 -> 5 -> 4
//  Note :
// No need to print the list, it has already been taken care. Only return the new head to the list.
//  Input format :
// The first line contains an Integer 't' which denotes the number of test cases or queries to be run. Then the test cases follow.

// The first line of each test case or query contains the elements of the singly linked list separated by a single space.

// The second line of input contains a single integer depicting the value of 'k'.
//  Remember/Consider :
// While specifying the list elements for input, -1 indicates the end of the singly linked list and hence, would never be a list element
// Output format :
// For each test case/query, print the elements of the updated singly linked list.

// Output for every test case will be printed in a separate line.
// Constraints :
// 1 <= t <= 10^2
// 0 <= M <= 10^5
// Where M is the size of the singly linked list.
// 0 <= k <= M

// Time Limit:  1sec
// Sample Input 1 :
// 1
// 1 2 3 4 5 6 7 8 9 10 -1
// 4
// Sample Output 1 :
// 4 3 2 1 8 7 6 5 10 9
// Sample Input 2 :
// 2
// 1 2 3 4 5 -1
// 0
// 10 20 30 40 -1
// 4
// Sample Output 2 :
// 1 2 3 4 5 
// 40 30 20 10 

/*

    Following is the Node class already written for the Linked List

    class LinkedListNode<T> {
        T data;
        LinkedListNode<T> next;
    
        public LinkedListNode(T data) {
            this.data = data;
        }
    }

*/

public class Solution {

	public static LinkedListNode<Integer> reverseLinkedListRec(LinkedListNode<Integer> head) {
		//Your code goes here
        
        if (head==null || head.next==null)
        {
            return head;
        }
        LinkedListNode<Integer> smallerHead=reverseLinkedListRec(head.next);
        LinkedListNode<Integer> node=smallerHead;
        while (node.next!=null)
        {
            node=node.next;
        }
        node.next=head;
        head.next=null;
        return smallerHead;
	}
    
    public static LinkedListNode<Integer> findTail(LinkedListNode<Integer> head, int k)
    {
            for (int i=0;i<k && head.next!=null;i++)
            {
                head=head.next;
            }
            return head;
        
        
    }
    
    public static int findLength(LinkedListNode<Integer> head)
    {
        int count=0;
        while(head.next!=null)
        {
            head=head.next;
            count=count+1;
        }
        return count;
    }
    
    public static LinkedListNode<Integer> kReverse(LinkedListNode<Integer> head, int k) {
		//Your code goes here
        if (head==null || k==0 || k==1)
        {
            return head;
        }
        else if (k>findLength(head))
        {
            return reverseLinkedListRec(head);
        }
        
        LinkedListNode<Integer> node=head,nextNode=null,tail=null,prevTail=null,newHead=null;
        while(node!=null)
        {
            tail=findTail(node,k-1);
            nextNode=tail.next;
            tail.next=null;
            newHead=reverseLinkedListRec(node);
            //Runner.print(newHead);
            if (node==head)
            {
                tail=head;
                tail.next=nextNode;
                head=newHead;
                
            }
            else
            {
                tail=node;
                tail.next=nextNode;
                prevTail.next=newHead;
                
            }
            node=nextNode;
            prevTail=tail;
            //Runner.print(head);
            
        }
        return head;
        
        
	}

}
