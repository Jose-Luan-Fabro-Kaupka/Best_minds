import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ProdutoComponent } from './components/produto/produto.component';
import { ProdutoDetalheComponent } from './components/produto-detalhe/produto-detalhe.component';

const routes: Routes = [
  {path: "produtos", component: ProdutoComponent},
  {path: "produtos/:id", component: ProdutoDetalheComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
