package com.jz.eventcloudstream.customer.controller.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;

import java.time.LocalDate;

public record CustomerDTO(@NotBlank(message = "first name can't be blank") String firstName,
                          @NotBlank(message = "first name can't be blank") String lastName,
                          @NotNull(message = "birth date can't be null")
                          LocalDate birthDate,
                          @NotBlank(message = "email can't be blank")
                          @Email(message = "please provide valid email")
                          String email) {
}
