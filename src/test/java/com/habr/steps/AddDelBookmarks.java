package com.habr.steps;

import com.habr.pages.PostPage;

public class AddDelBookmarks {
    PostPage postPage=new PostPage();
    public void checkBookmarks()
    {
        postPage.clickToBookmarks();
        postPage.checkClickTo();
    }
}
