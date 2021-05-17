package FiniteStateMachine;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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



    public int runText(){

        this.currentNode = nodeArray.get(0);
        List<String> history = new ArrayList<>();
        history.add(currentNode.getName());

        for(char ch: jumps.toCharArray()){

            String c = String.valueOf(ch);

            if (currentNode.getJumps().containsKey(c)) {
                currentNode = currentNode.getJumps().get(c);
                history.add(currentNode.getName());

            } else {
                System.out.println("//-- Error melding --//");
                System.out.println("Node:"+history.get(history.size() - 1)+"\nHeeft geen overgang: "+c);
                System.out.println("Node overgang historiek"+history + " op index: "+ (history.size() - 1)+" is de Error");
                return 1;
            }

        }

        return 0;
    }

    public int runChance(){


        Random randInt = new Random();


        this.currentNode = nodeArray.get(randInt.nextInt(nodeArray.size()));

        List<String> history = new ArrayList<>();

        history.add(currentNode.getName());

        Object[] keys = currentNode.getJumps().keySet().toArray();

        for (Object val: keys){
            Object randomkey = keys[randInt.nextInt(keys.length)];
            System.out.println(randomkey);

            if (currentNode.getJumps().containsKey(randomkey)) {
                currentNode = currentNode.getJumps().get(randomkey);
                history.add(currentNode.getName());

            } else {
                System.out.println("//-- Error melding --//");
                System.out.println("Node:"+history.get(history.size() - 1)+"\nHeeft geen overgang: "+randomkey);
                System.out.println("Node overgang historiek"+history + " op index: "+ (history.size() - 1)+" is de Error");
                return 1;
            }

        }

        return 0;
    }


}
