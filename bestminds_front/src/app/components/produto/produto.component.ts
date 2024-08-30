import { Component, OnInit } from '@angular/core';
import { ProdutoService } from '../../services/produto.service';

@Component({
  selector: 'app-produto',
  templateUrl: './produto.component.html',
  styleUrls: ['./produto.component.css']  // Corrected "styleUrl" to "styleUrls"
})
export class ProdutoComponent implements OnInit {

  produtos: any[] = [];
  criandoProduto: boolean = false;
  novoProduto: any = {
    nome: '',
    descricao: '',
    preco: 0
  };

  constructor(private produtoService: ProdutoService) {}

  ngOnInit() {
    this.carregarProdutos();
  }

  carregarProdutos() {
    this.produtoService.getProdutos().subscribe({
      next: (data) => {
        this.produtos = data;
      }, 
      error: (err) => {
        console.error('Erro ao buscar produtos', err);
      }
    });
  }

  toggleCriarProduto() {
    this.criandoProduto = !this.criandoProduto;
  }

  onSubmitCriarProduto() {
    this.produtoService.createProduto(this.novoProduto).subscribe({
      next: (data) => {
        this.carregarProdutos();
        this.toggleCriarProduto();
        this.novoProduto = {
          nome: '',
          descricao: '',
          preco: 0
        };
      },
      error: (err) => {
        console.error('Erro ao criar produto', err);
      }
    });
  }

  excluirProduto(codigo: number) {
    if (codigo === undefined || codigo === null) {
      console.error('Erro: Código do produto não está definido');
      return;
    }
  
    this.produtoService.deleteProduto(codigo).subscribe({
      next: () => {
        this.carregarProdutos();
      },
      error: (err) => {
        console.error('Erro ao excluir produto', err);
      }
    });
  }
  
}
