package dominio;
import java.util.Random;
import java.util.Collections;
import java.util.ArrayList;

public class Partita {
	private static final int MAX_RANGE = 10;
	private static final int MIN_RANGE = 1;
	private static final int ARRAYLIST_SIZE = 2;
	private static final char BIANCO = 'b';
	private static final char NERO = 'n';
	private Giocatore[] giocatori; 
	private int count;
	private Random random;
	private ArrayList numRandom = new ArrayList();
	private Damiera d;
	
	public Partita() {
		
	}
    
	public Partita(String username1, String username2) {
		
		d= new Damiera();
		
		giocatori=new Giocatore[2];
		
		Giocatore g1=new Giocatore(username1);
		Giocatore g2=new Giocatore(username2);
		
		if(insertGiocatore(g1, g2)) {
			System.out.println("Giocatori Inseriti Con Successo:");
		}	
		else System.out.println("Giocatori Non Inseriti :(");
		
		sorteggio(MIN_RANGE,MAX_RANGE);
		
		printGiocatori();
		
		d.setCaselle();
		d.printCaselle();
		
	}
	
	private Boolean insertGiocatore(Giocatore gio1, Giocatore gio2) {
		Boolean add=true;
		for(this.count=0; this.count<2; this.count++) {
		 if(count == 0)	try{
			             this.giocatori[count] = gio1;
			            }catch(Exception e){
			            	add = false;
			            }
		 else try{
			   this.giocatori[count] = gio2;
		 	  }catch(Exception e) {
		 		  add = false;
		 	  }
		}
		
		return add;
	}
	
	public Giocatore getGiocatore(int index) {
		return this.giocatori[index];
	}

	private void sorteggio(int minRANGE,int maxRANGE) {
		/*this.random = new Random();
		this.numRand = random.nextInt(RANGE)+1;
		return numRand;*/
		this.random = new Random();
		this.count=0;
		while (this.count < ARRAYLIST_SIZE ) {
		    int random_number = random.nextInt(maxRANGE - minRANGE) + minRANGE;
		    this.numRandom.add(random_number);
		    count ++;
		}
	    System.out.println(numRandom.get(0));
	    System.out.println(numRandom.get(1));
	    
		if(this.numRandom.get(0)== this.numRandom.get(1)) {
	    int temp_num=(int) this.numRandom.get(0);
	    temp_num++;
		this.numRandom.set(0,temp_num);
		Collections.shuffle(this.numRandom);
		}

		
		this.giocatori[0].setNumRand((int)this.numRandom.get(0));
		this.giocatori[1].setNumRand((int)this.numRandom.get(1));
	    if(this.giocatori[0].getNumRand() > this.giocatori[1].getNumRand()) {
	    	this.giocatori[0].setColor(BIANCO);
	    	this.giocatori[0].setTurno(true);
	    	this.giocatori[0].setnumGiocatore(1);
	    	this.giocatori[1].setColor(NERO);
	    	this.giocatori[1].setTurno(false);
	    	this.giocatori[1].setnumGiocatore(2);
	    }
	    else {
	    	this.giocatori[1].setColor(BIANCO);
	    	this.giocatori[1].setTurno(true);
	    	this.giocatori[1].setnumGiocatore(1);
	        this.giocatori[0].setColor(NERO);
	        this.giocatori[0].setTurno(false);
	        this.giocatori[0].setnumGiocatore(2);
	    }
	    
	}
	
	private void printGiocatori() {
		for(this.count=0; this.count<2; this.count++) {
			System.out.println(giocatori[count].toString());
		}
	}
	
}