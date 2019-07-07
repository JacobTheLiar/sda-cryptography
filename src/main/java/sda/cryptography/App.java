package sda.cryptography;

import sda.cryptography.application.Application;
import sda.cryptography.application.IApplication;

public class App
{
    public static void main( String[] args )
    {
        System.out.println("Cryptoigraphy - ver 0.1");

        try {
            IApplication application = new Application();
            application.start();
        }catch (Exception ex){
            System.out.println("Application Error");
            throw ex;
        }

    }
}
