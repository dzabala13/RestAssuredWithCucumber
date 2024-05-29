package com.hotelreservations.steps;

import com.hotelreservations.models.BookingResponse;
import com.hotelreservations.services.ReservationService;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

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

/*    @Then("Reservation was successfully created")
    public void reservation_was_successfully_created() {
        // Write code here that turns the phrase above into concrete actions
    }

    @Then("User cancels the created reservation")
    public void user_cancels_the_created_reservation() {
        // Write code here that turns the phrase above into concrete actions
    }*/

}
