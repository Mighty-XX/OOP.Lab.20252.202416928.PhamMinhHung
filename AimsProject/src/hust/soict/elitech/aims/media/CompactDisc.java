package hust.soict.elitech.aims.media;

import java.util.ArrayList;
import java.util.List;

public class CompactDisc extends Disc implements Playable{
    private String artist;
    private List<Track> tracks = new ArrayList<>();

    public CompactDisc(String title, String category, String artist, float cost) {
        super();
        this.setTitle(title);
        this.setCategory(category);
        this.setCost(cost);
        this.artist = artist;
    }

    public String getArtist() {
        return artist;
    }

    public void addTrack(Track track) {
        if (tracks.contains(track)) {
            System.out.println("Track " + track.getTitle() + " is already in the CD.");
        } else {
            tracks.add(track);
            System.out.println("Track " + track.getTitle() + " added.");
        }
    }

    public void removeTrack(Track track) {
        if (tracks.contains(track)) {
            tracks.remove(track);
            System.out.println("Track " + track.getTitle() + " removed.");
        } else {
            System.out.println("Track " + track.getTitle() + " does not exist in the CD.");
        }
    }

    // Tổng độ dài của CD là tổng độ dài của các track
    @Override
    public int getLength() {
        int totalLength = 0;
        for (Track track : tracks) {
            totalLength += track.getLength();
        }
        return totalLength;
    }
    // Triển khai hàm play() cho CD
    @Override
    public void play() {
        System.out.println("Playing CD: " + this.getTitle() + " by artist: " + this.artist);
        System.out.println("Total length: " + this.getLength());
        
        // Vòng lặp gọi hàm play() của từng track
        for (Track track : tracks) {
            track.play();
        }
    }
}