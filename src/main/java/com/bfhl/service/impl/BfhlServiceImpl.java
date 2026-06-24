package com.bfhl.service.impl;

import com.bfhl.dto.BfhlRequest;
import com.bfhl.dto.BfhlResponse;
import com.bfhl.service.BfhlService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class BfhlServiceImpl implements BfhlService {
    private final String fullName;
    private final String email;
    private final String rollNumber;
    private final String datePart;

    public BfhlServiceImpl(
            @Value("${bfhl.full-name:Madhav Sharma}") String fullName,
            @Value("${bfhl.email:madhav1335.be23@chitkara.edu.in}") String email,
            @Value("${bfhl.roll-number:2310991335}") String rollNumber,
            @Value("${bfhl.date-part:24062026}") String datePart) {
        this.fullName = fullName;
        this.email = email;
        this.rollNumber = rollNumber;
        this.datePart = datePart;
    }

    @Override
    public BfhlResponse process(BfhlRequest request) {
        BfhlResponse resp = new BfhlResponse();
        List<String> data = request == null ? null : request.getData();
        if (data == null) data = new ArrayList<>();

        List<String> odd = new ArrayList<>();
        List<String> even = new ArrayList<>();
        List<String> alph = new ArrayList<>();
        List<String> special = new ArrayList<>();
        long sum = 0;

        StringBuilder lettersForConcat = new StringBuilder();

        for (String s : data) {
            if (s == null || s.isEmpty()) continue;
            if (s.matches("^-?\\d+$")) { // integer
                try {
                    long val = Long.parseLong(s);
                    sum += val;
                    if (Math.abs(val) % 2 == 0) even.add(s);
                    else odd.add(s);
                } catch (NumberFormatException e) {
                    // too large, treat as special
                    special.add(s);
                }
            } else if (s.matches("^[a-zA-Z]+$")) {
                alph.add(s.toUpperCase());
                // append the full alphabetical token for concat logic
                lettersForConcat.append(s);
            } else {
                special.add(s);
            }
        }

        // concat_string: concatenation of all alphabetical characters present in the input in the reverse order in alternating caps
        String concat = buildConcatString(lettersForConcat.toString());

        String userId = generateUserId(fullName);

        resp.setIs_success(true);
        resp.setUser_id(userId);
        resp.setEmail(email);
        resp.setRoll_number(rollNumber);
        resp.setOdd_numbers(odd);
        resp.setEven_numbers(even);
        resp.setAlphabets(alph);
        resp.setSpecial_characters(special);
        resp.setSum(String.valueOf(sum));
        resp.setConcat_string(concat);

        return resp;
    }

    private String buildConcatString(String s) {
        StringBuilder sb = new StringBuilder();
        String rev = new StringBuilder(s).reverse().toString();
        boolean upper = true;
        for (char c : rev.toCharArray()) {
            if (upper) sb.append(Character.toUpperCase(c));
            else sb.append(Character.toLowerCase(c));
            upper = !upper;
        }
        return sb.toString();
    }

    private String generateUserId(String fullName) {
        String normalized = fullName.trim().toLowerCase().replaceAll("\\s+","_");
        String safeDatePart = datePart == null || datePart.isBlank()
                ? LocalDate.now().format(DateTimeFormatter.ofPattern("ddMMyyyy"))
                : datePart;
        return normalized + "_" + safeDatePart;
    }
}
