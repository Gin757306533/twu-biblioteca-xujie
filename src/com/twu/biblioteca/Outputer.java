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
            System.out.printf("%-4d\t%-30s\n", i, list.get(i).getTitle());
        }

    }


//    public void displayListsTitle(List<? super Book> list){
//        System.out.println("index\t" + "title");
//        for(int i = 0; i < list.size(); i++){
//            System.out.println(i + "\t" + list.get(i).getTitle());
//        }
////        list.stream().forEach(this.consumerWithIndex((item, index)->{
////            System.out.println(index + "\t" + item.getTitle()); // 用泛型的时候这里报错，回头再来看看
////        }));
//
//    }

    public void displayBookListDetail(List<Book> list){
        System.out.printf("%-4s\t%-30s\t%-20s\t%-20s\n", "ID", "Book Title", "Publication Year", "Author List");
        for(int i = 0; i < list.size(); i++){
            System.out.printf("%-4s\t%-30s\t%-20s\t%-20s\n", i, list.get(i).getTitle(),list.get(i).getPublishYear(), list.get(i).getAuthorListString());
        }

    }

    public void displayLists(List<T> list){
        System.out.printf("%-4s\t%-30s\t%-20s\t%-20s\n", "ID", "Book Title", "Publication Year", "Author List");
        list.stream().forEach(this.consumerWithIndex((item, index)->{
            System.out.printf("%-4d\t%s\n", index, item);
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
