
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SoloLevelingSystemGUI extends JFrame implements ActionListener {
    private Student student;
    private JLabel nameLabel;
    private JLabel levelLabel;
    private JProgressBar progressBar;
    private JButton levelUpButton;

    public SoloLevelingSystemGUI(Student student) {
        this.student = student;
        initComponents();
    }

    private void initComponents() {
        // set up the main window
        setTitle("Solo Leveling System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setSize(400, 200);

        // add a label for the student's name
        nameLabel = new JLabel("Name: " + student.getName());
        add(nameLabel, BorderLayout.NORTH);

        // add a label for the student's level
        levelLabel = new JLabel("Level: " + student.getLevel());
        add(levelLabel, BorderLayout.CENTER);

        // add a progress bar for the student's progress
        progressBar = new JProgressBar(0, 100);
        progressBar.setValue(student.getProgress());
        add(progressBar, BorderLayout.SOUTH);

        // add a button for leveling up the student's skills
        levelUpButton = new JButton("Level up");
        levelUpButton.addActionListener(this);
        add(levelUpButton, BorderLayout.EAST);

        // show the window
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        // handle button clicks
        if (e.getSource() == levelUpButton) {
            student.levelUp();
            levelLabel.setText("Level: " + student.getLevel());
            progressBar.setValue(student.getProgress());
            JOptionPane.showMessageDialog(this, "Congratulations, you leveled up!");
        }
    }

    public static void main(String[] args) {
        // create a new student
        Student student = new Student("John");

        // create a new instance of the GUI
        SoloLevelingSystemGUI gui = new SoloLevelingSystemGUI(student);
    }
}

class Student {
    private String name;
    private int level;
    private int progress;

    public Student(String name) {
        this.name = name;
        this.level = 1;
        this.progress = 0;
    }

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    public int getProgress() {
        return progress;
    }

    public void levelUp() {
        progress += 10;
        if (progress >= 100) {
            level++;
            progress = 0;
        }
    }
}
