package com.example.Movies;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

@Document(collection = "Appointments")
@NoArgsConstructor
@Data
@AllArgsConstructor

public class Patient {

    Patient(String Name,String Email, String DoctorID ,String dateString,String Service,String Link,String timeString) throws ParseException {
        System.out.println(dateString+"from Patient");
        SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd");
        inputFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        this.date = inputFormat.parse(dateString);
        this.DoctorID = DoctorID;
        this.Email = Email;
        this.Name = Name;
        this.Time = timeString;
        this.Service = Service;
        this.Link = Link;
    }

    @Id
    private ObjectId id ;

    private String Name;
    private String Email;
    private Date date;
    private String DoctorID;
    private String Link;
    private String Time;
    private String Service;




}
