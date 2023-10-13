import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.security.SecureRandom;
import java.security.spec.KeySpec;
import java.util.Base64;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

public class Authentication {
    public static boolean signup(String username, String password) throws Exception {
        // Check if the username already exists
        try (BufferedReader reader = new BufferedReader(new FileReader("users.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts[0].equals(username)) {
                    System.out.println("Username already exists. Please choose a different username.");
                    return false;
                }
            }
        }
    
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16];
        random.nextBytes(salt);
    
        KeySpec spec = new PBEKeySpec(password.toCharArray(), salt, 65536, 128);
        SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
    
        byte[] hash = factory.generateSecret(spec).getEncoded();
    
        try (FileWriter writer = new FileWriter("users.txt", true);
             BufferedWriter bufferedWriter = new BufferedWriter(writer)) {
            bufferedWriter.write(username + "," + Base64.getEncoder().encodeToString(hash) + ","
                    + Base64.getEncoder().encodeToString(salt));
            bufferedWriter.newLine();
        }
    
        System.out.println("User registered successfully!");
        return true;
    }

    public static boolean check(String username, String password) throws Exception {
        try (BufferedReader reader = new BufferedReader(new FileReader("users.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts[0].equals(username)) {
                    byte[] salt = Base64.getDecoder().decode(parts[2]);
                    KeySpec spec = new PBEKeySpec(password.toCharArray(), salt, 65536, 128);
                    SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
                    byte[] hash = factory.generateSecret(spec).getEncoded();
                    return Base64.getEncoder().encodeToString(hash).equals(parts[1]);
                }
            }
        }
        return false;
    }
}
