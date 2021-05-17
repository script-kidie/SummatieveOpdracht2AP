package FiniteStateMachine;

import java.util.HashMap;

public class Node {
    private String name;
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
                ", jumps=" + jumps +
                '}';
    }
}
