package universityManagement;
import javax.swing.*;
import java.awt.*;


public class Splash extends JFrame implements Runnable {
    Thread t;

    Splash(){
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/icon0.jpg"));
        Image i2=i1.getImage().getScaledInstance(1100,600,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        add(image);
        setVisible(true);

        t=new Thread(this);
        t.start();

        for (int i = 0; i <= 600; i++) {
            setLocation(800-i,700-i);
            setSize(i*2,i);
            try{
                Thread.sleep(5);
            }catch (Exception e){};
        }

    }

    @Override
    public void run() {
        try {
            Thread.sleep(7000);
            setVisible(false);
            //nextFrame
            new Login();
        }catch (Exception e){

        }
    }

    public static void main(String[] args) {
        Splash s=new Splash();
    }
}
