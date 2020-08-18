package com.habr.tests;
import com.codeborne.selenide.Configuration;
import com.habr.steps.AddDelBookmarks;
import com.habr.steps.InLogin;
import com.habr.steps.OpenStartPage;
import com.habr.steps.SearchPost;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import static com.habr.tests.config.*;

//        jupiter.api.BeforeEach;

public class Tests {
    @BeforeEach
    public void option() {
        Configuration.timeout = 6000;
        Configuration.browser = browser;
        Configuration.startMaximized = true;

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-extensions");

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        Configuration.browserCapabilities = capabilities;
    }

    @Test()
    public void loginIn() throws InterruptedException {

        OpenStartPage openStartPage=new OpenStartPage();
        openStartPage.openPage(baseUrl);
        openStartPage.openLoginPage();
        InLogin inLogin=new InLogin();
        inLogin.enterLoginPass(email,password);

        inLogin.inLoginCheck(login);

    }
    @Test
    public void toBookmarksLoginOut() throws InterruptedException {
        OpenStartPage openStartPage2=new OpenStartPage();
        openStartPage2.openPage(baseUrl);

        SearchPost searchPost=new SearchPost();
        searchPost.searchByWord(searchWord);
        searchPost.searchInTitle(title);

        AddDelBookmarks addDelBookmarks=new AddDelBookmarks();
        addDelBookmarks.checkBookmarks();
    }
    @Test
    public void toBookmarksLoginIn() throws InterruptedException {
        OpenStartPage openStartPage3=new OpenStartPage();
        openStartPage3.openPage(config.baseUrl);
        openStartPage3.openLoginPage();

        InLogin inLogin2=new InLogin();
        inLogin2.enterLoginPass(email,password);
        Thread.sleep(4000);

        SearchPost searchPost2=new SearchPost();
        searchPost2.searchByWord(searchWord);
        searchPost2.searchInTitle(title);

        AddDelBookmarks addDelBookmarks2=new AddDelBookmarks();
        addDelBookmarks2.checkBookmarks();
    }
    @Test
    public void searchPost() throws InterruptedException {
        OpenStartPage openStartPage4=new OpenStartPage();
        openStartPage4.openPage(baseUrl);
        openStartPage4.openLoginPage();

        SearchPost searchPost3=new SearchPost();
        searchPost3.searchInTitle("");
        searchPost3.searchByWord(searchWord);
        searchPost3.searchInTitle(title);

        AddDelBookmarks addDelBookmarks2=new AddDelBookmarks();
        addDelBookmarks2.checkBookmarks();
    }
    @Test
    public void editLangAndCheck() throws InterruptedException {
//        open("https://www.habr.com/ru/");
//
//        Thread.sleep(4000);
//        StartPage startPage=new StartPage();
//        startPage.openPage(baseUrl);
//        startPage.clickAllPosts();
//        startPage.editLang();
//        startPage.checkPostTitle();


    }

}

