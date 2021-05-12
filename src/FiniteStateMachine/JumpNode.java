package FiniteStateMachine;

import java.lang.reflect.Array;

public class JumpNode {
    private Array nodeArray;
    private String jumps;

    public JumpNode(Array nodeArray, String jumps) {
        this.nodeArray = nodeArray;
        this.jumps = jumps;
    }

    public Array getNodeArray() {
        return nodeArray;
    }

    public String getJumps() {
        return jumps;
    }

}
