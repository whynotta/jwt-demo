package kg.megalab.jwtdemo.models.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Schema(description = "Запрос на регистрацию")
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SignUpRequest {
    @Schema(description = "Имя пользователя", example = "username")
    @Size(min = 5, max = 50,message = "Имя пользователя должео содержать от 5 до 50 символов")
    @NotBlank(message = "Имя пользователя  не может быть пустым")
    String username;
    @Schema(description = "Адрес электронной почты",example = "username@gmail.com")
            @NotBlank(message = "Адрес электронной почты не может быть пустым")
            @Email(message = "Адрес электронной должен быть в формате username@gmail.com")
            @Size(min = 5, max = 100,message = "Адрес электронной почты должен " +
                    "содержать от 5 до 100 символов")
    String email;
    @Schema(description = "Пароль", example = "password123")
            @NotBlank(message = "Пароль не может быть пустым")
            @Size(min = 5,max = 30,message = "Пароль должен содержать от 5 до 30 символов")
    String password;




}
