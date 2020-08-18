package com.habr.steps;

import com.habr.pages.SearchPage;

public class SearchPost {
    SearchPage searchPage=new SearchPage();

    public void searchByWord(String word){

        searchPage.searchByWord(word);
    }
    public void searchByNumbOfPost(int numb){

        searchPage.searchByNumb(numb);
    }
    public void searchInTitle(String titleWord){
        searchPage.searchPost(titleWord);
    }




}
