import javax.swing.*;

public abstract class UIBuilder {
    protected JPanel orderUI;

    public abstract void addUIControls();
    public abstract  void initialize();
    public JPanel getOrderUI(){
        return orderUI;
    }
    public abstract JTextField getJTextFieldID();
    public abstract JTextField getJTextFieldAmount();
    public abstract JTextField getJTextFieldTax();
    public abstract JTextField getJTextFieldSH();
}
