package interfaccia.text;
import dominio.Dama;

public class DamaConsole {
	
	public void start() {
		Dama dama = new Dama();
		stampaBenvenuto();
		Comando comando = Parser.getInstance().getComando(ElencoComandi.DAMA);
		
		while (!comando.getCodiceComando().equals("0")) {
			comando.esegui(dama); 
			System.out.println();
			stampaBenvenuto();
			comando = Parser.getInstance().getComando(ElencoComandi.DAMA);
		}
		comando.esegui(dama); // dama sicuramente è il comando esci
		
	}

    private void stampaBenvenuto() {
        System.out.println("La Dama italiana di Giovanni Santoro e Nicola Pollino");
		System.out.println(ElencoComandi.elencoTuttiComandi(ElencoComandi.DAMA));
		System.out.println("FAI LA TUA SCELTA");
	}
	
}
