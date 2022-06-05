package paginas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FormulariodDeAdicaoDeProdutoPage {
    private WebDriver navegador;

    public FormulariodDeAdicaoDeProdutoPage(WebDriver navegador){
        this.navegador = navegador;
    }

    public FormulariodDeAdicaoDeProdutoPage informarNomeDoProduto(String produtoNome){
        navegador.findElement(By.id("produtonome")).sendKeys(produtoNome);
        return this;
    }

    public FormulariodDeAdicaoDeProdutoPage informarValorDoProduto(String produtoValor){
        navegador.findElement(By.id("produtovalor")).sendKeys(produtoValor);
        return this;
    }

    public FormulariodDeAdicaoDeProdutoPage informarCoresDoProduto(String produtoCores){
        navegador.findElement(By.id("produtocores")).sendKeys(produtoCores);
        return this;
    }

    // como estou adicionando um valor zero ele vai voltar pra lista de produto page
    public ListaDeProdutosPage submeterFormularioDeAdicaoComErro(){
        // Vou submeter o formulario
        navegador.findElement(By.cssSelector("button[type='submit']")).click();
        return new ListaDeProdutosPage(navegador);
    }

    public FormularioDeEdicaoDoProdutoPage submeterFormularioDeAdicaoComSucesso(){
        navegador.findElement(By.cssSelector("button[type='submit']")).click();
        return new FormularioDeEdicaoDoProdutoPage(navegador);
    }



}
