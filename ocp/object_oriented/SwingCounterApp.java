import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SwingCounterApp extends JFrame implements ActionListener {
    private JLabel lblCount;
    private JTextField tfCount;
    private JButton btnCount;
    private int count = 0;

    public SwingCounterApp() {
        setLayout(new FlowLayout());

        lblCount = new JLabel("Counter: ");
        tfCount = new JTextField("0", 10);
        tfCount.setEditable(false);
        btnCount = new JButton("Click");

        // 4. Connect the button to the action listener
        btnCount.addActionListener(this);

        // 5. Replace WindowListener boilerplate with a single line
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        add(lblCount);
        add(tfCount);
        add(btnCount);

        setTitle("swing counter application");
        setSize(400, 150);

        setLocationRelativeTo(null);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        count++;
        tfCount.setText(String.valueOf(count));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new SwingCounterApp().setVisible(true);
            }
        });
    }
}
