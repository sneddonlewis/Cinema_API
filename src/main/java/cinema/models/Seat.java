package cinema.models;

import lombok.Getter;

@Getter
public final class Seat {
    private final int row;
    private final int column;
    private int price;

    public Seat(int row, int column) {
        this.row = row;
        this.column = column;
        setPrice(row);
    }

    public void setPrice(int row) {
        this.price = row <= 4 ? 10 : 8;
    }
}
