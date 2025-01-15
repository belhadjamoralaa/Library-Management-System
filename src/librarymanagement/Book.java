package librarymanagement;

public abstract class Book {
    private static int counter = 0;
    protected int id;
    protected String title;
    protected String author;
    protected int totalAvailable;

    public Book(String title, String author, int totalAvailable) {
        this.id = ++counter;
        this.title = title;
        this.author = author;
        this.totalAvailable = totalAvailable;
    }

    public abstract double getPrice();

    public void updateAvailability(boolean isBorrowing) {
        if (isBorrowing) {
            if (totalAvailable > 0) {
                totalAvailable--;
            }
        } else {
            totalAvailable++;
        }
    }

    public int getId() { return id; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public int getTotalAvailable() { return totalAvailable; }

    @Override
    public String toString() {
        return "ID: " + id + " | Titre: " + title + " | Auteur: " + author + 
               " | Disponible: " + totalAvailable;
    }
}
