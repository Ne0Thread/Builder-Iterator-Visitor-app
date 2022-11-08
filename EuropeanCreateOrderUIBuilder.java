import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.Vector;

public class EuropeanCreateOrderUIBuilder extends UIBuilder{

    private JTextField txtOrderAmount = new JTextField(15);
    private JTextField txtAdditionalSH = new JTextField(15);
    private JPanel panSup,panInfe;

    private Vector vector;
    @Override
    public void addUIControls() {
        orderUI = new JPanel();
        panSup =new JPanel();
        panInfe=new JPanel();
        JLabel lblOrderAmout = new JLabel("Order Amount :");
        JLabel lblAdditionalTax = new JLabel("Addtitional S & H (European Order): ");
        JScrollPane scrll = new JScrollPane();
        scrll.setPreferredSize(new Dimension(300,100));
        scrll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        DefaultTableModel tableModel = new DefaultTableModel();

        tableModel.addColumn("Id");
        tableModel.addColumn("Ammount");
        tableModel.addColumn("TAX");
        tableModel.addColumn("SH");

        JTable tabla = new JTable(tableModel);
        scrll.setViewportView(tabla);


        GridBagLayout gridbag = new GridBagLayout();
        panInfe.setLayout(gridbag);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor =GridBagConstraints.WEST;

        panInfe.add(lblOrderAmout);
        panInfe.add(txtOrderAmount);
        panInfe.add(lblAdditionalTax);
        panInfe.add(txtAdditionalSH);
        //orderUI.add(scrll);

        gbc.insets.top = 5;
        gbc.insets.bottom = 5;
        gbc.insets.left = 5;
        gbc.insets.right = 5;

        gbc.gridx = 0;
        gbc.gridy = 1;
        gridbag.setConstraints(lblOrderAmout, gbc);
       /* gbc.gridx = 0;
        gbc.gridy = 0;
        gridbag.setConstraints(scrll, gbc);*/
        gbc.gridx = 0;
        gbc.gridy = 2;
        gridbag.setConstraints(txtOrderAmount, gbc);
        gbc.gridx = 0;
        gbc.gridy = 3;
        gridbag.setConstraints(lblAdditionalTax, gbc);

        gbc.anchor = GridBagConstraints.WEST;
        gbc.gridx = 0;
        gbc.gridy = 4;
        gridbag.setConstraints(txtAdditionalSH, gbc);

        panSup.add(scrll);

        orderUI.setLayout(new GridLayout(2,1));

        orderUI.add(panSup);
        orderUI.add(panInfe);


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
