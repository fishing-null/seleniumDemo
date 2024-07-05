package org.example.util;

import org.example.impl.LoginInterface;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static java.lang.Thread.sleep;

public class userLogin implements LoginInterface {
    //通过url或ip+端口号的形式确定一个主页
    String jumpPageUrl;
    String userAccount;
    String usrPassword;

    //通过调用webDrive对象完成对页面的模拟操作
    WebDriver webDriver = new ChromeDriver();

    public userLogin(String jumpPageUrl, String userAccount, String usrPassword) {
        this.jumpPageUrl = jumpPageUrl;
        this.userAccount = userAccount;
        this.usrPassword = usrPassword;
    }

    //调用这个函数来实现页面的跳转
    private void jumpPage(String jumpPageUrl) throws InterruptedException {
        webDriver.get(jumpPageUrl);
        //页面跳转之后等待页面响应
        webDriver.wait(10);
    }
    @Override
    public void login() throws InterruptedException {
        //先跳转到页面
        jumpPage(jumpPageUrl);

        //定位用户账号输入框
        WebElement accountInput = webDriver.findElement(By.xpath("/html/body/div/div/div/div[2]/form/div[3]/div/div[1]/input"));

        accountInput.sendKeys(userAccount);

        //定位用户密码输入框
        WebElement passwordInput = webDriver.findElement(By.xpath("/html/body/div/div/div/div[2]/form/div[4]/div/div/input"));

        passwordInput.sendKeys(usrPassword);

        WebElement login = webDriver.findElement(By.xpath("/html/body/div/div/div/div[2]/form/button"));
        login.click();
    }
}
