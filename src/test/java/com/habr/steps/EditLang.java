package com.habr.steps;

import com.habr.pages.StartPage;
import org.junit.Assert;

public class EditLang {
    StartPage startPage=new StartPage();
    public void setEng(){
        startPage.clickAllPosts();
        startPage.editLangEng();
    }
    public void editLangCheck(Boolean langCheck){
        Assert.assertTrue(startPage.checkLangPostTitle());
    }
}
