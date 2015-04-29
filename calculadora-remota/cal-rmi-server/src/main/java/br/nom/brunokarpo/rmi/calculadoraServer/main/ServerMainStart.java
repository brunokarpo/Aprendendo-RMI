package br.nom.brunokarpo.rmi.calculadoraServer.main;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import br.nom.brunokarpo.rmi.calculadoraBase.interfaces.ICalculadora;
import br.nom.brunokarpo.rmi.calculadoraBase.main.ServerMainBase;
import br.nom.brunokarpo.rmi.calculadoraServer.implementacao.CalcServiceImpl;

/** @author Bruno Nogueira
 *
 * <p>Essa classe será responsável pelo start do servidor.
 * Ela quem irá criar a conexão para que o cliente possa requisitar os métodos que serão fornecidos por ele*/
public class ServerMainStart extends ServerMainBase{

	private static final int PORTA = 1099; //Porta padrão do RMI (coloquei só para lembrar)

	public ServerMainStart() {
		super(ICalculadora.class);
	}

	@Override
	public void doCalcCustomRmiHandling() {

		try {

			/* Eu instancio um objeto da interface ICalculadora.java e
			 * digo qual classe concreta irá implementar essa interface */
			ICalculadora calc = new CalcServiceImpl();

			/* Agora eu instancio um objeto Registry
			 * para que eu possa registrar meu servidor e colocar a porta de minha preferência na escuta*/
			Registry registry = LocateRegistry.createRegistry(PORTA);

			/* Aqui eu registro um bind, tipo de marcacao para que meu cliente reconheca as acoes que ele ira receber
			 * apos enviar os dados para serem processados no servidor */
			registry.bind("calculo", calc);

			System.out.println(calc + "\n");
			System.out.println(registry + "\n");
		} catch (RemoteException e) {
			System.err.println("Problema ao criar o objeto ICalculadora");
			e.printStackTrace();
		} catch (AlreadyBoundException e) {
			System.err.println("Problema no bind do registro");
			e.printStackTrace();
		}

	}

	// Aqui criei o método main para que minha classe possa ser iniciada
	public static void main(String[] args) {
		new ServerMainStart();
	}

}
