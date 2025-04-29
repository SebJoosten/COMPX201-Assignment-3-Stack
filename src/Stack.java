/**
 * This class holds a stack with various stack functions
 */
public class Stack {











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
            this.data = data;
            this.next = next;
        }

        /**
         * A public method to get the String data in this node
         * @return - The string held in this node
         */
        public String getData(){
            return data;
        }

        /**
         * A public method to get the next node in the list
         * @return - The next node after this one
         */
        public node getNext(){
            return next;
        }

        /**
         * This is to set the next node in the chain
         * @param next - update the next node in this chain
         */
        public void setNext(node next){
            this.next = next;
        }


    }

}
