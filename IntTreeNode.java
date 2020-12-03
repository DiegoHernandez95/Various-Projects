import java.util.*;

public class IntTreeNode
{  
    public int data;//value
    public IntTreeNode left;//left child
    public IntTreeNode right;//right child
    public IntTreeNode(int data)//constructor
    {
     this.data =  data; 
    }
    public void add(int value)//method for adding value
    {
       if(value< data)//is value less than root
       {
          if(left == null)//is left side null
          {
            left =new IntTreeNode(value); //create a new node with value   
          }
          else
          {
            left.add(value);//add node with value (Recursive)
          }
        }
        else{
           if(right == null)
           {
             right = new IntTreeNode(value); 
           }
           else
           {
              right.add(value); //Recursive
           }
        }
    }
        public boolean find(int value)
    {
        if(value == data)//checking root for the value
        {
          return true;//if found return true
        }
        else if(value < data)//if value smaller go left
        {
            if(left == null)
            {
                return false;
            }
            else
            {
                return left.find(value);//(recursive find)
            }
        }
        else
        {
            if(right == null)
            {
                return false;
            }
            else
            {
               return right.find(value);//recursive find
            }
        }
    }
    public void printInOrder()//print in order left - root - right
    {
       if(left != null)//check left child
       {
         left.printInOrder(); //(recursive call) 
       }
       System.out.println(data);
       if(right != null)//check right child
       {
          right.printInOrder(); //recursive call
       }
    } // end printInOrder()
    public int size(IntTreeNode root)//pass node here
    {
        if(root == null)//check if empty
        {
            return 0;//if empty return 0
        }
        else
        {
            return size(root.left) + size(root.right) + 1;//recursively counting to determine size        
        }
    } // end size
    public static IntTreeNode min(IntTreeNode root) {
        if (root.left == null) {
            return root;
        } else {
          return min(root.left);  
        }
    } // end min
    public static IntTreeNode remove(IntTreeNode root, int data)
    {
        if (root == null) {
            return null;
        }
        if (root.data > data) {
            root.left = remove(root.left, data);
        } else if (root.data < data) {
            root.right = remove(root.right, data);
        } else {
            if (root.left != null && root.right != null) {
                IntTreeNode temp = root;
                IntTreeNode minRight = min(temp.right);
                root.data = minRight.data;
                root.right = remove(root.right, minRight.data);
            } // end else if
            else if (root.left != null) {
                root = root.left;
            } else if (root.right != null) {
                root = root.right;
            } else {
                root = null;
            }
        } 
        return root;
    }
    void postOrder(IntTreeNode root) {
        if (root == null)
        return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.println(root.data + " ");
    } // end postOrder
    void preOrder(IntTreeNode root) {
        if (root == null)
        return;
        System.out.println(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    } // end preOrder
    public static int findMax(int a, int b) {
        return (a > b) ? a : b;
    }
    public static boolean findLeaf(IntTreeNode a) {
        if(a.right == null && a.left == null) {
            return true;
        }
        return false;
    }
    public static int getHeight(IntTreeNode a) {
        if(a == null || findLeaf(a)) {
            return 0;
        }
        return (findMax(getHeight(a.left), getHeight(a.right)) + 1);
    } 
    public static void main(String[] args) {
        IntTreeNode root = new IntTreeNode(1);
        root.add(2);
        root.add(3);
        root.add(4);
        root.add(5);
        root.add(6);
        root.add(7);
        root.add(8);
        root.add(9);
        root.add(10);
        
        System.out.println("Binary Tree In Order");
        root.printInOrder();
        
        System.out.println("\nTree after removing node 7");
        root = remove(root, 7);
        root.printInOrder();
        
        System.out.println("\nTree in Post Order:");
        root.postOrder(root);
        
        System.out.println("\nTree in Pre Order:");
        root.preOrder(root);
        
        System.out.println("\nHeight of Tree:");
        System.out.println(getHeight(root));
        
    }
}


