package com.Library.model;

import java.util.ArrayList;

public class Member extends User {
    private int fine;
    private ArrayList<Book> borrowedBooks= new ArrayList<Book>();

    public Member(String name, int id, String email, String password, String role) {
        super(name, id, email, password, role);
    }

    public void borrowBook(Book book) {
        borrowedBooks.add(book);
    }

    public void returnBook(Book book){
        borrowedBooks.remove(book);
    }

    public void payFine(){
        System.out.println("Member has a fine of $" + this.fine);
    }
}
