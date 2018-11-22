package com.fatec.sce;

import org.apache.log4j.Logger;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import com.fatec.sce.model.Emprestimo;
import com.fatec.sce.model.Livro;
import com.fatec.sce.model.Usuario;
import com.fatec.sce.servico.ServicoEmprestimo;

public class ObtemEmprestimo {
	static Logger logger = Logger.getLogger(ObtemEmprestimo.class);
	
	public static Emprestimo comDadosValidos() {
		Livro livro = ObtemLivro.comDadosValidos();
		Usuario aluno = ObtemUsuario.comDadosValidos();
		ServicoEmprestimo servico = new ServicoEmprestimo();
		return servico.empresta(livro, aluno);
	}
	/**
	 * Devolveu na data do emprestimo
	 * @return 0
	 */
	public static Emprestimo comDataDeDevolucaoIgualDataDeEmprestimo() {
		Livro livro = ObtemLivro.comDadosValidos();
		Usuario aluno = ObtemUsuario.comDadosValidos();
		ServicoEmprestimo servico = new ServicoEmprestimo();
		Emprestimo umEmprestimo = servico.empresta(livro, aluno);
		DateTime dataAtual = new DateTime();
		DateTimeFormatter fmt = DateTimeFormat.forPattern("YYYY/MM/dd");
		//umEmprestimo.setDataEmprestimo(dataAtual.toString(fmt));
		umEmprestimo.setDataDevolucao(dataAtual.toString(fmt));
		return umEmprestimo;
	}
	public static Emprestimo comDataDeDevolucaoVencida() {
		Livro livro = ObtemLivro.comDadosValidos();
		Usuario aluno = ObtemUsuario.comDadosValidos();
		ServicoEmprestimo servico = new ServicoEmprestimo();
		Emprestimo umEmprestimo = servico.empresta(livro, aluno);
		DateTime dataAtual = new DateTime();
		DateTimeFormatter fmt = DateTimeFormat.forPattern("YYYY/MM/dd");
		//umEmprestimo.setDataEmprestimo(dataAtual.minusDays(12).toString(fmt));
		umEmprestimo.setDataDevolucao(dataAtual.minusDays(4).toString(fmt));
		return umEmprestimo;
	}
	
	/**
	 * Devolveu um dia depois do emprestimo
	 * @return 0
	 */
	public static Emprestimo comDataDeDevolucaoUmDiaDepoisDoEmprestimo() {
		Livro livro = ObtemLivro.comDadosValidos();
		Usuario aluno = ObtemUsuario.comDadosValidos();
		ServicoEmprestimo servico = new ServicoEmprestimo();
		Emprestimo umEmprestimo = servico.empresta(livro, aluno);
		
		DateTimeFormatter fmt = DateTimeFormat.forPattern("YYYY/MM/dd");
		DateTime dataAtual = fmt.parseDateTime(new DateTime().toString(fmt));
		umEmprestimo.setDataEmprestimo(dataAtual.toString(fmt));
		umEmprestimo.setDataDevolucao(dataAtual.plusDays(1).toString(fmt));
		logger.info("Data atual obtem emprestimo ======> : " + umEmprestimo.getDataEmprestimo());
		logger.info("Data devolucao obtem emprestimo um dia depois ======> : " + umEmprestimo.getDataDevolucao());
		
		return umEmprestimo;
	}
	/**
	 * Devolveu um dia depois do emprestimo
	 * @return 0
	 */
	public static Emprestimo comDataDeDevolucaoUmDiaAntesDaDataDeDevolucao() {
		Livro livro = ObtemLivro.comDadosValidos();
		Usuario aluno = ObtemUsuario.comDadosValidos();
		ServicoEmprestimo servico = new ServicoEmprestimo();
		Emprestimo umEmprestimo = servico.empresta(livro, aluno);
		
		DateTimeFormatter fmt = DateTimeFormat.forPattern("YYYY/MM/dd");
		DateTime dataAtual = fmt.parseDateTime(new DateTime().toString(fmt));
		umEmprestimo.setDataEmprestimo(dataAtual.toString(fmt));
		umEmprestimo.setDataDevolucao(dataAtual.plusDays(1).toString(fmt));
		logger.info("Data atual obtem emprestimo ======> : " + umEmprestimo.getDataEmprestimo());
		logger.info("Data devolucao obtem emprestimo um dia depois ======> : " + umEmprestimo.getDataDevolucao());
		
		return umEmprestimo;
	}
}
