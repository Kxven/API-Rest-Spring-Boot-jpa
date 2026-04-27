package br.com.keven.spring_boot_essentials.controller;

import br.com.keven.spring_boot_essentials.database.model.ExerciciosEntity;
import br.com.keven.spring_boot_essentials.service.ExerciciosService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/exercicios")
@RequiredArgsConstructor
public class ExerciciosController {
    private final ExerciciosService exerciciosService;

    public List<ExerciciosEntity> findAll(){
        return exerciciosService.findAll();
    }

}
