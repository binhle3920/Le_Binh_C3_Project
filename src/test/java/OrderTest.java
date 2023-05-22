import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OrderTest {
    Order order;

    @BeforeEach
    public void setup() {
        Item item1 = new Item("Sweet corn soup", 119);
        Item item2 = new Item("Vegetable lasagne", 269);
        order = new Order(new ArrayList<Item>() {{
            add(item1);
            add(item2);
        }});
    }

    @Test
    public void getOrderValue_should_return_total_value_of_all_items() throws itemNotFoundException {
        assertEquals(388, order.getOrderValue(List.of("Sweet corn soup", "Vegetable lasagne")));
    }

    @Test
    public void getOrderValue_should_return_0_when_no_items_are_selected() throws itemNotFoundException {
        assertEquals(0, order.getOrderValue(List.of()));
    }

    @Test
    public void getOrderValue_should_throw_error_when_items_are_not_included_in_menu() {
        assertThrows(itemNotFoundException.class, () -> order.getOrderValue(List.of("French fries", "Vegetable lasagne")));
    }
}