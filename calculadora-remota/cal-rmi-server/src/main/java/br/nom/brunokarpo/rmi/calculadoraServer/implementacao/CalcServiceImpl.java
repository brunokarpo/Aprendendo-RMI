package br.nom.brunokarpo.rmi.calculadoraServer.implementacao;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import br.nom.brunokarpo.rmi.calculadoraBase.interfaces.ICalculadora;

/** @author Bruno Nogueira
 *
 * <p>Essa classe será utilizada para implementar os métodos da interface que foi criada no projeto cal-rmi-base.
 *
 * <p>O servidor irá receber os dados e processar as operações e retornar o resultado para o cliente*/
public class CalcServiceImpl extends UnicastRemoteObject implements
		ICalculadora {

	/**
	 *
	 */
	private static final long serialVersionUID = 4983444515885473283L;

	/** Construtor da classe.*/
	public CalcServiceImpl() throws RemoteException {
		super();
	}

	public double somar(double x, double y) throws RemoteException {
		return x + y;
	}

	public double subtrair(double x, double y) throws RemoteException {
		return x - y;
	}

	public double multiplicar(double x, double y) throws RemoteException {
		return x * y;
	}

	public double dividir(double x, double y) throws RemoteException,
			ArithmeticException {
		return x / y;
	}

}
