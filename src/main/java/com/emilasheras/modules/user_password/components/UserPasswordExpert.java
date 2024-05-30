package com.emilasheras.modules.user_password.components;

import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.Base64;

public class UserPasswordExpert {
    public static String generateSalt() {
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16];
        random.nextBytes(salt);
        return Base64.getEncoder().encodeToString(salt);
    }

    public static String hashPassword(String password, String salt) throws Exception {
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256"); // todo: cambiar por un algoritmo menos berreta
        messageDigest.update(Base64.getDecoder().decode(salt));
        byte[] hashedPassword = messageDigest.digest(password.getBytes());
        return Base64.getEncoder().encodeToString(hashedPassword);
    }
}
