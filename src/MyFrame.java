import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MyFrame extends JFrame {
    Calendar calendar;
    SimpleDateFormat timeFormat;
    SimpleDateFormat dateFormat;
    JButton startShift;
    JButton b1;
    JButton b2;
    JButton endShift;
    JLabel timeLabel;
    JLabel dateLabel;
    String time;
    String date;
    public MyFrame(){
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(350,420);
        this.setLayout(new FlowLayout());
        this.setResizable(false);
        this.setTitle("CLK");
        this.getContentPane().setBackground(Color.BLACK);
        startShift = new JButton("Start shift");
        endShift = new JButton("End shift");
        endShift.setVisible(false);
        startShift.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startShift.setVisible(false);
                endShift.setVisible(true);
                startShift();
            }
        });
        endShift.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startShift.setVisible(true);
                endShift.setVisible(false);
                endShift();
            }
        });

        b1 = new JButton("-");
        b2 = new JButton("+");
        b1.setVisible(false);
        b2.setVisible(false);
        timeFormat = new SimpleDateFormat("HH:mm:ss");
        dateFormat = new SimpleDateFormat("EEEEEE, dd MMM yyyy");
        timeLabel = new JLabel();
        timeLabel.setBackground(Color.BLACK);
        timeLabel.setOpaque(true);
        timeLabel.setFont(new Font("Verdana", Font.PLAIN, 50));
        timeLabel.setForeground(Color.GREEN);
        this.add(timeLabel);
        dateLabel = new JLabel();
        dateLabel.setBackground(Color.BLACK);
        dateLabel.setOpaque(true);
        dateLabel.setFont(new Font("Verdana", Font.PLAIN, 25));
        dateLabel.setForeground(Color.GREEN);
        this.add(dateLabel);
        this.add(startShift);
        this.add(endShift);
        this.add(b1);
        this.add(b2);
        this.setVisible(true);
        updateTime();
    }
    public void startShift(){
        System.out.println("Shift started at: " + time);
        b1.setVisible(true);
        b2.setVisible(true);
    }
    public void endShift(){
        System.out.println("Shift ended at: " + time);
        b1.setVisible(false);
        b2.setVisible(false);
    }
    public void updateTime(){
        while(true){
            time = timeFormat.format(Calendar.getInstance().getTime());
            date = dateFormat.format(Calendar.getInstance().getTime());
            timeLabel.setText(time);
            dateLabel.setText(date);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
