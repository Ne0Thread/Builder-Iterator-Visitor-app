import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Iterator;


public class OrderManager extends JFrame {
  public static final String newline = "\n";
  public static final String GET_TOTAL = "Get Total";
  public static final String CREATE_ORDER = "CreateOrder";
  public static final String EDIT_ORDER = "Edit Order";
  public static final String DELETE_ORDER = "Delete Order";
  public static final String EXIT = "Exit";
  public static final String CA_ORDER = "CaliforniaOrder";
  public static final String NON_CA_ORDER = 
    "NonCaliforniaOrder";

  public static final String OVERSEAS_ORDER = "OverseasOrder";
  public static final String EUROPEAN_ORDER = "EuropeanOrder";
  public static final String BLANK = "";


  private JComboBox cmbOrderType;
  private JTextField txtOrderId,txtOrderAmount, txtAdditionalTax,txtAdditionalSH;
  private JTextArea texAreaSelectedOrders;
  private JLabel lblOrderType, lblOrderAmount;
  private JLabel lblAdditionalTax, lblAdditionalSH;
  private JLabel lblTotal, lblTotalValue;

  private JPanel panel,panOrderCriteria;
  private OrderVisitor objVisitor;

  public OrderManager() {
    super("Visitor Pattern - Example");

    //Create the visitor instance
    objVisitor = new OrderVisitor();

    cmbOrderType = new JComboBox();

    cmbOrderType.addItem(OrderManager.BLANK);
    cmbOrderType.addItem(OrderManager.CA_ORDER);
    cmbOrderType.addItem(OrderManager.NON_CA_ORDER);
    cmbOrderType.addItem(OrderManager.OVERSEAS_ORDER);
    cmbOrderType.addItem(OrderManager.EUROPEAN_ORDER);


    txtOrderAmount = new JTextField(10);
    txtAdditionalTax = new JTextField(10);
    txtAdditionalSH = new JTextField(10);

    texAreaSelectedOrders = new JTextArea(15,30);

    lblOrderType = new JLabel("Order Type:");
    lblOrderAmount = new JLabel("Order Amount:");

    lblTotal = new JLabel("Result:");
    lblTotalValue =
      new JLabel("Click Create or GetTotal Button");

    //Create the open button
    JButton getTotalButton =
      new JButton(OrderManager.GET_TOTAL);
    getTotalButton.setMnemonic(KeyEvent.VK_G);
    JButton createOrderButton =
      new JButton(OrderManager.CREATE_ORDER);
    getTotalButton.setMnemonic(KeyEvent.VK_C);
    JButton editOrderButton = new JButton(OrderManager.EDIT_ORDER);
    JButton deleteOrderButton = new JButton(OrderManager.DELETE_ORDER);
    JButton exitButton = new JButton(OrderManager.EXIT);
    exitButton.setMnemonic(KeyEvent.VK_X);
    ButtonHandler objButtonHandler = new ButtonHandler(this);


    getTotalButton.addActionListener(objButtonHandler);
    createOrderButton.addActionListener(objButtonHandler);
    editOrderButton.addActionListener(objButtonHandler);
    deleteOrderButton.addActionListener(objButtonHandler);
    exitButton.addActionListener(new ButtonHandler());
    cmbOrderType.addActionListener(objButtonHandler);

    //For layout purposes, put the buttons in a separate panel
    JPanel buttonPanel = new JPanel();

    panel = new JPanel();
    GridBagLayout gridbag2 = new GridBagLayout();
    panel.setLayout(gridbag2);
    GridBagConstraints gbc2 = new GridBagConstraints();

    panel.add(getTotalButton);
    panel.add(createOrderButton);
    panel.add(editOrderButton);
    panel.add(deleteOrderButton);
    panel.add(exitButton);

    gbc2.anchor = GridBagConstraints.EAST;
    gbc2.gridx = 0;
    gbc2.gridy = 0;
    gridbag2.setConstraints(createOrderButton, gbc2);
    gbc2.gridx = 1;
    gbc2.gridy = 0;
    gridbag2.setConstraints(getTotalButton, gbc2);
    gbc2.gridx = 2;
    gbc2.gridy = 0;
    gridbag2.setConstraints(editOrderButton, gbc2);
    gbc2.gridx = 3;
    gbc2.gridy = 0;
    gridbag2.setConstraints(deleteOrderButton, gbc2);
    gbc2.gridx = 4;
    gbc2.gridy = 0;
    gridbag2.setConstraints(exitButton, gbc2);

    panOrderCriteria = new JPanel();


    //****************************************************
    GridBagLayout gridbag = new GridBagLayout();
    buttonPanel.setLayout(gridbag);
    GridBagConstraints gbc = new GridBagConstraints();

    buttonPanel.add(lblOrderType);
    buttonPanel.add(cmbOrderType);
    buttonPanel.add(lblOrderAmount);
    //aqui se agregaria el panel
    buttonPanel.add(panOrderCriteria);
    buttonPanel.add(lblTotal);
    buttonPanel.add(lblTotalValue);
    //aqui se agregaria el JTextArea
    buttonPanel.add(texAreaSelectedOrders);

    gbc.insets.top = 5;
    gbc.insets.bottom = 5;
    gbc.insets.left = 5;
    gbc.insets.right = 5;

    gbc.anchor = GridBagConstraints.EAST;
    gbc.gridx = 0;
    gbc.gridy = 0;
    gridbag.setConstraints(lblOrderType, gbc);
    gbc.anchor = GridBagConstraints.WEST;
    gbc.gridx = 1;
    gbc.gridy = 0;
    gridbag.setConstraints(cmbOrderType, gbc);
    gbc.anchor = GridBagConstraints.EAST;
    gbc.gridx = 0;
    gbc.gridy = 1;
    gridbag.setConstraints(lblOrderAmount, gbc);

    //este se cambia por el panel
    gbc.anchor = GridBagConstraints.EAST;
    gbc.gridx = 0;
    gbc.gridy = 2;
    gridbag.setConstraints(panOrderCriteria, gbc);

    //se agregan los datos resultado
    gbc.anchor = GridBagConstraints.EAST;
    gbc.gridx = 0;
    gbc.gridy = 4;
    gridbag.setConstraints(lblTotal, gbc);
    gbc.anchor = GridBagConstraints.WEST;
    gbc.gridx = 1;
    gbc.gridy = 4;
    gridbag.setConstraints(lblTotalValue, gbc);
    gbc.anchor = GridBagConstraints.WEST;
    gbc.gridx = 0;
    gbc.gridy = 5;
    gridbag.setConstraints(texAreaSelectedOrders, gbc);

    gbc.insets.left = 2;
    gbc.insets.right = 2;
    gbc.insets.top = 40;

    //****************************************************

    //Add the buttons and the log to the frame
    Container contentPane = getContentPane();
    contentPane.add(buttonPanel, BorderLayout.NORTH);
    contentPane.add(panel, BorderLayout.CENTER);
    /*
    try {
      UIManager.setLookAndFeel(new WindowsLookAndFeel());
      SwingUtilities.updateComponentTreeUI(
        OrderManager.this);
    } catch (Exception ex) {
      System.out.println(ex);
    }
*/
  }

