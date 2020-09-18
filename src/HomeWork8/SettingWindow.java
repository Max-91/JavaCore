package HomeWork8;

import sun.rmi.runtime.Log;

import javax.swing.*;
import java.awt.*;

public class SettingWindow extends JFrame {
    private GameWindow gameWindow;
    static final int WINDOW_X = GameWindow.WINDOW_X + 50;
    static final int WINDOW_Y = GameWindow.WINDOW_Y + 50;
    static final int WINDOW_WIDTH = 405;
    static final int WINDOW_HEIGHT = 300;
    private static final int MIN_FIELD_SIZE = 3;
    private static final int MAX_FIELD_SIZE = 10;

    static final int MODE_H_VS_A = 0;
    static final int MODE_H_VS_H = 1;

    private JRadioButton jrbHumVsAi;
    private JRadioButton jrbHumVsHum;
    private ButtonGroup gameModeGroup;
    private JSlider slFieldSize;
    private JSlider slWinningLength;

    public SettingWindow(GameWindow gameWindow) {
        this.gameWindow = gameWindow;
        setBounds(WINDOW_X, WINDOW_Y, WINDOW_WIDTH, WINDOW_HEIGHT);
        setTitle("Настройки новой игры");
        setLayout(new GridLayout(8, 1));
        //Область выбора режима игры
        add(new JLabel("Выберите режим игры"));
        jrbHumVsAi = new JRadioButton("Человек-ПК", true);
        jrbHumVsHum = new JRadioButton("Человек-Человек");
        jrbHumVsHum.setEnabled(false);
        gameModeGroup = new ButtonGroup();
        gameModeGroup.add(jrbHumVsAi);
        gameModeGroup.add(jrbHumVsHum);
        add(jrbHumVsAi);
        add(jrbHumVsHum);
        //Область выбора размера поля
        add(new JLabel("Выберите размер поля"));
        slFieldSize = new JSlider(MIN_FIELD_SIZE, MAX_FIELD_SIZE, MIN_FIELD_SIZE);
        slFieldSize.setMajorTickSpacing(1);
        slFieldSize.setPaintLabels(true);
        slFieldSize.setPaintTicks(true);
        add(slFieldSize);
        //Область выбора кол-ва фишек для победы
        add(new JLabel("Выберите длину линии победы"));
        slWinningLength = new JSlider(MIN_FIELD_SIZE, MIN_FIELD_SIZE, MIN_FIELD_SIZE);
        slWinningLength.setMajorTickSpacing(1);
        slWinningLength.setPaintLabels(true);
        slWinningLength.setPaintTicks(true);
        add(slWinningLength);
        // Действие при изменение размера поля (изменение макс.кол-ва фишек для победы)
        slFieldSize.addChangeListener(e -> {
            slWinningLength.setMaximum(slFieldSize.getValue());
        });
        //Клавиша Старт игры
        JButton buttonStartGame = new JButton("Запуск новой игры");
        add(buttonStartGame);
        buttonStartGame.addActionListener(e -> {
            int mode;
            if (jrbHumVsAi.isSelected()) {
                mode = MODE_H_VS_A;
            } else {
                mode = MODE_H_VS_H;
            }
            int fieldSize = slFieldSize.getValue();
            int winningLength = slWinningLength.getValue();
            Logic.SIZE = fieldSize;
            Logic.DOT_TO_WIN = winningLength;
            Logic.initMap();
            Logic.isFinished=false;
            gameWindow.startNewGame(mode, fieldSize, winningLength);

            setVisible(false);

        });


        setVisible(false);

    }
}
