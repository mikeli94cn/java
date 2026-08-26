import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

/**
 *
 */
public class SwingCountAppV2 extends JFrame implements ActionListener {

    private JLabel lbl = new JLabel("counter");
    private JTextField tf = new JTextField("0", 10);
    private JButton btn = new JButton("click");
    private int cnt = 0;

    public SwingCountApp() {
        setLayout(new FlowLayout());
        add(lbl);
        add(tf);
        add(btn);

        setSize(400, 300);
        setTitle("swing count");
        setVisible(true);

        /*
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                dispose();
                System.exit(0);
            }
        });
         */
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        tf.setEditable(false);

        btn.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        cnt++;
        tf.setText(String.valueOf(cnt));
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new SwingCountApp();
            }
        });
    }

}
