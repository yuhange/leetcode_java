import java.util.Stack;
import java.io.*;

public class No1_getMin_Stack {
    private Stack<Integer> stackData = new Stack<Integer>();
    private Stack<Integer> stackMin = new Stack<Integer>();

    public void push(int num) {
        stackData.push(num);
        if(stackMin.empty() || (!stackMin.empty() && stackMin.peek() >= num)) stackMin.push(num);
    }

    public int pop() {
        if(this.stackData.empty()) throw new RuntimeException("empty stack exception!");
        int top = stackData.pop();
        if(this.getMin() == top) stackMin.pop();
        return top;
    }

    public int getMin() {
        if(stackMin.empty()) throw new RuntimeException("min stack is empty!");
        return stackMin.peek();
    }

    public static void main(String args[]) {
//        No1_getMin_Stack minStack = new No1_getMin_Stack();
//        minStack.push(1);
//        minStack.pop();
//        minStack.getMin();
        String s1 = "1234";
        String s2 = "1234";
        String s3 = "12" + "34";
        String s4 = "12";
        s4 += "34";
        System.out.println(s1.equals(s2));
        System.out.println(s2.hashCode());
        System.out.println(s3.hashCode());
        System.out.println(s4.hashCode());
        System.out.println(s4==s3);

    }
}
