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
        /**
         * Jumps between nodes based if a text input
         * @return int
         */


        this.currentNode = nodeArray.get(0); //start at the first node

        List<String> history = new ArrayList<>(); //make an empty list to track nodes that the code has jumped to

        history.add(currentNode.getName()); // add the current nodes name to the history list

        // loop true all the characters in the given "jumps" string
        for(char ch: jumps.toCharArray()){

            String c = String.valueOf(ch);  //make "ch" a string for easier use

            if (currentNode.getJumps().containsKey(c)) {    // check if the current node contains the given key
                currentNode = currentNode.getJumps().get(c); // get the next node
                history.add(currentNode.getName()); // add the current nodes name to the history list

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
        /**
         * Jumps between nodes at random
         * @return int
         */


        Random randInt = new Random(); // make a random int

        this.currentNode = nodeArray.get(randInt.nextInt(nodeArray.size())); // get a random node from the ones available

        List<String> history = new ArrayList<>(); //make an empty list to track nodes that the code has jumped to

        history.add(currentNode.getName()); // add the current nodes name to the history list

        Object[] keys = currentNode.getJumps().keySet().toArray(); // get all keys from the first random selcted node


        // loops for the amount of keys in the current node
        for (Object val: keys){
            Object randomkey = keys[randInt.nextInt(keys.length)]; // get a random key from the ones available
            System.out.println(randomkey);

            if (currentNode.getJumps().containsKey(randomkey)) {  // check if the current node contains the given key
                currentNode = currentNode.getJumps().get(randomkey); // get the next node
                history.add(currentNode.getName()); // add the current nodes name to the history list

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
