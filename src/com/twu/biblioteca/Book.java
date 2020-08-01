package com.twu.biblioteca;
import java.text.ParseException;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.List;

public class Book<T> {
    String title;
    Date publishDate;
    List<T> authorList;
    static final SimpleDateFormat SDF = new SimpleDateFormat("yyyy-MM-dd");

    public Book(String title, String publishDate, List<T> authorList) throws ParseException {
        this.title = title;
        this.setPublishDate(publishDate);
        this.authorList = authorList;
    }

    @Override
    public String toString() {
        String authorListString = "";
        for(T author: this.authorList){
            authorListString += author;
        }
        return "Book{" +
                "title='" + this.title + '\'' +
                ", publishDate='" + this.getPublishDateString() + '\'' +
                ", authorList=" + authorListString +
                '}';
    }

    public String getTitle() {
        return title;
    }


    public Date getPublishDate() {
        return publishDate;
    }

    public String getPublishDateString(){
        return SDF.format(this.publishDate);
    }

    public List<T> getAuthorList() {
        return authorList;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public void setPublishDate(String publishDate) throws ParseException {
        this.publishDate = SDF.parse(publishDate);
    }

    public void setAuthorList(List<T> authorList) {
        this.authorList = authorList;
    }

}
