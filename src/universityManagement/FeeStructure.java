package universityManagement;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;

public class FeeStructure extends JFrame {
    FeeStructure(){
        setSize(1000,700);
        setLocation(250,50);
        setLayout(null);
        JLabel heading=new JLabel("Fee Structure:");
        heading.setBounds(50,10,500,50);
        heading.setFont(new Font("serif", Font.BOLD,30));
        add(heading);

        JTable table=new JTable();
        try {
            Conn c=new Conn();
            ResultSet rs=c.s.executeQuery("select * from fee");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            e.printStackTrace();
        }
        JScrollPane jsp=new JScrollPane(table);
        jsp.setBounds(0,100,1000,700);
        add(jsp);


        setVisible(true);
    }
    public static void main(String[] args) {
        new  FeeStructure();
    }
}
