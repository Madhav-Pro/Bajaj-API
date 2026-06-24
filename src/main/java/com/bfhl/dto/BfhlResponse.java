package com.bfhl.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class BfhlResponse {
    @JsonProperty("is_success")
    private boolean is_success;

    @JsonProperty("user_id")
    private String user_id;

    @JsonProperty("email")
    private String email;

    @JsonProperty("roll_number")
    private String roll_number;

    @JsonProperty("odd_numbers")
    private List<String> odd_numbers;

    @JsonProperty("even_numbers")
    private List<String> even_numbers;

    @JsonProperty("alphabets")
    private List<String> alphabets;

    @JsonProperty("special_characters")
    private List<String> special_characters;

    @JsonProperty("sum")
    private String sum;

    @JsonProperty("concat_string")
    private String concat_string;

    public BfhlResponse() {}

    // getters and setters

    public boolean isIs_success() {
        return is_success;
    }

    public void setIs_success(boolean is_success) {
        this.is_success = is_success;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRoll_number() {
        return roll_number;
    }

    public void setRoll_number(String roll_number) {
        this.roll_number = roll_number;
    }

    public List<String> getOdd_numbers() {
        return odd_numbers;
    }

    public void setOdd_numbers(List<String> odd_numbers) {
        this.odd_numbers = odd_numbers;
    }

    public List<String> getEven_numbers() {
        return even_numbers;
    }

    public void setEven_numbers(List<String> even_numbers) {
        this.even_numbers = even_numbers;
    }

    public List<String> getAlphabets() {
        return alphabets;
    }

    public void setAlphabets(List<String> alphabets) {
        this.alphabets = alphabets;
    }

    public List<String> getSpecial_characters() {
        return special_characters;
    }

    public void setSpecial_characters(List<String> special_characters) {
        this.special_characters = special_characters;
    }

    public String getSum() {
        return sum;
    }

    public void setSum(String sum) {
        this.sum = sum;
    }

    public String getConcat_string() {
        return concat_string;
    }

    public void setConcat_string(String concat_string) {
        this.concat_string = concat_string;
    }

    @Override
    public String toString() {
        return "BfhlResponse{" +
                "is_success=" + is_success +
                ", user_id='" + user_id + '\'' +
                ", email='" + email + '\'' +
                ", roll_number='" + roll_number + '\'' +
                ", odd_numbers=" + odd_numbers +
                ", even_numbers=" + even_numbers +
                ", alphabets=" + alphabets +
                ", special_characters=" + special_characters +
                ", sum='" + sum + '\'' +
                ", concat_string='" + concat_string + '\'' +
                '}';
    }
}
