package br.com.keven.spring_boot_essentials.database.model;

import lombok.*;
import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class ProdutoEntity{

    private Integer id;
    private String name;
    private BigDecimal preco;
    private Integer quantidade;
}
