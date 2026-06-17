package com.Library;

import com.Library.model.Book;
import com.Library.model.Member;
import com.Library.service.Library;
import com.Library.util.InputValidator;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();

        while (true) {
            System.out.println("\n================================");
            System.out.println("   Library Management System    ");
            System.out.println("================================");
            System.out.println("1. Add Book");
            System.out.println("2. Remove Book");
            System.out.println("3. Update Book");
            System.out.println("4. Search Book");
            System.out.println("5. Display All Books");
            System.out.println("6. Register Member");
            System.out.println("7. Remove Member");
            System.out.println("8. Display Members");
            System.out.println("9. Issue Book");
            System.out.println("10. Return Book");
            System.out.println("11. View Transactions");
            System.out.println("12. Statistics");
            System.out.println("13. Exit");
            System.out.print("Enter your choice: ");
            
            int choice = InputValidator.getInteger();

            switch (choice) {
                case 1:
                    System.out.print("Enter Book ID: ");
                    long bookId = InputValidator.getLong();
                    System.out.print("Enter Title: ");
                    String title = InputValidator.getString();
                    System.out.print("Enter Author: ");
                    String author = InputValidator.getString();
                    library.addBook(new Book(bookId, title, author, LocalDate.now()));
                    System.out.println("Book added successfully!");
                    break;
                case 2:
                    System.out.print("Enter Book ID to remove: ");
                    long removeBookId = InputValidator.getLong();
                    library.removeBook(removeBookId);
                    System.out.println("Book removed successfully!");
                    break;
                case 3:
                    System.out.print("Enter Book ID to update: ");
                    long updateBookId = InputValidator.getLong();
                    System.out.print("Enter new Title: ");
                    String newTitle = InputValidator.getString();
                    System.out.print("Enter new Author: ");
                    String newAuthor = InputValidator.getString();
                    if (library.updateBook(updateBookId, newTitle, newAuthor)) {
                        System.out.println("Book updated successfully!");
                    } else {
                        System.out.println("Book not found.");
                    }
                    break;
                case 4:
                    System.out.println("1 Search by ID");
                    System.out.println("2 Search by Title");
                    System.out.println("3 Search by Author");
                    System.out.print("Select search type: ");
                    int searchChoice = InputValidator.getInteger();
                    if (searchChoice == 1) {
                        System.out.print("Enter Book ID: ");
                        Book b = library.searchByBookId(InputValidator.getLong());
                        if (b != null) b.DisplayDetails(); else System.out.println("Not found.");
                    } else if (searchChoice == 2) {
                        System.out.print("Enter Title: ");
                        Book b = library.searchByTitle(InputValidator.getString());
                        if (b != null) b.DisplayDetails(); else System.out.println("Not found.");
                    } else if (searchChoice == 3) {
                        // We skipped author search method in library, simple title search fallback for now or we can implement it.
                        System.out.println("Search by author not yet implemented fully. Feature coming soon.");
                    }
                    break;
                case 5:
                    library.displayAllbooks();
                    break;
                case 6:
                    System.out.print("Enter Member User ID: ");
                    long userId = InputValidator.getLong();
                    System.out.print("Enter Name: ");
                    String name = InputValidator.getString();
                    System.out.print("Enter Membership ID: ");
                    String membershipId = InputValidator.getString();
                    library.addMember(new Member(userId, name, membershipId));
                    System.out.println("Member registered successfully!");
                    break;
                case 7:
                    System.out.print("Enter Member User ID to remove: ");
                    long removeUserId = InputValidator.getLong();
                    Member m = library.searchMember(removeUserId);
                    if (m != null) {
                        library.removeMember(m);
                        System.out.println("Member removed.");
                    } else {
                        System.out.println("Member not found.");
                    }
                    break;
                case 8:
                    library.displayallMembers();
                    break;
                case 9:
                    System.out.print("Enter Member ID: ");
                    long issueMemberId = InputValidator.getLong();
                    System.out.print("Enter Book ID: ");
                    long issueBookId = InputValidator.getLong();
                    library.issueBook(issueMemberId, issueBookId);
                    break;
                case 10:
                    System.out.print("Enter Member ID: ");
                    long returnMemberId = InputValidator.getLong();
                    System.out.print("Enter Book ID: ");
                    long returnBookId = InputValidator.getLong();
                    library.returnBook(returnMemberId, returnBookId);
                    break;
                case 11:
                    System.out.println("1. All Transactions");
                    System.out.println("2. Active Transactions");
                    System.out.println("3. Returned Transactions");
                    System.out.print("Select type: ");
                    int txChoice = InputValidator.getInteger();
                    if (txChoice == 1) library.displayTransactions();
                    else if (txChoice == 2) library.displayActiveTransactions();
                    else if (txChoice == 3) library.displayReturnedTransactions();
                    break;
                case 12:
                    System.out.println("=== Statistics ===");
                    System.out.println("Total Books: " + library.totalBooks());
                    System.out.println("Available Books: " + library.availableBooks());
                    System.out.println("Issued Books: " + library.borrowedBooks());
                    System.out.println("Members: " + library.totalMembers());
                    System.out.println("Transactions: " + library.totalTransactions());
                    break;
                case 13:
                    System.out.println("Exiting System...");
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
