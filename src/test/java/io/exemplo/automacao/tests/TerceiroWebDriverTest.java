package io.exemplo.automacao.tests;

import io.exemplo.automacao.extensions.WebDriverExtension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(WebDriverExtension.class)
public class TerceiroWebDriverTest {

    @Test
    public void exercicioTerceiraAula(WebDriver webDriver) {

        webDriver.get("https://matheusbeoulve.github.io/aulas/aula3/");

        webDriver.findElement(By.linkText("Professor")).click();

        List<WebElement> presencas = webDriver.findElements(By.xpath("//table//td[3]"));

        int presentes = 0;

        for (WebElement presenca : presencas) {
            if (presenca.getText().equals("Sim")) {
                presentes++;
            }
        }

        assertEquals(2, presentes, "Numero de alunos presentes esperado:");
    }
}
