import javax.swing.*;
import java.awt.*;

public class EuropeanEditOrderUIBuilder extends UIBuilder{
    @Override
    public void addUIControls() {
        orderUI = new JPanel();
        JLabel lblOrderAmout = new JLabel("Order Amount :");
        JLabel lblAdditionalTax = new JLabel("Addtitional S & H (European Order): ");


        GridBagLayout gridbag = new GridBagLayout();
        orderUI.setLayout(gridbag);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor =GridBagConstraints.WEST;
    }

    @Override
    public void initialize() {

    }

    @Override
    public JTextField getJTextFieldAmount() {
        return null;
    }

    @Override
    public JTextField getJTextFieldTax() {
        return null;
    }

    @Override
    public JTextField getJTextFieldSH() {
        return null;
    }
}
