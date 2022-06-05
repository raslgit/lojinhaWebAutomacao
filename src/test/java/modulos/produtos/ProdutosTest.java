package modulos.produtos;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import paginas.LoginPage;

import java.time.Duration;

@DisplayName("Testes Web do Modulo de produtos")
public class ProdutosTest {

    private WebDriver navegador;

    // para uso do WebdriverManager
/*    private ChromeDriver navegador;
    //private FirefoxDriver navegador;*/

    @BeforeEach
    public void beforeEach(){
        // Abrir o navegador

        //System.setProperty("webdriver.chrome.diver", "C:\\Drivers\\chromedriver_win32\\chromedriver.exe");
        //this.navegador = new ChromeDriver();


        WebDriverManager.chromedriver().setup();
        //WebDriverManager.firefoxdriver().setup();
        this.navegador = new ChromeDriver();
        //this.navegador = new FirefoxDriver();


        // vou maximizar a tela
        this.navegador.manage().window().maximize();

        // Vou definir um tempo de espera padrão de 5 segundos
        this.navegador.manage().timeouts().implicitlyWait((Duration.ofSeconds(5)));


        // Navegar para a pagina da Lojinha Web
        this.navegador.get("http://165.227.93.41/lojinha-web/v2/");

    }

    @AfterEach
    public void afterEach(){
        // Vou fechar o navegador
        navegador.quit();
    }


    @Test
    @DisplayName("Nao e permitido registrar um produto com valor igual a zero")
    public void testNaoEPermitidoRegistrarProdutosComValorIgualAZero() {
        // Fazer login
        String mensagemApresentada = new LoginPage(navegador)
                .informarOUsuario("admin")
                .informarASenha("admin")
                .submeterFormularioDeLogin()
                .acessarFormularioAdicaoNovoProduto()
                .informarNomeDoProduto("Televisão Samsung")
                .informarValorDoProduto("0")
                .informarCoresDoProduto("Preto, Branco")
                .submeterFormularioDeAdicaoComErro()
                .capturarMensagemApresentada();

        Assertions.assertEquals("O valor do produto deve estar entre R$ 0,01 e R$ 7.000,00", mensagemApresentada);

    }

    @Test
    @DisplayName("Nao e permitido registrar um produto com valor maior que 7.000")
    public void testNaoEPermitidoRegistrarProdutosComValorMaiorQue7000() {
        String mensagemApresentada = new LoginPage(navegador)
                .informarOUsuario("admin")
                .informarASenha("admin")
                .submeterFormularioDeLogin()
                .acessarFormularioAdicaoNovoProduto()
                .informarNomeDoProduto("Televisão Samsung")
                .informarValorDoProduto("700010")
                .informarCoresDoProduto("Preto, Branco")
                .submeterFormularioDeAdicaoComErro()
                .capturarMensagemApresentada();

        Assertions.assertEquals("O valor do produto deve estar entre R$ 0,01 e R$ 7.000,00", mensagemApresentada);

    }

    @Test
    @DisplayName("Posso adicionar produtos que estejam na faixa de 0,01 ateh 7.000,00")
    public void testPossoAdicionarProdutosComValorDeUmCentavoASeteMilReais(){
        String mensagemApresentada = new LoginPage((navegador))
                .informarOUsuario("admin")
                .informarASenha("admin")
                .submeterFormularioDeLogin()
                .acessarFormularioAdicaoNovoProduto()
                .informarNomeDoProduto("TV Sony")
                .informarValorDoProduto("599999")
                .informarCoresDoProduto("Cinza, preto")
                .submeterFormularioDeAdicaoComSucesso()
                .capturarMensagemApresentada();

        Assertions.assertEquals("Produto adicionado com sucesso", mensagemApresentada);
    }

    @Test
    @DisplayName("Posso adicionar produtos que estejam no limite de 0,01")
    public void testPossoAdicionarProdutosComValorDeUmCentavo(){
        String mensagemApresentada = new LoginPage((navegador))
                .informarOUsuario("admin")
                .informarASenha("admin")
                .submeterFormularioDeLogin()
                .acessarFormularioAdicaoNovoProduto()
                .informarNomeDoProduto("TV Sony")
                .informarValorDoProduto("001")
                .informarCoresDoProduto("Cinza, preto")
                .submeterFormularioDeAdicaoComSucesso()
                .capturarMensagemApresentada();

        Assertions.assertEquals("Produto adicionado com sucesso", mensagemApresentada);
    }

    @Test
    @DisplayName("Posso adicionar produtos que estejam no limite de 7000")
    public void testPossoAdicionarProdutosComValorDeSeteMilReais(){
        String mensagemApresentada = new LoginPage((navegador))
                .informarOUsuario("admin")
                .informarASenha("admin")
                .submeterFormularioDeLogin()
                .acessarFormularioAdicaoNovoProduto()
                .informarNomeDoProduto("TV Sony")
                .informarValorDoProduto("700000")
                .informarCoresDoProduto("Cinza, preto")
                .submeterFormularioDeAdicaoComSucesso()
                .capturarMensagemApresentada();

        Assertions.assertEquals("Produto adicionado com sucesso", mensagemApresentada);
    }

}
