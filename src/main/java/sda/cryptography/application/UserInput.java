package sda.cryptography.application;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UserInput implements IUserInput {

    private final BufferedReader inputReader = new BufferedReader(new InputStreamReader(System.in));

    public String readLine() {
        try {
            return inputReader.readLine().trim();
        } catch (IOException ex){
            return "";
        }
    }


    public int readInteger(){
        int result=0;
        boolean correctConvert;

        do {
            try {
                result = Integer.parseInt(readLine());
                correctConvert = true;
            }catch (Exception ex){
                correctConvert = false;
            }
        } while (!correctConvert);

        return result;

    }

}
