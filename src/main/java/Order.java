import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<Item> orderItems;

    public Order(List<Item> orderItems) {
        this.orderItems = orderItems;
    }

    public int getOrderValue(List<String> itemNames) throws itemNotFoundException {
        int total = 0;
        for (String itemName : itemNames) {
            Item item = findItemByName(itemName);
            if (item == null) {
                throw new itemNotFoundException(itemName);
            }
            total += item.getPrice();
        }

        return total;
    }

    private Item findItemByName(String itemName) {
        for (Item item : orderItems) {
            if (item.getName().equals(itemName)) {
                return item;
            }
        }
        return null;
    }
}
