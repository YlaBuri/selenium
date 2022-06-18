package impostos;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Assert;

public class CalculoImpostoSteps {

    Imposto imposto = new Imposto();

    @Given("estou na funcionalidade de calculo de imposto de renda")
    public void entrar() throws InterruptedException {
        imposto.entrar();
    }

    @When("informo como rendimentos tributáveis $rendimentosTrivbutaveis reais")
    public void informarRendimentosTrivbutaveis(String rendimentosTrivbutaveis){
        imposto.informarRendimentosTrivbutaveis(rendimentosTrivbutaveis);
    }

    @When("habilito a opcao de informar deducoes")
    public void habilitarInformarDeducoes(){
        imposto.habilitarInformarDeducoes();
    }

    @When("informo como previdencia oficial $previdenciaOficial reais")
    public void informarPrevidenciaOficial(String previdenciaOficial){
        imposto.informarPrevidenciaOficial(previdenciaOficial);
    }

    @When("informo $qtdDependentes dependentes")
    public void informarDependentes(String qtdDependentes){
        imposto.informarDependentes(qtdDependentes);
    }

    @When("solicito que o calculo seja realizado")
    public void realizarCalculo(){
        imposto.realizarCalculo();
    }

    @Then("o valor do imposto a pagar e de $valor reais")
    public void verificarValorAPagar(String valor){
        Assert.assertEquals(valor, imposto.calcularValorAPagar());
    }

    @Then("a aliquota efetiva e de $aliquota%")
    public void verificarAliquota(String aliquota){
        aliquota+="%";
        Assert.assertEquals(aliquota, imposto.calcularAliquota());
    }
}
