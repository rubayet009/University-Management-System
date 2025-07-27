package universityManagement;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class TeacherLeaveDetails extends JFrame implements ActionListener {
    Choice Id;
    JTable table;
    JButton search,print,cancel;
    TeacherLeaveDetails(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

//        JLabel heading=new JLabel("Search:");
//        heading.setBounds(20,20,150,20);
//        add(heading);


        Id =new Choice();
        Id.setBounds(20,20,150,20);
        add(Id);

        try{
            Conn c=new Conn();
            ResultSet rs=c.s.executeQuery("select * from teacherleave");
            while(rs.next()){
                Id.add(rs.getString("eMid"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        table =new JTable();
        try{
            Conn c=new Conn();
            ResultSet rs=c.s.executeQuery("select * from teacherleave");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            e.printStackTrace();
        }


        JScrollPane jsp=new JScrollPane(table);
        jsp.setBounds(0,100,900,800);
        add(jsp);

        search =new JButton("Search");
        search.setBounds(180,20,80,20);
        search.addActionListener(this);
        add(search);

        print =new JButton("Print");
        print.setBounds(20,70,80,20);
        print.addActionListener(this);
        add(print);



        cancel =new JButton("Cancel");
        cancel.setBounds(120,70,80,20);
        cancel.addActionListener(this);
        add(cancel);



        setSize(900,700);
        setLocation(300,50);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==search){
            String query="select * from teacherleave where eMid = '"+ Id.getSelectedItem()+"'";
            try {
                Conn c=new Conn();
                ResultSet rs=c.s.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(rs));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else if(ae.getSource()==print){
            try {
                table.print();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }  else if (ae.getSource()==cancel) {
            setVisible(false);
        }

    }

    public static void main(String[] args) {
        new TeacherLeaveDetails();
    }
}
