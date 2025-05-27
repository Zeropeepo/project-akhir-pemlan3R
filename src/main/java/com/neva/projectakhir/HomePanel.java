package com.neva.projectakhir;


import com.neva.projectakhir.AudioPlayer;
import javazoom.jl.player.Player;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.*;
import javax.swing.filechooser.FileNameExtensionFilter;

public class HomePanel extends javax.swing.JFrame {

    private File audioFile;
    private FloatControl volumeControl;

    private String currentSongName = "No song selected";
    private Timer progressTimer;
    private int songDurationInSeconds = 0;
    private int currentPositionInSeconds = 0;
    private DefaultListModel history = new DefaultListModel();
    private PlaylistManager playlistManager = PlaylistManager.getInstance();
    private DefaultListModel<String> playlistModel = new DefaultListModel<>();
    private ArrayList<Song> historyarray = new ArrayList<>();

    public HomePanel() {
        jPanel1 = new javax.swing.JPanel();
        initComponents();
        
        progressBar.addMouseListener(new java.awt.event.MouseAdapter(){
            public void mouseClicked(java.awt.event.MouseEvent evt){
                progressBarMouseClicked(evt);
    }
 });
        
        progressTimer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (AudioPlayer.isPlaying() && AudioPlayer.getClip() != null) {
                    currentPositionInSeconds = (int)(AudioPlayer.getClip().getMicrosecondPosition() / 1000000);
                    progressBar.setValue(currentPositionInSeconds);
                    updateTimeLabels();
                }
            }
        });
        volumeSlider.addChangeListener(e -> adjustVolume());
        jPlaylist1.setModel(playlistModel);
    }


    private String formatTime(int timeInSeconds) {
        int minutes = timeInSeconds / 60;
        int seconds = timeInSeconds % 60;
        return String.format("%d:%02d", minutes, seconds);
    }

    // Update time labels on UI
    private void updateTimeLabels() {
        currentTimeLabel.setText(formatTime(currentPositionInSeconds));
        totalTimeLabel.setText(formatTime(songDurationInSeconds));
    }

    private void adjustVolume() {
        if (AudioPlayer.getClip() != null && AudioPlayer.getClip().isControlSupported(FloatControl.Type.MASTER_GAIN)) {
            volumeControl = (FloatControl) AudioPlayer.getClip().getControl(FloatControl.Type.MASTER_GAIN);
            float volume = volumeSlider.getValue() / 100.0f;
            float dB = (float) (Math.log10(volume) * 20.0f);
            if (dB < volumeControl.getMinimum()) {
                dB = volumeControl.getMinimum();
            }
            if (volume > 0) {
                volumeControl.setValue(dB);
            } else {
                volumeControl.setValue(volumeControl.getMinimum());
            }
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        songButton = new javax.swing.JButton();
        browseButton = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        playButton = new javax.swing.JButton();
        Pause = new javax.swing.JButton();
        volumeSlider = new javax.swing.JSlider();
        songNameLabel = new javax.swing.JLabel();
        stopButton = new javax.swing.JButton();
        progressBar = new javax.swing.JProgressBar();
        currentTimeLabel = new javax.swing.JLabel();
        totalTimeLabel = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        skipButton = new javax.swing.JButton();
        previousButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        PlaylistHistory = new javax.swing.JList<>();
        PlaySelected = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPlaylist1 = new javax.swing.JList<>();
        jLabel4 = new javax.swing.JLabel();
        addSongButton = new javax.swing.JButton();
        removeSongButton = new javax.swing.JButton();
        playFromPlaylistBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));

        jPanel3.setBackground(new java.awt.Color(80, 80, 80));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 57, Short.MAX_VALUE)
        );

        jPanel2.setBackground(new java.awt.Color(80, 80, 80));

        jPanel4.setBackground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 160, Short.MAX_VALUE)
        );

        jLabel1.setFont(new java.awt.Font("OCR A Extended", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("      Profile");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE))
        );

        songButton.setBackground(new java.awt.Color(80, 80, 80));
        songButton.setFont(new java.awt.Font("OCR A Extended", 1, 24)); // NOI18N
        songButton.setForeground(new java.awt.Color(255, 255, 255));
        songButton.setText("Songs");
        songButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                songButtonActionPerformed(evt);
            }
        });

        browseButton.setBackground(new java.awt.Color(80, 80, 80));
        browseButton.setFont(new java.awt.Font("OCR A Extended", 1, 24)); // NOI18N
        browseButton.setForeground(new java.awt.Color(255, 255, 255));
        browseButton.setText("Browse");
        browseButton.setToolTipText("");
        browseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                browseButtonActionPerformed(evt);
            }
        });

        jPanel5.setBackground(new java.awt.Color(0, 0, 0));

        jPanel6.setBackground(new java.awt.Color(51, 51, 51));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 131, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        playButton.setText("Play");
        playButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                playButtonActionPerformed(evt);
            }
        });

        Pause.setText("Pause");
        Pause.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PauseActionPerformed(evt);
            }
        });

        volumeSlider.setBackground(new java.awt.Color(255, 255, 255));
        volumeSlider.setForeground(new java.awt.Color(51, 204, 255));

        songNameLabel.setFont(new java.awt.Font("OCR A Extended", 0, 14)); // NOI18N
        songNameLabel.setForeground(new java.awt.Color(255, 255, 255));
        songNameLabel.setText("Song Name");

        stopButton.setText("Stop");
        stopButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stopButtonActionPerformed(evt);
            }
        });

        progressBar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                progressBarMouseClicked(evt);
            }
        });

        currentTimeLabel.setForeground(new java.awt.Color(255, 255, 255));
        currentTimeLabel.setText("0:00");

        totalTimeLabel.setForeground(new java.awt.Color(255, 255, 255));
        totalTimeLabel.setText("0:00");

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("🔊");

        skipButton.setText("Next");
        skipButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                skipButtonActionPerformed(evt);
            }
        });

        previousButton.setText("Previous");
        previousButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                previousButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(currentTimeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(songNameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(progressBar, javax.swing.GroupLayout.DEFAULT_SIZE, 621, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(totalTimeLabel)
                        .addGap(224, 224, 224))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(previousButton)
                        .addGap(113, 113, 113)
                        .addComponent(playButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Pause)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(stopButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 201, Short.MAX_VALUE)
                        .addComponent(skipButton)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(volumeSlider, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(songNameLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(progressBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(totalTimeLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                            .addComponent(currentTimeLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(playButton)
                                .addComponent(Pause)
                                .addComponent(stopButton)
                                .addComponent(skipButton)
                                .addComponent(previousButton))
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(volumeSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel3)))
                        .addGap(10, 10, 10))
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jScrollPane1.setViewportView(PlaylistHistory);

        PlaySelected.setBackground(new java.awt.Color(80, 80, 80));
        PlaySelected.setFont(new java.awt.Font("OCR A Extended", 1, 24)); // NOI18N
        PlaySelected.setForeground(new java.awt.Color(255, 255, 255));
        PlaySelected.setText("Play Selected");
        PlaySelected.setToolTipText("");
        PlaySelected.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PlaySelectedActionPerformed(evt);
            }
        });

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Browse History");

        jScrollPane2.setViewportView(jPlaylist1);

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Playlist");

        addSongButton.setText("Add Song");
        addSongButton.setActionCommand("Add");
        addSongButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addSongButtonActionPerformed(evt);
            }
        });

        removeSongButton.setText("Remove Song");
        removeSongButton.setActionCommand("Remove");
        removeSongButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeSongButtonActionPerformed(evt);
            }
        });

        playFromPlaylistBtn.setText("Play Song");
        playFromPlaylistBtn.setActionCommand("Play from Playlist");
        playFromPlaylistBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                playFromPlaylistBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(songButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(browseButton, javax.swing.GroupLayout.DEFAULT_SIZE, 286, Short.MAX_VALUE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(61, 61, 61))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 70, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 395, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 283, Short.MAX_VALUE)
                            .addComponent(PlaySelected, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(41, 41, 41))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(112, 112, 112)
                        .addComponent(addSongButton)
                        .addGap(18, 18, 18)
                        .addComponent(removeSongButton)
                        .addGap(18, 18, 18)
                        .addComponent(playFromPlaylistBtn)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(songButton, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(3, 3, 3)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(removeSongButton)
                            .addComponent(addSongButton)
                            .addComponent(playFromPlaylistBtn))
                        .addGap(0, 23, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PlaySelected, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(75, 75, 75)
                        .addComponent(browseButton, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void songButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_songButtonActionPerformed


    }//GEN-LAST:event_songButtonActionPerformed

    private void browseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_browseButtonActionPerformed
        JFileChooser fileChooser = new JFileChooser();

        // Set default directory to Windows Music folder or fallback
        String musicDir = System.getProperty("user.home") + File.separator + "Music";
        File defaultDir = new File(musicDir);
        if (!defaultDir.exists() || !defaultDir.isDirectory()) {
            defaultDir = new File(System.getProperty("user.home"));
        }
        fileChooser.setCurrentDirectory(defaultDir);

        FileNameExtensionFilter filter = new FileNameExtensionFilter(
                "Audio Files", "wav", "aiff", "au");
        fileChooser.setFileFilter(filter);

        int returnVal = fileChooser.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            try {
                // Stop any currently playing audio
                if (AudioPlayer.getClip() != null && AudioPlayer.getClip().isOpen()) {
                    AudioPlayer.stop();
                }

                // Get the selected file
                audioFile = fileChooser.getSelectedFile();
                AudioPlayer.loadAudio(audioFile);
                currentSongName = audioFile.getName();
                songNameLabel.setText(currentSongName);

                // Set up the volume control
                if (AudioPlayer.getClip().isControlSupported(FloatControl.Type.MASTER_GAIN)) {
                    volumeControl = (FloatControl) AudioPlayer.getClip().getControl(FloatControl.Type.MASTER_GAIN);
                    adjustVolume();
                }

                // Calculate duration
                songDurationInSeconds = (int)(AudioPlayer.getClip().getMicrosecondLength() / 1000000);
                progressBar.setMaximum(songDurationInSeconds);
                updateTimeLabels();

                // Play automatically
                playButton.doClick();
            } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
                JOptionPane.showMessageDialog(this,
                        "Error loading audio file: " + ex.getMessage(),
                        "Error", JOptionPane.ERROR_MESSAGE);
                ex.printStackTrace();
            }
        }
    }//GEN-LAST:event_browseButtonActionPerformed



    private void historyUpdater(File tempfilehistory){
       try {
            historyarray.add(new Song(tempfilehistory));
        } catch (UnsupportedAudioFileException ex) {
            Logger.getLogger(HomePanel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(HomePanel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (LineUnavailableException ex) {
            Logger.getLogger(HomePanel.class.getName()).log(Level.SEVERE, null, ex);
        }

        history.clear();
        history.addAll(historyarray);
        //history.addElement(AudioPlayer.getFile().getName());
        PlaylistHistory.setModel(history);
}

    private void PauseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PauseActionPerformed
        if (AudioPlayer.getClip() != null && AudioPlayer.isPlaying()) {
            AudioPlayer.pause();
            progressTimer.stop();
        }
    }//GEN-LAST:event_PauseActionPerformed

    private void playButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_playButtonActionPerformed
        if (AudioPlayer.getClip() != null) {
            if (!AudioPlayer.isPlaying()) {
                AudioPlayer.start();
                progressTimer.start();
                // Listener when the clip ends
                AudioPlayer.getClip().addLineListener(new LineListener() {
                    @Override
                    public void update(LineEvent event) {
                        if (event.getType() == LineEvent.Type.STOP) {
                            if (AudioPlayer.getClip().getMicrosecondPosition() >= AudioPlayer.getClip().getMicrosecondLength()) {
                                // Song ended
                                progressTimer.stop();
                                progressBar.setValue(0);
                                currentPositionInSeconds = 0;
                                updateTimeLabels();
                            }
                        }
                    }
                });
            }
        } else {
            JOptionPane.showMessageDialog(this,
                    "Please select an audio file first.",
                    "No File Selected", JOptionPane.INFORMATION_MESSAGE);
        }

    }//GEN-LAST:event_playButtonActionPerformed

    private void stopButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stopButtonActionPerformed
        if (AudioPlayer.getClip() != null) {
            AudioPlayer.stop();
            progressTimer.stop();
            progressBar.setValue(0);
            currentPositionInSeconds = 0;
            updateTimeLabels();
        }

    }//GEN-LAST:event_stopButtonActionPerformed

    private void PlaySelectedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PlaySelectedActionPerformed

        AudioPlayer.stop();
        int indexnya = PlaylistHistory.getSelectedIndex();
        PlaylistManager.getInstance().setCurrentIndex(indexnya);
        // Get the selected file
        File filenya=playlistManager.getInstance().getSongbyIndex(indexnya).getFile();
        audioFile = filenya;
        try {
            if (AudioPlayer.getClip() != null && AudioPlayer.getClip().isOpen()) {
                AudioPlayer.stop();
            }
            AudioPlayer.loadAudio(audioFile);
        } catch (UnsupportedAudioFileException ex) {
            Logger.getLogger(HomePanel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(HomePanel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (LineUnavailableException ex) {
            Logger.getLogger(HomePanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        currentSongName = audioFile.getName();
        songNameLabel.setText(currentSongName);

        // Set up the volume control
        if (AudioPlayer.getClip().isControlSupported(FloatControl.Type.MASTER_GAIN)) {
            volumeControl = (FloatControl) AudioPlayer.getClip().getControl(FloatControl.Type.MASTER_GAIN);
            adjustVolume();
        }

        // Calculate duration
        songDurationInSeconds = (int)(AudioPlayer.getClip().getMicrosecondLength() / 1000000);
        progressBar.setMaximum(songDurationInSeconds);
        updateTimeLabels();

        // Play automatically
        playButton.doClick();


    }//GEN-LAST:event_PlaySelectedActionPerformed

    private void addSongButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addSongButtonActionPerformed
        JFileChooser fileChooser = new JFileChooser();

        // Set default directory to Windows Music folder or fallback
        String musicDir = System.getProperty("user.home") + File.separator + "Music";
        File defaultDir = new File(musicDir);
        if (!defaultDir.exists() || !defaultDir.isDirectory()) {
            defaultDir = new File(System.getProperty("user.home"));
        }
        fileChooser.setCurrentDirectory(defaultDir);

        FileNameExtensionFilter filter = new FileNameExtensionFilter(
                "Audio Files", "wav", "aiff", "au");
        fileChooser.setFileFilter(filter);

        int result = fileChooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            File songFile = fileChooser.getSelectedFile();

            try {
                Song newSong = new Song(songFile);
                playlistManager.getInstance().addSong(newSong);
                playlistModel.addElement(newSong.getName());
                refreshPlaylist();

                jPlaylist1.setSelectedIndex(playlistManager.getInstance().getPlaylist().size() - 1);


            } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
                JOptionPane.showMessageDialog(this,
                        "Gagal menambahkan atau memutar lagu: " + ex.getMessage(),
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_addSongButtonActionPerformed

    private void removeSongButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeSongButtonActionPerformed
        int selectedIndex = jPlaylist1.getSelectedIndex();
        if (selectedIndex != -1) {

            String songTitle = playlistModel.getElementAt(selectedIndex);
            Song songToRemove = playlistManager.findSongByTitle(songTitle);

            if (AudioPlayer.getFile() != null && AudioPlayer.getFile().equals(songToRemove.getFile())) {
                AudioPlayer.stop();
            }

            playlistManager.removeSong(songToRemove);
            playlistModel.removeElementAt(selectedIndex);

            progressBar.setValue(0);
        } else {
            JOptionPane.showMessageDialog(this, "Pilih lagu yang ingin dihapus.");
        }
    }//GEN-LAST:event_removeSongButtonActionPerformed

    private void skipButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_skipButtonActionPerformed
        Song nextSong = playlistManager.getInstance().getNextSong();
        if (nextSong == null) {
            JOptionPane.showMessageDialog(this, "Tidak ada lagu berikutnya dalam playlist.");
            return;
        }

        try {
            // Stop audio saat ini jika sedang diputar
            if (AudioPlayer.getClip() != null && AudioPlayer.getClip().isOpen()) {
                AudioPlayer.stop();
            }

            // Load lagu berikutnya
            File songFile = nextSong.getFile();
            AudioPlayer.loadAudio(songFile);
            audioFile = songFile; // Simpan referensi untuk HomePanel
            currentSongName = nextSong.getName();
            songNameLabel.setText(currentSongName);
            jPlaylist1.setSelectedIndex(playlistManager.getCurrentIndex());
            // Volume control
            if (AudioPlayer.getClip().isControlSupported(FloatControl.Type.MASTER_GAIN)) {
                volumeControl = (FloatControl) AudioPlayer.getClip().getControl(FloatControl.Type.MASTER_GAIN);
                adjustVolume();
            }

            // Atur durasi dan progress bar
            songDurationInSeconds = (int) (AudioPlayer.getClip().getMicrosecondLength() / 1_000_000);
            progressBar.setMaximum(songDurationInSeconds);
            updateTimeLabels();

            // Update selection di JList
            jPlaylist1.setSelectedValue(nextSong, true);

            // Play lagu
            AudioPlayer.start();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Gagal memuat lagu: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }//GEN-LAST:event_skipButtonActionPerformed

    private void playFromPlaylistBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_playFromPlaylistBtnActionPerformed
        int selectedIndex = jPlaylist1.getSelectedIndex();
        PlaylistManager.getInstance().setCurrentIndex(selectedIndex);
        
    if (selectedIndex != -1) {
        String songTitle = playlistModel.getElementAt(selectedIndex);
        Song selectedSong = playlistManager.findSongByTitle(songTitle);

        if (selectedSong == null) {
            JOptionPane.showMessageDialog(this, "Lagu tidak ditemukan di data playlist.");
            return;
        }

        File songFile = selectedSong.getFile();

        try {
            if (AudioPlayer.getFile() != null && AudioPlayer.getFile().equals(songFile)) {
                if (!AudioPlayer.isPlaying()) {
                    AudioPlayer.resume();
                    progressTimer.start(); // Resume time update
                }
            } else {
                if (AudioPlayer.isPlaying()) {
                    AudioPlayer.stop();
                }
                AudioPlayer.loadAudio(songFile);
                AudioPlayer.start();
                progressTimer.start(); // Start time update when new song is played

                // Reset progress
                progressBar.setValue(0);
                currentPositionInSeconds = 0;

                // Set the duration of song
                songDurationInSeconds = (int)(AudioPlayer.getClip().getMicrosecondLength() / 1000000);
                progressBar.setMaximum(songDurationInSeconds);
                updateTimeLabels();
            }

            songNameLabel.setText(selectedSong.getName());
            historyUpdater(songFile);
            
            
            AudioPlayer.getClip().addLineListener(new LineListener() {
                @Override
                public void update(LineEvent event) {
                    if (event.getType() == LineEvent.Type.STOP) {
                        if (AudioPlayer.getClip().getMicrosecondPosition() >= AudioPlayer.getClip().getMicrosecondLength()) {
                            // Song ended
                            progressTimer.stop();
                            progressBar.setValue(0);
                            currentPositionInSeconds = 0;
                            updateTimeLabels();
                        }
                    }
                }
            });

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Gagal memutar lagu: " + ex.getMessage());
        }

    } else {
        JOptionPane.showMessageDialog(this, "Pilih lagu dari playlist.");
    }
    }//GEN-LAST:event_playFromPlaylistBtnActionPerformed

    private void progressBarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_progressBarMouseClicked
        if (AudioPlayer.getClip() != null){
            int mouseX = evt.getX();
            int progressBarWidth = progressBar.getWidth();
            int durationInSeconds = (int)(AudioPlayer.getClip().getMicrosecondLength() / 1_000_000);
            
            double clickRatio = Math.min(1.0, Math.max(0.0, (double) mouseX / progressBarWidth));
            int newPositionInSeconds = (int)(clickRatio * durationInSeconds);
            
            AudioPlayer.getClip().setMicrosecondPosition(newPositionInSeconds * 1_000_000L);
            
            progressBar.setValue(newPositionInSeconds);
            currentPositionInSeconds = newPositionInSeconds;
            updateTimeLabels();
    }//GEN-LAST:event_progressBarMouseClicked
}
    
    private void previousButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_previousButtonActionPerformed
        Song previousSong = playlistManager.getInstance().getPreviousSong();
        if (previousSong == null) {
            JOptionPane.showMessageDialog(this, "Tidak ada lagu sebelumnya");
            return;
        }

        try {
            // Stop audio saat ini jika sedang diputar
            if (AudioPlayer.getClip() != null && AudioPlayer.getClip().isOpen()) {
                AudioPlayer.stop();
            }

            // Load lagu berikutnya
            File songFile = previousSong.getFile();
            AudioPlayer.loadAudio(songFile);
            audioFile = songFile; // Simpan referensi untuk HomePanel
            currentSongName = previousSong.getName();
            songNameLabel.setText(currentSongName);
            jPlaylist1.setSelectedIndex(playlistManager.getCurrentIndex());

            // Volume control
            if (AudioPlayer.getClip().isControlSupported(FloatControl.Type.MASTER_GAIN)) {
                volumeControl = (FloatControl) AudioPlayer.getClip().getControl(FloatControl.Type.MASTER_GAIN);
                adjustVolume();
            }

            // Atur durasi dan progress bar
            songDurationInSeconds = (int) (AudioPlayer.getClip().getMicrosecondLength() / 1_000_000);
            progressBar.setMaximum(songDurationInSeconds);
            updateTimeLabels();

            // Update selection di JList
            jPlaylist1.setSelectedValue(previousSong, true);

            // Play lagu
            AudioPlayer.start();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Gagal memuat lagu: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }//GEN-LAST:event_previousButtonActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        
            File file = new File("DataUser.txt");

        try(FileWriter fw = new FileWriter(file, false)){ // false = overwrite
            for (Song s : playlistManager.getPlaylist()) {
                fw.write(s.getFile().getAbsolutePath() + "\n");
            }
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }

        refreshPlaylist();


        
    }//GEN-LAST:event_formWindowClosing

    
    
    boolean PlaylistLoaded=false;
    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        
        
        if (PlaylistLoaded) {
            return;
        }
        PlaylistLoaded = true;
        System.out.println("Load txt");
        File file = new File("DataUser.txt");

        try(FileReader fr = new FileReader(file)){
            Scanner sc = new Scanner(fr);
            var playlistpointer=playlistManager.getPlaylist();
            while (sc.hasNextLine()) {
                try{
                playlistpointer.add(new Song(new File(sc.nextLine())));}
                catch (FileNotFoundException e){
                    JOptionPane.showConfirmDialog(this, "Saved song not found: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
        catch (IOException | UnsupportedAudioFileException | LineUnavailableException e) {
            throw new RuntimeException(e);
        }

        refreshPlaylist();


        
    }//GEN-LAST:event_formWindowActivated


    private void refreshPlaylist() {
        playlistModel.clear();
        for (Song song : PlaylistManager.getInstance().getPlaylist()) {
            playlistModel.addElement(song.getName());
        }
    }

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(HomePanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HomePanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HomePanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HomePanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HomePanel().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Pause;
    private javax.swing.JButton PlaySelected;
    private javax.swing.JList<String> PlaylistHistory;
    private javax.swing.JButton addSongButton;
    private javax.swing.JButton browseButton;
    private javax.swing.JLabel currentTimeLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JList<String> jPlaylist1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton playButton;
    private javax.swing.JButton playFromPlaylistBtn;
    private javax.swing.JButton previousButton;
    private javax.swing.JProgressBar progressBar;
    private javax.swing.JButton removeSongButton;
    private javax.swing.JButton skipButton;
    private javax.swing.JButton songButton;
    private javax.swing.JLabel songNameLabel;
    private javax.swing.JButton stopButton;
    private javax.swing.JLabel totalTimeLabel;
    private javax.swing.JSlider volumeSlider;
    // End of variables declaration//GEN-END:variables
}
