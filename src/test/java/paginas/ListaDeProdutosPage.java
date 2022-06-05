package paginas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ListaDeProdutosPage {
    private WebDriver navegador;

    public ListaDeProdutosPage(WebDriver navegador){
        this.navegador = navegador;
    }


    public FormulariodDeAdicaoDeProdutoPage acessarFormularioAdicaoNovoProduto() {
        // Vou para a tela de registro de produto
        // Sempre tenho que perguntar pra saber qual o nome da classe deve ser escrito acima: Depois de clicar em ADICIOANR PRODUTO eu vou pra onde?
        // Vou pro Formulario de adicao de produto...por isso o nome deste metodo e o retorno
        navegador.findElement(By.linkText("ADICIONAR PRODUTO")).click();

        return new FormulariodDeAdicaoDeProdutoPage(navegador);
    }
}
