package librarymanagement;

public class LibraryMenu {
    private Library library;

    public LibraryMenu(Library library) {
        this.library = library;
    }

    public void displayMenu() {
        System.out.println("\n=== Système de Gestion de Bibliothèque ===");
        System.out.println("1. Ajouter un livre");
        System.out.println("2. Ajouter un membre");
        System.out.println("3. Emprunter un livre");
        System.out.println("4. Retourner un livre");
        System.out.println("5. Afficher tous les livres");
        System.out.println("6. Afficher tous les membres");
        System.out.println("7. Quitter");
    }

    public void processChoice(int choice) {
        switch (choice) {
            case 1 -> {
                Book book = InputManager.createBook();
                library.addBook(book);
                System.out.println("Livre ajouté avec succès!");
            }
            case 2 -> {
                Member member = InputManager.createMember();
                library.addMember(member);
                System.out.println("Membre ajouté avec succès!");
            }
            case 3 -> {
                System.out.println("ID du membre: ");
                int memberId = InputManager.getMenuChoice();
                System.out.println("ID du livre: ");
                int bookId = InputManager.getMenuChoice();
                
                Member member = library.findMemberById(memberId);
                Book book = library.findBookById(bookId);
                
                if (member != null && book != null) {
                    if (member.borrowBook(book)) {
                        System.out.println("Livre emprunté avec succès!");
                    }
                } else {
                    System.out.println("Membre ou livre non trouvé!");
                }
            }
            case 4 -> {
                System.out.println("ID du membre: ");
                int memberId = InputManager.getMenuChoice();
                System.out.println("ID du livre: ");
                int bookId = InputManager.getMenuChoice();
                
                Member member = library.findMemberById(memberId);
                Book book = library.findBookById(bookId);
                
                if (member != null && book != null) {
                    if (member.returnBook(book)) {
                        System.out.println("Livre retourné avec succès!");
                    } else {
                        System.out.println("Ce membre n'a pas emprunté ce livre!");
                    }
                } else {
                    System.out.println("Membre ou livre non trouvé!");
                }
            }
            case 5 -> {
                System.out.println("\nListe des livres:");
                for (int i = 0; i < library.getBookCount(); i++) {
                    System.out.println(library.getBooks()[i]);
                }
            }
            case 6 -> {
                System.out.println("\nListe des membres:");
                for (int i = 0; i < library.getMemberCount(); i++) {
                    System.out.println(library.getMembers()[i]);
                }
            }
            case 7 -> System.out.println("Au revoir!");
            default -> System.out.println("Choix invalide!");
        }
    }

    public void run() {
        int choice;
        do {
            displayMenu();
            choice = InputManager.getMenuChoice();
            processChoice(choice);
        } while (choice != 7);
    }
}
