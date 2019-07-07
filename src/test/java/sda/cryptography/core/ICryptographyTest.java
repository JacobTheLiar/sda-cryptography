package sda.cryptography.core;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(value = Parameterized.class)
public class ICryptographyTest {


    private String decrypted;
    private int shift;
    private String encrypted;

    public ICryptographyTest(String decrypted, int shift, String encrypted){
        this.encrypted = encrypted;
        this.shift = shift;
        this.decrypted = decrypted;
    }

    @Parameterized.Parameters(name = "Test [{index}]: {0} enc {1} dec {2}")
    public static Collection<Object> data(){
        return Arrays.asList(new Object[][]{
                {"a",2,"c"},
                {"abc",5,"fgh"},
                {"Dingo2",2,"Fkpiq4"},
                {"SDAcademy course", 16, "jTQsqtu!9Cs-634u"},
                {"Lorem ipsum dolor sit amet.", 32, "sDG6BS0EHJBS5DADGSH0IS2B6IP"}});
    }

    @Test
    public void encrypt() {
        ICryptography crypt = new CesarCrypt(decrypted, shift);

        String result = crypt.encrypt();

        assertEquals(encrypted, result);
    }

    @Test
    public void decrypt() {

        ICryptography crypt = new CesarCrypt(encrypted, shift);

        String result = crypt.decrypt();

        assertEquals(decrypted, result);


    }
}