import javax.swing.*;
import java.awt.*;

public class OverseasCreateOrderUIBuilder extends UIBuilder{
    private JTextField txtOrderAmount = new JTextField(15);
    private JTextField txtAdditionalSH = new JTextField(15);
    @Override
    public void addUIControls() {
        orderUI = new JPanel();
        JLabel lblOrderAmout = new JLabel("Order Amount :");
        JLabel lblAdditionalTax = new JLabel("Addtitional S & H (Overseas Order): ");

        GridBagLayout gridbag = new GridBagLayout();
        orderUI.setLayout(gridbag);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor =GridBagConstraints.WEST;

        orderUI.add(lblOrderAmout);
        orderUI.add(txtOrderAmount);
        orderUI.add(lblAdditionalTax);
        orderUI.add(txtAdditionalSH);

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
        gbc.gridx = 0;
        gbc.gridy = 2;
        gridbag.setConstraints(lblAdditionalTax, gbc);

        gbc.anchor = GridBagConstraints.WEST;
        gbc.gridx = 0;
        gbc.gridy = 3;
        gridbag.setConstraints(txtAdditionalSH, gbc);
    }

    @Override
    public void initialize() {
        txtOrderAmount.setText("");
        txtAdditionalSH.setText("");
    }

    @Override
    public JTextField getJTextFieldAmount() {
        return txtOrderAmount;
    }

    @Override
    public JTextField getJTextFieldTax() {
        return null;
    }

    @Override
    public JTextField getJTextFieldSH() {
        return txtAdditionalSH;
    }
}
