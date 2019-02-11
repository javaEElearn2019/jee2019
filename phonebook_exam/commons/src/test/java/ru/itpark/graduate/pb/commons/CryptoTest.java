package ru.itpark.graduate.pb.commons;

import org.junit.Assert;
import org.junit.Test;

public class CryptoTest {

    @Test
    public void encryptPassword_Test() {
        String hash = Crypto.encryptPassword("12345678");
        Assert.assertEquals("EFAECC0E8F3165F5D727203A99966BC2436D993C8F3C5D0A46CC5EAC40968AF7", hash);
    }
}
