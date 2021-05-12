package FiniteStateMachine;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Node S0 = new Node("S0");
        Node S1 = new Node("S1");
        Node S2 = new Node("S2");
        Node S3 = new Node("S3");

        S0.setA(S2);
        S1.setB(S1);
        S1.setA(S2);
        S2.setB(S1);
        S3.setB(S1);
        S3.setA(S2);

        List<Node> nodeList = new ArrayList<>();

        nodeList.add(S0);
        nodeList.add(S1);
        nodeList.add(S2);
        nodeList.add(S3);

        FSM finalStateMachine = new FSM(nodeList, "aabaa");

        finalStateMachine.run();

    }
}


