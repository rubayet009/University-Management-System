package universityManagement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class EnterMarks extends JFrame implements ActionListener {
    Choice crollno;
    JComboBox cbsemester;
    JTextField tfsub1,tfsub2,tfsub3,tfsub4,tfsub5,tfmarks1,tfmarks2,tfmarks3,tfmarks4,tfmarks5;
    JButton submit,cancel;
    EnterMarks(){
        setSize(1000,600);
        setLocation(300,150);
        setLayout(null);
        getContentPane().setBackground(Color.ORANGE);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/icons.jpeg"));
        Image i2=i1.getImage().getScaledInstance(200,150,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(700,20,200,150);
        add(image);

        JLabel heading=new JLabel("Enter Marks:");
        heading.setBounds(50,10,500,50);
        heading.setFont(new Font("Tahoma", Font.BOLD,30));
        add(heading);
        JLabel lblrollno=new JLabel("Select Roll:");
        lblrollno.setBounds(50,130,150,20);
        lblrollno.setFont(new Font("Tahoma", Font.PLAIN,20));
        add(lblrollno);


        crollno=new Choice();
        crollno.setBounds(210,130,150,20);
        add(crollno);

        try{
            Conn c=new Conn();
            ResultSet rs=c.s.executeQuery("select * from student");
            while(rs.next()){
                crollno.add(rs.getString("roll"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        String semester[]={"1st","2nd","3rd","4th","5th","6th","7th","8th"};
        JLabel lblsemester=new JLabel("Select Semester:");
        lblsemester.setBounds(50,160,150,20);
        lblsemester.setFont(new Font("Tahoma", Font.PLAIN,20));
        add(lblsemester);

        cbsemester=new JComboBox(semester);
        cbsemester.setBounds(210,160,150,20);
        add(cbsemester);

        JLabel lblentersub=new JLabel("Select Subject :");
        lblentersub.setBounds(200,220,150,20);
        lblentersub.setFont(new Font("Tahoma", Font.PLAIN,20));
        add(lblentersub);

        JLabel lblmarks=new JLabel("Enter Marks :");
        lblmarks.setBounds(500,220,150,20);
        lblmarks.setFont(new Font("Tahoma", Font.PLAIN,20));
        add(lblmarks);

        tfsub1=new JTextField();
        tfsub1.setBounds(200,250,150,20);
        add(tfsub1);
        tfsub2=new JTextField();
        tfsub2.setBounds(200,280,150,20);
        add(tfsub2);
        tfsub3=new JTextField();
        tfsub3.setBounds(200,310,150,20);
        add(tfsub3);
        tfsub4=new JTextField();
        tfsub4.setBounds(200,340,150,20);
        add(tfsub4);
        tfsub5=new JTextField();
        tfsub5.setBounds(200,370,150,20);
        add(tfsub5);

        tfmarks1=new JTextField();
        tfmarks1.setBounds(500,250,150,20);
        add(tfmarks1);
        tfmarks2=new JTextField();
        tfmarks2.setBounds(500,280,150,20);
        add(tfmarks2);
        tfmarks3=new JTextField();
        tfmarks3.setBounds(500,310,150,20);
        add(tfmarks3);
        tfmarks4=new JTextField();
        tfmarks4.setBounds(500,340,150,20);
        add(tfmarks4);
        tfmarks5=new JTextField();
        tfmarks5.setBounds(500,370,150,20);
        add(tfmarks5);

        submit=new JButton("Submit");
        submit.setBounds(250,450,120,30);
        submit.setBackground(Color.WHITE);
        submit.setForeground(Color.GREEN);
        submit.addActionListener(this);
        submit.setFont(new Font("Tahoma",Font.BOLD,20));
        add(submit);

        cancel=new JButton("Cancel");
        cancel.setBounds(500,450,120,30);
        cancel.setBackground(Color.RED);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        cancel.setFont(new Font("Tahoma",Font.BOLD,20 ));
        add(cancel);

        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == submit) {
            try {
                Conn c = new Conn();

                String query1 = "insert into subject values('"+crollno.getSelectedItem()+"', '"+cbsemester.getSelectedItem()+"', '"+tfsub1.getText()+"', '"+tfsub2.getText()+"', '"+tfsub3.getText()+"', '"+tfsub4.getText()+"', '"+tfsub5.getText()+"')";
                String query2 = "insert into mark values('"+crollno.getSelectedItem()+"', '"+cbsemester.getSelectedItem()+"', '"+tfmarks1.getText()+"', '"+tfmarks2.getText()+"', '"+tfmarks3.getText()+"', '"+tfmarks4.getText()+"', '"+tfmarks5.getText()+"')";

                c.s.executeUpdate(query1);
                c.s.executeUpdate(query2);

                JOptionPane.showMessageDialog(null, "Marks Inserted Sucessfully");
                setVisible(false);
                new EnterMarks();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            setVisible(false);
        }
    }
    public static void main(String[] args) {
        new EnterMarks();
    }
}
