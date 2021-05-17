package FiniteStateMachine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Node S0 = new Node("S0");
        Node S1 = new Node("S1");
        Node S2 = new Node("S2");
        Node S3 = new Node("S3");

        HashMap<String, Node> Node0 = new HashMap<>();
        Node0.put("a", S0);
        Node0.put("b", S1);
        Node0.put("c", S2);
        Node0.put("d", S3);
        HashMap<String, Node> Node1 = new HashMap<>();
        Node1.put("a", S1);
        Node1.put("b", S2);
        Node1.put("c", S3);
        Node1.put("d", S0);
        HashMap<String, Node> Node2 = new HashMap<>();
        Node2.put("a", S2);
        Node2.put("b", S3);
        Node2.put("c", S0);
        HashMap<String, Node> Node3 = new HashMap<>();
        Node3.put("a", S3);
        Node3.put("c", S0);
        Node3.put("d", S2);



        S0.setJumps(Node0);
        S1.setJumps(Node1);
        S2.setJumps(Node2);
        S3.setJumps(Node3);


        List<Node> nodeList = new ArrayList<>();

        nodeList.add(S0);
        nodeList.add(S1);
        nodeList.add(S2);
        nodeList.add(S3);

        FSM finalStateMachine = new FSM(nodeList, "abcdbacd");

        finalStateMachine.runChance();

        finalStateMachine.runText();
        }
    }



