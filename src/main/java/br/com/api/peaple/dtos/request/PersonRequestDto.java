package br.com.api.peaple.dtos.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PersonRequestDto {

    @NotBlank(message = "O nome é obrigatório")
    private String name;
    @NotBlank(message = "O cpf é obrigatório")
    private String cpf;
    @NotNull(message = "A idade é obrigatória")
    private Integer age;
}
