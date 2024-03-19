package com.finalproject.delership.dto.response.order;

import com.finalproject.delership.enums.PlaneType;
import com.finalproject.delership.enums.Status;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class OrderCreateResponse {

    private Long id;

    private String orderPrice;
    private LocalDateTime dateTime;

    private Status status;

    //private CustomerData customer;

    //private EmployeeData employee;

    //private PlaneData plane;

    /*@Data
    private static class CustomerData {
        private Long id;
        private String firstName;
        private String lastName;
        private String contactNo;
        private String nic;
        private String email;
    }*/

    /*@Data
    private static class EmployeeData {
        private Long id;
        private String firstName;
        private String contactNo;
        private String nic;
    }*/

    /*@Data
    private static class PlaneData {
        private Long id;
        private String name;
        private String price;
        private PlaneType primary;
    }*/
}
