package FiniteStateMachine;

import junit.framework.TestCase;

import java.util.HashMap;

public class NodeTest extends TestCase {

    public void testMissingJump() {
        /*
         * tests if the code returns null if jumping to a node is not possible
         */
        Node S1 = new Node("S1");
        Node S2 = new Node("S2");
        Node S3 = new Node("S3");

        HashMap <String, Node> hm1 = new HashMap<>();

        hm1.put("a", S1);
        hm1.put("b", S2);
        hm1.put("d", S3);

        S1.setJumps(hm1);

        assertNull(S1.jump("c"));
        assertNull(S1.jump("e"));

    }

    public void testValidJumps(){
        Node S1 = new Node("S1");
        Node S2 = new Node("S2");
        Node S3 = new Node("S3");

        HashMap <String, Node> hm1 = new HashMap<>();

        hm1.put("a", S1);
        hm1.put("b", S2);
        hm1.put("d", S3);

        S1.setJumps(hm1);

        assertEquals(S1, S1.jump("a"));
        assertEquals(S2, S1.jump("b"));
        assertEquals(S3, S1.jump("d"));

    }
}