package spring.validation.model;

import jakarta.validation.constraints.*;
import org.springframework.data.mongodb.core.mapping.Document;

@Document ("Employees")
public record Employee(
    String id,
    @NotBlank @Size (min = 2, max = 40, message = "Name must contain between 2 to 40 characters") String name,
    @NotBlank @Email String email,
    @NotBlank @Pattern (regexp = "^\\d{10}$", message = "Telephone number should be 10 numbers") String phone
) {
}

/**
 * @NotNull
 * Ensures that the annotated element is not null. This validation only checks for null values
 * and does not validate the content of the element (e.g., empty strings or collections).
 */

/**
 * @NotEmpty
 * Ensures that the annotated element is not null and contains at least one element.
 * For Strings, it ensures the string is not null and has a length greater than zero.
 * For collections, it checks that the collection is not empty.
 */

/**
 * @NotBlank
 * Ensures that the annotated String is not null, not empty, and does not consist solely of whitespace characters.
 * This is more strict than @NotEmpty, as it also validates against strings like "   ".
 */
