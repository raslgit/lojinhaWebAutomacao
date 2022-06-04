package paginas;

import org.openqa.selenium.chrome.ChromeDriver;

public class LoginPage {
    // Regras pra ter page objects (padrao a ser seguido)
    // 1 - Atibuto privado que representa o navegador
    private ChromeDriver navegador;

    // 2 - Tem que ter um construtor que recebe o estado atual do navegador e passa pra dentro dessa classe
    public LoginPage(ChromeDriver navegador){
        this.navegador = navegador;
    }

    // 3 - Terei um metodo de interacao para cada elemento da tela (ver se depois da acao vou continuar na mesma pagina ou se vai pra outra pagina)
    // Neste caso aqui, vou continuar na mesma pagina...por isso public LoginPage....se fosse outra página seria public nome da outra class (outra pagina)
    public LoginPage informarOUsuario(String usuario){

    }



}
