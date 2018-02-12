package a2;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class VirtualFriends {

    private Map <String, Node> map = new HashMap<>();

            class Node {
                String name;
                Node parent;
                int noOfFriends;

            }
            /*
                create a set with one user
             */
            public void makeSet(String name){
                if(!map.containsKey(name)) {

                    Node node = new Node();
                    node.name = name;
                    node.parent = node;
                    node.noOfFriends = 1;

                    map.put(name, node);
                }
            }

//            public String findSet(String name){
//                return findSet(map.get(name).name);
//            }

            /*
                Find set representative recursively
             */
            private Node findSet(Node node){
                Node parent = node.parent;
                if(parent == node){
                    return parent;
                }
                node.parent = findSet(node.parent);
                return node.parent;

            }

            /*
                Combines two sets together
                @return true if successful and false if they're in the same set
             */

            public boolean union(String user1, String user2){
                Node nodeA = map.get(user1);
                Node nodeB = map.get(user2);

                Node parentA = findSet(nodeA); //return representative
                Node parentB = findSet(nodeB);

                if(parentA.name.equals(parentB.name)) return false;

                if(parentA.noOfFriends > parentB.noOfFriends){
                    parentA.noOfFriends = (parentA.noOfFriends + parentB.noOfFriends);
                    parentB.parent = parentA;
                } else {
                    parentB.noOfFriends = (parentB.noOfFriends + parentA.noOfFriends);
                    parentA.parent = parentB;
                }

                return true;

            }

            public static void main (String [] args){

                VirtualFriends test = new VirtualFriends();

                Scanner input = new Scanner(System.in);
               //System.out.println("Enter No of Test Cases");

                int testCases = Integer.parseInt(input.nextLine());

               // System.out.println("FriendShips");
                int friendShips = Integer.parseInt(input.nextLine());

                while(testCases>0){


                    while(friendShips > 0){
                        //System.out.println("Make friends");
                        String user1 = input.next();
                        String user2 = input.next();


                        test.makeSet(user1);
                        test.makeSet(user2);
                        if(test.union(user1,user2)){
                            System.out.print(test.findSet(test.map.get(user1)).noOfFriends);
                        } else {
                            System.out.print(test.findSet(test.map.get(user1)).noOfFriends);
                        }



                        //if(input.hasNext()) input.nextLine();

                        friendShips--;
                    }
                    testCases--;
                }




            }





}
