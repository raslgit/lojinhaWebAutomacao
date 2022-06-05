package paginas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginPage {
    // Regras pra ter page objects (padrao a ser seguido)
    // 1 - Atibuto privado que representa o navegador
    private WebDriver navegador;

    // 2 - Tem que ter um construtor que recebe o estado atual do navegador e passa pra dentro dessa classe
    public LoginPage(WebDriver navegador){
        this.navegador = navegador;
    }

    // 3 - Terei um metodo de interacao para cada elemento da tela (ver se depois da acao vou continuar na mesma pagina ou se vai pra outra pagina)
    // Neste caso aqui, vou continuar na mesma pagina...por isso public LoginPage....se fosse outra página seria public nome da outra class (outra pagina)
    public LoginPage informarOUsuario(String usuario){
        navegador.findElement(By.cssSelector("label[for='usuario']")).click();
        navegador.findElement(By.id("usuario")).sendKeys(usuario);

        return this;
        /*
         nesta classe estamos usando dois design patterns (Page objects e Fluent pages)
         Fluent pages => o tempo todo retornar a proxima pagina...nem que a proxima seja a mesma atual
        */
    }
    public LoginPage informarASenha(String senha) {
        navegador.findElement(By.cssSelector("label[for='senha']")).click();
        navegador.findElement(By.id("senha")).sendKeys(senha);

        return this; // pq depois que eu exeuctar este metodo eu ainda continuo na mesma pagina...por isso retorno this
    }

    public ListaDeProdutosPage submetetrFormularioDeLogin(){
        navegador.findElement(By.cssSelector("button[type='submit']")).click();

        return new ListaDeProdutosPage(navegador);

    }




}
