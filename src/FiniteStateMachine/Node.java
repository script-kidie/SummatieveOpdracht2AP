package FiniteStateMachine;

import java.util.HashMap;

public class Node {
    private final String name;
    private HashMap<String, Node> jumps;

    public Node(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public HashMap<String, Node> getJumps() {
        return jumps;
    }

    public void setJumps(HashMap<String, Node> jumps) {
        this.jumps = jumps;
    }

    @Override
    public String toString() {
        return "Node{" +
                "name='" + name + '\'' +
                '}';
    }
    public Node jump(String keyInput){
        /*
         * tries to jump from one note to another with the given key
         * @returns object
         */

        return getJumps().getOrDefault(keyInput, null); // return the next node or null if the key does not exist
    }
}
