package ru.itpark.graduate.pb.commons;

import org.bouncycastle.jce.provider.BouncyCastleProvider;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.Security;

public class Crypto {

    private static final String ALGORITHM_GOST_NAME = "GOST3411";

    public static String encryptPassword(String pass) {
        String result = null;
        try {
            Security.addProvider(new BouncyCastleProvider()); //bc-prov
            MessageDigest md = MessageDigest.getInstance(ALGORITHM_GOST_NAME);
            md.update(pass.getBytes("UTF-8"));
            byte[] digest = md.digest();
            result = String.format("%064x", new BigInteger(1, digest)).toUpperCase();
            //result += "@";
        } catch (Exception x){}
        return result;
    }
}
