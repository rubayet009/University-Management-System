package universityManagement;

import javax.swing.*;
import java.awt.*;

public class About extends JFrame {
    About() {

        setSize(700, 500);
        setLocation(400, 150);
        setLayout(null);
        JLabel heading = new JLabel("<html>University<br/>Management<br/> System<html>");
        heading.setBounds(50, 10, 300, 150);
        heading.setFont(new Font("serif", Font.BOLD, 30));
        add(heading);
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/icons.jpeg"));
        Image i2=i1.getImage().getScaledInstance(200,150,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(400,30,200,150);
        add(image);
        JLabel name = new JLabel("Devloped by : Mohammad  Rubayet");
        name.setBounds(50, 200, 400, 30);
        name.setFont(new Font("serif", Font.BOLD, 25));
        add(name);

        setVisible(true);
    }
    public static void main(String[] args) {
        new About();
    }
}
