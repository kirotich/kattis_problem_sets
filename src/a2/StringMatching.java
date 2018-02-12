package a2;

import java.io.*;

/**

 * Kattis String Matching
 * @author kirotich

 */

public class StringMatching {
    /*
      KMP Algorithm for Pattern Matching
     */
    public static void KMPSearch(String pattern, String text){

        //compute LPS
        int piArr[] = computePIArray(pattern);
        int j = 0; //pattern
        int i = 0; //text
        while (i < text.length()) {
            if (pattern.charAt(j) == text.charAt(i)) {
                j++;
                i++;
            }
            if (j == pattern.length()){
                System.out.print((i-j));
                j = piArr[j-1];
                System.out.print(" ");
            } else if (i < text.length() && pattern.charAt(j) != text.charAt(i)) {
                if (j != 0)
                    j = piArr[j-1];
                else
                    i = i+1;
            }
        }
    }
    /*
        Return temp array to maintain size of suffix which is same as prefix
     */

    public static int[] computePIArray(String pattern){


        int [] piArr = new int[pattern.length()];
        int length = 0;

        int i = 1;
        piArr[0] = 0;

        while (i < pattern.length()) {
            if (pattern.charAt(i) == pattern.charAt(length)){
                length++;
                piArr[i] = length;
                i++;
            } else {

                if (length != 0) {
                    length = piArr[length-1];
                } else {
                    piArr[i] = length;
                    i++;
                }
            }
        }
        return piArr;
    }


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String text,pattern;

        while (((pattern = br.readLine()) != null) && ((text = br.readLine()) != null) ){
            KMPSearch(pattern,text);
            System.out.println(" ");
        }
        bw.flush();
        bw.close();

    }

}
