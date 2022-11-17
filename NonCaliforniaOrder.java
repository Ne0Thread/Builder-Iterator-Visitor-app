public class NonCaliforniaOrder implements Order {
  private String idOrder;
  private double orderAmount;

  public NonCaliforniaOrder() {
  }
  public NonCaliforniaOrder(String idNCO,double inp_orderAmount) {
    idOrder = idNCO;
    orderAmount = inp_orderAmount;
  }
  public double getOrderAmount() {
    return orderAmount;
  }
  public void accept(OrderVisitor v) {
    v.visit(this);
  }
  public String getIdOrder(){return idOrder;}
}
