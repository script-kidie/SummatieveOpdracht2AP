package FiniteStateMachine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {

    // ---- eigen finite state machine ---- //
    public static void main(String[] args) {

        Node S0 = new Node("S0");
        Node S1 = new Node("S1");
        Node S2 = new Node("S2");
        Node S3 = new Node("S3");
        Node S10 = new Node("S10");

        HashMap<String, Node> Node0 = new HashMap<>();
        Node0.put("a", S0);
        Node0.put("b", S1);
        Node0.put("c", S2);
        Node0.put("d", S3);
        Node0.put("e", S10);
        HashMap<String, Node> Node1 = new HashMap<>();
        Node1.put("a", S1);
        Node1.put("b", S2);
        Node1.put("c", S3);
        Node1.put("d", S0);
        Node1.put("e", S10);
        HashMap<String, Node> Node2 = new HashMap<>();
        Node2.put("a", S2);
        Node2.put("b", S3);
        Node2.put("c", S0);
        Node2.put("e", S10);
        HashMap<String, Node> Node3 = new HashMap<>();
        Node3.put("a", S3);
        Node3.put("c", S0);
        Node3.put("d", S2);
        Node3.put("e", S10);
        HashMap<String, Node> Node10 = new HashMap<>();
        Node10.put("a", S10);
        Node10.put("c", S0);
        Node10.put("d", S2);
        Node10.put("e", S3);
        Node10.put("b", S1);

        S0.setJumps(Node0);
        S1.setJumps(Node1);
        S2.setJumps(Node2);
        S3.setJumps(Node3);
        S10.setJumps(Node10);


        List<Node> nodeList = new ArrayList<>();
        nodeList.add(S0);
        nodeList.add(S1);
        nodeList.add(S2);
        nodeList.add(S3);
        nodeList.add(S10);

        FSM finiteStateMachine = new FSM(nodeList, "eeedecebeaccc");

        finiteStateMachine.runText();

        // ---- Formatieve finite state machine ---- //

        Node fS0 = new Node("S0");
        Node fS1 = new Node("S1");
        Node fS2 = new Node("S2");
        Node fS3 = new Node("S3");

        HashMap<String, Node> fNode0 = new HashMap<>();
        fNode0.put("a", fS2);
        fNode0.put("b", fS1);
        HashMap<String, Node> fNode1 = new HashMap<>();
        fNode1.put("a", fS1);
        fNode1.put("b", fS2);
        HashMap<String, Node> fNode2 = new HashMap<>();
        fNode2.put("b", fS3);
        HashMap<String, Node> fNode3 = new HashMap<>();
        fNode3.put("a", fS3);
        fNode3.put("b", fS0);



        fS0.setJumps(fNode0);
        fS1.setJumps(fNode1);
        fS2.setJumps(fNode2);
        fS3.setJumps(fNode3);

        List<Node> fNodeList = new ArrayList<>();
        fNodeList.add(fS0);
        fNodeList.add(fS1);
        fNodeList.add(fS2);
        fNodeList.add(fS3);

        FSM formatieveFiniteStateMachine = new FSM(fNodeList, "ababaa");

        formatieveFiniteStateMachine.runText();


        }
    }





