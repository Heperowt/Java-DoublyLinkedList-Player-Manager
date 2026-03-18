
package application;

import java.util.ArrayList;

public class Stack{
    private ArrayList<Player> elements;

    //Constructor:
    public Stack(){
        elements = new ArrayList<>();
    }

    public Player pop(){
        if (!elements.isEmpty()) {
            return elements.remove(elements.size() - 1);
        }
        return null;
    }
    
    public void push(Player p){
        elements.add(p);
    }

    public boolean isEmpty(){
        return elements.isEmpty();
    }

    public Player peek(){
        if (!elements.isEmpty()){
            return elements.get(elements.size() - 1);
        }
        return null;
    }
}
