package stacks;
import interfaces.Istack;
import java.util.EmptyStackException;
import java.util.LinkedList;

public class Stack <T> implements Istack<T> {
    //propiedades
    private LinkedList <T> linkedList = new LinkedList();

    @Override
    public void push(T item) {
         linkedList.push(item);

    }
    @Override
    public T pop() throws EmptyStackException {
        return linkedList.pop();
    }
    @Override
    public T peek() throws EmptyStackException {
        return linkedList.getFirst();
    }
    @Override
    public boolean empty() {
        return linkedList.isEmpty();
    }
    @Override
    public int size() {
        return linkedList.size();
    }

}