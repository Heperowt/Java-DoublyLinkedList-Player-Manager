
package application;

import java.util.ArrayList;
import java.io.*;

public class DoublyLinkedList {
    
    
    //---------------------------------------------------------------------------------------------------------------
    private class Node {
        //Instance Variables for Node class:
        Player data;
        Node prev;
        Node next;
        
        //Constructor of Node Class:
        Node(Player data) {
            this.data=data;
            this.prev=null;
            this.next=null;
        }
    }
    //---------------------------------------------------------------------------------------------------------------
    
    
    //Instance Variables:
    private Node head;
    private Node tail;

    
    
    
    
    public void insert(Player player) {
        Node nodeToInsert = new Node(player);
        if(head ==null) { //if its empty
            head = tail = nodeToInsert;
            return;
        }
        Node pointer = head;
        while(pointer != null) {

            if(  player.getName().compareToIgnoreCase(pointer.data.getName()) < 0 || (player.getName().compareToIgnoreCase(pointer.data.getName()) == 0 && player.getSurname().compareToIgnoreCase(pointer.data.getSurname()) < 0)  ) {
                //insert before current
                nodeToInsert.next = pointer;
                nodeToInsert.prev = pointer.prev;
                
                if(pointer.prev != null) pointer.prev.next = nodeToInsert;
                else head = nodeToInsert;
                pointer.prev = nodeToInsert;
                return;
            }
            if(pointer.next == null) break;
            
            
            pointer = pointer.next;//iterate
        }
        // Insert at the end
        pointer.next = nodeToInsert;
        nodeToInsert.prev = pointer;
        tail = nodeToInsert;
    }
    
    
    // Delete method with name and surname:
    public boolean delete(String name , String surname) {
        Node pointer = head;
        while(pointer !=null) {
            if(pointer.data.getName().equalsIgnoreCase(name) && pointer.data.getSurname().equalsIgnoreCase(surname)) { //if we find the matching name-surname:
                
                //delete it with redirecting its links:
                if(pointer.prev != null) pointer.prev.next = pointer.next;
                else head = pointer.next;
                if(pointer.next != null) pointer.next.prev = pointer.prev;
                else tail = pointer.prev;
                return true;
            }
            pointer = pointer.next; //iterate
        }
        return false; //return false if we could not find matching name-surname
    }

    
    // Search player by name and surname
    public Player search(String name , String surname) {
        Node pointer = head;
        while (pointer != null) {
            if ( pointer.data.getName().equalsIgnoreCase(name) && pointer.data.getSurname().equalsIgnoreCase(surname) ) {
                return pointer.data;
            }
            pointer = pointer.next;
        }
        return null;
    }
    
    //---------------------------------------------------------------------------------------------------------------
    public void printFromStart(){
        Node pointer = head;
        while (pointer != null){
            System.out.println(pointer.data);
            pointer = pointer.next; //iterate
        }
    }
    
    
    public void printFromEnd(){
        Node pointer = tail;
        while(pointer != null){
            System.out.println(pointer.data);
            pointer = pointer.prev;
        }
    }
    //---------------------------------------------------------------------------------------------------------------
    
    
    public void writeFile(String filename) {//Write with FileWriter
    try {
        FileWriter fileWriter= new FileWriter(filename);
        Node pointer = head;
        while(pointer!= null) {
            fileWriter.write(pointer.data.toString() + "\n");
            pointer = pointer.next;
            }
        fileWriter.close();
        } 
    catch (Exception e) {
        System.out.println("Error while writing the file");
        }
    }
    
    public void readFromFile(String filename) {//read with BufferedReader
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filename))) {
            
            String line = bufferedReader.readLine();
            while(line != null) {
                String[] arr = line.split(",");
                String name = arr[0];
                String surname = arr[1];
                Date birthDate = parseNumericDate(arr[2]);
                ArrayList<String> clubs = new ArrayList<>();
                
                for (int i = 3 ; i < arr.length ; i++) {
                    clubs.add(arr[i]);
                }
                
                Player p = new Player(name, surname, birthDate, clubs);
                insert(p);
                line = bufferedReader.readLine();
            }
        } catch (Exception e) {
            System.out.println("Error while reading the file");
        }
    }
    
    //---------------------------------------------------------------------------------------------------------------
    public static Date parseNumericDate(String s) {//change numeric to Date
        String[] arr = s.split("/");
        
        //changing to int:
        int day = Integer.parseInt(arr[0]);
        int month = Integer.parseInt(arr[1]);
        int year = Integer.parseInt(arr[2]);
        //returning Date type data:
        return new Date(month , day , year);
    }
    
    public void copyToStack(Stack stack) {
        Node current = head;
        while (current !=null) {
            stack.push(current.data);
            current = current.next;
        }
    }
    
}