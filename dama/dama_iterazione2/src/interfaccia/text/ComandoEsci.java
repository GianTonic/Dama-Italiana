package interfaccia.text;

import dominio.Dama;

public class ComandoEsci implements Comando{
	
	public static final String codiceComando="0";
	public static final String descrizioneComando="esci";
	
	@Override
	public String getCodiceComando() {
		return codiceComando;
	}

	@Override
	public String getDescrizioneComando() {
		return descrizioneComando;
	}

	@Override
	public void esegui(Dama dama) {
		System.out.println("   BYE...");
		
	}

}