package com.habr.steps;

import com.habr.pages.StartPage;

public class OpenStartPage {
    StartPage startPage=new StartPage();
    public void openPage(String url){
        startPage.openPage(url);
    }
    public void openLoginPage(){
        startPage.enterToLogin();
    }


}
