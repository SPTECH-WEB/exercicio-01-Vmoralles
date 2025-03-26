package com.fatura.apifatura.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "faturas")
@Getter @Setter  @NoArgsConstructor @AllArgsConstructor @ToString
public class Fatura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message="O numero do cartão não pode estar em Branco.")
    @Pattern(regexp = "\\d{16}", message = "O numero do cartão deve ter 16 digitos.")
    private String numeroCartao;

    @NotBlank(message="O nome do titular não pode estar em Branco.")
    @Size(min=3, max = 100, message = "O nome deve possuir entre 3 e 100 caracteres")
    private String nomeTitular;

    @NotNull(message="O valor não pode estar em Branco.")
    @DecimalMin(value = "3", message = "O valor minimo é 3")
    @DecimalMax(value = "100",  message="O valor máximo é 10.000")
    private Double valor;

    @NotNull(message = "A data não pode ser Nula")
    @FutureOrPresent(message = "A data de pagamento deve ser a data atual ou futura")
    private LocalDate dataPagamento;

    @NotBlank(message = "O email não pode estar em branco")
    @Email(message = "O e-mail deve ser valido")
    private String emailContato;
}
