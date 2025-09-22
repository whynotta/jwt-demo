package kg.megalab.jwtdemo.models.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@Schema(description = "Запрос на аутентификацию")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SignInRequest {
    @Schema(description = "Имя пользователя", example = "username")
            @Size(min = 5, max = 50,message = "Имя пользователя должео содержать от 5 до 50 символов")
            @NotBlank(message = "Имя пользователя не может быть пустым")
    String username;
    @Schema(description = "Пароль", example = "password123")
            @Size(min = 5,max = 30, message = "Пароль должен содержать от 5 до 30 символов")
            @NotBlank(message = "Пароль не может быть пустым")
    String password;
}