  public static void main(String[] args) {
    JFrame frame = new OrderManager();
    frame.addWindowListener(new WindowAdapter() {
          public void windowClosing(WindowEvent e) {
            System.exit(0);
          }
        }
                           );

    //frame.pack();
    frame.setSize(600, 600);
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);
  }
  public void displayNewUI(JPanel panel) {
    this.panOrderCriteria.removeAll();
    this.panOrderCriteria.add(panel);
    this.panOrderCriteria.validate();
    validate();
  }

  public void setTotalValue(String msg) {
    lblTotalValue.setText(msg);
  }
  public OrderVisitor getOrderVisitor() {
    return objVisitor;
  }
  public String getOrderType() {
    return (String) cmbOrderType.getSelectedItem();
  }
  public JComboBox getOrderTypeCtrl(){
    return cmbOrderType;
  }

  public String getOrderAmount() {
    if (!(txtOrderAmount==null)){
      return txtOrderAmount.getText();
    }else {
      return "0";
    }
  }
  public String getTax() {
    if (!(txtAdditionalTax == null)){
      return txtAdditionalTax.getText();
    }else {
      return "0";
    }
  }
  public String getSH() {
    if (!(txtAdditionalSH == null)){
      return txtAdditionalSH.getText();
    }else {
      return "0";
    }
  }
  public String getID(){
    if (!(txtOrderId == null)){
      return txtOrderId.getText();
    }else{
      return null;
    }
  }
  public void setTxtOrderId(JTextField idJtextF){
    this.txtOrderId = idJtextF;
  }

  public void setTxtOrderAmount(JTextField oAJtextF){
    this.txtOrderAmount = oAJtextF;
  }
  public void setTxtAdditionalTax(JTextField aTAXJtextF){
    this.txtAdditionalTax = aTAXJtextF;
  }
  public void setTxtAdditionalSH(JTextField aSHJTextF){
    this.txtAdditionalSH = aSHJTextF;
  }
  public void setTexAreaSelectedOrders(String selOrd){
    texAreaSelectedOrders.setText(selOrd);
  }
} // End of class OrderManager

