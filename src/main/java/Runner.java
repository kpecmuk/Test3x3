import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileNotFoundException;

/**
 * Что это такое?
 * - ну это типа игры с полем 3 на 3 или больше, где требуется менять
 * иконки, жмякая на них, чтобы все из них стали одинаковыми.
 *
 * @author kpecmuk
 * @since 01.11.2019
 */
public class Runner extends JFrame {
    private static final Logger log = LoggerFactory.getLogger(Runner.class);

    private Game game;

    private JPanel panel;
    private JLabel label;
    private JButton resetButton;
    private final int COLS = 5;
    private final int ROWS = 5;
    private final int IMAGE_SIZE = 128;

    public static void main(String[] args) {

        try {
            new Runner().setVisible(true);
        } catch (FileNotFoundException e) {
            e.getMessage();
        }
    }

    private Runner() throws FileNotFoundException {
        game = new Game(COLS, ROWS);
        game.start();
        setImage();
        initLabel();
        initButtons();
        initPanel();
        initFrame();
    }

    private void initButtons() {
        resetButton = new JButton(" RESET ");
        resetButton.setFont(new Font("Century Gothic", Font.PLAIN, 18));
        resetButton.setSize(50, 30);
        resetButton.setBackground(Color.lightGray);
        resetButton.setBorderPainted(false);
        resetButton.setFocusPainted(false);
        resetButton.addActionListener(actionEvent -> {
            game.start();
            panel.repaint();
        });
        add(resetButton, BorderLayout.NORTH);
    }

    private void initLabel() {
        Font font = new Font("Century Gothic", Font.BOLD, 14);
        label = new JLabel(" (c) Kpecmuk 2019");
        label.setFont(font);
        add(label, BorderLayout.SOUTH);
    }

    private void initPanel() {
        panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);

                for (Cell cell : game.getField().getGF()) {
                    g.drawImage((Image) game.getIcon(cell).image,
                            cell.getCoord().getX() * IMAGE_SIZE, cell.getCoord().getY() * IMAGE_SIZE, this);
                }
            }
        };
        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {

                int x = e.getX() / IMAGE_SIZE;
                int y = e.getY() / IMAGE_SIZE;
                Coord coord = new Coord(x, y);
                Turn turn;
                if (e.getButton() == MouseEvent.BUTTON1)
                    turn = new TurnNext();                              // будем крутить вперёд
                else if (e.getButton() == MouseEvent.BUTTON3)
                    turn = new TurnPrevious();                          // будем крутить назад
                else return;                                            // нажали что-то, но не то

                turn.rightNow(coord, game.getField());                  // крутим
                panel.repaint();                                        // перерисовка
            }
        });
        panel.setPreferredSize(new Dimension(COLS * IMAGE_SIZE, ROWS * IMAGE_SIZE));
        add(panel);
    }

    private void initFrame() throws FileNotFoundException {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Logic " + COLS + "x" + ROWS + " game");
        setResizable(false);
        setVisible(true);
        pack();
        setLocationRelativeTo(null);
        setIconImage(getImage("icon"));
    }

    private void setImage() throws FileNotFoundException {
        for (Icons icons : Icons.values()) {
            icons.image = getImage(icons.name());
        }
    }

    private Image getImage(String name) throws FileNotFoundException {
        String filename = "img/" + name.toLowerCase() + ".png";

        ImageIcon icon;
        try {
            icon = new ImageIcon(getClass().getResource(filename));
        } catch (NullPointerException e) {
            log.error("Can't load images");
            throw new FileNotFoundException();
        }
        return icon.getImage();
    }
}