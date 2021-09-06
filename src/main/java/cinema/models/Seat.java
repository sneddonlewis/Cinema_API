package cinema.models;

public class Seat {
    private int row;
    private int column;
    private int price;


    public Seat(int row, int column) {
        this.row = row;
        this.column = column;
        setPrice(row);
    }

    public Seat() {
        setPrice(this.row);
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

    public void setColumn(int column) {
        this.column = column;
    }

    public void setRow(int row) {
        this.row = row;
    }
}
