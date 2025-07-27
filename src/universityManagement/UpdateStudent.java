package universityManagement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;

public class UpdateStudent extends JFrame implements ActionListener {
    JTextField tfcourse,address,phone,tfemail,lbldeptname;

    JLabel rollnum;
    JButton submit,cancel;
    Choice crollno;
    UpdateStudent(){
        setSize(900,700);
        setLocation(350,50);
        setLayout(null);

        JLabel heading=new JLabel("Update Student Details:");
        heading.setBounds(50,10,500,50);
        heading.setFont(new Font("Tahoma", Font.ITALIC,30));
        add(heading);
        JLabel lblrollno=new JLabel("Select Roll:");
        lblrollno.setBounds(50,130,300,20);
        lblrollno.setFont(new Font("Tahoma", Font.PLAIN,20));
        add(lblrollno);


        crollno=new Choice();
        crollno.setBounds(370,130,300,20);
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

        JLabel lblname=new JLabel("Student Name:");
        lblname.setBounds(50,160,300,20);
        lblname.setFont(new Font("serif", Font.BOLD,20));
        add(lblname);

        JLabel lablename=new JLabel();
        lablename.setBounds(370,160,300,20);
        lablename.setFont(new Font("Tahoma", Font.PLAIN,20));
        add(lablename);

        JLabel fathername=new JLabel("Father's Name:");
        fathername.setBounds(50,190,300,20);
        fathername.setFont(new Font("serif", Font.BOLD,20));
        add(fathername);
        JLabel lblfname=new JLabel();
        lblfname.setBounds(370,190,300,20);
        lblfname.setFont(new Font("Tahoma", Font.PLAIN,20));
        add(lblfname);

        JLabel roll=new JLabel("Roll:");
        roll.setBounds(50,220,300,20);
        roll.setFont(new Font("serif", Font.BOLD,20));
        add(roll);
        rollnum =new JLabel();
        rollnum.setBounds(370,220,300,25);
        rollnum.setFont(new Font("serif", Font.PLAIN,20));
        add(rollnum);

        JLabel db=new JLabel("Date of Birth:");
        db.setBounds(50,250,300,20);
        db.setFont(new Font("serif", Font.BOLD,20));
        add(db);

        JLabel lbldb=new JLabel();
        lbldb.setBounds(370,250,300,20);
        lbldb.setFont(new Font("Tahoma", Font.PLAIN,20));
        add(lbldb);

        JLabel addr=new JLabel("Address:");
        addr.setBounds(50,280,300,20);
        addr.setFont(new Font("serif", Font.BOLD,20));
        add(addr);
        address=new JTextField();
        address.setBounds(370,280,300,25);
        address.setFont(new Font("Tahoma", Font.PLAIN,20));
        add(address);

        JLabel phn=new JLabel("Phone:");
        phn.setBounds(50,310,300,20);
        phn.setFont(new Font("serif", Font.BOLD,20));
        add(phn);
        phone=new JTextField();
        phone.setBounds(370,310,300,25);
        phone.setFont(new Font("Tahoma", Font.PLAIN,20));
        add(phone);

        JLabel emil=new JLabel("Email:");
        emil.setBounds(50,340,300,20);
        emil.setFont(new Font("serif", Font.BOLD,20));
        add(emil);
        tfemail=new JTextField();
        tfemail.setBounds(370,340,300,25);
        tfemail.setFont(new Font("Tahoma", Font.PLAIN,20));
        add(tfemail);

        JLabel ssc=new JLabel("SSC GPA:");
        ssc.setBounds(50,370,300,20);
        ssc.setFont(new Font("serif", Font.BOLD,20));
        add(ssc);
        JLabel lblssc=new JLabel();
        lblssc.setBounds(370,370,300,20);
        lblssc.setFont(new Font("Tahoma", Font.PLAIN,20));
        add(lblssc);

        JLabel hsc=new JLabel("HSC GPA:");
        hsc.setBounds(50,400,150,20);
        hsc.setFont(new Font("serif", Font.BOLD,20));
        add(hsc);
        JLabel lblhsc=new JLabel();
        lblhsc.setBounds(370,400,300,20);
        lblhsc.setFont(new Font("Tahoma", Font.PLAIN,20));
        add(lblhsc);

        JLabel nid=new JLabel("NID NO:");
        nid.setBounds(50,430,150,20);
        nid.setFont(new Font("serif", Font.BOLD,20));
        add(nid);
        JLabel lblnid=new JLabel();
        lblnid.setBounds(370,430,300,20);
        lblnid.setFont(new Font("Tahoma", Font.PLAIN,20));
        add(lblnid);

        JLabel course=new JLabel("Course:");
        course.setBounds(50,460,150,20);
        course.setFont(new Font("serif", Font.BOLD,20));
        add(course);
        String coursename[]={"BSC","BBA","BA","MSC","MBA","PHD"};
        tfcourse =new JTextField();
        tfcourse.setBackground(Color.WHITE);
        tfcourse.setBounds(370,460,300,25);
        tfcourse.setFont(new Font("Tahoma", Font.PLAIN,20));
        add(tfcourse);

        JLabel dept=new JLabel("Department:");
        dept.setBounds(50,490,150,20);
        dept.setFont(new Font("serif", Font.BOLD,20));
        add(dept);

        lbldeptname =new JTextField();
        lbldeptname.setBackground(Color.WHITE);
        lbldeptname.setBounds(370,490,300,25);
        lbldeptname.setFont(new Font("Tahoma", Font.PLAIN,20));
        add(lbldeptname);

        try{
          Conn c=new Conn();
          String query="select * from student where roll=('"+crollno.getSelectedItem()+"')";
          ResultSet rs=c.s.executeQuery(query);
          while(rs.next()){
              lablename.setText(rs.getString("name"));
              lblfname.setText(rs.getString("fname"));
              rollnum.setText(rs.getString("roll"));
              lbldb.setText(rs.getString("date"));
              address.setText(rs.getString("addrs"));
              phone.setText(rs.getString("ph"));
              tfemail.setText(rs.getString("email"));
              lblssc.setText(rs.getString("sscgpa"));
              lblhsc.setText(rs.getString("hscgpa"));
              lblnid.setText(rs.getString("nid"));
              tfcourse.setText(rs.getString("crs"));
              lbldeptname.setText(rs.getString("department"));
          }
        } catch (Exception e) {
            e.printStackTrace();
        }

        crollno.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                try{
                    Conn c=new Conn();
                    String query="select * from student where roll=('"+crollno.getSelectedItem()+"')";
                    ResultSet rs=c.s.executeQuery(query);
                    while(rs.next()){
                        lablename.setText(rs.getString("name"));
                        lblfname.setText(rs.getString("fname"));
                        rollnum.setText(rs.getString("roll"));
                        lbldb.setText(rs.getString("date"));
                        address.setText(rs.getString("addrs"));
                        phone.setText(rs.getString("ph"));
                        tfemail.setText(rs.getString("email"));
                        lblssc.setText(rs.getString("sscgpa"));
                        lblhsc.setText(rs.getString("hscgpa"));
                        lblnid.setText(rs.getString("nid"));
                        tfcourse.setText(rs.getString("crs"));
                        lbldeptname.setText(rs.getString("department"));
                    }
                } catch (Exception ex) {
                    ex .printStackTrace();
                }
            }
        });


        submit=new JButton("Update");
        submit.setBounds(200,550,120,30);
        submit.setBackground(Color.WHITE);
        submit.setForeground(Color.GREEN);
        submit.addActionListener(this);
        submit.setFont(new Font("Tahoma",Font.BOLD,20));
        add(submit);

        cancel=new JButton("Cancel");
        cancel.setBounds(500,550,120,30);
        cancel.setBackground(Color.RED);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        cancel.setFont(new Font("Tahoma",Font.BOLD,20 ));
        add(cancel);

        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==submit){
            String roll= rollnum.getText();
            String ph= phone.getText();
            String addrs= address.getText();
            String email= tfemail.getText();
            String crs=tfcourse.getText();
            String department=lbldeptname.getText();

            try {
                String query="update student set ph='"+ph+"',addrs='"+addrs+"',email='"+email+"' ,crs='"+crs+"',department= '"+department+"' where roll='"+roll+"'";
                Conn con=new Conn();
                con.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"student details updated successfully");
                setVisible(false);

            } catch (Exception e) {
                e.printStackTrace();
            }

        }else setVisible(false);

    }
    public static void main(String[] args) {
        new UpdateStudent();
    }
}
