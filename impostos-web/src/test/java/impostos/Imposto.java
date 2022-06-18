package impostos;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.awt.*;

public class Imposto {

    public static WebDriver driver;

    @Test
    public void entrar() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "D:/yla_m/Downloads/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("C:\\Users\\yla_m\\git\\impostos-web\\impostos-web\\src\\main\\resources\\webapp\\imposto.html");
        Thread.sleep(2000);
    }

    @Test
    public void informarRendimentosTrivbutaveis(String rendimentosTrivbutaveis){
        WebElement inputRendimentosTrivbutaveis = driver.findElement(By.id("rendimentosTributaveis"));
        inputRendimentosTrivbutaveis.clear();
        inputRendimentosTrivbutaveis.sendKeys(rendimentosTrivbutaveis);
    }

    @Test
    public void habilitarInformarDeducoes() {
        WebElement check = driver.findElement(By.id("isInformarDeducoes"));
        check.click();
    }

    @Test
    public void informarPrevidenciaOficial(String previdenciaOficial) {
        WebElement inputPrevidenciaOficial = driver.findElement(By.id("previdenciaOficial"));
        inputPrevidenciaOficial.clear();
        inputPrevidenciaOficial.sendKeys(previdenciaOficial);
    }

    @Test
    public void informarDependentes(String qtdDependentes) {
        WebElement inputQuantidadeDependentes = driver.findElement(By.id("quantidadeDependentes"));
        inputQuantidadeDependentes.clear();
        inputQuantidadeDependentes.sendKeys(qtdDependentes);
    }

    @Test
    public void realizarCalculo() {
        WebElement calculoBtn = driver.findElement(By.id("calculoBtn"));
        calculoBtn.click();
    }

    @Test
    public String calcularValorAPagar() {
        WebElement impostoPagar = driver.findElement(By.id("impostoPagar"));
        String x = impostoPagar.getAttribute("value");
        return  x;
    }

    @Test
    public String calcularAliquota() {
        WebElement aliquotaEfetiva = driver.findElement(By.id("aliquotaEfetiva"));
        String x =  aliquotaEfetiva.getAttribute("value");
        return x;
    }

    @AfterAll
    public static void teardown(){
        driver.close();
    }
}
