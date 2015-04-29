package br.nom.brunokarpo.rmi.calculadoraBase.interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;
/** @author Bruno Nogueira de Oliveira<br><br>
 *
 *			<p>Interface com os m&eacute;todos da calculadora;<br>
 *
 * 			<p>Em um sistema distribu&iacute;do utilizando RMI sempre a interface com os m&eacute;todos a serem implementados devem extender (herdar) de Remote (java.rmi.Remote)
 *
 * */
public interface ICalculadora extends Remote {

	/** Executa a soma de dois doubles
	 *
	 * <p> M&eacute;todo recebe como par&acirc;metro dois doubles, executa a soma desses dois n&uacute;meros e retorna o resultado em formato double
	 *
	 * @throws RemoteException Exce&ccedil;&atilde;o b&aacute;sica que ocorre pela chamada do RMI
	 * */
	public double somar(double x, double y) throws RemoteException;

	/** Executa a subtração de dois doubles
	 *
	 * <p> M&eacute;todo recebe como par&acirc;metro dois doubles e retorna a diferen&ccedil;a entre eles no formato double
	 *
	 * @throws RemoteException Exce&ccedil;&atilde;o b&aacute;sica que ocorre pela chamada do RMI */
	public double subtrair(double x, double y) throws RemoteException;

	/** Executa a multiplicação de dois doubles
	 *
	 * <p>M&eacute;todo recebe como par&acirc;metro dois doubles e retorna o produto entre eles no formato double
	 *
	 * @throws RemoteException Exce&ccedil;&atilde;o b&aacute;sica que ocorre pela chamada do RMI */
	public double multiplicar(double x, double y) throws RemoteException;

	/** Executa a divisão entre dois doubles
	 *
	 * <p> M&eacute;todo recebe como par&acirc;metro dois doubles e retorna a divis&atilde;o entre eles no formato double
	 *
	 * @throws RemoteException Exce&ccedil;&atilde;o b&aacute;sica que ocorre pela chamada do RMI
	 * @throws ArithmeticException Exce&ccedil;&atilde;o lan&ccedil;ada quando o par&acirc;metro y &eacute; igual a 0 (zero). N&atilde;o &eacute; poss&iacute;vel dividir nada por zero nesse programa */
	public double dividir(double x, double y) throws RemoteException, ArithmeticException;


}
