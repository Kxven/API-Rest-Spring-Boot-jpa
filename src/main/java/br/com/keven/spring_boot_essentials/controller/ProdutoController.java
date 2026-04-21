package br.com.keven.spring_boot_essentials.controller;

import br.com.keven.spring_boot_essentials.database.model.ProdutoEntity;
import br.com.keven.spring_boot_essentials.dto.ProdutoDTO;
import br.com.keven.spring_boot_essentials.exception.NotFoundException;
import br.com.keven.spring_boot_essentials.service.ProdutoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/produtos")
public class ProdutoController {

    private final ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ProdutoEntity> findAll(){
        return produtoService.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProdutoEntity createProduct(@RequestBody ProdutoDTO produtoDTO){
        return produtoService.createProduct(produtoDTO);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ProdutoEntity updateProduct(@PathVariable Integer id,
                                       @RequestBody ProdutoDTO produtoDTO) throws NotFoundException {
        return produtoService.updateProduct(produtoDTO, id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeProduct(@PathVariable Integer id){
        produtoService.removeProduct(id);
    }
}
