package br.com.keven.spring_boot_essentials.service;

import br.com.keven.spring_boot_essentials.Repository.IAlunosRepository;
import br.com.keven.spring_boot_essentials.database.model.AlunosEntity;
import br.com.keven.spring_boot_essentials.database.model.AvaliacoesFisicasEntity;
import br.com.keven.spring_boot_essentials.dto.AlunoDto;
import br.com.keven.spring_boot_essentials.exception.BadRequestException;
import br.com.keven.spring_boot_essentials.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AlunoService {
    private final IAlunosRepository alunosRepository;

    public void criarAluno(AlunoDto alunoDTO) throws BadRequestException {
        AlunosEntity aluno = alunosRepository.findByEmail(alunoDTO.getEmail())
                .orElse(null);

        if (aluno != null){
            throw new BadRequestException("Email já cadastrado");
        }

        alunosRepository.save(AlunosEntity.builder()
                        .nome(alunoDTO.getNome())
                        .email(alunoDTO.getEmail())
                .build());
    }

}
