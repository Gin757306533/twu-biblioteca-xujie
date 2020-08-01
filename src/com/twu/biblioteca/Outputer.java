package com.twu.biblioteca;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class Outputer<T> {

    public void displayMessage(String message){
        System.out.println(message);
    }

    public void displayLists(List<T> list){
        list.stream().forEach(this.consumerWithIndex((item, index)->{
            System.out.println(index + " " + item);
        }));

    }

    // 工具方法
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
