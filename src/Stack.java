/**
 * This class holds a stack with various stack functions
 */
public class Stack {

    private node root;
    boolean debugPrint = true;


    /**
     * Used to push to the top of the stack
     * @param data - The data in the form of a string to add to the top
     */
    public void push(String data){

        if(data == null){
            System.out.println("Nothing to push");
            return;
        }

        node top = new node(data,root);
        root = top;

    }

    /**
     * Pop something off the top of this stack
     * @return - The string in the stack or empty string
     */
    public String pop(){

        // Root null check
        if(root == null) {
            if(debugPrint) System.out.println("ERROR Nothing to pop");
            return "";
        }

        // Make sure we return something
        String data = (root.data == null? "" : root.data);

        // Data return error message
        if(data.isEmpty()) {
            if(debugPrint) System.out.println("ERROR No string to return pop");
        }

        root = root.next;
        return data;

    }

    /**
     * A method to look at the top of the stack without changing the stack
     * @return - The String data at the top of the stack
     */
    public String peek(){

        // Root null check
        if(root == null) {
            if(debugPrint) System.out.println("ERROR Nothing to peek");
            return "";
        }

        // Make sure we return something
        String data = (root.data == null? "" : root.data);

        // Data return error message
        if(data.isEmpty()) {
            if(debugPrint) System.out.println("ERROR No string to return peek");
        }

        return data;

    }

    /**
     * A method to check if the stack is empty
     * @return - True if empty otherwise false
     */
    public boolean isEmpty(){
        return root == null;
    }

    /**
     * A method to count the items in this stack
     * @return - the count of strings stored in this stack
     */
    public int length(){

        // Root null check
        if(root == null) {
            if(debugPrint) System.out.println("ERROR Nothing to count");
            return 0;
        }

        return root.count();

    }


    public void dump(){

        // Null check
        if (root == null) {
            System.out.println("********************** Stack empty **********************");
            return;
        }

        // Call the print to start the chain
        System.out.println("********************** Stack  Dump **********************");
        root.print();
        System.out.println("********************* Stack Dump END ********************");

    }

    /**
     * This is the Node for the linked list class
     * Each node holds the next node in the list
     * Each node also holds a String of data
     */
    private class node{

        // String data and next node
        private String data;
        private node next;

        /**
         * This constructs a node in the linked list of this stack class
         * @param data - The String data held in this node
         * @param next - The Next node in the linked list
         */
        public node(String data, node next){

            // Make sure data is never empty reduce null returns
            this.data = (data == null) ? "" : data;
            this.next = next;

        }

        /**
         * A public method to get the String data in this node
         * @return - The string held in this node
         */
        public String getData(){
            return (data == null) ? "" : data;
        }

        /**
         * A public method to get the next node in the list
         * @return - The next node after this one
         */
        public node getNext(){

            if(next == null){
                if (debugPrint) System.out.println("ERROR no next Node");
            }

            return next;
        }

        /**
         * A method to cound the nodes in this list
         * @return - the number of nodes in this list
         */
        public int count(){
            return countRecursive(0);
        }

        /**
         * The recursive method used by the count method to cound the nodes in this list
         * @param i - The count of nodes so far
         * @return - the total number of nodes in the list
         */
        private int countRecursive(int i){

            if (root.next == null){
              return  i + 1;
            }
            return next.countRecursive(i+1);
        }

        /**
         * This method calls the internal recursive method to print each node in this chain
         */
        public void print(){
            printRecursive(1);
        }

        /**
         * The recursive print method counts down the chain to make a nice print
         * @param i - The current count we are up to
         */
        private void printRecursive(int i){

            if (next == null) return;

            System.out.println(i + ". -> " + data );

            next.printRecursive(i+1);

        }

    }

}
