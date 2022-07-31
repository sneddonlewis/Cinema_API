package cinema.model;

import cinema.repository.seat.SeatEntity;
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

    public Seat(SeatEntity entity) {
        this.row = entity.getRow();
        this.column = entity.getColumn();
        this.price = entity.getPrice();
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int row) {
        this.price = row <= 4 ? 10 : 8;
    }
}
