package hust.soict.elitech.aims.store;

import java.util.ArrayList;
import hust.soict.elitech.aims.media.Media;

public class Store {
    // Thay đổi từ mảng Media[] sang ArrayList<Media>
    private ArrayList<Media> itemsInStore = new ArrayList<Media>();

    public Store() {
    }

    // Thay thế addDigitalVideoDisc bằng addMedia
    public void addMedia(Media media) {
        if (!itemsInStore.contains(media)) {
            itemsInStore.add(media);
            System.out.println("The media '" + media.getTitle() + "' has been added to the store.");
        } else {
            System.out.println("The media '" + media.getTitle() + "' is already in the store.");
        }
    }

    // Thay thế removeDigitalVideoDisc bằng removeMedia
    public void removeMedia(Media media) {
        if (itemsInStore.contains(media)) {
            itemsInStore.remove(media);
            System.out.println("The media '" + media.getTitle() + "' has been removed from the store.");
        } else {
            System.out.println("The media '" + media.getTitle() + "' was not found in the store.");
        }
    }

    // Phương thức bổ sung: Hiển thị danh sách sản phẩm đang có trong cửa hàng
    public void printStore() {
        System.out.println("\n*********************** STORE ***********************");
        System.out.println("Items currently in store:");
        if (itemsInStore.isEmpty()) {
            System.out.println("The store is empty.");
        } else {
            int i = 1;
            for (Media media : itemsInStore) {
                System.out.println(i + ". " + media.toString());
                i++;
            }
        }
        System.out.println("*****************************************************\n");
    }

    // Phương thức bổ sung: Lấy danh sách sản phẩm (dùng cho menu AIMS sau này)
    public ArrayList<Media> getItemsInStore() {
        return itemsInStore;
    }
    // ex18
    public Media searchByTitle(String title) {
        for (Media media : itemsInStore) {
            // So sánh không phân biệt hoa thường để người dùng dễ nhập liệu
            if (media.getTitle().equalsIgnoreCase(title)) {
                return media; // Trả về đối tượng tìm thấy
            }
        }
        return null; // Trả về null nếu không tìm thấy
    }
}