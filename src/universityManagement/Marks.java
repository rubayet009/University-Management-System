package universityManagement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Marks extends JFrame implements ActionListener {
    String rollno;
    JButton cancel;
    Marks(String rollno){
      this.rollno=rollno;
        setSize(500,600);
        setLocation(500,100);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        JLabel heading=new JLabel("SUST");
        heading.setBounds(200,10,500,50);
        heading.setFont(new Font("Tahoma", Font.BOLD,30));
        add(heading);
        setVisible(true);

        JLabel subheading=new JLabel("Result of Examination:");
        subheading.setBounds(120,50,500,50);
        subheading.setFont(new Font("Tahoma", Font.PLAIN,25));
        add(subheading);

        JLabel lblrollno=new JLabel("Roll : "+rollno);
        lblrollno.setBounds(50,150,200,20);
        lblrollno.setFont(new Font("Tahoma", Font.PLAIN,18));
        add(lblrollno);
        setVisible(true);

        JLabel lblsemester=new JLabel();
        lblsemester.setBounds(50,180,200,20);
        lblsemester.setFont(new Font("Tahoma", Font.PLAIN,18));
        add(lblsemester);

        JLabel sub1=new JLabel();
        sub1.setBounds(50,250,200,20);
        sub1.setFont(new Font("Tahoma", Font.PLAIN,18));
        add(sub1);
        JLabel sub2=new JLabel();
        sub2.setBounds(50,280,200,20);
        sub2.setFont(new Font("Tahoma", Font.PLAIN,18));
        add(sub2);
        JLabel sub3=new JLabel();
        sub3.setBounds(50,310,200,20);
        sub3.setFont(new Font("Tahoma", Font.PLAIN,18));
        add(sub3);
        JLabel sub4=new JLabel();
        sub4.setBounds(50,340,200,20);
        sub4.setFont(new Font("Tahoma", Font.PLAIN,18));
        add(sub4);
        JLabel sub5=new JLabel();
        sub5.setBounds(50,370,200,20);
        sub5.setFont(new Font("Tahoma", Font.PLAIN,18));
        add(sub5);
        try {
            Conn c = new Conn();
            String query="select * from subject where rollno = '"+rollno+"'";

            ResultSet rs1 = c.s.executeQuery(query);
            while(rs1.next()) {
                sub1.setText(rs1.getString("sub1"));
                sub2.setText(rs1.getString("sub2"));
                sub3.setText(rs1.getString("sub3"));
                sub4.setText(rs1.getString("sub4"));
                sub5.setText(rs1.getString("sub5"));
            }
            String query2="select * from mark where rollno = '"+rollno+"'";
            ResultSet rs2 = c.s.executeQuery(query2);
            while(rs2.next()) {
                sub1.setText(sub1.getText() + "------------" + rs2.getString("marks1"));
                sub2.setText(sub2.getText() + "------------" + rs2.getString("marks2"));
                sub3.setText(sub3.getText() + "------------" + rs2.getString("marks3"));
                sub4.setText(sub4.getText() + "------------" + rs2.getString("marks4"));
                sub5.setText(sub5.getText() + "------------" + rs2.getString("marks5"));
                lblsemester.setText("Semester " + rs2.getString("semester"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        cancel=new JButton("Cancel");
        cancel.setBounds(250,500,120,30);
        cancel.setBackground(Color.RED);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        cancel.setFont(new Font("Tahoma",Font.BOLD,20 ));
        add(cancel);

        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
    }

    public static void main(String[] args) {
        new Marks("");
    }
}
