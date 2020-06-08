package interfaccia.text;

class ElencoComandi {
    
	public static final int DAMA = 0;
	public static final int NUOVA_PARTITA = 1;
	public static final int VISUALIZZA_STORICO = 2;
	//public static final int NUOVA_COLAZIONE = 3;
	
	/* MENU' PRINCIPALE */
    private static final String comandiValidiDamaConsole[][] = {
		/*{ComandoElencaTipiColazione.codiceComando,ComandoElencaTipiColazione.descrizioneComando},
		{ComandoNuovoTipoColazione.codiceComando,ComandoNuovoTipoColazione.descrizioneComando},
		{ComandoNuovoOrdine.codiceComando,ComandoNuovoOrdine.descrizioneComando},
		{ComandoEsci.codiceComando, ComandoEsci.descrizioneComando}*/
    		{ComandoNuovaPartita.codiceComando,ComandoNuovaPartita.descrizioneComando},
    		{ComandoVisualizzaStorico.codiceComando,ComandoVisualizzaStorico.descrizioneComando},
    		{ComandoEsci.codiceComando, ComandoEsci.descrizioneComando}
    };
	
	/* USE CASE 1 : INSERIMENTO NUOVA PARTITA */
	private static final String comandiValidiNuovaPartitaConsole[][] = { //comandiValidiNuovoTipoColazioneConsole[][]
	 /*{ComandoAggiungiComponenteColazione.codiceComando, ComandoAggiungiComponenteColazione.descrizioneComando},
		{ComandoDefinisciPrezzo.codiceComando, ComandoDefinisciPrezzo.descrizioneComando},
		{ComandoConfermaTipoColazione.codiceComando, ComandoConfermaTipoColazione.descrizioneComando},
	*/
		{ComandoEsci.codiceComando, ComandoEsci.descrizioneComando}
	};
	
	/* USE CASE 2 : NUOVO ORDINE 
	private static final String comandiValidiNuovoOrdineConsole[][] = {
			{ComandoNuovaColazione.codiceComando,ComandoNuovaColazione.descrizioneComando},
		{ComandoDefinisciModoServizio.codiceComando,ComandoDefinisciModoServizio.descrizioneComando},
		{ComandoAssociaOrdineCliente.codiceComando,ComandoAssociaOrdineCliente.descrizioneComando},
		{ComandoConfermaOrdine.codiceComando,ComandoConfermaOrdine.descrizioneComando},
		{ComandoEsci.codiceComando, ComandoEsci.descrizioneComando}
	};*/
	
   /* USE CASE 2 : NUOVA COLAZIONE 
	private static final String comandiValidiNuovaColazioneConsole[][] = {
		{ComandoEsci.codiceComando,ComandoEsci.descrizioneComando}
	};*/
	
   public static String elencoTuttiComandi(int console){
    	int i=0;
    	StringBuffer elenco = new StringBuffer();
		String comandi[][]=getComandi(console);
		
		
    	for (i=0; i<comandi.length-1; i++) {
			elenco.append(comando(i,console));
			elenco.append("\n");
		}
		elenco.append(comando(i,console));
		return elenco.toString();
    }
	
	private static String comando(int i, int console) {
		String comandi[][]= getComandi(console);
		return " " + comandi[i][0] + ")" + comandi[i][1];
	}

	public static String[][] getComandi(int console){
		
		String comandi[][]=null;
		
		switch (console){
			case DAMA: comandi = comandiValidiDamaConsole; break;
			case NUOVA_PARTITA: comandi = comandiValidiNuovaPartitaConsole; break;
			//case VISUALIZZA_STORICO: comandi = comandiValidiNuovoOrdineConsole; break;
			//case NUOVA_COLAZIONE: comandi = comandiValidiNuovaColazioneConsole; break;
		};
		return comandi;
	}
	
    public boolean comandoValido(String stringa, int console) {
		String comandi[][]= getComandi(console);
		for(int i = 0; i < comandi.length; i++) {
            if(comandi[i][0].equals(stringa))
                return true;
        }
        return false;
    }
	
}