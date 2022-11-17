public class OverseasOrder implements Order {
  private String idOrder;
  private double orderAmount;
  private double additionalSH;

  public OverseasOrder() {
  }
  public OverseasOrder(String idOO,double inp_orderAmount,
      double inp_additionalSH) {
    idOrder = idOO;
    orderAmount = inp_orderAmount;
    additionalSH = inp_additionalSH;
  }
  public double getOrderAmount() {
    return orderAmount;
  }
  public double getAdditionalSH() {
    return additionalSH;
  }
  public void accept(OrderVisitor v) {
    v.visit(this);
  }
  public String getIdOrder(){return idOrder;}
}
