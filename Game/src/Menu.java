import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JFrame implements ActionListener {
    private static final long serialVersionUID = 1L;
    private JButton button1;
    private JButton button2;

    public Menu() {
        createWindow();
        setResizable(false);
    }

    private void createWindow() {
        setTitle("Meni");
        setSize(1000, 563);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridBagLayout());

        ImageIcon imageIcon = new ImageIcon(getClass().getResource("/Naslovnica.png"));
        JLabel imageLabel = new JLabel(imageIcon);
        imageLabel.setLayout(new GridBagLayout());
        add(imageLabel);

        button1 = new JButton("IGRAJ");
        button1.addActionListener(this);
        button1.setMargin(new Insets(5,35,5,35));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.CENTER;
        imageLabel.add(button1, gbc);
        
        
        button2 = new JButton("Izhod iz igre");
        button2.addActionListener(this);
        button2.setMargin(new Insets(5,18,5,19));
        GridBagConstraints gba = new GridBagConstraints();
        gba.gridx = 0;
        gba.gridy = 1;
        gba.anchor = GridBagConstraints.CENTER;
        imageLabel.add(button2, gba);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button1) {
            Game game = new Game();
            game.setVisible(true);
            dispose();
        } 
        
        if (e.getSource() == button2) {
            System.exit(0);
        }
    }

}
