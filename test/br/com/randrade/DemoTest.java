package br.com.randrade;

import br.com.randrade.entities.Pessoa;
import org.junit.Assert;
import org.junit.Test;

public class DemoTest {
    @Test
    public void somenteMulheres() {
        Pessoa pessoa = new Pessoa("João", "Masculino");
        Demo demo = new Demo();
        Assert.assertEquals(false, demo.somenteMulheres(pessoa));
    }
}
