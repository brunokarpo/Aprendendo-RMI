package br.nom.brunokarpo.rmi.calculadoraBase.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;

/** @author Bruno Nogueira
 *
 * <p>Class para ler o arquivo .policy
 * que faz refer&ecirc;ncia sobre permiss&atilde;o do RMI com o Java
 * */
public class PolicyFileLocator {

	public static final String POLICY_FILE_NAME = "/allow_all.policy";

	public static String getLocationOfPolicyFile() {

		try {
			File tempFile = File.createTempFile("calc-rmi-base", ".policy");

			InputStream is = PolicyFileLocator.class.getResourceAsStream(POLICY_FILE_NAME);

			BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

			int read = 0;
			while((read = is.read()) != -1) {
				writer.write(read);
			}
			writer.close();
			tempFile.deleteOnExit();

			System.out.println("My policy: " + is);
			return tempFile.getAbsolutePath();

		} catch(IOException e) {
			throw new RuntimeException(e);
		}

	}

}
