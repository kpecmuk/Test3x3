import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
    private final int COLS = 5;
    private final int ROWS = 5;
    private final int IMAGE_SIZE = 128;

    public static void main(String[] args) {

        new Runner().setVisible(true);
    }

    private Runner() {
        game = new Game(COLS, ROWS);
        game.start();
        setImage();
        initLabel();
        initPanel();
        initFrame();
    }

    private void initLabel() {
        label = new JLabel(" Welcome!");
        add(label, BorderLayout.SOUTH);
    }

    private void initPanel() {
        panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);

                for (Cell cell : game.field().getGF()) {
                    g.drawImage((Image) game.getBox(cell).image,
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
                if (e.getButton() == MouseEvent.BUTTON1) {
                    game.pressLeftButton(coord);
                }

//                label.setText(getMessage());
                panel.repaint();
            }
        });

        panel.setPreferredSize(new Dimension(COLS * IMAGE_SIZE, ROWS * IMAGE_SIZE));
        add(panel);
    }

    private void initFrame() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Logic 3x3 game");
        setResizable(false);
        setVisible(true);
        pack();
        setLocationRelativeTo(null);
        setIconImage(getImage("icon"));
    }

    private void setImage() {
        for (Box box : Box.values())
            box.image = getImage(box.name());
    }

    private Image getImage(String name) {
        String filename = "img/" + name.toLowerCase() + ".png";

        ImageIcon icon = null;
        try {
            icon = new ImageIcon(getClass().getResource(filename));
        } catch (NullPointerException e) {
            log.error("Can't load images");
        }

        assert icon != null;
        return icon.getImage();
    }
}