package ru.vsu.cs.kunakhova_a_y;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;

import util.ArrayUtils;
import util.JTableUtils;
import util.SwingUtils;

public class FrameMain extends JFrame {
    private final JFileChooser fileChooserOpen;
    private final JFileChooser fileChooserSave;
    private JButton buttonRunStandard;
    private JButton buttonInputFromFile;
    private JButton buttonSaveToFile;
    private JPanel PanelMain;
    private JButton buttonRunStack;
    private JButton buttonRunRecursion;
    private JTable tableInput;
    private JTable tableOutput;

    public FrameMain() {
        this.setTitle("Task 3");
        this.setContentPane(PanelMain);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(700, 200, 300, 300);
        this.pack();

        JTableUtils.initJTableForArray(tableInput, 40, true, true, true, true);
        JTableUtils.initJTableForArray(tableOutput, 40, true, true, true, true);
        tableInput.setRowHeight(25);
        tableOutput.setRowHeight(25);

        fileChooserOpen = new JFileChooser();
        fileChooserSave = new JFileChooser();
        fileChooserOpen.setCurrentDirectory(new File("."));
        fileChooserSave.setCurrentDirectory(new File("."));
        FileFilter filter = new FileNameExtensionFilter("Text files", "txt");
        fileChooserOpen.addChoosableFileFilter(filter);
        fileChooserSave.addChoosableFileFilter(filter);

        fileChooserSave.setAcceptAllFileFilterUsed(false);
        fileChooserSave.setDialogType(JFileChooser.SAVE_DIALOG);
        fileChooserSave.setApproveButtonText("Save");

        JMenuBar menuBarMain = new JMenuBar();
        setJMenuBar(menuBarMain);

        JMenu menuLookAndFeel = new JMenu();
        menuLookAndFeel.setText("Вариант 3");
        menuBarMain.add(menuLookAndFeel);
        SwingUtils.initLookAndFeelMenu(menuLookAndFeel);

        this.pack();
        buttonInputFromFile.addActionListener(actionEvent ->{
                try {
                    if (fileChooserOpen.showOpenDialog(PanelMain) == JFileChooser.APPROVE_OPTION) {
                        int[] arr = ArrayUtils.readIntArrayFromFile(fileChooserOpen.getSelectedFile().getPath());
                        assert arr != null;
                        JTableUtils.writeArrayToJTable(tableInput, arr);
                    }
                } catch (Exception e) {
                    SwingUtils.showErrorMessageBox(e);
                }

        });

        buttonSaveToFile.addActionListener(actionEvent -> {
                try {
                    if (fileChooserSave.showSaveDialog(PanelMain) == JFileChooser.APPROVE_OPTION) {
                        int[] result = JTableUtils.readIntArrayFromJTable(tableOutput);
                        String file = fileChooserSave.getSelectedFile().getPath();
                        if (!file.toLowerCase().endsWith(".txt")) {
                            file += ".txt";
                        }
                       ArrayUtils.writeArrayToFile(file, result);
                    }
                } catch (Exception e) {
                    SwingUtils.showErrorMessageBox(e);
                }
        });
        buttonRunStack.addActionListener(actionEvent -> {
            try {
                int input = ArrayUtils.arrayToInt(JTableUtils.readIntArrayFromJTable(tableInput));
                JTableUtils.writeArrayToJTable(tableOutput,ArrayUtils.intToArray(BuildYByX.buildY(input)));
            } catch (Exception e) {
                SwingUtils.showErrorMessageBox(e);
            }
        });
        buttonRunStandard.addActionListener(actionEvent -> {
            try {
                int input = ArrayUtils.arrayToInt(JTableUtils.readIntArrayFromJTable(tableInput));
                JTableUtils.writeArrayToJTable(tableOutput,ArrayUtils.intToArray(BuildYByX.buildYStandard(input)));
            } catch (Exception e) {
                SwingUtils.showErrorMessageBox(e);
            }
        });
        buttonRunRecursion.addActionListener(actionEvent -> {
            try {
                int input = ArrayUtils.arrayToInt(JTableUtils.readIntArrayFromJTable(tableInput));
                JTableUtils.writeArrayToJTable(tableOutput,ArrayUtils.intToArray(BuildYByX.buildYByXRecursive(input)));
            } catch (Exception e) {
                SwingUtils.showErrorMessageBox(e);
            }
        });
    }
}
