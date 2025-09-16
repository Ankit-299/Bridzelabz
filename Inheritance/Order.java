import java.time.LocalDate;

// Base class
class Order {
    private String orderId;
    private LocalDate orderDate;

    public Order(String orderId, LocalDate orderDate) {
        this.orderId = orderId;
        this.orderDate = orderDate;
    }

    public String getOrderId() {
        return orderId;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public String getOrderStatus() {
        return "Order placed";
    }
}

// Subclass: ShippedOrder
class ShippedOrder extends Order {
    private String trackingNumber;

    public ShippedOrder(String orderId, LocalDate orderDate, String trackingNumber) {
        super(orderId, orderDate);
        this.trackingNumber = trackingNumber;
    }

    public String getTrackingNumber() {
        return trackingNumber;
    }

    @Override
    public String getOrderStatus() {
        return "Order shipped with tracking number: " + trackingNumber;
    }
}

// Subclass of ShippedOrder: DeliveredOrder
class DeliveredOrder extends ShippedOrder {
    private LocalDate deliveryDate;

    public DeliveredOrder(String orderId, LocalDate orderDate, String trackingNumber, LocalDate deliveryDate) {
        super(orderId, orderDate, trackingNumber);
        this.deliveryDate = deliveryDate;
    }

    public LocalDate getDeliveryDate() {
        return deliveryDate;
    }

    @Override
    public String getOrderStatus() {
        return "Order delivered on " + deliveryDate;
    }
}

// Demo
public class OrderManagementDemo {
    public static void main(String[] args) {
        Order order = new Order("O101", LocalDate.of(2025, 9, 10));
        ShippedOrder shippedOrder = new ShippedOrder("O102", LocalDate.of(2025, 9, 11), "TRK12345");
        DeliveredOrder deliveredOrder = new DeliveredOrder("O103", LocalDate.of(2025, 9, 12), "TRK54321", LocalDate.of(2025, 9, 15));

        System.out.println(order.getOrderStatus());         // Order placed
        System.out.println(shippedOrder.getOrderStatus());  // Order shipped with tracking number: TRK12345
        System.out.println(deliveredOrder.getOrderStatus());// Order delivered on 2025-09-15
    }
}
