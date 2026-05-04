package hust.soict.elitech.test.media;

import java.util.ArrayList;
import java.util.List;
import hust.soict.elitech.aims.media.*; // Import các lớp Media, CD, DVD, Book từ package aims.media
// for ex16
public class MediaTest {
    public static void main(String[] args) {
        // 1. Tạo danh sách kiểu Media
        List<Media> mediae = new ArrayList<Media>();

        // 2. Tạo các đối tượng 
        CompactDisc cd = new CompactDisc("Greatest Hits", "Music", "Justin Bieber", "Director X", 45, 18.95f);
        Media dvd = new DigitalVideoDisc("Inception", "Sci-Fi", 20.0f);
        Media book = new Book("Java Programming", "Education", 10.0f);

        // 3. Thêm vào danh sách
        mediae.add(cd);
        mediae.add(dvd);
        mediae.add(book);

        // 4. Duyệt và in ra (Sẽ gọi toString() của từng lớp con nhờ Đa hình)
        System.out.println("\n--- Testing Polymorphism with toString() ---");
        for (Media m : mediae) {
            System.out.println(m.toString());
        }
    }
}
