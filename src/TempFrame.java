import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 * Created by Simone Salvo on 10/01/2018.
 */
public class TempFrame extends JFrame implements ActionListener, PropertyChangeListener {

    private static final String TEMPERATURE = "TEMPERATURE";
    private TempSensor tempSensor;
    private JLabel label;

    public static void main(String[] args) {
        new TempFrame();
    }

    private TempFrame() {
        this.tempSensor = TempSensor.InitTempSensor(false);

        JFrame frame = new JFrame("Temp Frame");
        JButton btn = new JButton("Start sensing");

        this.label = new JLabel();
        GridLayout experimentLayout = new GridLayout(0,1);

        btn.addActionListener(this);

        frame.setLayout(experimentLayout);
        frame.add(btn);
        frame.add(label);

        frame.setSize(450, 350);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.tempSensor.go();
        tempSensor.addPropertyChangeListener(this);

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        this.label.setText(TEMPERATURE + " " + evt.getNewValue());

    }
}
