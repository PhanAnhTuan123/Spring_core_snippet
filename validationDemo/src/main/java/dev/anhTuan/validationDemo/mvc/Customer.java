package dev.anhTuan.validationDemo.mvc;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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

}
