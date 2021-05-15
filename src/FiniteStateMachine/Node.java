package FiniteStateMachine;

public class Node {
    private String name;
    private Node a;
    private Node b;

    public Node(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Node getA() {
        return a;
    }

    public Node getB() {
        return b;
    }

    public void setA(Node a) {
        this.a = a;
    }

    public void setB(Node b) {
        this.b = b;
    }

    @Override
    public String toString() {
        return "Node{" +
                "name='" + name + '\'' +
                '}';
    }
}
