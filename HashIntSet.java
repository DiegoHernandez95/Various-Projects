// Implements a set of integers using a hash table.
// The hash table uses separate chaining to resolve collisions.
public class HashIntSet {
    private static final double MAX_LOAD_FACTOR = 0.75;
    private HashEntry[] elementData;
    private int size;
    // Constructs an empty set.
    public HashIntSet() {
        elementData = new HashEntry[10];
        size = 0;
    }
    // Adds the given element to this set, if it was not already
    // contained in the set.
    public void add(int value) {
        if (!contains(value)) {
            if (loadFactor() >= MAX_LOAD_FACTOR) {
                rehash();
            }
            
            // insert new value at front of list
            int bucket = hashFunction(value);
            elementData[bucket] = new HashEntry(value, elementData[bucket]);
            size++;
        }
    }
    // Removes all elements from the set.
    public void clear() {
        for (int i = 0; i < elementData.length; i++) {
            elementData[i] = null;
        }
        size = 0;
    }
    // Returns true if the given value is found in this set.
    public boolean contains(int value) {
        int bucket = hashFunction(value);
        HashEntry current = elementData[bucket];
        while (current != null) {
            if (current.data == value) {
                return true;
            }
            current = current.next;
        }
        return false;
    }
    // Returns true if there are no elements in this queue.
    public boolean isEmpty() {
        return size == 0;
    }
    // Removes the given value if it is contained in the set.
    // If the set does not contain the value, has no effect.
    public void remove(int value) {
        int bucket = hashFunction(value);
        if (elementData[bucket] != null) {
            // check front of list
            if (elementData[bucket].data == value) {
                elementData[bucket] = elementData[bucket].next;
                size--;
            } else {
                // check rest of list
                HashEntry current = elementData[bucket];
                while (current.next != null && current.next.data != value) {
                    current = current.next;
                }
                
                // if the element is found, remove it
                if (current.next != null && current.next.data == value) {
                    current.next = current.next.next;
                    size--;
                }
            }
        }
    }
    // Returns the number of elements in the queue.
    public int size() {
        return size;
    }
    // Returns a string representation of this queue, such as "[10, 20, 30]";
    // The elements are not guaranteed to be listed in sorted order.
    public String toString() {
        String result = "[";
        boolean first = true;
        if (!isEmpty()) {
            for (int i = 0; i < elementData.length; i++) {
                HashEntry current = elementData[i];
                while (current != null) {
                    if (!first) {
                        result += ", ";
                    }
                    result += current.data;
                    first = false;
                    current = current.next;
                }
            }
        }
        return result + "]";
    }
    // Returns the preferred hash bucket index for the given value.
    private int hashFunction(int value) {
        return Math.abs(value) % elementData.length;
    }
    
    private double loadFactor() {
        return (double) size / elementData.length;
    }
    // Resizes the hash table to twice its former size.
    private void rehash() {
        // replace element data array with a larger empty version
        HashEntry[] oldElementData = elementData;
        elementData = new HashEntry[2 * oldElementData.length];
        size = 0;

        // re-add all of the old data into the new array
        for (int i = 0; i < oldElementData.length; i++) {
            HashEntry current = oldElementData[i];
            while (current != null) {
                add(current.data);
                current = current.next;
            }
        }
    }
    // Represents a single value in a chain stored in one hash bucket.
    private class HashEntry {
        public int data;
        public HashEntry next;
        public HashEntry(int data) {
            this(data, null);
        }
        public HashEntry(int data, HashEntry next) {
            this.data = data;
            this.next = next;
        }
    }

    public void addAll(HashIntSet set) {
        for(int i = 0; i < set.elementData.length; i++) {
            HashEntry current = set.elementData[i];
            while (current != null) {
                if (!this.contains(current.data)) {
                    this.add(current.data);
                }
                current = current.next;
            }           
        }
    } // end addAll
    
    public boolean containsAll(HashIntSet set) {
        for (int bucket = 0; bucket < set.elementData.length; bucket++) {
            HashEntry current = set.elementData[bucket];
            while(current != null) {
                if(this.contains(current.data)==false) {
                    return false;
                }
                current = current.next;
            }
        }
        return true;
    } // end containsAll
    
    public void retainAll(HashIntSet set) {
        for (int i = 0; i < elementData.length; i++) {
             HashEntry prev = null;
             HashEntry current = elementData[i];
             
             while(current != null) {
                 if(!set.contains(current.data)) {
                     if (prev == null) 
                         elementData[i] = current.next;
                     else { 
                         prev.next = current.next;
                     }
                     size--;
                     break;
                 } else {
                     prev = current;
                     current = current.next;
                 }
             }
        }
    } // end retainAll
    
    public void removeAll(HashIntSet set) {
        for (int i = 0; i < set.elementData.length; i++) {
            HashEntry current = set.elementData[i];
            while (current != null) {
                remove(current.data);
                current = current.next;
            }
        }
    } // end removeAll
    
    public static void main(String[] args) {
        HashIntSet s0 = new HashIntSet();
        s0.add(1);
        s0.add(2);
        s0.add(3);
        s0.add(4);
        
        HashIntSet s1 = new HashIntSet();
        s1.add(1);
        s1.add(2);
        s1.add(3);
        
        HashIntSet s2 = new HashIntSet();
        s2.add(1);
        s2.add(7);
        s2.add(3);
        s2.add(9);
        
        s1.addAll(s2);
        System.out.println("Here is the addAll method");
        System.out.println(s1 + "\n");
        
        HashIntSet s3 = new HashIntSet();
        s3.add(-2);
        s3.add(3);
        s3.add(5);
        s3.add(6);
        s3.add(8);
        System.out.println("Testing the containsAll method to return false");
        System.out.println(s3.containsAll(s1) + "\n");
        
        HashIntSet s4 = new HashIntSet();
        s4.add(2);
        s4.add(1);
        s4.add(4);
        s4.add(3);
        System.out.println("Testing the containsAll method to return true");
        System.out.println(s4.containsAll(s0) + "\n");
        
        HashIntSet s5 = new HashIntSet();
        s5.add(-2);
        s5.add(3);
        s5.add(5);
        s5.add(6);
        s5.add(8);
        
        HashIntSet s6 = new HashIntSet();
        s6.add(2);
        s6.add(3);
        s6.add(6);
        s6.add(8);
        s6.add(11);
        
        System.out.println("Here is the retainAll method");
        s5.retainAll(s6);
        System.out.println(s5 + "\n");
        
        HashIntSet s7 = new HashIntSet();
        s7.add(-2);
        s7.add(3);
        s7.add(5);
        s7.add(6);
        s7.add(8);
        
        HashIntSet s8 = new HashIntSet();
        s8.add(2);
        s8.add(3);
        s8.add(6);
        s8.add(8);
        s8.add(11);
        
        System.out.println("Here is the removeAll method");
        s7.removeAll(s8);
        System.out.println(s7);
    } // end main
}
