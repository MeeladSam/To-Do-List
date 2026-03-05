import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TaskListPanel extends JPanel {

    private DefaultListModel<String> model;
    private JList<String> taskList;

    public TaskListPanel(){
        setLayout(null);
        setBackground(Color.WHITE);

        model = new DefaultListModel<>();

        taskList = new JList<>(model);
        taskList.setFont(new Font("Arial", Font.PLAIN,16));
        taskList.setSelectionBackground(new Color(200,220,255));

        taskList.setCellRenderer(new TaskCellRenderer());

        JScrollPane scroll = new JScrollPane(taskList);
        scroll.setBounds(0,0,250,260);
        add(scroll);
    }

    public void addTask(String text){
        model.addElement(text);
    }

    public void markTaskDone(){
        int index = taskList.getSelectedIndex();
        if(index != -1){
            String task = model.getElementAt(index);
            model.set(index, "✔ " + task);

            Timer timer = new Timer(2000, e -> model.remove(index));
            timer.setRepeats(false);
            timer.start();
        }
    }

    public void editTask(){
        int index = taskList.getSelectedIndex();
        if(index != -1){
            String newTask = JOptionPane.showInputDialog(
                    this,
                    "Edit Task:",
                    model.getElementAt(index)
            );

            if(newTask != null && !newTask.isEmpty()){
                model.set(index,newTask);
            }
        }
    }
}