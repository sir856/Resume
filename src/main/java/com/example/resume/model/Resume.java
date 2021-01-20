package com.example.resume.model;

import com.example.resume.util.DateDeserialize;
import com.example.resume.util.DateSerialize;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;

import java.util.Date;

public class Resume{
    @Transient
    public static String DATE_FORMAT = "dd.MM.yyyy";

    @Transient
    public static final String SEQUENCE_NAME = "resume_sequence";

    @Id
    private int id;

    @JsonDeserialize(using = DateDeserialize.class)
    @JsonSerialize(using = DateSerialize.class)
    private Date birthdate;
    private String name;
    private String lastName;
    private String patronymic;
    private String description;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
