//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {


        System.out.println("Stack testing ");
        Stack stack = new Stack();


        for (int i = 1; i <= 10; i++) {
            stack.push("String " + i);
        }

        stack.dump();
        System.out.println("count :  " + stack.length());

        for (int i = 1; i <= 15; i++) {
            System.out.println("Stack pop " + i + ": " + stack.pop());
        }
        System.out.println("count :  " + stack.length());

        for (int i = 1; i <= 10; i++) {
            stack.push("String " + i);
        }

        stack.dump();
        System.out.println("count :  " + stack.length());

        for (int i = 1; i <= 15; i++) {
            System.out.println("Stack peek " + i + ": " + stack.peek());
        }

        System.out.println("is empty? " + stack.isEmpty());


        for (int i = 1; i <= 15; i++) {
            stack.pop();
        }

        System.out.println("is empty? " + stack.isEmpty());
        System.out.println("count :  " + stack.length());

    }
}