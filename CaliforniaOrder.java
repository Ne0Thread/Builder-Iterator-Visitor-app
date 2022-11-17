public class CaliforniaOrder implements Order {
  private String idOrder;
  private double orderAmount;
  private double additionalTax;

  public CaliforniaOrder() {
  }
  public CaliforniaOrder(String idCO,double inp_orderAmount,
      double inp_additionalTax) {
    idOrder = idCO;
    orderAmount = inp_orderAmount;
    additionalTax = inp_additionalTax;
  }
  public double getOrderAmount() {
    return orderAmount;
  }
  public double getAdditionalTax() {
    return additionalTax;
  }
  public void accept(OrderVisitor v) {
    v.visit(this);
  }
  public String getIdOrder(){return idOrder;}
}

