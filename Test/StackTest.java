
// Test suite
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

// For output capture
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/**
 * This is a test suite for the Stack
 * Some tests will use other features so they are tested in order of when other things will use them
 * push and pop first as they are needed for
 * --> isEmpty()
 * --> peek()
 * --> length()
 */
class StackTest {

    /**
     * Push one string to the stack pop it with associated error messages
     */
    @Test
    @DisplayName("Test to make sure push works with normal string")
    void pushString() {

        Stack stack = new Stack();
        stack.push("Hello");
        assertEquals("Hello", stack.pop(), "Stack push(String) should pop \"Hello\"");

    }

    /**
     * Push null to the stack and check to make sure empty string is returned not null
     */
    @Test
    @DisplayName("Test to make sure push works with null string")
    void pushNull() {

        Stack stack = new Stack();
        stack.push(null);
        assertEquals("", stack.pop(), "Stack push(NULL) should pop \"\"");

    }

    /**
     * Push 5 elements and pop top make sure the top element is the last one pushed
     */
    @Test
    @DisplayName("Test to make sure push works and maintains stack order LIFO")
    void push() {

        Stack stack = new Stack();

        //Push 5 to the stack
        pushTo(stack,6);

        // Pop and check
        assertEquals("Hello 5", stack.pop(), "Stack push(Hello + i) should pop \"Hello 5\"");

    }

    /**
     * This will completely fill the stack to test if it will hit the limit
     * DONT RUN THIS
     * This will take DAYS and use around 64 ~ 66 gig of memory
     * It was more for a fun test
     */
    //@Test
    @DisplayName("int MAX")
    public void max() {
        Stack stack = new Stack();
        pushTo(stack, Integer.MAX_VALUE);
        assertEquals(Integer.MAX_VALUE , stack.length(), "check max length");
    }

    /**
     * Test to see if the stack responds correctly to a pull when its empty
     * I'm not sure what's expected, but im personally not a fan of null returns
     */
    @Test
    @DisplayName("pop empty stack")
    void popEmpty() {
        Stack stack = new Stack();
        assertEquals("", stack.pop(), "Stack pop(empty) should pop \"\"");
    }

    /**
     * Test to make sure when items are popped they are coming out in the right order,
     * It will add 0-99 elements then remove 50 and check we are at 49
     */
    @Test
    @DisplayName("Pop a Lot: push 100 > pop 50 > check for 49")
    void popALot() {

        // Make stack > push 100 > pull 50
        Stack stack = new Stack();
        pushTo(stack,100);
        popFrom(stack, 50);

        // Check the next element is correct
        assertEquals("Hello 49", stack.pop(), "Stack pop(Hello + i) should pop \"Hello 50\"");

    }

    /**
     * peek - Test One peek element to make sure its correct
     * Then pops the top element and checks again to make sure its empty string not null
     */
    @Test
    @DisplayName("Peek check one element: Add > peek > remove > peek")
    void peek1() {

        Stack stack = new Stack();
        stack.push("Test");
        assertEquals("Test", stack.peek(), "Stack peek should be \"Test\"" );
        stack.pop();
        assertEquals("", stack.peek(), "Stack peek should be \"\" Not null we dont like null returns");

    }

    /**
     * Peek - Test One peek element to make sure its correct
     * Then pops the top element and checks again to make sure its empty string not null
     */
    @Test
    @DisplayName("Peek check one element: Add > peek > remove > peek")
    void peek10() {

        // Make stack and push 10
        Stack stack = new Stack();
        pushTo(stack,10);

        // peek a bunch of times and make sure it's still the top element
        for (int i = 0 ; i < 10 ; i++) {
            assertEquals("Hello 9", stack.peek(), "Stack peek should be \"Hello 9\"");
        }

    }

    /**
     * isEmpty > True > Simple lest to make sure is empty bool is the correct way around
     */
    @Test
    @DisplayName("Is empty True")
    void isStackEmpty() {

        Stack stack = new Stack();
        assertTrue(stack.isEmpty(), "Empty stack should be true");

    }

    /**
     * isEmpty > False > Simple test to make sure the boolean is empty is the correct way around
     */
    @Test
    @DisplayName("Is stack empty > False")
    void isStackFull() {

        Stack stack = new Stack();
        stack.push("a");
        assertFalse(stack.isEmpty(), "Filled stack should be false");

    }

    /**
     * Length > This is to test the length counter stays up to dave with changes
     */
    @Test
    @DisplayName("Test length Push 100 > pop 10 > pop 90")
    void length() {

        Stack stack = new Stack();

        // Push 100
        pushTo(stack,100);
        assertEquals(100, stack.length(), "Length of stack should be 100");

        // Pop 10
        popFrom(stack,10);
        assertEquals(90, stack.length(), "Length of stack should be 90");

        // Pop 90
        popFrom(stack,90);
        assertEquals(0, stack.length(), "Length of stack should be 0");
    }

    @Test
    @DisplayName("Just prints out the contents of the current stack")
    void dump() {

        // Make a stack > Push 2 > push Top Of Stack
        Stack stack = new Stack();
        pushTo(stack,2);
        stack.push("Top Of Stack");

        // Change output to Byte array capture and collect print stream
        // Any System.out.print now goes into outContent instead of the console
        // https://docs.oracle.com/javase/8/docs/api/java/io/ByteArrayOutputStream.html
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        // Call the method
        stack.dump();

        // Note to future self """" something """" you can input text "Java Text Blocks"
        // Based on a Manually written out txt doc
        String dumpResult = """
        ********************** Stack  Dump **********************
          1. -> Top Of Stack
          2. -> Hello 1
          3. -> Hello 0
        ********************* Stack Dump END ********************
        """.trim();

        // Set output back to console instead of the capture array
        System.setOut(originalOut);
        // Put output in to capture String for compare and replace line separators
        String output = outContent.toString().replaceAll("\\r\\n?", "\n").trim();

        assertEquals(dumpResult, output, "Dump Output docent match expected \n" + dumpResult ); // Change this to match your actual print format

    }

    /**
     * Push too method used to push standard format strings to the stack for testing
     * Hello 0
     * Hello 1.......
     * @param stack - The stack you want to push to
     * @param i - The number of standard strings to push
     */
    private void pushTo(Stack stack, long i) {

        for(long j = 0; j < i ; j++){
            stack.push("Hello " + j);
        }

    }

    /**
     * Pop From will pop "i" number of items from the stack
     * @param stack - the stack you want to pop from
     * @param i - the number of pops from the stack
     */
    private void popFrom(Stack stack, int i) {

        for(int j = 0; j < i ; j++){
            stack.pop();
        }

    }

}