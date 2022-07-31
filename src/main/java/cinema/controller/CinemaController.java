package cinema.controller;

import cinema.exception.ErrorBody;
import cinema.exception.IllegalSeatException;
import cinema.exception.IncorrectPasswordException;
import cinema.exception.UnavailableSeatException;
import cinema.model.*;
import cinema.services.CinemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class CinemaController {
    private final CinemaService cinemaService;

    public CinemaController(@Autowired CinemaService cinemaService) {
        this.cinemaService = cinemaService;
    }

    @GetMapping("/seats")
    public Cinema getAvailableSeats() {
        return cinemaService.showCinema();
    }

    @GetMapping("/all-seats")
    public List<Seat> allSeats() {
        return cinemaService.allSeats();
    }

    @RequestMapping(value = "/purchase", method = RequestMethod.POST)
    public Ticket purchaseSeat(@RequestBody final SeatPosition seatPosition) {
        return cinemaService.purchase(seatPosition);
    }

    @RequestMapping(value = "/return", method = RequestMethod.POST)
    public Refund returnTicket(@RequestBody final Token token) {
        final UUID ticketId = UUID.fromString(token.getToken());
        return cinemaService.returnTicket(ticketId);
    }

    @RequestMapping(value = "/stats", method = RequestMethod.POST)
    public Statistics getStatistics(@RequestParam(value = "password", required = false) String password) throws IncorrectPasswordException {
        if (password == null) throw new IncorrectPasswordException("The password is wrong!");
        if (password.equals("super_secret")) {
            return cinemaService.getStatistics();
        } else {
            throw new IncorrectPasswordException("The password is wrong!");
        }
    }
}

@ControllerAdvice
class CinemaControllerAdvice {

    @ExceptionHandler({UnavailableSeatException.class, IllegalSeatException.class, IllegalArgumentException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ErrorBody handlePurchaseException(Exception e) {
        return new ErrorBody(e.getMessage());
    }

    @ExceptionHandler({IncorrectPasswordException.class})
    @ResponseStatus(code = HttpStatus.UNAUTHORIZED)
    @ResponseBody
    public ErrorBody handleIncorrectPasswordException(Exception e) {
        return new ErrorBody(e.getMessage());
    }
}
