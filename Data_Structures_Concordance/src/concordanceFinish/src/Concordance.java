package concordanceFinish.src;

import java.util.*;
import java.io.*;

public class Concordance {
    public static void main(String[] args) {

        try {
            long startTime = System.nanoTime();

            String oneLine="";

           // System.out.println(oneLine);
            //System.out.println(oneLine.replace(""));
            MyLinkedList listOfWords=new MyLinkedList();

            BufferedReader inFile = new BufferedReader( new FileReader( args[0] ) );

            for (int lineNum = 1; (oneLine = inFile.readLine()) != null; lineNum++) {
                oneLine= fixLine(oneLine.toLowerCase());

                StringTokenizer st = new StringTokenizer(oneLine);
                while (st.hasMoreTokens()) {
                    String word = st.nextToken();
                    Boolean isExist=listOfWords.search(word);

                    if (isExist == false && word.length()>1) {
                        listOfWords.addNode(word); //obviously this is the tail now
                    }
                    listOfWords.tail.wordInfo.addNode(lineNum);
                }
            }
            listOfWords.sortList();
            listOfWords.printLinkedList();

            long endTime = System.nanoTime();
            long totalTime = endTime - startTime;
            System.out.println("Time it took to sort (in nanoseconds): " + totalTime);
        } catch (Exception e) {
            System.err.println("Error: " + e);
        }



    }

    public static String fixLine(String line){
        String ans="";
        int i=0;
        while(i!=line.length()){
            if(line.charAt(i)!=32){
                if(line.charAt(i)<97||line.charAt(i)>122)
                    ans=ans+" ";
                else
                    ans=ans+line.charAt(i);
            }
            else
                ans=ans+line.charAt(i);
            i++;
        }
        return ans;
    }
}
