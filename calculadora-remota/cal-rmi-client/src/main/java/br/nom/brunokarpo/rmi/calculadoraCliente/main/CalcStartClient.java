package br.nom.brunokarpo.rmi.calculadoraCliente.main;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import javax.swing.JOptionPane;

import br.nom.brunokarpo.rmi.calculadoraBase.interfaces.ICalculadora;
import br.nom.brunokarpo.rmi.calculadoraBase.main.ServerMainBase;

public class CalcStartClient extends ServerMainBase {

	private ICalculadora calculadoraRemota;
	private Registry registry;

	public CalcStartClient() {
		super(ICalculadora.class);
	}

	@Override
	public void doCalcCustomRmiHandling() {
		menu();

		String operacao = JOptionPane.showInputDialog("Digite a operacao desejada");

		switch(operacao) {
		case "+":
			JOptionPane.showMessageDialog(null, "Operador soma escolhido", "Soma", JOptionPane.DEFAULT_OPTION);
			somar();
			break;

		case "-":
			JOptionPane.showMessageDialog(null, "Operador subtracao escolhido", "Subtração", JOptionPane.DEFAULT_OPTION);
			subtrair();
			break;

		case "*":
			JOptionPane.showMessageDialog(null, "Operador multiplicacao escolhido", "Multiplicação", JOptionPane.DEFAULT_OPTION);
			multiplicar();
			break;

		case "/":
			JOptionPane.showMessageDialog(null, "Operador divisão escolhido", "Divisão", JOptionPane.DEFAULT_OPTION);
			dividir();
			break;

		default:
			JOptionPane.showMessageDialog(null, "Operação desconhecida ou não implementada", "Operação inválida", JOptionPane.ERROR_MESSAGE);
		}

	}

	private void menu() {
		StringBuilder sb = new StringBuilder();

		sb.append("/*********************************************/\n");
		sb.append("/* 	Sistema para pequenos calculos			*/\n");
		sb.append("/*	Calculadora Distribuida					*/\n");
		sb.append("/*********************************************/\n");

		sb.append("\n");
		sb.append("Menu de opções\n");
		sb.append("+ para Adicao\n");
		sb.append("- para Subtracao\n");
		sb.append("* para Multiplicacao\n");
		sb.append("/ para Divisao\n");

		JOptionPane.showMessageDialog(null, sb.toString());
	}

	private void somar() {
		double valor1 = requisitarNumero();
		double valor2 = requisitarNumero();

		double resultado = 0;
		try {
			resultado = getCalculadoraRemota().somar(valor1, valor2);

			JOptionPane.showMessageDialog(null, "O resultado da operacao é " + resultado, "Resultado", JOptionPane.DEFAULT_OPTION);
		} catch (RemoteException e) {
			System.err.println("Problema ao executar a operacao no RMI");
			e.printStackTrace();
		}

	}

	private void subtrair() {
		double valor1 = requisitarNumero();
		double valor2 = requisitarNumero();

		double resultado = 0;
		try {
			resultado = getCalculadoraRemota().subtrair(valor1, valor2);

			JOptionPane.showMessageDialog(null, "O resultado da operacao é " + resultado, "Resultado", JOptionPane.DEFAULT_OPTION);
		} catch (RemoteException e) {
			System.err.println("Problema ao executar a operacao no RMI");
			e.printStackTrace();
		}

	}

	private void multiplicar() {
		double valor1 = requisitarNumero();
		double valor2 = requisitarNumero();

		double resultado = 0;
		try {
			resultado = getCalculadoraRemota().multiplicar(valor1, valor2);

			JOptionPane.showMessageDialog(null, "O resultado da operacao é " + resultado, "Resultado", JOptionPane.DEFAULT_OPTION);
		} catch (RemoteException e) {
			System.err.println("Problema ao executar a operacao no RMI");
			e.printStackTrace();
		}

	}

	private void dividir() {
		double valor1 = requisitarNumero();
		double valor2 = requisitarNumero();

		double resultado = 0;
		try {
			resultado = getCalculadoraRemota().dividir(valor1, valor2);

			JOptionPane.showMessageDialog(null, "O resultado da operacao é " + resultado, "Resultado", JOptionPane.DEFAULT_OPTION);
		} catch (RemoteException e) {
			System.err.println("Problema ao executar a operacao no RMI");
			e.printStackTrace();
		} catch(ArithmeticException e) {
			JOptionPane.showMessageDialog(null, "Não é possível dividir por zero, mané!", "Falha na divisão", JOptionPane.ERROR_MESSAGE);
		}

	}

	private double requisitarNumero() {

		String valor = JOptionPane.showInputDialog(null, "Digite um valor para a operação: ", "Solicitar valor", JOptionPane.QUESTION_MESSAGE);
		double resultado = 0;
		try {
			resultado = Double.parseDouble(valor);
		} catch(NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Isso não é um número conhecido", "Valor invalido", JOptionPane.ERROR_MESSAGE);
			resultado = requisitarNumero();
		}

		return resultado;
	}

	private ICalculadora getCalculadoraRemota() {
		if(calculadoraRemota == null) {
			try {
				calculadoraRemota = (ICalculadora) getRegistry().lookup("calculo");

			} catch (Exception e) {
				System.err.println("Ocorreu um erro ao pegar a referencia remota da calculadora. Fechando tudo");
				throw new RuntimeException("Fudeu tudo!");
			}
		}
		return calculadoraRemota;
	}

	private Registry getRegistry() throws RemoteException {
		if(registry == null) {
			registry = LocateRegistry.getRegistry();
		}
		return registry;
	}

	public static void main(String[] args) {
		new CalcStartClient();
	}
}
