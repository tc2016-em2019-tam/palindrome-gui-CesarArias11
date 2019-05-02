package com.cesaraap;

import java.util.ArrayList;

public class Stack<T extends Comparable> {
    ArrayList<T> stack;

    public Stack(){
        stack = new ArrayList<>();
    }

    public T pop() throws Exception{
        if (stack.size() != 0){
            return stack.remove(stack.size()-1);
        } else {
            throw new Exception("No elements found");
        }
    }

    public void push(T x){
        stack.add(x);
    }

    public boolean find(T x){
        boolean found = false;
        for (T t : stack){
            if (t.equals(x)){
                found = true;
            }
        }
        return found;
    }

    @Override
    public String toString() {
        return "Stack{" +
                "stack=" + stack +
                '}';
    }
}
