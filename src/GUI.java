import javax.swing.*;
import java.awt.event.*;
import java.awt.Color;
import java.awt.event.KeyEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
public class GUI extends JFrame {

    private JPanel mainPanel;
    private JButton buttonFwd;
    private JButton buttonRev;
    private JButton buttonRight;
    private JButton buttonLeft;
    private JRadioButton radioButton1;

    public GUI(String title) {
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.pack();

        buttonFwd.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_UP) {
                    buttonFwd.setBackground(Color.GREEN);
                    System.out.println("Fwd");
                } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    buttonRev.setBackground(Color.RED);
                    System.out.println("Revers");
                } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    buttonLeft.setBackground(Color.GREEN);
                    System.out.println("Left");
                } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    buttonRight.setBackground(Color.GREEN);
                    System.out.println("Right");
                }
            }
        });

        buttonFwd.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_UP) {
                    buttonFwd.setBackground(getBackground());
                }
                else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    buttonRev.setBackground(getBackground());
                }
                else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    buttonLeft.setBackground(getBackground());
                }
                else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    buttonRight.setBackground(getBackground());
                }
            }
        });
    }

    public static void main(String[] args) {
                JFrame frame = new GUI("Car GUI");
                frame.setVisible(true);

            }
        }
