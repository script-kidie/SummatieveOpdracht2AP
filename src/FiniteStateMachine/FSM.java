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

    public Object run(String key, List<String> history){
        /**
         * Jumps from one note to another with the given key
         * @returns object
         */

        if (currentNode.getJumps().containsKey(key)) {    // check if the current node contains the given key
            currentNode = currentNode.getJumps().get(key); // get the next node
            history.add(currentNode.getName()); // add the current nodes name to the history list

        } else {
            System.out.println("//-- Error melding --//");
            System.out.println("Node:"+history.get(history.size() - 1)+"\nHeeft geen overgang: "+key);
            System.out.println("Node overgang historiek"+history + " op index: "+ (history.size() - 1)+" is de Error");
        }
        return currentNode;
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

            if (currentNode.getJumps().containsKey(c)){ //check if the current node contains the current key
                currentNode = (Node) run(c, history); // get the new current node
                continue;
            } else {
                run(c,history); // give an error message
                return 1;
            }

        }
        System.out.println(history);
        System.out.println("FSM sucsesvool uitgevoerd.");
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

        Object[] keys = currentNode.getJumps().keySet().toArray(); // get all keys from the first random selected node

        // loops for the amount of keys in the first current node
        for (Object val: keys){
            Object randkey = keys[randInt.nextInt(keys.length)]; // get a random key from the ones available

            String StringRandomKey = String.valueOf(randkey);  //make "randkey" a string for easier use

            if (currentNode.getJumps().containsKey(StringRandomKey)){ //check if the current node contains the current key
                currentNode = (Node) run(StringRandomKey, history); // get the new current node
                continue;
            } else {
                run(StringRandomKey,history); // give an error message
                return 1;
            }

        }
        System.out.println(history);
        System.out.println("FSM sucsesvool uitgevoerd.");
        return 0;
    }


}
