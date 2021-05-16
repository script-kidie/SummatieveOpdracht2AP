package FiniteStateMachine;


import java.util.ArrayList;
import java.util.List;

public class FSM {
    private List<Node> nodeArray;
    private String jumps;
    private Node currentNode;

    public FSM(List nodeArray, String jumps) {
        this.nodeArray = nodeArray;
        this.jumps = jumps;

    }

    public List getNodeArray() {
        return nodeArray;
    }

    public String getJumps() {
        return jumps;
    }



    public List<String> run(){

        System.out.println(nodeArray);
        this.currentNode = nodeArray.get(0);
        List<String> history = new ArrayList<>();
        history.add(currentNode.getName());

        for(char c: jumps.toCharArray()){
            System.out.println(c);
            System.out.println("current node="+currentNode);
            try {
                if (c == 'a') {
                    currentNode = currentNode.getA();
                    history.add(currentNode.getName());

                } else if (c == 'b') {
                    currentNode = currentNode.getB();
                    history.add(currentNode.getName());

                }

            } catch (Exception e) {
                System.out.println("//-- Error melding --//");
                System.out.println("Node:"+history.get(history.size() - 1)+"\nHeeft geen overgang:"+c);
                System.out.println("Node overgang historiek"+history + " op index: "+ (history.size() - 1)+" heeft te fout zich plaatgevonden");
                break;
            }

        }
        return history;
    }

}