class ButtonHandler implements ActionListener {
  OrderManager objOrderManager;
  UIBuilder builder;
  public void actionPerformed(ActionEvent e) {
    String totalResult = null;

    if (e.getActionCommand().equals(OrderManager.EXIT)) {
      System.exit(1);
    }
    if (e.getSource() == objOrderManager.getOrderTypeCtrl()) {
      if (!objOrderManager.getOrderType().equals("")) {
        //Obtiene el la seleccion del combobox
        String selection = objOrderManager.getOrderType();
        //Elimina si el primer elemento del combo box es vacio
        if (objOrderManager.getOrderTypeCtrl().getItemAt(0).equals("")) {
          objOrderManager.getOrderTypeCtrl().removeItemAt(0);
        }
        BuilderFactory factory = new BuilderFactory();
        //crea una insatancia apropiada del constructor(builder)
        builder = factory.getUIBuilder(selection);
        //genera cargadores para los datos de textField no importa el constructor concreto
        objOrderManager.setTxtOrderId(builder.getJTextFieldID());
        objOrderManager.setTxtOrderAmount(builder.getJTextFieldAmount());
        objOrderManager.setTxtAdditionalTax(builder.getJTextFieldTax());
        objOrderManager.setTxtAdditionalSH(builder.getJTextFieldSH());
        //configura el director con el constructor
        UIDirector director = new UIDirector(builder);
        //metodos
        director.build();
        //obtiene el objeto constructor final
        JPanel UIobj = builder.getOrderUI();
        objOrderManager.displayNewUI(UIobj);
      }
    }
      if (e.getActionCommand().equals(OrderManager.CREATE_ORDER)
      ) {
        //get input values
        String orderType = objOrderManager.getOrderType();

        String strID = objOrderManager.getID();
        String strOrderAmount =
                objOrderManager.getOrderAmount();
        String strTax = objOrderManager.getTax();
        String strSH = objOrderManager.getSH();

        double dblOrderAmount = 0.0;
        double dblTax = 0.0;
        double dblSH = 0.0;

        if (strOrderAmount.trim().length() == 0) {
          strOrderAmount = "0.0";
        }
        if (strTax.trim().length() == 0) {
          strTax = "0.0";
        }
        if (strSH.trim().length() == 0) {
          strSH = "0.0";
        }

        dblOrderAmount =
                Double.parseDouble(strOrderAmount);
        dblTax = Double.parseDouble(strTax);
        dblSH = Double.parseDouble(strSH);

        //Create the order
        Order order = createOrder(strID, orderType, dblOrderAmount,
                dblTax, dblSH);

        if (order!=null){
        //Get the Visitor
        OrderVisitor visitor =
                objOrderManager.getOrderVisitor();

        // accept the visitor instance
        order.accept(visitor);

        objOrderManager.setTotalValue(
                " Order Created Successfully");
      }
        else {
          //indica que ya existe y no se creo la orden
          objOrderManager.setTotalValue(
                  " Already Exist Order !!");
        }
      }
    if (e.getActionCommand().equals(OrderManager.GET_TOTAL)) {
      //Get the Visitor----------Se elimino la funcionalidad anterior
      /*OrderVisitor visitor =
        objOrderManager.getOrderVisitor();
      totalResult = Double.toString(visitor.getOrderTotal());
      totalResult = " Orders Total = " + totalResult;
      objOrderManager.setTotalValue(totalResult);
      */
      //obtener las ordenes especificas
      String orderType = (String) objOrderManager.getOrderType();
      OrderVisitor visitor = objOrderManager.getOrderVisitor();
      Iterator specifOrders = visitor.getFilteredOrders(orderType);
      String selectedOrders =
              "Id --- Amount --- TAX --- S&H " + "\n" +
                      "--------------------------------------";

      while (specifOrders.hasNext()) {
        Order o = (Order) specifOrders.next();
        if (o.getClass().equals(CaliforniaOrder.class)){
          selectedOrders = selectedOrders + "\n" +
                  ((CaliforniaOrder) o).getIdOrder() + " - " + ((CaliforniaOrder) o).getOrderAmount() +
                  " - " + ((CaliforniaOrder) o).getAdditionalTax() +" - "+" 0 ";
        } else if (o.getClass().equals(NonCaliforniaOrder.class)) {
          selectedOrders = selectedOrders + "\n" +
                  ((NonCaliforniaOrder) o).getIdOrder() + " - " + ((NonCaliforniaOrder) o).getOrderAmount() +
                  " - " + "0" +" - "+ "0";
        } else if (o.getClass().equals(OverseasOrder.class)) {
          selectedOrders = selectedOrders + "\n" + ((OverseasOrder) o).getIdOrder() +" - "+((OverseasOrder) o).getOrderAmount()+" - "+ "0"+((OverseasOrder) o).getAdditionalSH();
        }else if (o.getClass().equals(EuropeanOrder.class)){
          selectedOrders = selectedOrders + "\n" + ((EuropeanOrder) o).getIdOrder() +" - "+((EuropeanOrder) o).getOrderAmount()+" - "+ "0"+((EuropeanOrder) o).getAdditionalSH();
        }
      }
      objOrderManager.setTexAreaSelectedOrders(selectedOrders);
    }
    if (e.getActionCommand().equals(OrderManager.EDIT_ORDER)){
      Boolean flag = false;
      String orderType = (String) objOrderManager.getOrderType();
      OrderVisitor visitor = objOrderManager.getOrderVisitor();
      Iterator specifOrders = visitor.getFilteredOrders(orderType);
      while (specifOrders.hasNext()) {
        Order o = (Order) specifOrders.next();
        if (o.getClass().equals(CaliforniaOrder.class)){
          if (((CaliforniaOrder) o).getIdOrder().equals(objOrderManager.getID())){
            flag = true;
            ((CaliforniaOrder) o).setOrderAmount(Double.parseDouble(objOrderManager.getOrderAmount()));
            ((CaliforniaOrder) o).setAdditionalTax(Double.parseDouble(objOrderManager.getTax()));
            break;
          }
        } else if (o.getClass().equals(NonCaliforniaOrder.class)) {
          if (((NonCaliforniaOrder) o).getIdOrder().equals(objOrderManager.getID())){
            ((NonCaliforniaOrder) o).setOrderAmount(Double.parseDouble(objOrderManager.getOrderAmount()));
            flag = true;
            break;
          }
        } else if (o.getClass().equals(OverseasOrder.class)) {
          if (((OverseasOrder) o).getIdOrder().equals(objOrderManager.getID())){
            ((OverseasOrder) o).setOrderAmount(Double.parseDouble(objOrderManager.getOrderAmount()));
            ((OverseasOrder) o).setAdditionalSH(Double.parseDouble(objOrderManager.getSH()));
            flag = true;
            break;
          }
        }else if (o.getClass().equals(EuropeanOrder.class)){
          if (((EuropeanOrder) o).getIdOrder().equals(objOrderManager.getID())){
            ((EuropeanOrder) o).setOrderAmount(Double.parseDouble(objOrderManager.getOrderAmount()));
            ((EuropeanOrder) o).setAdditionalSH(Double.parseDouble(objOrderManager.getSH()));
            flag = true;
            break;
          }
        }
      }
      if (flag!=true){
        objOrderManager.setTotalValue("The Orden Doesn't exist!!");
      }

    }
    if (e.getActionCommand().equals(OrderManager.DELETE_ORDER)){
      Boolean flag = false;
      String orderType = (String) objOrderManager.getOrderType();
      OrderVisitor visitor = objOrderManager.getOrderVisitor();
      Iterator specifOrders = visitor.getFilteredOrders(orderType);
      while (specifOrders.hasNext()) {
        Order o = (Order) specifOrders.next();
        if (o.getClass().equals(CaliforniaOrder.class)){
          if (((CaliforniaOrder) o).getIdOrder().equals(objOrderManager.getID())){
            specifOrders.remove();
            flag = true;
            break;
          }
        } else if (o.getClass().equals(NonCaliforniaOrder.class)) {
          if (((NonCaliforniaOrder) o).getIdOrder().equals(objOrderManager.getID())){
            specifOrders.remove();
            flag = true;
            break;
          }
        } else if (o.getClass().equals(OverseasOrder.class)) {
          if (((OverseasOrder) o).getIdOrder().equals(objOrderManager.getID())){
            specifOrders.remove();
            flag = true;
            break;
          }
        }else if (o.getClass().equals(EuropeanOrder.class)){
          if (((EuropeanOrder) o).getIdOrder().equals(objOrderManager.getID())){
            specifOrders.remove();
            flag = true;
            break;
          }
        }
      }
      if (flag!=true){
        objOrderManager.setTotalValue("The Orden Doesn't exist!!");
      }
    }
  }

