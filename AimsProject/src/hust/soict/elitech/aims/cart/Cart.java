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
import hust.soict.elitech.aims.disc.DigitalVideoDisc;
public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    private DigitalVideoDisc itemOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
    private int qtyOrdered = 0;

    public void addDigitalVideoDisc(DigitalVideoDisc disc) {
        if (qtyOrdered < 20) {
            itemOrdered[qtyOrdered] = disc;
            qtyOrdered++;
            System.out.println("The disc has been added");
        } else {
            System.out.println("The cart is almost full");
        }
    }

    public void addDigitalVideoDisc(DigitalVideoDisc[] dvdList) {
        for (DigitalVideoDisc dvd : dvdList) {
            addDigitalVideoDisc(dvd);
        }
    }

    public void addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
        addDigitalVideoDisc(dvd1);
        addDigitalVideoDisc(dvd2);
    }

    public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
        for (int i = 0; i < qtyOrdered; i++) {
            if (itemOrdered[i] == disc) {
                for (int j = i; j < qtyOrdered - 1; j++) {
                    itemOrdered[j] = itemOrdered[j + 1];
                }
                qtyOrdered--;
                itemOrdered[qtyOrdered] = null;
                System.out.println("The disc has been removed");
                return;
            }
        }
    }

    public float totalCost() {
        float total = 0;
        for (int i = 0; i < qtyOrdered; i++) {
            total += itemOrdered[i].getCost();
        }
        return total;
    }

    public void print() {
        System.out.println("*************** CART ***************");
        System.out.println("Ordered items: ");
        double totalCost = 0;
        for (int i = 0; i < qtyOrdered; i++) {
            DigitalVideoDisc disc = itemOrdered[i];
            System.out.println((i + 1) + ". DVD - " + disc.toString());
            totalCost += disc.getCost();
        }
        System.out.println("Total cost: " + totalCost + " USD");
        System.out.println("************************************");
    }

    public void searchById(int id) {
        for (int i = 0; i < qtyOrdered; i++) {
            if (itemOrdered[i].getId() == id) {
                System.out.println("DVD found: " + itemOrdered[i].toString());
                return;
            }
        }
        System.out.println("No DVD found with ID: " + id);
    }

    public void searchByTitle(String title) {
        boolean found = false;
        for (int i = 0; i < qtyOrdered; i++) {
            if (itemOrdered[i].isMatch(title)) {
                System.out.println("DVD found: " + itemOrdered[i].toString());
                found = true;
            }
        }
        if (!found) {
            System.out.println("No DVD found with ID: " + title);
        }
    }
}