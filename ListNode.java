// ListNode is a class for storing a single node of a linked
// list.  This node class is for a list of integer values.
// Write methods called min and max that return the smallest and largest values in the linked list. These methods will be added to your ListNode class. 
// For example if a variable called list stores {11, -7, 3, 42, 0, 14], the call of list.min() should return -7 and the call of list.max() should return 42. 
// If the list is empty, return -1. Print the returned value. 
// Write a method called insertNode that inserts a new node anywhere in your linked list. Display your linked list with new value.  
//
//
import java.util.*;


public class ListNode {
    public int data;//data stored in this node
    public ListNode front;//points to head node
    public ListNode next;  // link to next node in the list

    // post: constructs a node with data 0 and null link
    public ListNode() {
        this(0, null);
    }

    // post: constructs a node with given data and null link
    public ListNode(int data) {
        this(data, null);
    }

    // post: constructs a node with given data and given link
    public ListNode(int data, ListNode next) {
        this.data = data;
        this.next = next;
    }
        public String toString() {
        if (front == null) {
            return "[]";
        } else {
            String result = "[" + front.data;
            ListNode current = front.next;
            while (current != null) {
                result += ", " + current.data;
                current = current.next;
            }
            result += "]";
            return result;
        }
    }

    // post: appends the given value to the end of the list
    public void add(int value) {
        if (front == null) {
            front = new ListNode(value);
        } else {
            ListNode current = front;
            while (current.next != null) {
                current = current.next;
            }
            current.next = new ListNode(value);
        }
    }
    // post : returns the position of the first occurrence of the given
    //        value (-1 if not found)   
    public void remove(int index) {
        if (index == 0) {
            front = front.next;
        } else {
            ListNode current = nodeAt(index - 1);
            current.next = current.next.next;
        }
    }
    // pre : 0 <= i < size()
    // post: returns a reference to the node at the given index
    public ListNode nodeAt(int index) {
        ListNode current = front;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }
    
    public void min()
    {
        ListNode current = front;
        int mini = 0;
        
        if (front == null)
        {
         System.out.println("The list is empty");
         
        } else {
         mini = front.data;
        } // end if else
        
        while (current != null)
        {
            if(mini > current.data)
            {
                mini = current.data;
            }
            current = current.next;
        }
        
        System.out.println("\nMinimum value is: " + mini);
    } // end min
    
    public void max()
    {
        ListNode current = front;
        int maxi = 0;
        
        if (front == null)
        {
            System.out.println("The List is empty");
            
        } else {
            maxi = front.data;
        } // end else if
        
        while (current != null)
        {
            if(maxi < current.data)
            {
                maxi = current.data;
            } // end if
            current = current.next;
        }
        System.out.println("Maximum value is: " + maxi);
    } // end max
   
    public void display()
    {
        ListNode current = front;
        if (front == null)
        {
            System.out.println("The list is empty");
            return;
        } // end if
        System.out.print("Current List: ");
        while(current != null) 
        {
            System.out.print(current.data + " ");
            current = current.next;
        } // end while
    } // end display
    
    public void InsertNode(int data, int pos)
    {
        ListNode node = new ListNode();
        node.data = data;
        node.next = null;
        
        if(this.front == null) 
        {
            if (pos != 0) {
                return;
            } else {
                this.front = node;
            } // end if-else
        }
        
        if (front != null && pos == 0)
        {
            node.next = this.front;
            this.front = node;
            return;
        }
        
        ListNode current = this.front;
        ListNode prev = null;
        
        int i = 0;
       
        while (i < pos)
        {
            prev = current;
            current = current.next;
            
            if (current == null) {
                break;
            }
            i++;
        } // end while
        
        
        node.next = current; 
        prev.next = node;
    } // end InsertNode
    
    public static void main(String[] args)
    {
        ListNode List = new ListNode();
        
        ListNode front = null;
        
       
        List.add(11);
        List.add(-7);
        List.add(3);
        List.add(42);
        List.add(0);
        List.add(14);
        
        List.display();
        
        
        System.out.println("\nPlease add a new node and position to the Linked List: ");
        System.out.println("(Node first, position second.)");
        Scanner sc = new Scanner(System.in);
        List.InsertNode(sc.nextInt(), sc.nextInt());
        List.display();
        List.min();
        List.max();
       
                    
    } // end main
}
