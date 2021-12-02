import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Welcome extends JFrame implements ActionListener{


    JButton b;

    public Welcome() {

        setBounds(50,50, 1250, 600);

        setLayout(null);

        Container c = this.getContentPane();

        Font f = new Font("atomic", Font.BOLD, 30);

        b = new JButton("Next");

        b.setForeground(Color.BLACK);
        b.setFont(f);
        b.setBounds(580, 500, 100, 50);
        c.add(b);

        JLabel l = new JLabel("LTCE");
        ImageIcon i = new ImageIcon("C:\\Users\\Lenovo\\Downloads\\ltce.png");
        Image ii = i.getImage().getScaledInstance(300, 200, Image.SCALE_DEFAULT);
        ImageIcon ic = new ImageIcon(ii);
        l = new JLabel(ic);
        l.setBounds(520, 50, 300, 200);
        c.add(l);

        JLabel welcome = new JLabel("WELCOME TO");

        welcome.setFont(new Font("atomic", Font.BOLD, 40));
        welcome.setBounds(550, 200, 600, 200);
        c.add(welcome);

        JLabel first = new JLabel("LOKMANYA TILAK COLLEGE");

        first.setFont(new Font("atomic", Font.BOLD, 45));
        first.setBounds(380, 240, 700, 250);
        c.add(first);

        JLabel second = new JLabel("OF");

        second.setFont(new Font("atomic", Font.BOLD, 45));
        second.setBounds(630, 350, 400, 150);
        add(second);

        JLabel third = new JLabel("ENGINERRING");

        third.setFont(new Font("atomic", Font.BOLD, 45));
        third.setBounds(530, 370, 500, 200);
        c.add(third);


        b.addActionListener(this);
        validate();
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {
        this.setVisible(false);
        String[] s=null;
        OnlineTest.main(s);

    }

    public static void main(String[] args) {
        new Welcome();
    }
}
