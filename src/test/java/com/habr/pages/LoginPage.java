package com.habr.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage {

    SelenideElement emailField=$(By.xpath("//*[@id=\"email_field\"]"));
    SelenideElement passwordField=$(By.xpath("//*[@id=\"password_field\"]"));
    SelenideElement enterButton=$(By.name("go"));
    //SelenideElement accountButton=$(By.xpath("//*[@class=\"default-image default-image_navbar default-image_pink\"]"));
    SelenideElement usernameField=$(By.xpath("//*[@class=\"user-info__nickname\"]"));
    boolean inLoginCheck;

    public void setEmail(String email){
        emailField.setValue(email);
    }
    public void setPassword(String password) {
        passwordField.setValue(password);
    }
    public void clickEnter() {
        enterButton.click();
    }
    public boolean checkLogin(String username)
    {
        SelenideElement accountButton=$(By.xpath("//*[@class=\"default-image default-image_navbar default-image_pink\"]"));
        accountButton.shouldBe(visible);
        if (accountButton.exists()){
            accountButton.click();
            if (usernameField.text().contains(username))
                inLoginCheck=true;
            else inLoginCheck=false;
         }
        else inLoginCheck=false;

        return inLoginCheck;
    }
}
