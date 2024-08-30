package com.bestminds.produtos.service;

import com.bestminds.produtos.dto.ProdutosRecordDTO;
import com.bestminds.produtos.model.ProdutoModel;
import com.bestminds.produtos.repository.ProdutosRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {
    @Autowired
    private ProdutosRepository repository;

    public ProdutoModel registrarProduto(ProdutosRecordDTO dto){
        ProdutoModel usuarioExiste = repository.findByNome(dto.nome());

        if (usuarioExiste != null){
            throw new RuntimeException("Ja existe um produto com esse nome!");
        }

        var model = new ProdutoModel();
        BeanUtils.copyProperties(dto, model);
        return repository.save(model);
    }

    public List<ProdutoModel> consultarTodosOsProdutos(){ return repository.findAll(); }

    public ProdutoModel consultarProduto(int codigo){
        return repository.findById(codigo)
                .orElseThrow(() -> new RuntimeException("Atividade não encontrada"));
    }


    public ProdutoModel editarProduto(int codigo, ProdutosRecordDTO dto){
        ProdutoModel model = repository.findById(codigo)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));

        if(dto.nome() != null){
            model.setNome(dto.nome());
        }
        if(dto.descricao() != null){
            model.setDescricao(dto.descricao());
        }
        if (dto.preco() != 0){
            model.setPreco(dto.preco());
        }

        return repository.save(model);
    }

    public String excluirProduto(int codigo){
        ProdutoModel model = repository.findById(codigo)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));

        repository.delete(model);

        return "Produto excluido com sucesso";
    }
}
