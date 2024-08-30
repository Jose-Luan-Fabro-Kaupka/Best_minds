package com.bestminds.produtos.repository;

import com.bestminds.produtos.model.ProdutoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutosRepository extends JpaRepository<ProdutoModel, Integer> {
    ProdutoModel findByNome(String nome);
}
