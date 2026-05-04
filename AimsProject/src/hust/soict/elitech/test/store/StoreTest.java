package hust.soict.elitech.test.store;

import hust.soict.elitech.aims.media.DigitalVideoDisc;
import hust.soict.elitech.aims.store.Store;

public class StoreTest {
    public static void main(String[] args) {
        Store store = new Store();

        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);

        System.out.println("==== TESTING ADD METHOD ====");
        store.addDVD(dvd1);
        store.addDVD(dvd2);
        store.addDVD(dvd3);

        System.out.println("\n==== TESTING REMOVE METHOD ====");
        store.removeDVD(dvd2); // Kết quả mong đợi: Xóa thành công Star Wars

        // Thử xóa lại chính đĩa đó (đã bị xóa rồi)
        store.removeDVD(dvd2); // Kết quả mong đợi: Thông báo không tìm thấy đĩa

        // Thử xóa một đĩa chưa từng được thêm vào cửa hàng
        DigitalVideoDisc dvd4 = new DigitalVideoDisc("Avatar", "Science Fiction", 20.0f);
        store.removeDVD(dvd4); // Kết quả mong đợi: Thông báo không tìm thấy đĩa
    }
}
