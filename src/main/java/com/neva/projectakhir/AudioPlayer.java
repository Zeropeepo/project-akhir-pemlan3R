package com.neva.projectakhir;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.File;
import java.io.IOException;

public class AudioPlayer {


    private static Clip clip;
    private static long pausePosition=0;
    private static boolean Playing = false;

    public static long getDuration() {
        return clip.getMicrosecondLength();
    }
    public static boolean isPlaying() {
        return Playing;
    }

    public static long getPausePosition() {
        return pausePosition;
    }

    public static void start() {
        clip.setMicrosecondPosition(pausePosition);
        clip.start();
        Playing = true;
    }
    public static void start(int startposition) {
        clip.setMicrosecondPosition(startposition*1000000);
        clip.start();
        Playing = true;
    }
    public static void stop() {
        clip.stop();
        Playing = false;
        pausePosition=0;
    }
    public static void resume() {
        clip.setMicrosecondPosition(pausePosition);
        clip.start();
        Playing = true;
    }
    public static void pause() {
        pausePosition = clip.getMicrosecondPosition()-1000000;
        clip.stop();
        Playing = false;

    }

    
    
    public static void loadAudio(File file) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
       clip = (new Song(file)).getclip();
    }

    public static Clip getClip() {
        return clip;
    }
}
