package com.connex.vehicle.Angularspringbootapplication.model;

public class Formresponse {

    private boolean success;
    private double premium;
    private String quoteReference;

    // Getters and setters

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public double getPremium() {
        return premium;
    }

    public void setPremium(double premium) {
        this.premium = premium;
    }

    public String getQuoteReference() {
        return quoteReference;
    }

    public void setQuoteReference(String quoteReference) {
        this.quoteReference = quoteReference;
    }

}
