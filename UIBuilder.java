import javax.swing.*;

public abstract class UIBuilder {
    protected JPanel orderUI;
    public static final String CREATE_ORDER = "Create Order";
    public static final String EDIT_ORDER = "Edit Order";



    public abstract void addUIControls();
    public abstract  void initialize();
    public JPanel getOrderUI(){
        return orderUI;
    }

    public abstract JTextField getJTextFieldAmount();
    public abstract JTextField getJTextFieldTax();
    public abstract JTextField getJTextFieldSH();
}
