package com.hotelreservations.services;

import com.hotelreservations.models.Booking;
import com.hotelreservations.models.BookingDates;
import com.hotelreservations.models.BookingResponse;
import com.hotelreservations.models.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class ReservationService extends BaseTest{

    public String Auth(){

        User user = new User("admin","password123");

     Response response= given(spec)
             .contentType(ContentType.JSON)
             .when()
             .body(user)
             .post("/auth");

     response.then()
             .statusCode(200);

     return response.jsonPath().getJsonObject("token");
    }


    public BookingResponse createBooking(){
        BookingDates bookingDates = new BookingDates("2018-19-21", "2018-19-21");
        Booking booking = new Booking("daniel","Zabala",2000,true,bookingDates,"dancing");

        Response response = given(spec)
                .contentType(ContentType.JSON)
                .when()
                .body(booking)
                .post("/booking");

        response.then()
                .statusCode(200);

        // deserialization
        return  response.as(BookingResponse.class);
    }

    public void deleteReservation (String token, int bookingID){

        Response response = given(spec)
                .contentType(ContentType.JSON)
                .header("Cookie","token="+token)
                .when()
                .delete("/booking/"+bookingID);

        response.then()
                .statusCode(201);
    }
}
