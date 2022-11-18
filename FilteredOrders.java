import java.util.Enumeration;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Vector;

public class FilteredOrders implements Iterator {
    private Vector v;
    OrderVisitor ordVis;
    String orderType;
    Order nextOrder;
    Enumeration ec;
    public FilteredOrders(OrderVisitor ov,String ordTyp){
        ordVis = ov;
        orderType = ordTyp;
        ec = ov.getOrderObjListElements();
    }
    @Override
    public boolean hasNext() {
        boolean matchFound = false;
        while (ec.hasMoreElements()) {
            Order tempObj = (Order) ec.nextElement();
            if (tempObj.getClass().equals(
                    orderType)) {
                matchFound = true;
                nextOrder = tempObj;
                break;
            }
        }
        if (matchFound == true) {
        } else {
            nextOrder = null;
        }
        return matchFound;
    }

    @Override
    public Object next() {
        if (nextOrder == null){
            throw new NoSuchElementException();
        }else {
            return nextOrder;
        }
    }

    @Override
    public void remove() {
        Iterator.super.remove();
    }
}
