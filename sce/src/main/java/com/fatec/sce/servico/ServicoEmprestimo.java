package com.fatec.sce.servico;

import org.apache.log4j.Logger;
import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.Duration;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import com.fatec.sce.model.Emprestimo;
import com.fatec.sce.model.FabricaDeConexoes;
import com.fatec.sce.model.Livro;
import com.fatec.sce.model.Usuario;

public class ServicoEmprestimo {
	Logger logger = Logger.getLogger(ServicoEmprestimo.class);

	public Emprestimo empresta(Livro livro, Usuario usuario) {
		if (livro == null | usuario == null) {
			throw new RuntimeException("Dados inválidos.");
		} else {
			Emprestimo emprestimo = new Emprestimo();
			emprestimo.setLivro(livro);
			emprestimo.setUsuario(usuario);
			// data do emprestimo - data atual do sistema
			DateTime dataAtual = new DateTime();
			DateTimeFormatter fmt = DateTimeFormat.forPattern("YYYY/MM/dd");
			emprestimo.setDataEmprestimo(dataAtual.toString(fmt));
			logger.info("Data atual ======> : " + emprestimo.getDataEmprestimo());
			// prazo de devolucao 8 dias
			DateTime dataDevolucao = fmt.parseDateTime(emprestimo.getDataEmprestimo());
			emprestimo.setDataDevolucao(dataDevolucao.plusDays(8).toString(fmt));
			logger.info("Data de devolucao ======> : " + emprestimo.getDataDevolucao());
			return emprestimo;
		}
	}

	/**
	 * Objetivo - verificar se a devolução esta atrasada
	 *
	 * @param umEmprestimo
	 * @return int < 0 se estiver atrasado e > 0 se estiver no prazo
	 *         retorna nulo se o objeto emprestimo é nulo.
	 */
	public Integer devolucao(Emprestimo umEmprestimo) {
		if (umEmprestimo != null) {
			DateTimeFormatter fmt = DateTimeFormat.forPattern("YYYY/MM/dd");
			DateTime dataAtual = fmt.parseDateTime(new DateTime().toString(fmt));
			DateTime dataDevolucao = fmt.parseDateTime(umEmprestimo.getDataDevolucao());
			int dias = Days.daysBetween(dataAtual, dataDevolucao).getDays();
			return dias;
		} else {
			return null;
		}
	}
}
