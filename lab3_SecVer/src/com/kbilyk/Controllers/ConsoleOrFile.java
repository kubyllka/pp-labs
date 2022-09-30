package com.kbilyk.Controllers;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;
import static com.kbilyk.Controllers.Correct.checkCorrect;

/**
 * Save the game to file with name that
 * user enter
 */

public class ConsoleOrFile {

    private int regime = -1;            // regime output
    private File file;                  // the file
    private PrintStream out;            // the new stream of output
    private PrintStream prevStream;     // the previous stream of output

    /**
     * Constructor
     */
    public ConsoleOrFile() {}

    /**
     * Set a regime output for writing a battle
     * @throws FileNotFoundException The error of finding file
     */
    public void FileOrNot() throws FileNotFoundException {
        System.out.println("\n-------------------------------------");
        System.out.println("Do you want to write this battle to file? 1 - YES, 0 - NO");
        regime = checkCorrect(0, 1);

        // if yes - create file and change the stream output
        if(regime == 1){
            createFile();
            System.out.println("\nThe game is saved to a file!");
            toFile();
        }
    }

    /**
     * Creating file with name that user enter
     */
    public void createFile(){
        System.out.println("\n-------------------------------------");
        System.out.println("Type name of file:");
        String fileName = input.next();
        fileName += ".txt";

        // Creating file
        try {
            file = new File(fileName);
            if (file.createNewFile()) {
                System.out.println("File created: " + file.getAbsolutePath());
            } else {
                System.out.println("File already exists!");
            }
        } catch (IOException e) {
            System.out.println("An error occurred!");
        }
    }

    /**
     * Change output stream to file
     * @throws FileNotFoundException The error of finding file
     */
    public void toFile() throws FileNotFoundException {
        prevStream = System.out;
        out = new PrintStream(file);
        System.setOut(out);
    }

    /**
     * Change output stream back to console
     */
    public void changeRegime(){
        if(regime == 1){
            out.close();
            System.setOut(prevStream);
            regime = -1;
        }
    }

    Scanner input = new Scanner(System.in);
}
