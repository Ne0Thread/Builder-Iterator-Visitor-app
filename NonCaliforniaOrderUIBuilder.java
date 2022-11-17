import javax.swing.*;
import java.awt.*;

public class NonCaliforniaOrderUIBuilder extends UIBuilder{
    private JTextField txtID = new JTextField(15);
    private JLabel lblId = new JLabel("ID :") ;
    private JTextField txtOrderAmount = new JTextField(15);
    private JLabel lblOrderAmout = new JLabel("Order Amount :");

    @Override
    public void addUIControls() {
        orderUI = new JPanel();

        GridBagLayout gridbag = new GridBagLayout();
        orderUI.setLayout(gridbag);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor =GridBagConstraints.WEST;


        orderUI.add(lblId);
        orderUI.add(txtID);
        orderUI.add(lblId);
        orderUI.add(txtID);
        orderUI.add(lblOrderAmout);
        orderUI.add(txtOrderAmount);


        gbc.insets.top = 5;
        gbc.insets.bottom = 5;
        gbc.insets.left = 5;
        gbc.insets.right = 5;

        gbc.gridx = 0;
        gbc.gridy = 0;
        gridbag.setConstraints(txtID, gbc);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gridbag.setConstraints(lblOrderAmout, gbc);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gridbag.setConstraints(txtOrderAmount, gbc);

    }

    @Override
    public void initialize() {
        txtID.setText("Ord_1");
        txtOrderAmount.setText("");
    }

    @Override
    public JTextField getJTextFieldID() {
        return txtID;
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
