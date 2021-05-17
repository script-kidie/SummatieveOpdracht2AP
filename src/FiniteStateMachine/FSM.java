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

        this.currentNode = nodeArray.get(0);
        List<String> history = new ArrayList<>();
        history.add(currentNode.getName());

        for(char ch: jumps.toCharArray()){

            String c = String.valueOf(ch);

            if (currentNode.getJumps().containsKey(c)){
                currentNode = currentNode.getJumps().get(c);
                history.add(currentNode.getName());
            } else {
                System.out.println("//-- Error melding --//");
                System.out.println("Node:"+history.get(history.size() - 1)+"\nHeeft geen overgang:"+c);
                System.out.println("Node overgang historiek"+history + " op index: "+ (history.size() - 1)+" heeft te fout zich plaatgevonden");
                break;
            }

        }
        return history;
    }

}
