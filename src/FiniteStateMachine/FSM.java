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
                if(c == 'a'){
                    currentNode = currentNode.getA();
                    history.add(currentNode.getName());
                }

                else if(c == 'b'){
                    currentNode = currentNode.getB();
                    history.add(currentNode.getName());
                }


        }
        return history;
    }

}
