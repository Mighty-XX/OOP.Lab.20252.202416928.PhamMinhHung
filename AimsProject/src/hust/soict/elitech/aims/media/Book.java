package hust.soict.elitech.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book extends Media {
    // Xóa id, title, category, cost vì đã kế thừa từ Media
    private List<String> authors = new ArrayList<String>();

    public Book() {
        super(); // Gọi constructor của Media
    }

    public List<String> getAuthors() {
        return authors;
    }

    public void addAuthor(String authorName) {
        if (!authors.contains(authorName)) {
            authors.add(authorName);
        }
    }

    public void removeAuthor(String authorName) {
        if (authors.contains(authorName)) {
            authors.remove(authorName);
        }
    }
}