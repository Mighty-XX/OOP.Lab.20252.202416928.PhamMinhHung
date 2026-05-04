package hust.soict.elitech.aims.media;

public class Track implements Playable {
    private String title;
    private int length;

    public Track(String title, int length) {
        this.title = title;
        this.length = length;
    }

    public String getTitle() { return title; }
    public int getLength() { return length; }

    // Triển khai hàm play() cho Track
    @Override
    public void play() {
        System.out.println("Playing track: " + this.getTitle());
        System.out.println("Track length: " + this.getLength());
    }

    
    @Override
    public boolean equals(Object obj) {
        // 1. Kiểm tra tham chiếu
        if (this == obj) {
            return true;
        }

        // 2. Kiểm tra kiểu dữ liệu
        if (!(obj instanceof Track)) {
            return false;
        }

        // 3. Ép kiểu
        Track other = (Track) obj;

        // 4. So sánh title VÀ length (theo yêu cầu đề bài)
        // Lưu ý: length là kiểu nguyên (int) nên dùng ==, title là String nên dùng equals()
        boolean titleMatches = (this.title != null && this.title.equalsIgnoreCase(other.title)) 
                                || (this.title == null && other.title == null);
        
        return titleMatches && (this.length == other.length);
    }
}