package org.example;

public interface LoginInterface {
    //所有角色的登录通过这个接口拓展 通过输入账号和密码登录
    void login(String account, String password) throws InterruptedException;
}
