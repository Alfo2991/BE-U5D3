package u5d3;

import java.time.LocalDateTime;
import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Order {
    private String orderNumber;
    private String status;
    private int numSeats;
    private LocalDateTime orderTime;
    private List<OrderItem> orderItems;
    private double totalAmount;
}
