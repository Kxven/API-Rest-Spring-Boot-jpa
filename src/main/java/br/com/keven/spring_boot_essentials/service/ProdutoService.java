package br.com.keven.spring_boot_essentials.service;

import br.com.keven.spring_boot_essentials.database.model.ProdutoEntity;
import br.com.keven.spring_boot_essentials.dto.ProdutoDTO;
import br.com.keven.spring_boot_essentials.exception.NotFoundException;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProdutoService {

    private static final List<ProdutoEntity> PRODUTOS = new ArrayList<>();

    static {
        ProdutoEntity p = new ProdutoEntity();
        p.setId(1);
        p.setName("Notebook");
        p.setPreco(new BigDecimal("5000"));
        p.setQuantidade(10);

        ProdutoEntity p1 = new ProdutoEntity();
        p1.setId(2);
        p1.setName("ipohne");
        p1.setPreco(new BigDecimal("7000"));
        p1.setQuantidade(10);


        ProdutoEntity p2 = new ProdutoEntity();
        p2.setId(3);
        p2.setName("mouse");
        p2.setPreco(new BigDecimal("500"));
        p2.setQuantidade(10);


        PRODUTOS.add(p);
        PRODUTOS.add(p2);
        PRODUTOS.add(p1);
    }

    public List<ProdutoEntity> findAll(){
        return new ArrayList<>(PRODUTOS);
    }

    public ProdutoEntity createProduct(ProdutoDTO produtoDTO){
        Integer identifier = PRODUTOS.stream()
                .mapToInt(ProdutoEntity::getId)
                .max()
                .orElse(0) + 1;
        ProdutoEntity newProduct = ProdutoEntity.builder()
                .id(identifier)
                .name(produtoDTO.getName())
                .preco(produtoDTO.getPreco())
                .quantidade(produtoDTO.getQuantidade())
                .build();

        PRODUTOS.add(newProduct);
        return newProduct;
    }
    public ProdutoEntity updateProduct(ProdutoDTO produtoDTO, Integer id) throws NotFoundException {
        ProdutoEntity product = PRODUTOS.stream()
                .filter(p -> p.getId().equals(id))
                .findAny()
                .orElseThrow(() -> new NotFoundException("Product not found"));
        product.setName(produtoDTO.getName());
        product.setPreco(produtoDTO.getPreco());
        product.setQuantidade(produtoDTO.getQuantidade());

        return product;
    }
    public void removeProduct(Integer id){
        PRODUTOS.removeIf(p -> p.getId().equals(id));
    }
}