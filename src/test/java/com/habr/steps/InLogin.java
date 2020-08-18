package com.habr.steps;
import com.codeborne.selenide.commands.ShouldBe;
import com.habr.pages.LoginPage;
import org.junit.Assert;


import javax.security.auth.spi.LoginModule;

public class InLogin {
    LoginPage loginPage=new LoginPage();

    public void enterLoginPass(String email,String passowrd){
        loginPage.setEmail(email);
        loginPage.setPassword(passowrd);
        loginPage.clickEnter();
    }
    public void inLoginCheck(String username){
        Assert.assertTrue(loginPage.checkLogin(username));
    }

}
