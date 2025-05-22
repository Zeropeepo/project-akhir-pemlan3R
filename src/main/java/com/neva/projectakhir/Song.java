package com.neva.projectakhir;
import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class Song {
    private String name;
    private Clip clip;
    private File file;
    AudioInputStream audioStream;
    public Song(File file) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
         audioStream = AudioSystem.getAudioInputStream(file);
        clip = AudioSystem.getClip();
        clip.open(audioStream);
        name= file.getName();
        this.file = file;
    }
    public Clip getclip(){
        return clip;
    }
    public String getName() {
        return name;
    }
    public File getFile() {
        return file;
    }
}

