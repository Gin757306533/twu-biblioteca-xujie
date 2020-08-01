package com.twu.biblioteca;

import java.util.List;

public class Menu<T> {
    List<T> listOfOptions;

    public Menu(List<T> listOfOptions) {
        this.listOfOptions = listOfOptions;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "listOfOptions=" + listOfOptions +
                '}';
    }

    public void displayMenu(){
        System.out.println("------------Hello, Welcome to Biblioteca Menu --------------\n");
        for(int i=0; i < this.listOfOptions.size(); i++){
            System.out.printf("%-2d:%-30s\n", i+1, this.listOfOptions.get(i));
        }
    }

    public boolean addMenu(T menu){
        try{
            this.listOfOptions.add(menu);
            return true;
        }catch (Exception e){
            return false;
        }

    }

    public boolean deleteOptionByIndex(Integer index){
        try{
            this.listOfOptions.remove(index-1);
            return true;
        }catch (Exception e){
            return false;
        }

    }


    public List<T> getlistOfOptions() {
        return listOfOptions;
    }

    public void setlistOfOptions(List<T> listOfOptions) {
        this.listOfOptions = listOfOptions;
    }

    public T getIndexOption(Integer index){
        return this.listOfOptions.get(index-1);
    }
}
