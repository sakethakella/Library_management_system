package com.Library.model;

import java.time.LocalDate;
public class Transaction {
    private String transactionId;
    private Book book;
    private Member member;
    private LocalDate issueDate;
    private LocalDate returnDate;
    private boolean returned;
    
    public void closeTransaction(){
        this.returnDate=LocalDate.now();
        this.returned=true;
    }

    public boolean isReturned(){
        return this.returned;
    }

    public void DisplayTransaction(){
        System.out.println("Transaction ID: " + transactionId);
        System.out.println("Book: " + book.getTitle());
        System.out.println("Member: " + member.getName());
        System.out.println("Issue Date: " + issueDate);
        System.out.println("Return Date: " + returnDate);
        System.out.println("Returned: " + returned);
    }
}

