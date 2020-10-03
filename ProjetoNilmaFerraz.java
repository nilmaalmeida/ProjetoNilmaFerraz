package com.example.tests;

import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

  @Test
public class ProjetoNilmaFerraz {
  private WebDriver driver;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();
  private final String pathChromeDriver = "C:\\Selenium\\chromedriver.exe";
  private String baseUrl;
  
  @BeforeClass(alwaysRun = true)
  public void setUp() throws Exception {
	System.setProperty("webdriver.chrome.driver", pathChromeDriver);
	driver = new ChromeDriver();
	driver.manage().window().maximize();
    baseUrl = "https://mantis-prova.base2.com.br/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  public void testProjetoNilmaFerraz() throws Exception {
    //acessa o site e realiza o login do usuário
	driver.get("https://mantis-prova.base2.com.br/login_page.php");
    driver.findElement(By.name("username")).clear();
    driver.findElement(By.name("username")).sendKeys("nilma.ferraz");
    driver.findElement(By.name("password")).clear();
    driver.findElement(By.name("password")).sendKeys("121527nil");
    driver.findElement(By.cssSelector("input.button")).click();
    //seleciona o projeto
    new Select(driver.findElement(By.name("project_id"))).selectByVisibleText("Nilma Ferraz´s Projetc");
    driver.findElement(By.cssSelector("input.button-small")).click();
    //inclui os casos
    driver.findElement(By.linkText("Relatar Caso")).click();
    new Select(driver.findElement(By.name("category_id"))).selectByVisibleText("[Todos os Projetos] Teste");
    new Select(driver.findElement(By.name("reproducibility"))).selectByVisibleText("às vezes");
    new Select(driver.findElement(By.name("severity"))).selectByVisibleText("grande");
    new Select(driver.findElement(By.name("priority"))).selectByVisibleText("alta");
    new Select(driver.findElement(By.name("profile_id"))).selectByVisibleText("PC Windows 7");
    driver.findElement(By.name("summary")).clear();
    driver.findElement(By.name("summary")).sendKeys("Testes de Sistema");
    driver.findElement(By.name("description")).clear();
    driver.findElement(By.name("description")).sendKeys("Executar testes de usabilidade do Sistema.");
    driver.findElement(By.cssSelector("input.button")).click();
    driver.findElement(By.linkText("Relatar Caso")).click();
    new Select(driver.findElement(By.name("category_id"))).selectByVisibleText("[Todos os Projetos] Teste");
    new Select(driver.findElement(By.name("reproducibility"))).selectByVisibleText("aleatório");
    new Select(driver.findElement(By.name("severity"))).selectByVisibleText("mínimo");
    new Select(driver.findElement(By.name("priority"))).selectByVisibleText("baixa");
    new Select(driver.findElement(By.name("profile_id"))).selectByVisibleText("PC Windows 7");
    driver.findElement(By.name("summary")).clear();
    driver.findElement(By.name("summary")).sendKeys("Testes de Sistema");
    driver.findElement(By.name("description")).clear();
    driver.findElement(By.name("description")).sendKeys("Executar os testes de integração de sistema.");
    driver.findElement(By.cssSelector("input.button")).click();
    driver.findElement(By.linkText("Relatar Caso")).click();
    new Select(driver.findElement(By.name("category_id"))).selectByVisibleText("[Todos os Projetos] Teste");
    new Select(driver.findElement(By.name("reproducibility"))).selectByVisibleText("sempre");
    new Select(driver.findElement(By.name("severity"))).selectByVisibleText("mínimo");
    new Select(driver.findElement(By.name("profile_id"))).selectByVisibleText("PC Windows 7");
    driver.findElement(By.name("summary")).clear();
    driver.findElement(By.name("summary")).sendKeys("Testes de Sistema");
    driver.findElement(By.name("description")).clear();
    driver.findElement(By.name("description")).sendKeys("Executar os testes verificando usuário e senha corretos.");
    driver.findElement(By.cssSelector("input.button")).click();
    //visualiza todos os casos criados
    driver.findElement(By.linkText("Minha Visão")).click();
    Thread.sleep(4000);
    //sai do sistema
    driver.findElement(By.linkText("Sair")).click();
    driver.findElement(By.cssSelector("input.button")).click();
  }

  @AfterClass(alwaysRun = true)
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

   @SuppressWarnings("unused")
private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
