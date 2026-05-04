package hust.soict.elitech.garbage;

import java.io.FileOutputStream;
import java.io.IOException;

public class CreateTestFile {
    public static void main(String[] args) {
        String filename = "test.exe";
        // Tạo file khoảng 10MB dữ liệu rác
        byte[] content = new byte[10 * 1024 * 1024]; 
        try (FileOutputStream fos = new FileOutputStream(filename)) {
            fos.write(content);
            System.out.println("Đã tạo file test.exe thành công!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
