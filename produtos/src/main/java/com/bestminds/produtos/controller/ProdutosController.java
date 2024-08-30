package com.bestminds.produtos.controller;

import com.bestminds.produtos.dto.ProdutosRecordDTO;
import com.bestminds.produtos.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
public class ProdutosController {

    @Autowired
    private ProdutoService service;

    @GetMapping("/produtos")
    public ResponseEntity<Object> getProdutos(){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(service.consultarTodosOsProdutos());
        }catch (RuntimeException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto nao encontrado");
        }
    }

    @GetMapping("/produtos/{codigo}")
    public ResponseEntity<Object> getProdutoById(@PathVariable(value = "codigo") int codigo){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(service.consultarProduto(codigo));
        }catch (RuntimeException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto nao encontrado");
        }
    }
    @PostMapping("/produtos")
    public ResponseEntity<Object> postProdutos(@RequestBody ProdutosRecordDTO dto){
        try{
            var produto = service.registrarProduto(dto);
            return ResponseEntity.status(HttpStatus.CREATED).body(produto);
        }catch (RuntimeException e){
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        }
    }

    @PutMapping("/produtos/{codigo}")
    public ResponseEntity<Object> putProdutos(@PathVariable(value = "codigo") int codigo, @RequestBody ProdutosRecordDTO dto){
        try{
            var produtoAtualizado = service.editarProduto(codigo, dto);
            return ResponseEntity.status(HttpStatus.OK).body(produtoAtualizado);
        }catch (RuntimeException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto nao encontrado");
        }
    }

    @DeleteMapping("/produtos/{codigo}")
    public ResponseEntity<Object> deleteProdutos(@PathVariable(value = "codigo") int codigo){
        try{
            service.excluirProduto(codigo);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Produto excluido com sucesso");
        }catch (RuntimeException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto nao encontrado");
        }
    }
}
