import java.util.Enumeration;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class FilteredOrders implements Iterator {
    OrderVisitor ordVis;
    Order nextOrder;
    String orderType;
    Enumeration ec;
    public FilteredOrders(OrderVisitor ov,String ordTyp){
        orderType = ordTyp;
        ordVis = ov;
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
