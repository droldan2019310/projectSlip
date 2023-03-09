package stacks;
import interfaces.Istack;
import java.util.EmptyStackException;

public class Stack <T> implements Istack<T> {
    //propiedades
    Stack<T> stack = new Stack<>();
    @Override
    public void push(T item) {stack.push(item);
    }
    @Override
    public T pop() throws EmptyStackException {
        return stack.pop();
    }
    @Override
    public T peek() throws EmptyStackException {
        return stack.peek();
    }
    @Override
    public boolean empty() {
        return stack.empty();
    }
    @Override
    public int size() {
        return stack.size();
    }
}