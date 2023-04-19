import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ExitPage extends JFrame implements ActionListener {
    private static final long serialVersionUID = 1L;
    private JButton button;

    public ExitPage() {
        createWindow();
        setResizable(false);
    }

    private void createWindow() {
        setTitle("Death Screen");
        setSize(1000, 563);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridBagLayout());

        ImageIcon imageIcon = new ImageIcon(getClass().getResource("/Poslovilo.png"));
        JLabel imageLabel = new JLabel(imageIcon);
        imageLabel.setLayout(new GridBagLayout());
        add(imageLabel);

        button = new JButton("Zaniè si!");
        button.addActionListener(this);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.CENTER;
        imageLabel.add(button, gbc);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button) {
            Menu menu = new Menu();
            menu.setVisible(true);
            dispose();
        }
    }
}
