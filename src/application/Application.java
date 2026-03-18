
package application;

import java.util.*;

public class Application {

    public static void main(String[] args) {
        DoublyLinkedList playerList = new DoublyLinkedList();
        Scanner scanner = new Scanner(System.in);

        while(true) {
            //Menu:
            System.out.println();
            System.out.println("1) Read from file (players.txt)");
            System.out.println("2) Add Player");
            System.out.println("3) Print Player Info");
            System.out.println("4) Remove Player");
            System.out.println("5) Print all (A-Z)");
            System.out.println("6) Print all (Z-A)");
            System.out.println("7) Copy to Stack and Print");
            System.out.println("8) Write to temp file and Exit");
            System.out.print("Choice: ");

            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } 
            catch (Exception e) {
                System.out.println("Please enter a valid number.");
                continue;
            }

            
            
            
            
            
            
            
            
//------------------------------------------------------------------------------------------------------              
            
            if(choice==1){ //Read file:
                playerList.readFromFile("players.txt");
                System.out.println("Players loaded from players.txt");
//------------------------------------------------------------------------------------------------------                
            }else if(choice==2) { //Add player:
                
                //input of name:
                System.out.print("Player Name: ");
                String name = scanner.nextLine().trim();
                
                //input of surname:
                System.out.print("Player Surname: ");
                String surname = scanner.nextLine().trim();
                
                //input of date:
                System.out.print("Birth date (dd/mm/yyyy): ");
                String dateStr = scanner.nextLine().trim();
                Date birthDate;
                try{
                    birthDate = DoublyLinkedList.parseNumericDate(dateStr);
                } 
                catch(Exception e) {
                    System.out.println("Invalid date format!");
                    continue;
                }
                
                
                //input of clubs:
                System.out.print("Clubs (comma separated): ");
                String clubsStr = scanner.nextLine().trim();
                ArrayList<String> clubs = new ArrayList<>();
                if(!(clubsStr.isEmpty())) {
                    for(String club : clubsStr.split(",")) {
                        clubs.add(club.trim());
                    }
                }
                
                //Construct player object with that information:
                Player p = new Player(name , surname , birthDate , clubs);
                
                //insert it to playerList:
                playerList.insert(p);
                System.out.println("Player added");
                
//-----------------------------------------------------------------------------------------------------------                
                
            }else if(choice==3) { //Print Player Info
                System.out.print("Search Name: "); 
                String strName = scanner.nextLine().trim();
                
                System.out.print("Search Surname: ");
                String strSurname = scanner.nextLine().trim();
                
                Player found = playerList.search(strName , strSurname);
                
                if(found != null) {
                    System.out.println(found.toString());
                }else{
                    System.out.println("Player not found.");
                }
                
//--------------------------------------------------------------------------------------------------------------                
                
            }else if(choice==4) { //Remove Player
                System.out.print("Remove Name: ");
                String dltName = scanner.nextLine().trim();
                
                System.out.print("Remove Surname: ");
                String dltSurname = scanner.nextLine().trim();
                
                boolean deleted = playerList.delete(dltName, dltSurname);
                if(deleted) {
                    System.out.println("Player removed");
                }else{
                    System.out.println("Player not found");
                }
                
//-----------------------------------------------------------------------------------------------------------------
                
                
            }else if(choice==5) { //Print all
                System.out.println("Players (A-Z):");
                playerList.printFromStart();
                
//-----------------------------------------------------------------------------------------------------------------                
                
            }else if(choice==6) {//Print all(Reversed)
                System.out.println("Players (Z-A):");
                playerList.printFromEnd();
                
//-----------------------------------------------------------------------------------------------------------------                
                
            }else if(choice==7) { //Copy to Stack and Print
                Stack stack = new Stack(); //Construct stack
                playerList.copyToStack(stack); //Copy it
                System.out.println("Players in Stack (LIFO):");
                
                //Printing it:
                while (!stack.isEmpty()) {
                    Player stackPlayer = stack.pop();
                    if (stackPlayer != null) {
                        System.out.println(stackPlayer.toString());
                    }
                }
                
//-----------------------------------------------------------------------------------------------------------------                  
                
                
            }else if(choice==8) { //8) Write to temp file and Exit
                String tmpFile = "players_temp.txt";
                playerList.writeFile(tmpFile);
                
                System.out.println("Players written to " + tmpFile + ". Exiting...");
                scanner.close();
                System.exit(0);
                
//-------------------------------------------------------------------------------------------------------------------                 
                
            }else{ //invalid choice:
                System.out.println("Invalid choice. Please select 1-8.");
            }
        }
    }
}
