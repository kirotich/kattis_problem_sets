package a6;

import java.util.ArrayList;
import java.util.Scanner;

public class Natrij {

    public static void main(String [] args){


        Scanner input = new Scanner(System.in);
        String [] curr = input.nextLine().split(":");
        String [] expl = input.nextLine().split(":");

        int currTime = toSeconds(curr);
        int expTime = toSeconds(expl);


        int totalSec;

        if(currTime > expTime){
            currTime = (24*3600) % currTime;
            totalSec = currTime + expTime;

        } else {
            totalSec = expTime - currTime;
        }

        if(totalSec <= (24*3600)){
            ArrayList<Integer> timeDiff = duration(totalSec);
            String res = String.format("%02d:%02d:%02d", timeDiff.get(0), timeDiff.get(1), timeDiff.get(2));
            res = res.equals("00:00:00") ? "24:00:00" : res;
            System.out.print(res);

        }
        input.close();

    }

    static int toSeconds(String [] arr){
        int hrs = Integer.parseInt(arr[0]);
        int mins = Integer.parseInt(arr[1]);
        int sec = Integer.parseInt(arr[2]);

        return hrs*3600 + mins*60 + sec;
    }

    static ArrayList<Integer> duration(int seconds){
        ArrayList<Integer> duration = new ArrayList<>();

        int sec = seconds % 60;
        int mins = (seconds % 3600) / 60;
        int hrs = (seconds / 3600) % 24;

        duration.add(hrs);
        duration.add(mins);
        duration.add(sec);

        return duration;
    }
}
