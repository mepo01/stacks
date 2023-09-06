package ak.po;

import ak.po.exceptions.EmptyStackException;
import ak.po.exceptions.FullStackException;
import ak.po.interfaces.StackInterface;
import ak.po.stacks.ArrayStack;
import ak.po.stacks.RubberStack;
import ak.po.stacks.SinkingStack;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        //testStack(new ArrayStack(10));
        //testStack(new RubberStack(5));
        //testStack(new SinkingStack(6));
        rubberstacktest(new RubberStack(16));
        //System.out.println((StringReverse("abcde")));
        //SinkinkStackTest(new SinkingStack(8));
    }

    public static void testStack(StackInterface stack) {
        Random random = new Random();
        int N = 1000;
        double number;
        Integer value = null;
        for (int i = 0; i < N; i++) {
            number = random.nextDouble();
            if (number < 0.6) {
                try {
                    value = random.nextInt(100);
                    System.out.println("Odkładam: " + value);
                    stack.push(value);
                } catch (FullStackException e) {
                    System.out.println(e);
                }
            } else {
                try {
                    System.out.println("Pobieram: " + stack.pop());
                } catch (EmptyStackException e) {
                    System.out.println(e);
                }
            }
            if (number < 0.5) {
                try {
                    System.out.println("Na górze jest: " + stack.peek());
                } catch (EmptyStackException e) {
                    System.out.println(e);
                }
            }
            if (number < 0.1) {
                System.out.println("Wyczyszczono stos");
                stack.clear();
            }

            System.out.println(stack);
        }
    }

    public static String StringReverse(String toreverse) {
        ArrayStack stack = new ArrayStack(toreverse.length());
        stack.push(toreverse);
        String reverse = (String) stack.pop();
        char x;
        for (int i = 0; i < toreverse.length(); i++) {
            x  = reverse.charAt(i);
            stack.push(x);
        }
        toreverse = "";
        while (!stack.empty()){
            toreverse += stack.pop();
        }
        return toreverse;
    }

    public static void rubberstacktest(RubberStack stack) {
        wyswietl(stack.getArray());
        System.out.println("uzupełniam stos do połowy: ");
        for (int i = 0; i < 8; i++) {
            stack.push(i);
        }
        wyswietl(stack.getArray());
        System.out.println("próba wymuszenia powiększenia stosu: ");
        stack.push(8);
        stack.push(9);
        stack.push(10);
        stack.push(11);
        stack.push(12);
        wyswietl(stack.getArray());
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        wyswietl(stack.getArray());
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        wyswietl(stack.getArray());
        System.out.println(stack.getItem(2));
        stack.clear();
        wyswietl(stack.getArray());
        for (int i = 0; i < 8; i++) {
            stack.push(i);
        }
        wyswietl(stack.getArray());
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        wyswietl(stack.getArray());

    }

    public static void SinkinkStackTest(SinkingStack stack) {
        System.out.println(stack.toString());
        for (int i = 0; i < 4; i++) {
            stack.push(i);
        }
        System.out.println(stack.toString());
        for (int i = 4; i < 16; i++) {
            stack.push(i);
            System.out.println(stack.toString());
        }
        System.out.println(stack.toString());
        stack.pop();
        stack.pop();
        stack.pop();
        System.out.println(stack.toString());
        System.out.println(stack.getItem(5));
        stack.clear();
        System.out.println(stack.toString());
        stack.push(1);
        System.out.println(stack.toString());

    }

    public static void wyswietl(Object[] x) {
        System.out.print(x.length + ": ");
        for (int i = 0; i < x.length; i++) {
            System.out.print(x[i] + " ");
        }
        System.out.println();
    }
}
