package com.teste.primeiro_exemplo.repository;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.teste.primeiro_exemplo.model.Produto;

@Repository
public class ProdutoRepository {
    
    private final  ArrayList<Produto> produtos = new ArrayList<>();
    private Integer ultimoId = 0;

    /**
     * Método para retornar uma lista de produtos
     * @return List de produtos
     */
    public List<Produto> obterTodos(){
        return produtos;
    }

    /**
     * Método que retorna o produto encontrado pelo seu Id.
     * @param id do produto que será buscado.
     * @return retorn um optional de produto, caso não encontre retorna vazio.
     */
    public Optional<Produto> obterPorId(Integer id){
        return produtos
        .stream()
        .filter(produto -> Objects.equals(produto.getId(), id))
        .findFirst();   
    }

    /**
     * Método que adiciona um produto na lista de produtos.
     * @param produto que será adicionado.
     * @return retorna o produto adicionado.
     */
    public Produto adicionar(Produto produto) {

        ultimoId++;

        produto.setId(ultimoId);
        produtos.add(produto);

        return produto;
    }

    /**
     * Método que remove um produto da lista de produtos.
     * @param id do produto que será removido.
     */
    public void deletar(Integer id) {
        produtos.removeIf(produto -> Objects.equals(produto.getId(), id));
    }

    /**
     * Método que atualiza um produto na lista de produtos.
     * @param produto que será atualizado.
     * @return retorna o produto atualizado.
     */
    public Produto atualizar(Produto produto) {
       Optional <Produto> produtoEncontrado =  obterPorId(produto.getId());

       if(produtoEncontrado.isEmpty()){
            throw new InputMismatchException("Produto não encontrado!");
       }

       deletar(produto.getId());

       produtos.add(produto);

       return produto;
    }

}

