package HomeWork8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class BattleField extends JPanel {
    private GameWindow gameWindow;
    private int mode;
    private int fieldSize;
    private int winningLength;
    private boolean isInit; //становится true, когда уже введены параметры первой игры
    int cellHeight;
    int cellWidth;


    public BattleField(GameWindow gameWindow) {
        this.gameWindow = gameWindow;
        setBackground(Color.ORANGE);
        // Назначение действие при клике на ячейки
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                int cellX = e.getX() / cellWidth;
                int cellY = e.getY() / cellHeight;
                if (!Logic.isFinished) { // Если игра не закончилась
                    Logic.humanTurn(cellX, cellY); // Запуск процедуры записи хода пользователя
                    if (Logic.isFinished) {
                        // Действие при завершение игры
                    }
                }
                repaint();

            }
        });
    }

    public void startNewGame(int mode, int fieldSize, int winningLength) {
        this.mode = mode;
        this.fieldSize = fieldSize;
        this.winningLength = winningLength;
        isInit = true;

        repaint(); // Для запуска перерисовки
    }


    // Переопределение метода paint (прорисовки)
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (!isInit) { // Выходить если впервая раз прорисовка и пользователь не ввел параметры
            return;
        }
        // Отображение гор. и верт. линий
        cellHeight = getHeight() / fieldSize;
        cellWidth = getWidth() / fieldSize;
        for (int i = 0; i < fieldSize; i++) {
            int y = i * cellHeight;
            g.drawLine(0, y, getWidth(), y);
        }
        for (int i = 0; i < fieldSize; i++) {
            int x = i * cellWidth;
            g.drawLine(x, 0, x, getHeight());
        }
        // Прорисовка Х и О
        for (int i = 0; i < Logic.SIZE; i++) {
            for (int j = 0; j < Logic.SIZE; j++) {
                if (Logic.map[i][j] == Logic.DOT_X) {
                    // Крестик
                    drawX(g, j, i);
                }
                if (Logic.map[i][j] == Logic.DOT_O) {
                    // Нолик
                    drawO(g, j, i);
                }
            }

        }

    }
    // Нарисовать крестик
    private void drawX(Graphics g, int cellX, int cellY) {
        ((Graphics2D) g).setStroke(new BasicStroke(5));
        g.setColor(Color.MAGENTA);
        g.drawLine(cellX * cellWidth + 5, cellY * cellHeight + 5, (cellX + 1) * cellWidth - 5, (cellY + 1) * cellHeight - 5);
        g.drawLine(cellX * cellWidth + 5, (cellY+1) * cellHeight - 5, (cellX + 1) * cellWidth - 5, cellY * cellHeight + 5);
    }
    // Нарисовать нолик
    private void drawO(Graphics g, int cellX, int cellY) {
        ((Graphics2D) g).setStroke(new BasicStroke(5));
        g.setColor(Color.BLUE);
        g.drawOval(cellX * cellWidth + 5, cellY * cellHeight + 5,  cellWidth - 10,  cellHeight - 10);
    }
}
