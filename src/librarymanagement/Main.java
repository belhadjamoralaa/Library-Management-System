package librarymanagement;

public class Main {
    public static void main(String[] args) {
        Library library = Library.getInstance();

        // Initialize some books
        Book book1 = BookFactory.createBook("physical", "Le Petit Prince", "Antoine de Saint-Exupéry", 3, 15.99);
        Book book2 = BookFactory.createBook("physical", "Les Misérables", "Victor Hugo", 2, 19.99);
        Book book3 = BookFactory.createBook("ebook", "Dom Juan", "Molière", 0, 0);

        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);

        // Initialize some members
        Member member1 = MemberFactory.createMember("Jean Dupont", "code", 0.2); // 20% discount
        Member member2 = MemberFactory.createMember("Marie Martin", "fixed", 5.0); // 5€ fixed discount

        library.addMember(member1);
        library.addMember(member2);

        // Start the menu
        LibraryMenu menu = new LibraryMenu(library);
        menu.run();
    }
}