package br.nom.brunokarpo.rmi.calculadoraBase.main;

import br.nom.brunokarpo.rmi.calculadoraBase.util.PolicyFileLocator;

/** @author Bruno Nogueira
 * <br>
 * <p>Essa classe cria um SecurityManager, seta o caminho do codebase
 * para que seja poss&iacute;vel setar o caminho do arquivo (allow_all.policy) que tem as permiss&otilde;es para
 * acesso ao RMI do Java*/
public abstract class ServerMainBase {

	@SuppressWarnings("rawtypes")
	public ServerMainBase(Class clazzToAddServerCodebase) {

		// Seta a propriedade do CodeBase
		System.setProperty("java.rmi.server.codebase",
				clazzToAddServerCodebase.getProtectionDomain().getCodeSource().getLocation().toString());

		// Seta o caminho do arquivo que configura as permissões para o protocolo RMI
		System.setProperty("java.security.policy", PolicyFileLocator.getLocationOfPolicyFile());

		// Se o gerenciador de segurança for nulo, cria um novo gerenciador de segurança;
		// É um padrão usado pelo RMI
		if(System.getSecurityManager() == null) {
			System.setSecurityManager(new SecurityManager());
		}

		// Método que será implementado pelo Service para criar a conexão do RMI
		doCalcCustomRmiHandling();

	}

	// Método que será implementado pelo Service para criar a conexão do RMI
	public abstract void doCalcCustomRmiHandling() ;

}
