package com.twu.biblioteca;
import java.text.ParseException;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.List;

public class Book<T> extends Item{
    private Date publishDate;
    private List<T> authorList;
    static final SimpleDateFormat SDF = new SimpleDateFormat("yyyy-MM-dd");

    public Book(String title, String publishDate, List<T> authorList) throws ParseException {
        super(title);
        this.setPublishDate(publishDate);
        this.authorList = authorList;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj){
            return true;
        }
        if (obj == null){
            return false;
        }
        if (getClass() != obj.getClass()){
            return false;
        }
        Book book = (Book) obj;
        boolean titleFlag = this.getTitle().equals(book.getTitle());
        boolean dateFlag = this.publishDate.equals(book.publishDate);
        boolean authorFlag = this.authorList.equals( book.authorList);

        return titleFlag && dateFlag && authorFlag;
    }

    @Override
    public String toString() {

        String retString = String.format("%-30s\t%-20s\t%-20s", this.getTitle(), this.getPublishDateString(), this.getAuthorListString());
        return retString;
    }



    public Date getPublishDate() {
        return publishDate;
    }

    public String getPublishYear(){
        return this.getPublishDateString().substring(0, 4);
    }

    public String getPublishDateString(){
        return SDF.format(this.publishDate);
    }

    public List<T> getAuthorList() {
        return authorList;
    }

    public String getAuthorListString(){
        String authorListString = "";
        for(T author: this.authorList){
            authorListString += (author + "\t");
        }
        return authorListString;
    }



    public void setPublishDate(String publishDate) throws ParseException {
        this.publishDate = SDF.parse(publishDate);
    }

    public void setAuthorList(List<T> authorList) {
        this.authorList = authorList;
    }

}
