/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Phạm Minh Hùng
 */
package hust.soict.elitech.aims.cart;

import java.util.ArrayList;
import java.util.Collections;

import hust.soict.elitech.aims.media.Media;

public class Cart {
    // Thay đổi từ mảng DigitalVideoDisc[] sang ArrayList<Media>
    private ArrayList<Media> itemsOrdered = new ArrayList<Media>();

    // Không cần biến qtyOrdered nữa vì ArrayList có hàm .size()

    public Cart() {
    }

    // Phương thức thêm Media bất kỳ (Book, CD, DVD đều dùng được)
     // Phương thức thêm Media và đếm số DVD nếu đối tượng là DVD
    public void addMedia(Media media) {
        if (!itemsOrdered.contains(media)) {
            itemsOrdered.add(media);
            System.out.println("The media has been added to the cart.");
            
            // BỔ SUNG: Kiểm tra nếu là DVD thì in ra số lượng DVD hiện có
            if (media instanceof hust.soict.elitech.aims.media.DigitalVideoDisc) {
                System.out.println("Number of DVDs in cart: " + countDVDs());
            }
        } else {
            System.out.println("The media is already in the cart.");
        }
    }
    // Hàm phụ để đếm số lượng DVD (Dùng cho yêu cầu ex 18)
    private int countDVDs() {
        int count = 0;
        for (Media m : itemsOrdered) {
            if (m instanceof hust.soict.elitech.aims.media.DigitalVideoDisc) {
                count++;
            }
        }
        return count;
    }


    // Phương thức xóa Media khỏi giỏ hàng
    public void removeMedia(Media media) {
        if (itemsOrdered.contains(media)) {
            itemsOrdered.remove(media);
            System.out.println("The media has been removed from the cart.");
        } else {
            System.out.println("The media was not found in the cart.");
        }
    }

    //ex17
    // PHƯƠNG THỨC SẮP XẾP THEO TIÊU ĐỀ
    public void sortByTitle() {
        // Sử dụng Collections.sort và truyền vào bộ so sánh đã định nghĩa ở lớp Media
        Collections.sort(itemsOrdered, Media.COMPARE_BY_TITLE_COST);
        System.out.println("The cart has been sorted by title.");
        
    }
     // PHƯƠNG THỨC SẮP XẾP THEO GIÁ
    public void sortByCost() {
        Collections.sort(itemsOrdered, Media.COMPARE_BY_COST_TITLE);
        System.out.println("The cart has been sorted by cost.");
        // this.print();
    }

    // Tính tổng tiền cho tất cả các loại media trong giỏ
    public float totalCost() {
        float total = 0;
        for (Media media : itemsOrdered) {
            total += media.getCost();
        }
        return total;
    }

    // Phương thức in giỏ hàng (bổ sung để kiểm tra)
    public void print() {
        System.out.println("***********************CART***********************");
        System.out.println("Ordered Items:");
        int i = 1;
        for (Media media : itemsOrdered) {
            System.out.println(i + ". " + media.toString());
            i++;
        }
        System.out.println("Total cost: " + totalCost() + " $");
        System.out.println("***************************************************");
    }
    // Tìm kiếm sản phẩm trong giỏ hàng theo ID
    public void searchById(int id) {
        boolean found = false;
        for (Media media : itemsOrdered) {
            if (media.getId() == id) {
                System.out.println("Found match: " + media.toString());
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("No media found with ID: " + id);
        }
    }

    // Tìm kiếm sản phẩm trong giỏ hàng theo tiêu đề (Title)
    public void searchByTitle(String title) {
        boolean found = false;
        for (Media media : itemsOrdered) {
            // Sử dụng toLowerCase().contains() để tìm kiếm tương đối (không phân biệt hoa thường)
            if (media.getTitle().toLowerCase().contains(title.toLowerCase())) {
                System.out.println("Found match: " + media.toString());
                found = true;
            }
        }
        if (!found) {
            System.out.println("No media found with title: " + title);
        }
    }
}