/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package observer;


import entidades.Inscricao;
import entidades.Torneio;
import java.sql.Date;
import org.joda.time.DateTime;
import org.joda.time.Days;

/**
 *
 * @author rodri
 */
public class DadosDoTorneio {
    
    
    private Inscricao inscricao;
    private Date dataAtual;
    private int diasRestantes;

    public DadosDoTorneio(Inscricao inscricao, Date dataAtual) {
        this.inscricao = inscricao;
        this.dataAtual = dataAtual;
        this.diasRestantes = Days.daysBetween(new DateTime(dataAtual), new DateTime(inscricao.getTorneio().getDataInicio())).getDays();
    }

    public Inscricao getInscricao() {
        return inscricao;
    }

    public Date getDataAtual() {
        return dataAtual;
    }

    public int getDiasRestantes() {
        return diasRestantes;
    }
}