  public Order createOrder(String idOr ,String orderType,
      double orderAmount, double tax, double SH) {
    //se revisa si existe y una orden con ese id
    OrderVisitor visitor = objOrderManager.getOrderVisitor();
    Iterator specifOrders = visitor.getFilteredOrders(orderType);
    Boolean flag = false;
    while (specifOrders.hasNext()) {
      Order o = (Order) specifOrders.next();
      if (o.getClass().equals(CaliforniaOrder.class)){
        if (((CaliforniaOrder) o).getIdOrder().equals(idOr)){
          flag = true;
          break;
        }
      } else if (o.getClass().equals(NonCaliforniaOrder.class)) {
        if (((NonCaliforniaOrder) o).getIdOrder().equals(idOr)){
          flag = true;
          break;
        }
      } else if (o.getClass().equals(OverseasOrder.class)) {
        if (((OverseasOrder) o).getIdOrder().equals(idOr)){
          flag = true;
          break;
        }
      }else if (o.getClass().equals(EuropeanOrder.class)){
        if (((EuropeanOrder) o).getIdOrder().equals(idOr)){
          flag = true;
          break;
        }
      }
    }
    if (flag!=true){
    if (orderType.equalsIgnoreCase(OrderManager.CA_ORDER)) {
      return new CaliforniaOrder(idOr,orderAmount, tax);
    }
    if (orderType.equalsIgnoreCase(
      OrderManager.NON_CA_ORDER)) {
      return new NonCaliforniaOrder(idOr,orderAmount);
    }
    if (orderType.equalsIgnoreCase(
          OrderManager.OVERSEAS_ORDER)) {
      return new OverseasOrder(idOr,orderAmount, SH);
    }
    if(orderType.equalsIgnoreCase(
            OrderManager.EUROPEAN_ORDER)){
      return new EuropeanOrder(idOr,orderAmount,SH);
    }
    return null;
    }
    return null;
  }

  public ButtonHandler() {
  }
  public ButtonHandler(OrderManager inObjOrderManager) {
      objOrderManager = inObjOrderManager;
  }

} // End of class ButtonHandler

class   BuilderFactory {
  public UIBuilder getUIBuilder(String str) {
    UIBuilder builder = null;
    if (str.equals(OrderManager.CA_ORDER)) {
      builder = new CaliforniaOrderUIBuilder();
    } else if (str.equals(OrderManager.NON_CA_ORDER)) {
      builder = new NonCaliforniaOrderUIBuilder();
    } else if (str.equals(OrderManager.EUROPEAN_ORDER)) {
      builder = new EuropeanOrderUIBuilder();
    } else if (str.equals(OrderManager.OVERSEAS_ORDER)) {
      builder = new OverseasOrderUIBuilder();
    }
    return builder;
  }
}
//End of class BuilderFactory