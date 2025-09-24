package com.brand.model;

public class SignUpModel {

    private String fullName;
    private String email;
    private String password;
    private String confirmPassword; // optional
    private String otp;             // optional
    private String phone;           // optional
    private boolean terms;
    private String city;


    // --- Constructors ---
    public SignUpModel() {
    }

    public SignUpModel(String fullName, String email, String password, boolean terms) {
        this.fullName = fullName;
        this.email = email;
        this.password = password;
        this.terms = terms;
    }

    // --- Getters and Setters ---

    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getOtp() {
        return otp;
    }

    public void setOtp(String otp) {
        this.otp = otp;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public boolean isTerms() {
        return terms;
    }

    public void setTerms(boolean terms) {
        this.terms = terms;
    }

    // --- toString() ---
    @Override
    public String toString() {
        return "SignUpModel{" +
                "fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", confirmPassword='" + confirmPassword + '\'' +
                ", otp='" + otp + '\'' +
                ", phone='" + phone + '\'' +
                ", terms=" + terms +
                '}';
    }
}
