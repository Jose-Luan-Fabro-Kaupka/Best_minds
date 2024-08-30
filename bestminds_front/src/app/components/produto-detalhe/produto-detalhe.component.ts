import { Component, OnInit } from '@angular/core';
import { ProdutoService } from '../../services/produto.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-produto-detalhe',
  templateUrl: './produto-detalhe.component.html',
  styleUrls: ['./produto-detalhe.component.css']
})
export class ProdutoDetalheComponent implements OnInit {

  produto: any = { nome: '', descricao: '', preco: 0 };

  constructor(
    private route: ActivatedRoute,
    private produtoService: ProdutoService
  ) { }

  ngOnInit(): void {
    const id = this.route.snapshot.paramMap.get('id');
    if (id) {
      this.produtoService.getProdutoById(id).subscribe({
        next: (data) => {
          this.produto = data;
          console.log('Produto carregado', this.produto);
        },
        error: (err) => {
          console.error('Erro ao buscar detalhes do produto', err);
        }
      });
    }
  }

  onSubmit(): void {
    const id = this.route.snapshot.paramMap.get('id');
    if (id) {
      this.produtoService.updateProduto(id, this.produto).subscribe({
        next: (data) => {
          console.log('Produto atualizado com sucesso', data);
        },
        error: (err) => {
          console.error('Erro ao atualizar produto', err);
        }
      });
    }
  }
}
