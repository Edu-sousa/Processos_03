package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class DistroController {

	public DistroController() {
		super();
	}

	private String os() {

		String os = System.getProperty("os.name");
		return os;

	}

	public void exibeDistro() {

		String os = os();
		String process = null;

		if (os.contains("Linux")) {
			process = "cat /etc/os-release";
		} else {
			System.out.println("Esse sistema não é Linux");
		}

		try {
			Process p = Runtime.getRuntime().exec(process);
			InputStream fluxo = p.getInputStream();
			InputStreamReader leitor = new InputStreamReader(fluxo);
			BufferedReader buffer = new BufferedReader(leitor);
			String linha = buffer.readLine();

			while (linha != null) {
				System.out.println(linha);
				linha = buffer.readLine();
			}

			buffer.close();
			leitor.close();
			fluxo.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
