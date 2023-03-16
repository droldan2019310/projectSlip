package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import stacks.StackArray;
import stacks.StackListDouble;
import stacks.StackListSimple;
import stacks.stackArrayList;

public class StackTest {
    

    @Test
    public void arrayListTest(){
        Integer x =5;
        stackArrayList<Integer> stack = new stackArrayList<Integer>();
        stack.push(x);
        assertEquals(x,stack.pop());
    }


    @Test
    public void arrayTest(){
        Integer x =5;
        StackArray<Integer> stack = new StackArray<Integer>();
        stack.push(x);
        assertEquals(x,stack.pop());
    }


    @Test
    public void listDoubleTest(){
        Integer x =5;
        StackListDouble<Integer> stack = new StackListDouble<Integer>();
        stack.push(x);
        assertEquals(x,stack.pop());
    }


    @Test
    public void listSimpleTest(){
        Integer x =5;
        StackListSimple<Integer> stack = new StackListSimple<Integer>();
        stack.push(x);
        assertEquals(x,stack.pop());
    }
}
