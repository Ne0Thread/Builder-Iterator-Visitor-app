public class EuropeanOrder implements Order{
    private String idOrder;
    private double orderAmount;
    private double additionalSH;

    public EuropeanOrder() {
    }
    public EuropeanOrder(String idEUO, double inp_orderAmount,
                         double inp_additionalSH) {
        idOrder = idEUO;
        orderAmount = inp_orderAmount;
        additionalSH = inp_additionalSH;
    }
    public void setOrderAmount(Double oa){
        orderAmount = oa;
    }
    public void setAdditionalSH(double addSH){
        additionalSH = addSH;
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
