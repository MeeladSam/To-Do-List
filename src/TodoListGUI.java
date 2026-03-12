import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TodoListGUI {

    public static void main(String[] args) {

        JFrame frame = new JFrame("To-Do List");
        frame.setSize(450, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);

        frame.getContentPane().setBackground(new Color(230,240,255));

        Font font = new Font("Arial", Font.PLAIN,16);

        JTextField taskField = new JTextField();
        taskField.setBounds(100, 40, 180, 30);

        JButton addButton = new JButton("Add");
        addButton.setBounds(290, 40, 70, 30);
        addButton.setBackground(new Color(76,175,80));
        addButton.setForeground(Color.WHITE);

        TaskListPanel taskListPanel = new TaskListPanel();
        taskListPanel.setBounds(100,100,250,260);

        JButton doneButton = new JButton("Done");
        doneButton.setBounds(110,380,90,35);
        doneButton.setBackground(new Color(33,150,243));
        doneButton.setForeground(Color.WHITE);

        JButton editButton = new JButton("Edit");
        editButton.setBounds(230,380,90,35);
        editButton.setBackground(new Color(255,152,0));
        editButton.setForeground(Color.WHITE);

        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                String task = taskField.getText().trim();

                if(!task.isEmpty()){
                    taskListPanel.addTask(task);
                    taskField.setText("");
                }
            }
        });

        doneButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                taskListPanel.markTaskDone();
            }
        });

        editButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                taskListPanel.editTask();
            }
        });

        frame.add(taskField);
        frame.add(addButton);
        frame.add(taskListPanel);
        frame.add(doneButton);
        frame.add(editButton);

        frame.setVisible(true);
    }
}
