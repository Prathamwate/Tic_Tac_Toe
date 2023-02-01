package tictactoe;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class EntryScreen extends JWindow {

    private static JProgressBar progressBar = new JProgressBar();
    private static EntryScreen splashScreen;
    private static int count = 2, TIMER_PAUSE = 30,PROGBAR_MAX=50;
    private static Timer progressBarTimer;
    ActionListener al = new ActionListener() {

        @Override
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            progressBar.setValue(count);
                  if (PROGBAR_MAX == count) {
                splashScreen.dispose();//dispose of splashscreen
                progressBarTimer.stop();//stop the timer
                try {
                    createAndShowFrame();
                } catch (IOException ex) {
                    Logger.getLogger(EntryScreen.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            count++;//increase counter

        }
    };

    public EntryScreen() {
        createSplash();
    }
private static ImageIcon createImageIcon(String path,
      String description) {
      java.net.URL imgURL = EntryScreen.class.getResource(path);
      
      if (imgURL != null) {
         return new ImageIcon(imgURL, description);
      } else {            
         System.err.println("Couldn't find file: " + path);
         return null;
      }
   }
    private void createSplash() {
        Container container = getContentPane();

        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(640, 480));
        panel.setBorder(new javax.swing.border.EtchedBorder());
        container.add(panel, BorderLayout.CENTER);
        ImageIcon icon = createImageIcon("t22.png","Java");
        
        JLabel label = new JLabel("", icon,JLabel.CENTER);
        
        label.setFont(new Font("Verdana", Font.BOLD, 14));
        panel.add(label);
        progressBar.setMaximum(PROGBAR_MAX);
        container.add(progressBar, BorderLayout.SOUTH);


        pack();
        setLocationRelativeTo(null);
        setVisible(true);

        startProgressBar();
    }

    private void startProgressBar() {
        progressBarTimer = new Timer(TIMER_PAUSE, al);
        progressBarTimer.start();
    }

    private void createAndShowFrame() throws IOException {
        UserPanel u=new UserPanel();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                splashScreen = new EntryScreen();
            }
        });
    }
}