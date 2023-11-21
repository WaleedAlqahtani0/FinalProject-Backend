package com.Project.CarRental.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookDTO {
    private String bookCode;
    private int nationalID;
    private String startDate;
    private String endDate;
    private String location;
    private int userId;
    private int carId;
}
