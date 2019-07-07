package sda.cryptography.application;

import sda.cryptography.core.CesarCrypt;
import sda.cryptography.core.ICryptography;

public class Application implements IApplication{

    @Override
    public void start() {
        IUserInput ui = new UserInput();

        do{
            System.out.println("Szyfrowanie algorytmem Cezara");
            System.out.print("podaj przesunięcie: ");

            int shift = ui.readInteger();

            System.out.print("podaj wiadomość: ");
            String orginalText = ui.readLine();


            // TODO dodanie szyfrowania
            ICryptography cesar = new CesarCrypt(orginalText, shift);

            String encryptedText = cesar.encrypt();

            System.out.println();
            System.out.println("zaszyfrowana wiadomość");
            System.out.println(encryptedText);


            // TODO dodanie odszyfrowania
            cesar = new CesarCrypt(encryptedText, shift);
            String decryptedText = cesar.decrypt();
            System.out.println();
            System.out.println("odszyfrowana wiadomość");
            System.out.println(decryptedText);

        }while(!canExit());
    }

    private boolean canExit() {
        return true;
    }
}
