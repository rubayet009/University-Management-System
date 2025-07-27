package universityManagement;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class TeacherLeave extends JFrame implements ActionListener {
    Choice cEmpId,ctime;
    JDateChooser dcdate;
    JButton submit,cancel;
    TeacherLeave(){
        setSize(500,550);
        setLocation(550,100);
        setLayout(null);
        getContentPane().setBackground(Color.YELLOW);

        JLabel heading=new JLabel("Apply Leave (teacher) :");
        heading.setBounds(40,50,300,30);
        heading.setFont(new Font("Tahoma", Font.BOLD,20));
        add(heading);

        JLabel lblrollnum=new JLabel("Search Employee Id :");
        lblrollnum.setBounds(50,100,150,20);
        lblrollnum.setFont(new Font("serif", Font.PLAIN,18));
        add(lblrollnum);


        cEmpId =new Choice();
        cEmpId.setBounds(180,100,120,20);
        add(cEmpId);

        try{
            Conn c=new Conn();
            ResultSet rs=c.s.executeQuery("select * from teacher");
            while(rs.next()){
                cEmpId.add(rs.getString("id"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        JLabel lbldate=new JLabel("Date :");
        lbldate.setBounds(50,140,120,20);
        lbldate.setFont(new Font("serif", Font.PLAIN,18));
        add(lbldate);
        dcdate =new JDateChooser();
        dcdate.setBounds(180,140,120,20);
        add(dcdate);

        JLabel lbltime=new JLabel("Time :");
        lbltime.setBounds(50,180,120,20);
        lbltime.setFont(new Font("serif", Font.PLAIN,18));
        add(lbltime);

        ctime=new Choice();
        ctime.setBounds(180,180,120,20);
        ctime.add("Half Day");
        ctime.add("Full Day");
        add(ctime);

        submit=new JButton("Submit");
        submit.setBounds(50,350,120,30);
        submit.setBackground(Color.WHITE);
        submit.setForeground(Color.GREEN);
        submit.addActionListener(this);
        submit.setFont(new Font("Tahoma",Font.BOLD,20));
        add(submit);

        cancel=new JButton("Cancel");
        cancel.setBounds(300,350,120,30);
        cancel.setBackground(Color.WHITE);
        cancel.setForeground(Color.RED);
        cancel.addActionListener(this);
        cancel.setFont(new Font("Tahoma",Font.BOLD,20 ));
        add(cancel);

        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==submit){
            String eMid= cEmpId.getSelectedItem();
            String date=((JTextField)dcdate.getDateEditor().getUiComponent()).getText();
            String duration=ctime.getSelectedItem();
            String query = "insert into teacherleave values('"+eMid+"', '"+ date + "', '" + duration + "')";

            try{
                Conn c=new Conn();
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Leave Confirmed");
                setVisible(false);
            } catch (Exception e) {
                e.printStackTrace();
            }

        } else if (ae.getSource()==cancel) {
            setVisible(false);
        }
    }
    public static void main(String[] args) {
        new TeacherLeave();
    }
}
