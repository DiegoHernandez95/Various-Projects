
/**
 * Write a description of class stackqueue here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.*;
public class stackqueue
{
    public static void splitStack(Stack<Integer> stack)
    {
        Queue<Integer> queue = new LinkedList<Integer>();
        int Negative = 0;
        
        while(!stack.isEmpty())
        {
            if(stack.peek() < 0){
                Negative++;
            }
            queue.add(stack.pop());
        }
        
        while(Negative > 0)
        {
            if(queue.peek() < 0)
            {
                stack.push(queue.remove());
                Negative--;
            } else{
                queue.add(queue.remove());
            }
        }
        
        while(!queue.isEmpty()){
            stack.push(queue.remove());
        }
    } // end splitStack
    
    public static void rearrange(Queue<Integer> queue) {
        Stack<Integer> stack = new Stack<Integer>();
        int size = queue.size();
            
        for(int i = 0; i < 2; i++) {
            for(int j = 0; j < size; j++) {
                if(queue.peek() % 2 == 0)
                    queue.add(queue.remove());
                    else
                    stack.push(queue.remove());
        }
        
        while(!stack.isEmpty())
            queue.add(stack.pop());
        }
    } // end rearrange
    
    public static void removeAll(Stack<Integer> stack)
    {
       int n = stack.size();
       
       if (stack.empty()) {
           return;
        } else {
           stack.clear(); 
        } // end if else
    } // end removeAll
    
    public static void main(String[] args)
    {
        Stack<Integer> stack = new Stack<Integer>();
        stack.add(3);
        stack.add(-10);
        stack.add(4);
        stack.add(-5);
        stack.add(8);
        stack.add(-7);
        
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(3);
        queue.add(5);
        queue.add(4);
        queue.add(17);
        queue.add(6);
        queue.add(83);
        queue.add(1);
        queue.add(84);
        queue.add(16);
        queue.add(37);
        
        splitStack(stack);
        System.out.println(stack);
        rearrange(queue);
        System.out.println(queue);
        removeAll(stack);
        System.out.println(stack);
        
    } // end main
}
