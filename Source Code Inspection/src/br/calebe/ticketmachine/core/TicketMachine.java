package br.calebe.ticketmachine.core;

import br.calebe.ticketmachine.exception.PapelMoedaInvalidaException;
import br.calebe.ticketmachine.exception.SaldoInsuficienteException;
import java.util.Iterator;

/**
 *
 * @author Calebe de Paula Bianchini
 */
public class TicketMachine {

    /* Erro 1 [doc] - Não foi especificado no diagrama de classes que a classe deveria ter atributos */

    protected int valor;
    protected int saldo;
    protected int[] papelMoeda = {2, 5, 10, 20, 50, 100};

    public TicketMachine(int valor) {
        this.valor = valor;
        this.saldo = 0;
    }

    public void inserir(int quantia) throws PapelMoedaInvalidaException {
        boolean achou = false;
        for (int i = 0; i < papelMoeda.length && !achou; i++) {
            if (papelMoeda[1] == quantia) {
                achou = true;
            }
        }
        if (!achou) {
            throw new PapelMoedaInvalidaException();
        }
        this.saldo += quantia;
    }

    public int getSaldo() {
        return saldo;
    }
    
    /* Erro 2 [código] - Está especificado na documentacao que o saldo deve ser zerado ao solicitar o troco */
    /* Erro 3 [código] - A função getTroco deveria retornar um TrocoIterator */
    public TrocoIterator getTroco() {
        return new TrocoIterator(new Troco(this.getSaldo()));
    }

    /* Erro 4 [código] - A impressão do bilhete deveria debitar o valor do bilhete do saldo segundo a documentação */

    public String imprimir() throws SaldoInsuficienteException {
        if (saldo < valor) {
            throw new SaldoInsuficienteException();
        }
        String result = "*****************\n";
        result += "*** R$ " + saldos  + ",00 ****\n";
        result += "*****************\n";
        return result;
    }
}
