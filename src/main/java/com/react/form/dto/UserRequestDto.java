package com.react.form.dto;

/**
 * DTO for incoming user create/update requests from frontend.
 */
public class UserRequestDto {
    private String username;
    private String email;
    private String hashedPassword;
    private String fullName;
    private String role; // e.g. "USER"
    private Boolean active; // optional

    public UserRequestDto() {}

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getHashedPassword() { return hashedPassword; }
    public void setHashedPassword(String hashedPassword) { this.hashedPassword = hashedPassword; }

    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }

    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }

    public Boolean getActive() { return active; }
    public void setActive(Boolean active) { this.active = active; }
}
