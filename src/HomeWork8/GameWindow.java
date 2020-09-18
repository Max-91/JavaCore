package HomeWork8;

import javax.swing.*;
import java.awt.*;

public class GameWindow extends JFrame {
    static final int WINDOW_X = 500;
    static final int WINDOW_Y = 100;
    static final int WINDOW_WIDTH = 505;
    static final int WINDOW_HEIGHT = 555;

    private BattleField battleField;
    private SettingWindow settingWindow;
    // Конструктор (создание элементов окна)
    public GameWindow() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); // При закрытие окна закрывается приложение
        setBounds(WINDOW_X,WINDOW_Y,WINDOW_WIDTH,WINDOW_HEIGHT);
        setTitle("TicTacToe");

        battleField = new BattleField(this);  // Инициализация (конструктор) панели BattleField;
        add(battleField,BorderLayout.CENTER);

        settingWindow = new SettingWindow(this); // Инициализация (конструктор) окна Setting;

        // Формирование панели с 2 клавишами внизу окна
        JPanel jPanel= new JPanel(new GridLayout(1,2));
        JButton buttonNewGame = new JButton("Старт новой игры");
        JButton buttonExit = new JButton("Выход");

        jPanel.add(buttonNewGame);
        jPanel.add(buttonExit);
        add(jPanel,BorderLayout.SOUTH);

        buttonNewGame.addActionListener(e -> {
            settingWindow.setVisible(true);
        });

        buttonExit.addActionListener(e -> {
            System.exit(0);
        });


        setVisible(true);
    }
    // Метод для создание (инициализации) новой игры
    public void startNewGame(int mode, int fieldSize, int winningLength)    {
        battleField.startNewGame(mode,fieldSize,winningLength);
    }
}
