package stacks;
import interfaces.Istack;
import java.util.EmptyStackException;
import java.util.LinkedList;
/**

 A stack implementation using a linked list.

 @param <T> The type of elements stored in the stack.
 */
public class Stack <T> implements Istack<T> {
    //propiedades
    private LinkedList <T> linkedList = new LinkedList();


    public void pushFirst(T item){
        linkedList.push(item);
    }

    @Override
    public void push(T item) {
         linkedList.add(item);
    }
    /**

     Removes and returns the element at the top of the stack.
     @return The element at the top of the stack.
     @throws EmptyStackException If the stack is empty.
     */
    @Override
    public T pop() throws EmptyStackException {
        return linkedList.pop();
    }
    /**

     Returns the element at the top of the stack without removing it.
     @return The element at the top of the stack.
     @throws EmptyStackException If the stack is empty.
     */
    @Override
    public T peek() throws EmptyStackException {
        return linkedList.getFirst();
    }
    /**

     Determines whether the stack is empty.
     @return {@code true} if the stack is empty, {@code false} otherwise.
     */
    @Override
    public boolean empty() {
        return linkedList.isEmpty();
    }
    /**

     Returns the number of elements in the stack.
     @return The number of elements in the stack.
     */
    @Override
    public int size() {
        return linkedList.size();
    }
    /**

     Returns the element at the specified position in the stack.
     @param position The position of the element to be returned.
     @return The element at the specified position in the stack.
     */
    public T getvalue(int position){
        return linkedList.get(position);
    }

}