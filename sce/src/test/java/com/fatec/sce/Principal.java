package com.fatec.sce;

import com.fatec.sce.model.Emprestimo;

public class Principal {

	public static void main(String[] args) {
		Emprestimo emprestimo = ObtemEmprestimo.comDadosValidos();
		emprestimo = ObtemEmprestimo.comDataDeDevolucaoVencida();
	}

}
