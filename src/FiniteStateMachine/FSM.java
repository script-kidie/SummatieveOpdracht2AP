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

        for(char c: jumps.toCharArray()){
            System.out.println(c);
            if(c == 'a'){
               System.out.println(nodeArray.get(0));
            }
        }
        return history;
    }

}
