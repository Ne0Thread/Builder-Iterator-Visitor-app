import javax.swing.*;
import java.awt.*;

public class NonCaliforniaOrderUIBuilder extends UIBuilder{
    private JTextField txtOrderAmount = new JTextField(15);
    @Override
    public void addUIControls() {
        orderUI = new JPanel();
        JLabel lblOrderAmout = new JLabel("Order Amount :");

        GridBagLayout gridbag = new GridBagLayout();
        orderUI.setLayout(gridbag);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor =GridBagConstraints.WEST;

        orderUI.add(lblOrderAmout);
        orderUI.add(txtOrderAmount);


        gbc.insets.top = 5;
        gbc.insets.bottom = 5;
        gbc.insets.left = 5;
        gbc.insets.right = 5;

        gbc.gridx = 0;
        gbc.gridy = 0;
        gridbag.setConstraints(lblOrderAmout, gbc);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gridbag.setConstraints(txtOrderAmount, gbc);

    }

    @Override
    public void initialize() {
        txtOrderAmount.setText("");
    }

    @Override
    public JTextField getJTextFieldAmount() {
        return this.txtOrderAmount;
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
