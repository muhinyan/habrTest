package com.habr.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public class SearchPage {
    SelenideElement searchButton=$(By.id("search-form-btn"));
    SelenideElement searchField=$(By.id("search-form-field"));
    SelenideElement nextButton=$(By.xpath("//*[@id=\"next_page\"]"));
    ElementsCollection postTitle=$$(By.xpath("//*[@class=\"post__title_link\"]"));


    public void searchByWord(String word){ //поиск по ключевому слову
        searchButton.click();
        searchField.setValue(word).pressEnter();
    }
    public void searchByNumb(int postNumb) //поиск по позиции статьи
    {
        postTitle.get(postNumb).click();
    }
    public void searchPost(String postName){ //поиск по заголовку статьи
        for(int i=0;i<postTitle.size();i++){
            if(postTitle.texts().contains(postName))
                postTitle.get(i).click();
        }
    }
    public void clickNextButton(){
        if(nextButton.isEnabled())
            nextButton.click();


    }
}
