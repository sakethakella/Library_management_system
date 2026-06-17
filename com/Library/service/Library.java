package com.Library.service;

import java.util.ArrayList;
import com.Library.model.Book;
import com.Library.model.Member;
import com.Library.model.Transaction;

public class Library {
    private ArrayList<Book> allBooks= new ArrayList<Book>();
    private ArrayList<Member> allMembers= new ArrayList<Member>();
    private ArrayList<Transaction> allTransactions= new ArrayList<Transaction>();

    public void addBook(Book book){
        allBooks.add(book);
    }

    public Book searchByBookId(long bookId){
        for(Book book : allBooks){
            if(book.getBookid()==bookId){
                return book;
            }
        }
        return null;
    }

    public void removeBook(long bookId){
        Book book = searchByBookId(bookId);
        if(book != null){
            allBooks.remove(book);
        }
    }

    public Book searchByTitle(String title){
        for(Book book : allBooks){
            if(book.getTitle().equals(title)){
                return book;
            }
        }
        return null;
    }

    public boolean updateBook(long bookId, String title, String author){
        Book book = searchByBookId(bookId);
        if(book != null){
            book.author=author;
            book.title=title;
            return true;
        }
        return false;
    }

    public void displayAllbooks(){
        for(Book book : allBooks){
            book.DisplayDetails();
        }
    }

    public void displayAvailableBooks(){
        for(Book book : allBooks){
            if(book.isAvail()){
                book.DisplayDetails();
            }
        }
    }

    public void displayIssuedBooks(){
        for(Book book : allBooks){
            if(!book.isAvail()){
                book.DisplayDetails();
            }
        }
    }

    public void addMember(Member member){
        allMembers.add(member);
    }
    public void removeMember(Member member){
        allMembers.remove(member);
    }
    public Member searchMember(long id){
        for(Member member : allMembers){
            if(member.getUserid() == id){
                return member;
            }
        }
        return null;
    }

    public void displayallMembers(){
        for(Member member : allMembers){
            member.DisplayProfile();
        }
    }

    public void issueBook(long memberId, long bookId) {
        Member member = searchMember(memberId);
        if (member == null) {
            System.out.println("Member not found.");
            return;
        }

        Book book = searchByBookId(bookId);
        if (book == null) {
            System.out.println("Book not found.");
            return;
        }

        if (!book.isAvail()) {
            System.out.println("Book is currently not available.");
            return;
        }

        if (!member.canBorrow()) {
            System.out.println("Borrowing limit exceeded. Member cannot borrow more books.");
            return;
        }

        book.BorrowBook(member);
        member.BorrowBook(book);

        String transactionId = "TXN-" + System.currentTimeMillis();
        Transaction transaction = new Transaction(transactionId, book, member, java.time.LocalDate.now());
        allTransactions.add(transaction);

        System.out.println("Book issued successfully. Transaction ID: " + transactionId);
    }

    public void returnBook(long memberId, long bookId) {
        Transaction actualTransaction = null;
        for (Transaction t : allTransactions) {
            if (!t.isReturned() && t.getMember().getUserid() == memberId && t.getBook().getBookid() == bookId) {
                actualTransaction = t;
                break;
            }
        }

        if (actualTransaction == null) {
            System.out.println("No active transaction found for this member and book.");
            return;
        }

        Book book = actualTransaction.getBook();
        Member member = actualTransaction.getMember();

        book.returnBook();
        member.ReturnBook(book);
        actualTransaction.closeTransaction();

        System.out.println("Book returned successfully.");
    }

    public void displayTransactions() {
        if (allTransactions.isEmpty()) {
            System.out.println("No transactions found.");
            return;
        }
        for (Transaction t : allTransactions) {
            t.DisplayTransaction();
            System.out.println("-------------------------");
        }
    }

    public void displayActiveTransactions() {
        boolean found = false;
        for (Transaction t : allTransactions) {
            if (!t.isReturned()) {
                t.DisplayTransaction();
                System.out.println("-------------------------");
                found = true;
            }
        }
        if (!found) {
            System.out.println("No active transactions.");
        }
    }

    public void displayReturnedTransactions() {
        boolean found = false;
        for (Transaction t : allTransactions) {
            if (t.isReturned()) {
                t.DisplayTransaction();
                System.out.println("-------------------------");
                found = true;
            }
        }
        if (!found) {
            System.out.println("No returned transactions.");
        }
    }

    public int totalBooks() {
        return allBooks.size();
    }

    public int totalMembers() {
        return allMembers.size();
    }

    public int availableBooks() {
        int count = 0;
        for (Book book : allBooks) {
            if (book.isAvail()) {
                count++;
            }
        }
        return count;
    }

    public int borrowedBooks() {
        int count = 0;
        for (Book book : allBooks) {
            if (!book.isAvail()) {
                count++;
            }
        }
        return count;
    }

    public int totalTransactions() {
        return allTransactions.size();
    }
}