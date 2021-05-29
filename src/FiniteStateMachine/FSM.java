package FiniteStateMachine;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class FSM {
    private final List<Node> nodeArray;
    private final String jumps;
    private Node currentNode;

    public FSM(List nodeArray, String jumps) {
        this.nodeArray = nodeArray;
        this.jumps = jumps;

    }

    public Node run(String key, List<String> history){
        /*
         * defines the next node
         * @return Node
         */

        currentNode = currentNode.jump(key); // try to get the next node
        System.out.println(key);
        if (currentNode == null){
            System.out.println("//-- Error melding --//");
            System.out.println("Node:"+history.get(history.size() - 1)+"\nHeeft geen overgang: "+key);
            System.out.println("Node overgang historiek"+history + " op index: "+ (history.size() - 1)+" is de Error");
        } else{
            history.add(currentNode.getName());
        }
        return currentNode;
    }

    public void runText(){
        /*
         * Jumps between nodes based of a text input
         * @return int
         */
        this.currentNode = nodeArray.get(0); //start at the first node

        List<String> history = new ArrayList<>(); //make an empty list to track nodes that the code has jumped to

        history.add(currentNode.getName()); // add the current nodes name to the history list

        // loop true all the characters in the given "jumps" string
        for(char ch: jumps.toCharArray()){

            String c = String.valueOf(ch);  //make "ch" a string for easier use

            currentNode = run(c, history);
            if (currentNode == null){
                return;
            }

        }
        System.out.println("Overgang geshiedenis:"+ history);
        System.out.println("FSM sucsesvool uitgevoerd.");
    }

    public void runChance(){
        /*
         * Jumps between nodes at random
         * @return int
         */
        Random randInt = new Random(); // make a random int

        this.currentNode = nodeArray.get(randInt.nextInt(nodeArray.size())); // get a random node from the ones available

        List<String> history = new ArrayList<>(); //make an empty list to track nodes that the code has jumped to

        history.add(currentNode.getName()); // add the current nodes name to the history list

        Object[] keys = currentNode.getJumps().keySet().toArray(); // get all keys from the first random selected node

        // loops for the amount of keys in the first current node
        for (Object ignored : keys){
            Object randkey = keys[randInt.nextInt(keys.length)]; // get a random key from the ones available

            String StringRandomKey = String.valueOf(randkey);  //make "randkey" a string for easier use

            currentNode = run(StringRandomKey, history);
            if (currentNode == null){
                return;
            }
        }
        System.out.println("Overgang geshiedenis:"+ history);
        System.out.println("FSM sucsesvool uitgevoerd.");
    }


}
