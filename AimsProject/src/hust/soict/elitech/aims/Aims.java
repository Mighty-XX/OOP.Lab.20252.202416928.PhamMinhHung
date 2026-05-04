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
import hust.soict.elitech.aims.cart.Cart;
import hust.soict.elitech.aims.media.DigitalVideoDisc;
public class Aims {
    public static void main(String[] args) {
        Cart anOrder = new Cart();

        //
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);

        anOrder.addMedia(dvd1);
        anOrder.addMedia(dvd2);
        anOrder.addMedia(dvd3);

        System.out.println("Total cost is: " + anOrder.totalCost());

        anOrder.removeMedia(dvd1);
        System.out.println("Total cost is: " + anOrder.totalCost());
    }
}