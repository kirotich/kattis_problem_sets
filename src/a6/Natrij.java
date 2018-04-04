package a6;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.ArrayList;
import java.util.Scanner;

public class Natrij {

    public static void main(String [] args){


        Scanner input = new Scanner(System.in);
        String [] curr = input.nextLine().split(":");
        String [] expl = input.nextLine().split(":");



        int currTime = toSeconds(curr);
        int expTime = toSeconds(expl);

        System.out.println("Curr Time in Seconds " +  currTime);
        System.out.println("Explosion Time in Seconds " + expTime);

        int totalSec;

        if(currTime > expTime){
            currTime = (24*3600) % currTime;
            totalSec = currTime + expTime;

        } else {
            totalSec = expTime - currTime;
        }

        System.out.println("Duration");
        ArrayList<Integer> timeDiff = duration(totalSec);
        System.out.println(timeDiff);


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
        int mins = (seconds % 60) / 60;
        int hrs = seconds / 3600;

        duration.add(hrs);
        duration.add(mins);
        duration.add(sec);

        return duration;
    }
}
