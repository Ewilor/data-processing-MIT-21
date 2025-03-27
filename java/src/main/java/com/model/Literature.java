package com.model;

public class Literature {
    private int id;
    private String title;
    private String author;
    private int pages;
    private String imageUrl;
    private boolean isHardcover;

    public Literature(int id, String title, String author, int pages, String imageUrl, boolean isHardcover) {
        this.title = title;
        this.author = author;
        this.pages = pages;
        this.imageUrl = imageUrl;
        this.isHardcover = isHardcover;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public boolean getIsHardcover() {
        return isHardcover;
    }

    public void setIsHardcover(boolean isHardcover) {
        this.isHardcover = isHardcover;
    }
}
