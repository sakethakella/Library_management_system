package com.Library.model;

import java.util.ArrayList;

public class Member extends User {
    private String membershipId;
    ArrayList<Book> borrowedBooks = new ArrayList<>();

    public Member(long userId, String name, String membershipId) {
        super(userId, name);
        this.membershipId = membershipId;
    }

    public void BorrowBook(Book book){
        borrowedBooks.add(book);
    }

    public void ReturnBook(Book book){
        borrowedBooks.remove(book);
    }

    public void getBorrowedBooks(){
        for(Book book : borrowedBooks){
            book.DisplayDetails();
        }
    }

    public boolean canBorrow(){
        return borrowedBooks.size() < 3; // Assuming a member can borrow at most 3 books
    }

    @Override
    public void DisplayProfile(){
        super.DisplayProfile();
        System.out.println("Membership ID: " + membershipId);
        System.out.println("Borrowed Books:");
        getBorrowedBooks();
    }
}
