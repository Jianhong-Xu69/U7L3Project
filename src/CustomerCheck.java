import java.util.ArrayList;

public class CustomerCheck {
    /** The check for a customer or group of customers
     *  Guaranteed to contain at least one MenuItem and all entries are non-null
     */
    private ArrayList<MenuItem> check;

    /* Constructor */
    public CustomerCheck(ArrayList<MenuItem> check) {
        this.check = check;
    }

    /** Returns the total of all MenuItem prices on the check,
     *  as described in part (a)
     */
    public double totalPrices() {
        /* to be implemented in part (a) */
        double temp = 0.0;
        for (MenuItem i: check) {
            temp += i.getPrice();
        }
        return temp;
    }

    /** Returns true if the restaurant’s coupon offer can be applied to this check and
     *  returns false otherwise, as described in part (b) */
    public boolean couponApplies() {
        /* to be implemented in part (b) */
        boolean temp = true;
        if (totalPrices() < 40.00){
            temp = false;
        }
        for (MenuItem i: check) {
            if (i.isDailySpecial()) {
                temp = false;
            }
        }
        return temp;
    }

    /** Calculates the final cost of this check, as described in part (c) */
    public double calculateCheck() {
        /* to be implemented in part (c) */
        double temp = totalPrices();
        int people = 0;
        for (MenuItem i: check) {
            if (i.isEntree()) {
                people++;
            }
        }
        if (couponApplies()) {
            temp = totalPrices() * 0.75;
        }
        if (people >= 6) {
            temp += totalPrices() * 0.2;
        }
        return temp;
    }
}
