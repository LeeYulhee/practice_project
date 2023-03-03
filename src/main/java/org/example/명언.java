package org.example;

public class 명언 {
    private int id;
    private String content;
    private String author;
    

    명언(int id, String author, String content){
        this.id = id;
        this.author = author;
        this.content = content;
    }


    public int getId() {
        return id;
    }


    public String getAuthor() {
        return author;
    }


    public String getContent() {
        return content;
    }


    public void setAuthor(String author) {
        this.author = author;
    }

    public void setContent(String content) {
        this.content = content;
    }


    @Override
    public String toString() {
        return id + " / " + author  + " / " + content;
    }
}
