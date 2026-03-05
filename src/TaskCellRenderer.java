import javax.swing.*;
import java.awt.*;

public class TaskCellRenderer extends DefaultListCellRenderer {

    @Override
    public Component getListCellRendererComponent(
            JList<?> list,//if i put string here it will give an error
            Object value,
            int index,
            boolean isSelected,
            boolean cellHasFocus){

        JLabel label = (JLabel) super.getListCellRendererComponent(
                list, value, index, isSelected, cellHasFocus);

        label.setBorder(BorderFactory.createMatteBorder(0,0,1,0,Color.LIGHT_GRAY));

        return label;
    }
}