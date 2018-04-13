package Competition;

import java.util.ArrayList;
import java.util.Scanner;

public class PolygonArea {
    public static void main(String [] args) {
        Scanner input = new Scanner(System.in);

        while (input.hasNextLine()) {
            //System.out.println("Input No Of Vertices");
            // String test = input.nextLine();
            String test = input.nextLine();
            if (test.equals("0")) {
                break;
            } else {
                int vertices = Integer.parseInt(test);
                ArrayList<Pair> coordinates = new ArrayList<>();
                while (vertices > 0) {
                    double xCoordinate = input.nextInt();
                    double yCoordinate = input.nextInt();
                    input.nextLine();
                    Pair pr = new Pair(xCoordinate, yCoordinate);
                    //System.out.println("x :"+  pr.x + " y: " + pr.y);
                    coordinates.add(pr);
                    vertices--;

                }

                Pair p1 = coordinates.get(0);
                Pair p2 = coordinates.get(1);
                Pair p3 = coordinates.get(2);

                //System.out.println();

                if (isClockWise(p1, p2, p3)) {
                    System.out.print("CW ");
                } else {
                    System.out.print("CCW ");
                }

                double area = calcArea(coordinates);
                System.out.print(area);
                System.out.println();
            }
        }

    }


    private static class Pair {
        private double x = 0.0;
        private double y = 0.0;

        public Pair(double x, double y) {
            this.x = x;
            this.y = y;
        }

        public Pair() {

        }

        public double getX() {
            return x;
        }

        public void setX(double x) {
            this.x = x;
        }

        public double getY(){
            return y;
        }

        public void setY(double y) {
            this.y = y;
        }


    }

    static boolean isClockWise(Pair A, Pair B, Pair C){
        double Ax = A.getX();
        double Ay = A.getY();
        double Bx = B.getX();
        double By = B.getY();
        double Cx = C.getX();
        double Cy = C.getY();

        double ccw = (Bx-Ax)*(Cy-Ay) - (By-Ay)*(Cx-Ax);
        if(ccw > 0){
            return false;
        } else {
            return true;
        }

    }

    static double calcArea(ArrayList<Pair> arr){
        double result = 0.0;
        //for(int i = 1; i < arr.size(); i++){
          //  result += (arr.get(i).getY()*arr.get(i-1).getX() - arr.get(i-1).getY()*arr.get(i).getX());
        //}
        int j = arr.size() -1;
        int n = arr.size();
        for (int i = 0; i < n; i++){
            result += ((arr.get(j).getX() + arr.get(i).getX())) * (arr.get(j).getY() - arr.get(i).getY());
            j = i;
        }
        return Math.abs(0.5 * result);
    }


}
