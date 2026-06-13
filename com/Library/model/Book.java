package com.Library.model;

import java.time.LocalDate;

public class Book {
    private long bookid;
    public String title;
    public String author;
    private LocalDate publicationDate;
    private boolean isAvailable;
    private Member isborrowedBy; 

    public Book(long bookid, String title, String author, LocalDate publicationDate) {
        this.bookid = bookid;
        this.title = title;
        this.author = author;
        this.publicationDate = publicationDate;
        this.isAvailable = true;
    }

    public long getBookid() {
        return this.bookid;
    }

    public String getTitle(){
        return this.title;
    }

    public String getAuthor(){
        return this.author;
    }

    public boolean isAvail(){
        return this.isAvailable;
    } 

    public boolean BorrowBook(Member mem){
        if(this.isAvailable){
            this.isAvailable = false;
            this.isborrowedBy = mem;
            return true;
        }
        return false;
    }

    public boolean returnBook(){
        if(!this.isAvailable){
            this.isAvailable = true;
            this.isborrowedBy = null;
            return true;
        }
        return false;
    }

    public void DisplayDetails(){
        System.out.println("Book ID: " + this.bookid);
        System.out.println("Title: " + this.title);
        System.out.println("Author: " + this.author);
        System.out.println("Publication Date: " + this.publicationDate);
        System.out.println("Availability: " + this.isAvailable);
    }
        
}
