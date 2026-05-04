package hust.soict.elitech.garbage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class GarbageCreator {
    public static void main(String[] args) {
        String filename = "test.exe"; 
        byte[] inputBytes = { 0 };
        long startTime, endTime;

        try {
            // Đọc toàn bộ nội dung file vào mảng byte
            inputBytes = Files.readAllBytes(Paths.get(filename));
            
            startTime = System.currentTimeMillis();
            
            // CÁCH LÀM XẤU: Sử dụng toán tử "+" trong vòng lặp
            String outputString = "";
            for (byte b : inputBytes) {
                outputString += (char)b;
            }
            
            endTime = System.currentTimeMillis();
            System.out.println("Time with + operator: " + (endTime - startTime) + " ms");
            
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }
}