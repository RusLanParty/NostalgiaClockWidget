import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MyFrame extends JFrame {
    Calendar calendar;
    SimpleDateFormat timeFormat;
    JLabel timeLabel;
    String time;
    public MyFrame(){
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(300,220);
        this.setLayout(new FlowLayout());
        this.setResizable(false);
        this.setTitle("CLK");
        this.getContentPane().setBackground(Color.BLACK);

        timeFormat = new SimpleDateFormat("HH:mm:ss");
        timeLabel = new JLabel();
        timeLabel.setBackground(Color.BLACK);
        timeLabel.setOpaque(true);
        timeLabel.setFont(new Font("Verdana", Font.PLAIN, 50));
        timeLabel.setForeground(Color.ORANGE);
        this.add(timeLabel);
        this.setVisible(true);
        updateTime();
    }
    public void updateTime(){
        while(true){
            time = timeFormat.format(Calendar.getInstance().getTime());
            timeLabel.setText(time);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
