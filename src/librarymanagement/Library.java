package librarymanagement;

public class Library implements Subject {
    private static Library instance;
    private Book[] books;
    private Member[] members;
    private Observer[] observers;
    private int bookCount;
    private int memberCount;
    private int observerCount;
    private static final int MAX_BOOKS = 100;
    private static final int MAX_MEMBERS = 50;
    private static final int MAX_OBSERVERS = 50;

    private Library() {
        books = new Book[MAX_BOOKS];
        members = new Member[MAX_MEMBERS];
        observers = new Observer[MAX_OBSERVERS];
        bookCount = 0;
        memberCount = 0;
        observerCount = 0;
    }

    public static Library getInstance() {
        if (instance == null) {
            instance = new Library();
        }
        return instance;
    }

    public void addBook(Book book) {
        if (bookCount < MAX_BOOKS) {
            books[bookCount++] = book;
            notifyObservers(book);
        }
    }

    public void addMember(Member member) {
        if (memberCount < MAX_MEMBERS) {
            members[memberCount++] = member;
            attach(member);
        }
    }

    @Override
    public void attach(Observer observer) {
        if (observerCount < MAX_OBSERVERS) {
            observers[observerCount++] = observer;
        }
    }

    @Override
    public void detach(Observer observer) {
        for (int i = 0; i < observerCount; i++) {
            if (observers[i] == observer) {
                for (int j = i; j < observerCount - 1; j++) {
                    observers[j] = observers[j + 1];
                }
                observers[--observerCount] = null;
                break;
            }
        }
    }

    @Override
    public void notifyObservers(Book book) {
        for (int i = 0; i < observerCount; i++) {
            observers[i].update(book);
        }
    }

    public Book[] getBooks() { return books; }
    public Member[] getMembers() { return members; }
    public int getBookCount() { return bookCount; }
    public int getMemberCount() { return memberCount; }

    public Book findBookById(int id) {
        for (int i = 0; i < bookCount; i++) {
            if (books[i].getId() == id) {
                return books[i];
            }
        }
        return null;
    }

    public Member findMemberById(int id) {
        for (int i = 0; i < memberCount; i++) {
            if (members[i].getId() == id) {
                return members[i];
            }
        }
        return null;
    }
}
