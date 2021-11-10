package io.exemplo.automacao.tests;

import io.exemplo.automacao.extensions.WebDriverExtension;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(WebDriverExtension.class)
public class SegundoWebDriverTest {

    @Test
    public void segundaAulaPrimeiroExercicio(WebDriver webDriver) {
        webDriver.get("https://matheusbeoulve.github.io/aulas/aula2/");

        webDriver.findElement(By.linkText("Carro")).click();

        WebElement tipoTransacao = webDriver.findElement(By.cssSelector("[name=tipo-transacao]"));
        new Select(tipoTransacao).selectByIndex(2);
        webDriver.findElement(By.cssSelector("[name=valor-veiculo]")).sendKeys("10000");
        webDriver.findElement(By.cssSelector("[name=nome-emissor")).sendKeys("Matheus Henrique G Santos");
        webDriver.findElement(By.cssSelector("[name=nome-beneficiario]")).sendKeys("Josefa Silene S Galdino");
        webDriver.findElement(By.cssSelector("[name=ano-carro]")).sendKeys("2020");
        webDriver.findElement(By.cssSelector("#carro-assegurado")).click();
        webDriver.findElement(By.cssSelector("#usou-seguro-carro")).click();

        webDriver.findElement(By.cssSelector("[type=submit]")).click();

        String mensagem = webDriver.findElement(By.cssSelector("#confirmar-dados")).getText();

        assertEquals("Obrigado, Matheus Henrique G Santos pelo seu pedido!", mensagem);
    }

    @Test
    public void segundaAulaSegundoExercicio(WebDriver webDriver) {
        webDriver.get("https://matheusbeoulve.github.io/aulas/aula2/");

        webDriver.findElement(By.linkText("Carro")).click();

        WebElement usouSeguroCarro = webDriver.findElement(By.cssSelector("#usou-seguro-carro"));

        assertFalse(usouSeguroCarro.isEnabled());

        webDriver.findElement(By.cssSelector("#carro-assegurado")).click();

        assertTrue(usouSeguroCarro.isEnabled());
    }

    @Test
    public void segundoDesafio(WebDriver webDriver) {
        // Escreva aqui o codigo do seu desafio
    }
}
