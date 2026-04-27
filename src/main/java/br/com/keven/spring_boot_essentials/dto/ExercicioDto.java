package br.com.keven.spring_boot_essentials.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class ExercicioDto {
    private String nome;
    private String grupoMuscular;
}
