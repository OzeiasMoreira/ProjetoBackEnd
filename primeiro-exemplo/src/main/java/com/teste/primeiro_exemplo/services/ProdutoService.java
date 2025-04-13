package com.teste.primeiro_exemplo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teste.primeiro_exemplo.model.Produto;
import com.teste.primeiro_exemplo.repository.ProdutoRepository;

@Service
public class ProdutoService {
    
    @Autowired
    private ProdutoRepository produtoRepository;

    /**
     * Método para retornar uma lista de produtos
     * @return Lista de produtos
     */
    public List<Produto> obterTodos (){
        return produtoRepository.obterTodos();
    }

        /**
     * Método que retorna o produto encontrado pelo seu Id.
     * @param id do produto que será buscado.
     * @return retorn um optional de produto, caso não encontre retorna vazio.
     */
    public Optional<Produto> obterPorId(Integer id){
        return produtoRepository.obterPorId(id);
    }

        /**
     * Método que adiciona um produto na lista de produtos.
     * @param produto que será adicionado.
     * @return retorna o produto adicionado.
     */
    public Produto adicionar(Produto produto) {
        return produtoRepository.adicionar(produto);
    }

        /**
     * Método que remove um produto da lista de produtos.
     * @param id do produto que será removido.
     */
    public void deletar(Integer id) {
        produtoRepository.deletar(id);
    }

        /**
     * Método que atualiza um produto na lista de produtos.
     * @param produto que será atualizado.
     * @return retorna o produto atualizado.
     */
    public Produto atualizar(Integer id ,Produto produto) {
        
        produto.setId(id);

        return produtoRepository.atualizar(produto);
    }
}
