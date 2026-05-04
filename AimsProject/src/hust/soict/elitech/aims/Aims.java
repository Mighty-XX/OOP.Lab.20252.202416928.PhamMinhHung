/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Phạm Minh Hùng
 */
package hust.soict.elitech.aims;

import java.util.Scanner;
import hust.soict.elitech.aims.cart.Cart;
import hust.soict.elitech.aims.media.*;
import hust.soict.elitech.aims.store.Store;

public class Aims {
    private static Store store = new Store();
    private static Cart cart = new Cart();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // 1. Khởi tạo dữ liệu mẫu cho cửa hàng
        initData();

        // 2. Vòng lặp chính của chương trình
        int choice;
        while (true) {
            showMenu();
            choice = scanner.nextInt();
            scanner.nextLine(); // Xóa bộ đệm sau khi nhập số

            switch (choice) {
                case 1:
                    viewStore();
                    break;
                case 2:
                    updateStore();
                    break;
                case 3:
                    viewCart();
                    break;
                case 0:
                    System.out.println("Thanks for using AIMS. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    // --- CÁC PHƯƠNG THỨC HIỂN THỊ MENU (Theo yêu cầu đề bài) ---
    public static void showMenu() {
        System.out.println("\nAIMS: ");
        System.out.println("--------------------------------");
        System.out.println("1. View store");
        System.out.println("2. Update store");
        System.out.println("3. See current cart");
        System.out.println("0. Exit");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number: 0-1-2-3: ");
    }

    public static void storeMenu() {
        System.out.println("\nOptions: ");
        System.out.println("--------------------------------");
        System.out.println("1. See a media's details");
        System.out.println("2. Add a media to cart");
        System.out.println("3. Play a media");
        System.out.println("4. See current cart");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number: 0-1-2-3-4: ");
    }

    public static void mediaDetailsMenu() {
        System.out.println("\nOptions: ");
        System.out.println("--------------------------------");
        System.out.println("1. Add to cart");
        System.out.println("2. Play");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number: 0-1-2: ");
    }

    public static void cartMenu() {
        System.out.println("\nOptions: ");
        System.out.println("--------------------------------");
        System.out.println("1. Filter media in cart");
        System.out.println("2. Sort media in cart");
        System.out.println("3. Remove media from cart");
        System.out.println("4. Play a media");
        System.out.println("5. Place order");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number: 0-1-2-3-4-5: ");
    }

    // --- LOGIC XỬ LÝ CHI TIẾT ---

    // Chức năng 1: Xem cửa hàng
    public static void viewStore() {
        store.printStore(); 
        int choice;
        while (true) {
            storeMenu();
            choice = scanner.nextInt();
            scanner.nextLine();
            if (choice == 0) break;

            switch (choice) {
                case 1: seeMediaDetails(); break;
                case 2: addMediaToCart(); break;
                case 3: playMedia(); break;
                case 4: viewCart(); break;
                default: System.out.println("Invalid choice.");
            }
        }
    }

    // Xem chi tiết một Media
    public static void seeMediaDetails() {
        System.out.print("Enter the title of the media: ");
        String title = scanner.nextLine();
        Media media = store.searchByTitle(title); 
        
        if (media != null) {
            System.out.println(media.toString());
            int choice;
            while (true) {
                mediaDetailsMenu();
                choice = scanner.nextInt();
                scanner.nextLine();
                if (choice == 0) break;
                if (choice == 1) cart.addMedia(media);
                else if (choice == 2) {
                    if (media instanceof Playable) ((Playable) media).play();
                    else System.out.println("This media cannot be played!");
                }
            }
        } else {
            System.out.println("Media not found!");
        }
    }

    // Thêm vào giỏ hàng
    public static void addMediaToCart() {
        System.out.print("Enter the title to add: ");
        String title = scanner.nextLine();
        Media media = store.searchByTitle(title);
        if (media != null) {
            cart.addMedia(media);
        } else {
            System.out.println("Media not found!");
        }
    }

    // Chức năng "Play"
    public static void playMedia() {
        System.out.print("Enter the title to play: ");
        String title = scanner.nextLine();
        Media media = store.searchByTitle(title);
        if (media != null && media instanceof Playable) {
            ((Playable) media).play();
        } else {
            System.out.println("Cannot play this media!");
        }
    }

    // Chức năng 3: Xem giỏ hàng
    public static void viewCart() {
        cart.print();
        int choice;
        while (true) {
            cartMenu();
            choice = scanner.nextInt();
            scanner.nextLine();
            if (choice == 0) break;

            switch (choice) {
                case 1: // Filter media in cart
                System.out.println("Filtering options: ");
                System.out.println("1. Filter by ID");
                System.out.println("2. Filter by Title");
                System.out.print("Your choice: ");
                int filterChoice = scanner.nextInt();
                scanner.nextLine(); // Clear buffer

                if (filterChoice == 1) {
                    System.out.print("Please enter the ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    cart.searchById(id); // Gọi hàm searchById đã có trong Cart của bạn
                } else if (filterChoice == 2) {
                    System.out.print("Please enter the Title: ");
                    String title = scanner.nextLine();
                    cart.searchByTitle(title); // Gọi hàm searchByTitle đã có trong Cart của bạn
                } else {
                    System.out.println("Invalid option!");
                }
                break;
                case 2: // Sort
                    System.out.println("1. By Title, 2. By Cost");
                    int s = scanner.nextInt();
                    if (s==1) cart.sortByTitle(); else cart.sortByCost();
                    cart.print();
                    break;
                case 3: // Remove
                    System.out.print("Title to remove: ");
                    Media m = store.searchByTitle(scanner.nextLine());
                    if (m != null) cart.removeMedia(m);
                    break;
                case 4: playMedia(); break;
                case 5: 
                    System.out.println("An order has been created! Cart is now empty.");
                    cart = new Cart(); // Làm trống giỏ hàng
                    return; 
                default: System.out.println("Invalid choice.");
            }
        }
    }

    // Chức năng 2: Cập nhật Store (Thêm/Xóa sản phẩm khỏi Store)
    public static void updateStore() {
    System.out.println("\nUpdate Store Options: ");
    System.out.println("--------------------------------");
    System.out.println("1. Add a Media to store");
    System.out.println("2. Remove a Media from store");
    System.out.println("0. Back");
    System.out.print("Please choose: ");
    
    int updateChoice = scanner.nextInt();
    scanner.nextLine(); // Clear buffer

    if (updateChoice == 1) {
        // LOGIC THÊM MEDIA MỚI
        System.out.println("Choose media type: 1. DVD, 2. CD, 3. Book");
        int type = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter Title: ");
        String title = scanner.nextLine();
        System.out.print("Enter Category: ");
        String category = scanner.nextLine();
        System.out.print("Enter Cost: ");
        float cost = scanner.nextFloat();
        scanner.nextLine();

        if (type == 1) { // Thêm DVD
            System.out.print("Enter Director: ");
            String director = scanner.nextLine();
            System.out.print("Enter Length: ");
            int length = scanner.nextInt();
            scanner.nextLine();
            store.addMedia(new DigitalVideoDisc(title, category, director, length, cost));
        } 
        else if (type == 2) { // Thêm CD
            System.out.print("Enter Artist: ");
            String artist = scanner.nextLine();
            System.out.print("Enter Director: ");
            String director = scanner.nextLine();
            System.out.print("Enter Length: ");
            int length = scanner.nextInt();
            scanner.nextLine();
            // Khớp với constructor bạn đã định nghĩa ở các câu trước
            store.addMedia(new CompactDisc(title, category, artist, director, length, cost));
        } 
        else if (type == 3) { // Thêm Book
            store.addMedia(new Book(title, category, cost));
            System.out.println("Note: Authors can be added later via Book class methods.");
        }
    } 
    else if (updateChoice == 2) {
        // LOGIC XÓA MEDIA
        System.out.print("Enter the title of the media you want to remove: ");
        String title = scanner.nextLine();
        Media media = store.searchByTitle(title);
        if (media != null) {
            store.removeMedia(media);
        } else {
            System.out.println("Media not found in store!");
        }
    }
}

    private static void initData() {
        store.addMedia(new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f));
        store.addMedia(new DigitalVideoDisc("Star Wars", "Sci-Fi", "George Lucas", 124, 24.95f));
        store.addMedia(new Book("Java Programming", "Education", 45.0f));
    }
}