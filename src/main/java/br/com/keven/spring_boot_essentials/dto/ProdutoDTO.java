package br.com.keven.spring_boot_essentials.dto;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class ProdutoDTO {

    private String name;
    private BigDecimal preco;
    private Integer quantidade;
}
