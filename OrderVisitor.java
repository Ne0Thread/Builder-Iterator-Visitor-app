import java.util.*;

class OrderVisitor implements VisitorInterface{
  private Vector orderObjList;
  private double orderTotal;

  public OrderVisitor() {
    orderObjList = new Vector();
  }
  public void visit(NonCaliforniaOrder inp_order) {
    orderTotal = orderTotal + inp_order.getOrderAmount();
  }
  public void visit(CaliforniaOrder inp_order) {
    orderTotal = orderTotal + inp_order.getOrderAmount() +
                 inp_order.getAdditionalTax();
    orderObjList.add(inp_order);
  }
  public void visit(OverseasOrder inp_order) {
    orderTotal = orderTotal + inp_order.getOrderAmount() +
                 inp_order.getAdditionalSH();
    orderObjList.add(inp_order);
  }
  public void visit(EuropeanOrder inp_order){
    orderTotal = orderTotal + inp_order.getOrderAmount() + inp_order.getAdditionalSH();
    orderObjList.add(inp_order);
  }
  public double getOrderTotal() {
    return orderTotal;
  }
  public Enumeration getOrderObjListElements() {
    return orderObjList.elements();
  }
  public Iterator getFilteredOrders(String type){
    return new FilteredOrders(this,type);
  }
}
