/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Phạm Minh Hùng
 */
package hust.soict.elitech.test.cart;

import hust.soict.elitech.aims.cart.Cart;
import hust.soict.elitech.aims.disc.DigitalVideoDisc;
public class CartTest {
    public static void main(String[] args) {
        // Create a new cart
        Cart cart = new Cart();

        // Create new dvd objects and add them to the cart
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        cart.addDigitalVideoDisc(dvd1);

        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        cart.addDigitalVideoDisc(dvd2);

        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
        cart.addDigitalVideoDisc(dvd3);

        // Test the print method
        cart.print();

        // To-do: Test the search methods here
        
        // Test Search By ID (Có tồn tại và Không tồn tại)
        System.out.println("\nTesting Search By ID:");
        cart.searchById(2); // Thử tìm ID 2 (Star Wars)
        cart.searchById(998); // Thử tìm ID không tồn tại

        // Test Search By Title (Có tồn tại và Không tồn tại)
        System.out.println("\nTesting Search By Title:");
        cart.searchByTitle("Lion"); // Tìm bằng 1 từ khóa đúng
        cart.searchByTitle("Aladin"); // Tìm bằng tên chính xác
        cart.searchByTitle("Avatar"); // Tìm đĩa không có trong giỏ
    }
}