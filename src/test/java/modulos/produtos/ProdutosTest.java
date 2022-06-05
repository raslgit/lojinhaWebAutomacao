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
        new LoginPage(navegador)
                .informarOUsuario("admin")
                .informarASenha("admin")
                .submetetrFormularioDeLogin();


        // Vou para a tela de registro de produto
        navegador.findElement(By.linkText("ADICIONAR PRODUTO")).click();

        // Vou preencher dados do produto e o valor sera igual a zero
        navegador.findElement(By.id("produtonome")).sendKeys("XPTO");
        navegador.findElement(By.id("produtovalor")).sendKeys("0");
        navegador.findElement(By.id("produtocores")).sendKeys("Verde, Rosa");

        // Vou submeter o formulario
        navegador.findElement(By.cssSelector("button[type='submit']")).click();

        // Vou validar que a mensagem de erro foi apresentada
        String mensagemToast = navegador.findElement(By.cssSelector(".toast.rounded")).getText();
        Assertions.assertEquals("O valor do produto deve estar entre R$ 0,01 e R$ 7.000,00", mensagemToast);


    }


}
