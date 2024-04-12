package dev.anhTuan.validationDemo.mvc;

import dev.anhTuan.validationDemo.mvc.validation.CourseCode;
import jakarta.validation.constraints.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Customer {

    private String firstName;
    @NotNull(message = "is required")
    @Size(message = "is required",min = 1)
    private String lastName = "";


    @NotNull(message = "is required")
    @Min(value = 0,message = "must be greater than or equal  to zero")
    @Max(value = 10,message = "must be greater than or equal to 10")
    private Integer freePasses;

    @Pattern(regexp = "^[a-zA-Z0-9]{5}",message = "only 5 chars/digits")
    private String postalCode;

    @CourseCode(value = "TUAN123",message = "must start be TUAN123")
    private String courseCode;


}
