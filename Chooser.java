import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.*;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.Clip;
import javax.sound.sampled.AudioSystem;

// requires sound.wav file to play audio when pressing the button

public class Chooser implements ActionListener {

    JLabel label;
    JFrame frame;
    JPanel panel;
    JButton button;

    public Chooser() {
        frame = new JFrame();
        panel = new JPanel();
        label = new JLabel();


        button = new JButton("What class will I play in Shadowlands?");
        button.addActionListener(this);
        button.setFocusPainted(false);



        label.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));



        panel.setBorder(BorderFactory.createEmptyBorder(100, 100, 100, 100));
        panel.setLayout(new GridLayout(0, 1));
        panel.add(label);
        panel.add(button);


        frame.setLayout(new FlowLayout());
        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Wow Class Chooser");
        frame.setSize(new Dimension(600, 300));
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }

    public void playSound(String SoundName) {
        try {
            AudioInputStream audioInputStream =
                    AudioSystem.getAudioInputStream(new File(SoundName).getAbsoluteFile());
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
        } catch(Exception ex) {
            System.out.println("Error with playing Sound.");
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Chooser();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String[] classes = {"Warrior", "Hunter", "Shaman", "Priest", "Mage", "Warlock", "Paladin",
                "Monk", "Demon Hunter", "Rogue", "Druid"};
        Random r = new Random();
        int Random = r.nextInt(classes.length);
        label.setText("You should play a " + classes[Random]);
        playSound("sound.wav");
    }
}
