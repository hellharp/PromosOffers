package com.ryggsekk.promosoffers.util;
 
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
 
// For password encryption of the first inserted admin accounts
public class QuickPasswordEncodingGenerator {
 
    /**
     * @param args
     */
    public static void main(String[] args) {
            String password = "abc125";
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            System.out.println(passwordEncoder.encode(password));
    }
 
}