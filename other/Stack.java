/**
 * I here present a stack implementation.
 * 
 * INFO: 
 * A stack is a LIFO list in which elements can be added or removed from only one end.
 * 
 * In this class an array is used to represent the entire stack and the operations push, pop are 
 * simply the process of adding and removing an element from this array. 
 * 
 * For the stack to be optimally efficient the array used will be dynamic i.e. will not 
 * need to create a whole new array for each element added to the stack.
 */

class Stack{


    DynamicArray stack = new DynamicArray();
    public Stack(int[] e){
        for(int i : e){
            stack.add(i);
        }
    }
    public Stack(){
    }

    /**
     * Retrieves and removes the last element of stack.
     */
    public int pop(){
        int l = stack.getLast();
        stack.deleteLast();
        return l;
    }

    /**
     * Add element to stack
     * @param i element to be added
     */
    public void push(int i){
        stack.add(i);
    }


    public int size(){
        return stack.size;
    }

    private class DynamicArray{

        public int size = 1;
        public int[] array = new int[size];

        /**
         * Add new element to array, if array if full copy contents into 
         * a new array and with the size doubled.
         * @param element
         */
        public void add(int element){
            if(size == array.length){
                // Copy array to new array
                int[] newArr = new int[2*size];
                for(int i = 0; i < size; i++){
                    newArr[i] = array[i];
                }

                array = newArr;
            }
            array[size] = element;
            size++;
        }

        /**
         * Delete the last element simply by ignoring it
         */
        public void deleteLast(){
            size--;
        }

        public void delete(int index){
            for(int i = index; i < array.length-1; i++){
                array[i] = array[i+1];
            }
            size--;
        }

        /**
         * Get an element.
         * @param i
         * @return
         */
        public int get(int i){
            if(i > size){
                throw new ArrayIndexOutOfBoundsException();
            }
            else{
                return array[i];
            }
        }

        public int getLast(){
            return get(size-1);
        }
    }

    public static void main(String[] args){
        Stack a = new Stack();
        int size = a.size()-1;
        for(int i=0; i < size; i++){
            System.out.println(a.pop());
        }

    }

}