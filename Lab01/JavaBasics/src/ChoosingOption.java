/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Phạm Minh Hùng
 */
import javax.swing.JOptionPane;

public class ChoosingOption {
    public static void main(String[] args) {
        int option = JOptionPane.showConfirmDialog(
                null,
                "Do you want to change to the first class ticket?"
        );

        JOptionPane.showMessageDialog(
                null,
                "You've chosen: " + (option == JOptionPane.YES_OPTION ? "Yes" : "No")
        );

        System.exit(0);
    }
}
