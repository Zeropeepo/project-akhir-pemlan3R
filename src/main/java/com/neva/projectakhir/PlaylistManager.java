package com.neva.projectakhir;

import java.util.ArrayList;
import java.util.List;

public class PlaylistManager {
    private List<Song> playlist;
    private int currentIndex;

    private static PlaylistManager instance = new PlaylistManager();

    public static PlaylistManager getInstance() {
        return instance;
    }
    
    private PlaylistManager() {
        playlist = new ArrayList<>();
        currentIndex = -1;
    }

    public void addSong(Song song) {
        playlist.add(song);
        if (currentIndex == -1) {
            currentIndex = 0;
        }
    }

    public void removeSong(Song song) {
        int removedIndex = playlist.indexOf(song);
        if (removedIndex != -1) {
            playlist.remove(removedIndex);
            if (playlist.isEmpty()) {
                currentIndex = -1;
            } else if (removedIndex <= currentIndex) {
                currentIndex = Math.max(0, currentIndex - 1);
            }
        }
    }

    public void moveUp() {
        if (currentIndex > 0) {
            // Swap current song with the previous song
            Song temp = playlist.get(currentIndex - 1);
            playlist.set(currentIndex - 1, playlist.get(currentIndex));
            playlist.set(currentIndex, temp);
            currentIndex = currentIndex - 1;
        } else {
            System.out.println("Sudah di lagu pertama.");
        }
    }

    public void moveDown() {
        if (currentIndex < playlist.size() - 1) {
            // Swap current song with the next song
            Song temp = playlist.get(currentIndex + 1);
            playlist.set(currentIndex + 1, playlist.get(currentIndex));
            playlist.set(currentIndex, temp);
            currentIndex = currentIndex + 1;
        } else {
            System.out.println("Sudah di lagu terakhir.");
        }
    }

    public Song getCurrentSong() {
        if (currentIndex >= 0 && currentIndex < playlist.size()) {
            return playlist.get(currentIndex);
        }
        return null;
    }

    public Song getSongbyIndex(int currentIndex) {
        if (currentIndex >= 0 && currentIndex < playlist.size()) {
            return playlist.get(currentIndex);
        }
        return null;
    }

    public Song findSongByTitle(String title) {
        for (Song song : playlist) {
            if (song.getName().equals(title)) {
                return song;
            }
        }
        return null;
    }

    public Song getNextSong() {
        if (currentIndex + 1 < playlist.size()) {
            currentIndex++;
            return playlist.get(currentIndex);
        }
        return null;
    }

    public Song getPreviousSong() {
        if (currentIndex - 1 >= 0) {
            currentIndex--;
            return playlist.get(currentIndex);
        }
        return null;
    }

    public List<Song> getPlaylist() {
        return playlist;
    }

    public int getCurrentIndex() {
        return currentIndex;
    }
    
    public void setCurrentIndex(int index){
        if(index >= 0 && index < playlist.size()){
            this.currentIndex = index;
        }
    }
}
