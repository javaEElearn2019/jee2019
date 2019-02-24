package ru.itpark.graduate.pb.commons;

import org.junit.*;

@Ignore
public class CryptoTest {

    @BeforeClass
    public static void bc(){
        System.out.println("in before Class");
    }

    @AfterClass
    public static void ac(){
        System.out.println("in AFTER Class");
    }


    @Before
    public void bef(){
        System.out.println("in before CryptoTest");
    }


    @After
    public void aft(){
        System.out.println("in afret CryptoTest");
    }

    @Test
    public void doAA(){
        System.out.println("in test doAAA");
    }

    //@Ignore
    @Test
    public void encryptPassword_Test() {
        System.out.println("in test encryptPassword_Test");
        String hash = Crypto.encryptPassword("12345678");

        Assert.assertEquals("EFAECC0E8F3165F5D727203A99966BC2436D993C8F3C5D0A46CC5EAC40968AF7", hash);
    }
}
