import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class AwtCounterApp extends Frame implements ActionListener {
    private Label lblCount;
    private TextField tfCount;
    private Button btnCount;
    private int count = 0;

    public AwtCounterApp() {
        setLayout(new FlowLayout());

        lblCount = new Label("Counter:");
        tfCount = new TextField("0", 10);
        tfCount.setEditable(false);
        btnCount = new Button("Click");

        add(lblCount);
        add(tfCount);
        add(btnCount);

        btnCount.addActionListener(this);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                dispose();
                System.exit(0);
            }
        });

        setTitle("awt counter application");
        setSize(400, 150);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        count++;
        tfCount.setText(String.valueOf(count));
    }

    public static void main(String[] args) {
        new AwtCounterApp();
    }
}
