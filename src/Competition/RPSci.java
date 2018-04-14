package Competition;

import java.util.*;

public class RPSci {

    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);

        int [] players = new int[sc.nextInt()];
        System.out.println("No of Games");
        int noOfGames = sc.nextInt();
        sc.nextLine();




        for(int i=0; i<noOfGames; i++){
            String [] line = sc.nextLine().split(" ");

            String curr = line[i];
            if(line[1].equals("rock") && line[3].equals("paper")){
                players[Integer.parseInt(line[2])-1]++;
            } else if((line[1].equals("rock") && line[3].equals("scissors"))){
                players[Integer.parseInt(line[0])-1]++;
            } else if((line[1].equals("scissors") && line[3].equals("paper"))){
                players[Integer.parseInt(line[0])-1]++;
            }
        }

        //calculate average
        double totalWins = 0;
        for(int j=0; j<players.length; j++){
            totalWins+=players[j];

        }

        for(int k=0; k<players.length; k++){
            double win = players[k]/totalWins;
            win = Math.round(win * 1000) / 1000d;
            String wins = Double.toString((win));
            //String.format("%.52g%n", wins);
            System.out.println(wins);

        }





    }



}
