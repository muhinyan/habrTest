package com.habr.pages;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.commands.ShouldBe;
import org.junit.Assert;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class PostPage {
    String bookmarkNumb;
    Boolean check;
    String checkFollow;
    SelenideElement addToBookmarksButton=$(By.xpath("//*[@class=\"btn_inner\"]"));

    public void clickToBookmarks() { //добавляет статью в закладки
        bookmarkNumb=$(By.xpath("//*[@class=\"bookmark__counter js-favs_count\"]")).getText();
        Integer.parseInt(bookmarkNumb);
        addToBookmarksButton.click();

    }
    public void checkClickTo() {
        Assert.assertNotEquals(bookmarkNumb, Integer.parseInt(addToBookmarksButton.getText()));
    }

//    public Boolean Follow()
//    {
//        checkFollow=$(By.xpath("//*[@title=\"Подписаться на пользователя\"]")).getText();
//        if (checkFollow.contains("Подписаться")) {
//            $(By.xpath("//*[@title=\"Подписаться на пользователя\"]")).click();
//            if (checkFollow.contains("Подписан"))
//            check=true;
//        }
//        return check;
//    }

}
