package com.neva.projectakhir;

import java.util.ArrayList;


public class PlaylistManager {
    private ArrayList<Song> playlist= new ArrayList<Song>();
    int index=0;

    public void addSong(Song song){
        playlist.addLast(song);
    }

    public void removeSong(Song song){
        playlist.remove(song);
    }

    
    public void moveUp(int index){
        if (index-1<0){
            System.out.println("Tidak ada lagu dalam playlist.");
        } else {
            index -= 1;
        }
    }

    public void moveDown(int index){
        index += 1;
    }

    public Song getCurrentSong(){
        Song currentSong = playlist.get(index);
        return currentSong;
    }
    public Song getSongbyIndex(int n){
    Song currentSong = playlist.get(n);
        return currentSong;
    }
    
    public Song getNextSong(){
        Song nextSong = playlist.get(index+1);
        return nextSong;
    }

    public Song getPreviousSong(){
        Song previousSong = playlist.get(index-1);
        return previousSong;
    }

    public ArrayList<Song> getPlaylist(){
        return playlist;
    }
}
