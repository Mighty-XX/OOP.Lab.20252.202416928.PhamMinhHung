package hust.soict.elitech.aims.media;

public class Disc extends Media {
    private int length;
    private String director;
    
    public Disc() {
        super();
    }
     public Disc(String title, String category, String director, int length, float cost) {
        super(title, category, cost); // Gọi constructor của Media
        this.director = director;
        this.length = length;
    }


    public int getLength() {
        return length;
    }

    public String getDirector() {
        return director;
    }

    // Setter bổ sung nếu cần
    public void setLength(int length) {
        this.length = length;
    }

    public void setDirector(String director) {
        this.director = director;
    }
}
