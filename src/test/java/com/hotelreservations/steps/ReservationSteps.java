package com.hotelreservations.steps;

import com.hotelreservations.models.Booking;
import com.hotelreservations.models.BookingDates;
import com.hotelreservations.models.BookingResponse;
import com.hotelreservations.services.ReservationService;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class ReservationSteps {

    ReservationService reservationService;
    String auth;
    BookingResponse bookingResponse;


    @Given("User creates a new reservation")
    public void user_creates_a_new_reservation() {

        reservationService = new ReservationService();
    }

    @Given("the user gives the information needed for booking")
    public void the_user_gives_the_information_needed_for_booking() {
        auth=reservationService.Auth();
    }
    @When("User creates hotel reservation")
    public void user_creates_hotel_reservation() {
        bookingResponse = reservationService.createBooking();
    }

   @Then("Reservation was successfully created")
    public void reservation_was_successfully_created() {

       Assertions.assertEquals("daniel",bookingResponse.getBooking().getFirstname());
       Assertions.assertEquals("Zabala",bookingResponse.getBooking().getLastname());
       Assertions.assertEquals(2000,bookingResponse.getBooking().getTotalprice());
       Assertions.assertTrue(bookingResponse.getBooking().isDepositpaid());
       Assertions.assertEquals("dancing",bookingResponse.getBooking().getAdditionalneeds());

   }

    @Then("User cancels the created reservation")
    public void user_cancels_the_created_reservation() {

        reservationService.deleteReservation(auth,bookingResponse.getBookingid());
    }

}
