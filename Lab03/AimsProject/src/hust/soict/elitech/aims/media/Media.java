package hust.soict.elitech.aims.media;

import java.util.Comparator;

public abstract class Media {
    private int id;
    private String title;
    private String category;
    private float cost;

    // b17
    public static final Comparator<Media> COMPARE_BY_TITLE_COST = new MediaComparatorByTitleCost();
    public static final Comparator<Media> COMPARE_BY_COST_TITLE = new MediaComparatorByCostTitle();
   
    public Media() {
    }
    
    public Media(String title) { this.title = title; }

    // Constructor đầy đủ
    public Media(String title, String category, float cost) {
        this.title = title;
        this.category = category;
        this.cost = cost;
    }

    // Các Getter và Setter chung cho tất cả Media
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public float getCost() { return cost; }
    public void setCost(float cost) { this.cost = cost; }
    
    @Override
    public String toString() {
        return "Media: " + title;
    }
    @Override
    public boolean equals(Object obj) {
        // 1. Kiểm tra nếu so sánh với chính nó (cùng địa chỉ ô nhớ)
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Media)) {
            return false;
        }

        // 3. Ép kiểu đối tượng Object về kiểu Media để truy cập thuộc tính
        Media other = (Media) obj;

        // 4. So sánh thuộc tính title (Sử dụng equals của String, chú ý null)
        if (this.title == null) {
            return other.title == null;
        }
        return this.title.equalsIgnoreCase(other.title);
    }
}

