package by.achramionok;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        long starttime = System.currentTimeMillis();
        List<Integer> values = new ArrayList<Integer>();
        try {
            Scanner fileScanner = new Scanner(new File("src/files/input.txt"));
            while(fileScanner.hasNextInt()){
                values.add(fileScanner.nextInt());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        int value = (values.get(0)*values.get(1)/100)*values.get(2)+(values.get(3)*values.get(4)/100)*values.get(5);
        int val = (values.get(0)-(values.get(0)*values.get(1)/100))-(values.get(3)-(values.get(3)*values.get(4)/100));
        if(val<=0){
            value += Math.abs(val*values.get(5));
        }else{
            value += Math.abs(val*values.get(2));
        }
        Writer wr = null;
        try {
            wr = new FileWriter("src/files/output.txt");
            wr.write(String.valueOf(value));
            wr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        long endTime = System.currentTimeMillis();
        long duration = endTime - starttime;

        System.out.println(duration);
    }
}
