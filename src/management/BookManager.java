package management;
import datastructures.maps.CustomHashMap;
import library.Book;
import library.Member;

public class BookManager {

    private CustomHashMap<String, Book> booksMap;
    private MemberManager memberManager;

    public BookManager(MemberManager memberManager) {

        this.booksMap = new CustomHashMap<>();
        this.memberManager = memberManager;
    }

    public void addBook(Book book) {
        if (book == null) {
            throw new IllegalArgumentException();
        }
        String isbn = book.getIsbn();
        if (booksMap.containsKey(isbn)) {
            throw new IllegalArgumentException();
        }
        booksMap.put(isbn, book);
    }

    public Book getBookByIsbn(String isbn) {
        return booksMap.get(isbn);
    }

    public boolean isBookAvailable(String isbn) {
        Book book = booksMap.get(isbn);
        if (book == null) {
            throw new IllegalArgumentException();
        }
        return book.isAvailable();
    }

    public void setBookAvailability(String isbn, boolean available) {
        Book book = booksMap.get(isbn);
        if (book == null) {
            throw new IllegalArgumentException();
        }
        book.setAvailable(available);
    }

    public void addToWaitlist(String isbn, String memberId) {
        Book book = booksMap.get(isbn);
        if (book == null) {
            throw new IllegalArgumentException();
        }
        Member member = memberManager.getMember(memberId);
        if (member == null) {
            throw new IllegalArgumentException();
        }
        book.addToWaitlist(member);
    }

    public Member getNextFromWaitlist(String isbn) {
        Book book = booksMap.get(isbn);
        if (book == null) {
            throw new IllegalArgumentException();
        }
        return book.getNextInWaitlist();
    }

    public boolean hasWaitlist(String isbn) {
        Book book = booksMap.get(isbn);
        if (book == null) {
            throw new IllegalArgumentException();
        }
        return book.hasWaitlist();
    }
}