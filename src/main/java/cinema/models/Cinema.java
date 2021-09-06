package cinema.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;


public class Cinema {
    private final static int DEFAULT_ROWS = 9;
    private final static int DEFAULT_COLUMNS = 9;

    @JsonProperty("total_rows")
    private final int totalRows;
    @JsonProperty("total_columns")
    private final int totalColumns;
    @JsonProperty("available_seats")
    private Seat[] availableSeats;

    @JsonIgnore
    private static Cinema instance;

    public static Cinema getInstance() {
        if (instance == null) {
            return new Cinema(DEFAULT_ROWS, DEFAULT_COLUMNS);
        }
        return instance;
    }

    private Cinema(int totalRows, int totalColumns) {
        this.totalRows = totalRows;
        this.totalColumns = totalColumns;
        initSeats();
    }

    private void initSeats() {
        int totalSeats = totalRows * totalColumns;
        this.availableSeats = new Seat[totalSeats];
        for (
            int index = 0, row = 1, column = 1;
            index < totalSeats;
            index++
        ) {
            this.availableSeats[index] = new Seat(row, column);
            if (column < this.totalColumns) {
                column++;
            } else {
                column = 1;
                row++;
            }
        }
    }

    public Seat[] getAvailableSeats() {
        return availableSeats;
    }

    public int getTotalRows() {
        return totalRows;
    }

    public int getTotalColumns() {
        return totalColumns;
    }

    public boolean purchaseSeat(int index) {
        if (this.availableSeats[index] == null) {
            return false;
        }
        this.availableSeats[index] = null;
        return true;
    }

    public void releaseSeat(Seat seat) {
        int index = calculateIndexFromPosition(seat.getRow(), seat.getColumn());
        this.availableSeats[index] = seat;
    }

    public int calculateIndexFromPosition(int r, int c) {
        return (r - 1) * (this.totalColumns) + c - 1;
    }
}
