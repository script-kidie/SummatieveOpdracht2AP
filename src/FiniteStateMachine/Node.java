package FiniteStateMachine;

public class Node {
    private String naam;
    private String a;
    private String b;

    public Node(String naam, String a, String b) {
        this.naam = naam;
        this.a = a;
        this.b = b;
    }

    public String getNaam() {
        return naam;
    }

    public String getA() {
        return a;
    }

    public String getB() {
        return b;
    }
}
