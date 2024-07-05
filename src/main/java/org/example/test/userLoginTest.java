package org.example.test;

import org.example.util.userLogin;

public class userLoginTest {
    public static void main(String[] args) throws InterruptedException {
        userLogin userLogin = new userLogin("http://192.168.0.80:8099/#/login","yewuyuan1","111111");

        userLogin.login();
    }
}
