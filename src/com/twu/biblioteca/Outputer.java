package com.twu.biblioteca;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class Outputer<T> {

    public void displayMessage(String message){
        System.out.println(message);
    }

    public void displayBookListTitle(List<Book> list){
        System.out.println("ID  " + "\t" + "Book Title");
        for(int i = 0; i < list.size(); i++){
            System.out.printf("%-4d\t%-30s\n", i+1, list.get(i).getTitle());
        }

    }


    public void displayMovieListDetail(List<Movie> list){
        System.out.printf("%-4s\t%-30s\t%-20s\t%-20s\t%-15s\n", "ID", "Movie Name", "Year", "Director", "Movie rating");
        for(int i = 0; i < list.size(); i++){
            System.out.printf("%-4s\t%-30s\t%-20s\t%-20s\t%-15d\n", i+1, list.get(i).getTitle(),list.get(i).getYear(), list.get(i).getDirector(), list.get(i).getMovieRating());
        }

    }

    public void displayBookListDetail(List<Book> list){
        System.out.printf("%-4s\t%-30s\t%-20s\t%-20s\n", "ID", "Book Title", "Publication Year", "Author List");
        for(int i = 0; i < list.size(); i++){
            System.out.printf("%-4s\t%-30s\t%-20s\t%-20s\n", i+1, list.get(i).getTitle(),list.get(i).getPublishYear(), list.get(i).getAuthorListString());
        }

    }

    public void displayLists(List<T> list){
        System.out.printf("%-4s\t%-30s\t%-20s\t%-20s\n", "ID", "Book Title", "Publication Year", "Author List");
        list.stream().forEach(this.consumerWithIndex((item, index)->{
            System.out.printf("%-4d\t%s\n", index+1, item);
        }));

    }

    // tools function
    public <T> Consumer<T> consumerWithIndex(BiConsumer<T, Integer> consumer) {
        class Obj {
            int i;
        }
        Obj obj = new Obj();
        return t -> {
            int index = obj.i++;
            consumer.accept(t, index);
        };
    }



}
