package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static java.lang.Thread.sleep;

public class userLogin implements LoginInterface{
    //通过url或ip+端口号的形式确定一个主页
    String jumpPageUrl;
    String userAccount;
    String usrPassword;

    //通过调用webDrive对象完成对页面的模拟操作
    WebDriver webDriver;

    //调用这个函数来实现页面的跳转
    private void jumpPage(String jumpPageUrl) throws InterruptedException {
        webDriver.get(jumpPageUrl);
        //页面跳转之后等待页面响应
        sleep(3000);
    }
    @Override
    public void login(String account, String password) throws InterruptedException {
        //先跳转到页面
        jumpPage(jumpPageUrl);

        //定位用户账号输入框
        WebElement accountInput = webDriver.findElement(By.cssSelector("#vue-admin-beautiful > div > div > div.el-col.el" +
                "-col-24.el-col-xs-24.el-col-sm-24.el-col-md-12.el-col-lg-8.el-col-xl-8 > form > div.el-form-item.is-err" +
                "or.is-required.el-form-item--small > div > div.el-input.el-input--small > input"));

        accountInput.sendKeys(account);

        //定位用户密码输入框
        WebElement passwordInput = webDriver.findElement(By.cssSelector("#vue-admin-beautiful > div > div > div.el-col.e" +
                "l-col-24.el-col-xs-24.el-col-sm-24.el-col-md-12.el-col-lg-8.el-col-xl-8 > form > div:nth-child(4) > div" +
                " > div > input"));
        passwordInput.sendKeys(password);
    }
}
