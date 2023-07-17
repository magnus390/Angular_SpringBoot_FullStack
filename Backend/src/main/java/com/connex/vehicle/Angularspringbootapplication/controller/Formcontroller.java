package com.connex.vehicle.Angularspringbootapplication.controller;

import com.connex.vehicle.Angularspringbootapplication.model.Formrequest;
import com.connex.vehicle.Angularspringbootapplication.model.Formresponse;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.text.DecimalFormat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.UUID;

import static java.nio.charset.StandardCharsets.UTF_8;

@RestController
@CrossOrigin(origins = "http://localhost:4200", methods = {RequestMethod.POST})

public class Formcontroller {

    public String handleError() {
        // Handle the error here or redirect to an error page
        return "Error occurred";
    }

    @PostMapping("/insurance/quote")
    public Formresponse calculateQuote(@RequestBody Formrequest quoteRequest) throws MalformedURLException {

        // Calculate the insurance premium based on the quoteRequest
        double basePremium = getBasePremium();
        double ageFactor = calculateAgeFactor(quoteRequest.getAge());
        double drivingExperienceFactor = calculateDrivingExperienceFactor(quoteRequest.getDrivingExperience());
        double driverRecordFactor = calculateDriverRecordFactor(quoteRequest.getDriverRecord());
        double claimsFactor = calculateClaimsFactor(quoteRequest.getClaims());
        double carValueFactor = calculateCarValueFactor(quoteRequest.getCarValue());
        double annualMileageFactor = calculateAnnualMileageFactor(quoteRequest.getAnnualMileage());
        double insuranceHistoryFactor = calculateInsuranceHistoryFactor(quoteRequest.getInsuranceHistory());

        double premium = basePremium * ageFactor * drivingExperienceFactor * driverRecordFactor * claimsFactor *
                carValueFactor * annualMileageFactor * insuranceHistoryFactor;

        Formresponse response = new Formresponse();
        response.setSuccess(true);
        response.setPremium(premium);
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        Double formattedPremium = Double.valueOf(decimalFormat.format(premium));
        response.setPremium(formattedPremium);
        String randomReference = UUID.randomUUID().toString().substring(0, 6);
        response.setQuoteReference("Q" + randomReference);
        return response;
    }

    public Double getBasePremium() throws MalformedURLException {
        String data_url = "https://storage.googleapis.com/connex-th/insurance_assignment/base_premium.json";
        URL url = new URL(data_url);
        StringBuilder builder = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(url.openStream(), UTF_8))) {
            String str;
            while ((str = bufferedReader.readLine()) != null) {
                builder.append(str);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String jsonStr = builder.toString();

        Gson gson = new Gson();
        JsonObject jsonObject = gson.fromJson(jsonStr, JsonObject.class);
        if (jsonObject.has("base_premium")) {
            return jsonObject.get("base_premium").getAsDouble();
        } else {
            return 0.00;
        }
    }

    private double calculateAgeFactor(int age) {
        if (age < 25) {
            return 1.3;
        } else if (age >= 25 && age < 40) {
            return 1.0;
        } else if (age >= 40 && age < 70) {
            return 0.9;
        } else {
            return 0.0;
        }
    }

    private double calculateDrivingExperienceFactor(int drivingExperience) {
        if (drivingExperience < 2) {
            return 1.5;
        } else if (drivingExperience >= 2 && drivingExperience < 5) {
            return 1.3;
        } else if (drivingExperience >= 5 && drivingExperience < 10) {
            return 1.0;
        } else {
            return 0.9;
        }
    }

    private double calculateDriverRecordFactor(int driverRecord) {
        if (driverRecord == 0) {
            return 1.0;
        } else if (driverRecord == 1) {
            return 1.1;
        } else if (driverRecord >= 2 && driverRecord <= 3) {
            return 1.3;
        } else {
            return 0.0;
        }
    }

    private double calculateClaimsFactor(int claims) {
        if (claims == 0) {
            return 0.9;
        } else if (claims == 1) {
            return 1.2;
        } else if (claims >= 2 && claims <= 3) {
            return 1.5;
        } else {
            return 0.0;
        }
    }

    private double calculateCarValueFactor(int carValue) {
        if (carValue < 30000) {
            return 0.8;
        } else if (carValue >= 30000 && carValue < 60000) {
            return 1.0;
        } else if (carValue >= 60000 && carValue < 100000) {
            return 1.2;
        } else if (carValue >= 100000 && carValue < 150000) {
            return 1.5;
        } else if (carValue >= 150000 && carValue < 200000) {
            return 2.0;
        } else {
            return 0.0;
        }
    }

    private double calculateAnnualMileageFactor(int annualMileage) {
        if (annualMileage < 20000) {
            return 0.9;
        } else if (annualMileage >= 20000 && annualMileage < 30000) {
            return 1.0;
        } else if (annualMileage >= 30000 && annualMileage < 50000) {
            return 1.1;
        } else {
            return 1.3;
        }
    }

    private double calculateInsuranceHistoryFactor(int insuranceHistory) {
        if (insuranceHistory == 0) {
            return 1.2;
        } else if (insuranceHistory < 2) {
            return 1.1;
        } else {
            return 1.0;
        }
    }

}
