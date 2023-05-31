package u5d3;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Table {
    private int tableNumber;
    private int maxSeats;

    public Table(int tableNumber, int maxSeats) {
        this.tableNumber = tableNumber;
        this.maxSeats = maxSeats;
    }
}
