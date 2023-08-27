package com.onurgundogdu.bookstore.dto;

import lombok.Data;

@Data
public class AuthorDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String biography;

}
