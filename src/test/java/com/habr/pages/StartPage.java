package com.habr.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.junit.Assert;
import org.openqa.selenium.By;

import java.util.Collections;

import static com.codeborne.selenide.Selenide.*;

public class StartPage {

    int rusPostTitle=0;
    boolean langCheck;
    SelenideElement allPostsButton=$(By.xpath("//*[@href=\"https://habr.com/ru/all/\"]"));
    SelenideElement loginButton=$(By.xpath("//*[@id=\"login\"]"));
    SelenideElement langSettingsButton=$(By.xpath("//*[@class=\"btn btn_medium btn_navbar_lang js-show_lang_settings\"]"));
    SelenideElement engLang=$(By.xpath("//*[@for=\"hl_langs_en\"]"));
    SelenideElement saveLangSettingsButton=$(By.xpath("//*[@class=\"btn btn_blue btn_huge btn_full-width js-popup_save_btn\"]"));
    ElementsCollection postTitle =$$(By.xpath("//article[@class=\"post post_preview\"]//*[@class=\"post__title_link\"]"));



    public void openPage(String url){
        open(url);
    }
    public void clickAllPosts()//выбирает "все подряд" статьи
    {
        allPostsButton.click();
    }
    public void enterToLogin()
    {
        loginButton.click();
    }
    public void editLangEng()//меняет язык страницы на английский
    {
        langSettingsButton.click();
        engLang.click();//через val("English") не получилось
        saveLangSettingsButton.click();

    }

    public Boolean checkLangPostTitle (){ //проверяет после изм. языка остались ли русскоязычные статьи

        for (int i=0;i<postTitle.size();i++){
            if (postTitle.get(i).getText().matches("[а-яА-Я]")){
                rusPostTitle++;
            }
        }
        if(rusPostTitle>0)
            langCheck=false;
        else
            langCheck=true;
        return langCheck;
    }
}
