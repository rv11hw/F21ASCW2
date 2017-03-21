package model;

/**
 * Created by jithinjanardanan on 3/17/17.
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
//import java.io.FileWriter;
//import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class ProcessFile {

    public static ArrayList<String> readFile(String filename) {
        ArrayList<String> str= new ArrayList<String>();
        try {
            File f = new File("res/"+filename);
            Scanner scanner = new Scanner(f);
            while (scanner.hasNextLine()) {
                // read first line and process it
                String inputLine = scanner.nextLine();
                if (inputLine.length() != 0) {// ignored if blank line
                    str.add(inputLine);
                }
            }
        }
        // if the file is not found, stop with system exit
        catch (FileNotFoundException fnf) {
            System.out.println(filename + " not found ");
            System.exit(0);
        }
        return str;
    }

   public static void writeFile(String filename, String input){
        writeFile(filename, input, false);
    }

    public static void writeFile(String filename, String input, Boolean append){
        FileWriter fw;
        try {
            if(append)
                fw = new FileWriter(filename,true);
            else
                fw = new FileWriter(filename);
            fw.write(input);
            fw.close();
        }
        // message and stop if file not found
        catch (FileNotFoundException fnf) {
            System.out.println(filename + " not found ");
            System.exit(0);
        }
        // stack trace here because we don't expect to come here
        catch (IOException ioe) {
            ioe.printStackTrace();
            System.exit(1);
        }
    }
}

