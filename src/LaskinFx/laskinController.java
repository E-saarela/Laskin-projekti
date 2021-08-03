package LaskinFx;

import java.util.ArrayList;


import fi.jyu.mit.ohj2.Mjonot;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;


public class laskinController {

    @FXML
    private TextArea naytto;
    
    
    @FXML
    void handleClear(ActionEvent event) {
    	tyhjenna();
    }

    @FXML
    void handleEquals(ActionEvent event) {
    	toteuta();
    }

    @FXML
    void handleJaa(ActionEvent event) {
    	jaa();
    }

    @FXML
    void handleKerro(ActionEvent event) {
    	kerro();
    }

    @FXML
    void handleNeg(ActionEvent event) {

    }

    @FXML
    void handleNumerot(ActionEvent event) {
    	kasitteleNumerot(event);
    }


	@FXML
    void handlePiste(ActionEvent event) {

    }

    @FXML
    void handlePlus(ActionEvent event) {
    	lisaa();
    }

    @FXML
    void handlePoista(ActionEvent event) {
    	poista();
    }

    @FXML
    void handleVah(ActionEvent event) {
    	vahenna();
    }

    @FXML
    void handleX2(ActionEvent event) {

    }
    
    
///////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////
    

    private ArrayList <String> sisalto1 = new ArrayList<String>();
    private ArrayList <String> sisalto2 = new ArrayList<String>();
    private boolean laskutoimitus = false;
    private boolean desimaali = false;
    private boolean desimaalitulos = false;
    int poistetut = 0;

 
  
    private void kasitteleNumerot(ActionEvent painettu) {
    	String s = painettu.toString();
      	StringBuffer sb = new StringBuffer();
      	sb.append(s);
      	char c =',';
      	String ss = Mjonot.erota(sb, c);
      	char vali = ss.charAt(ss.length()-1);
      	String numero  = Character.toString(vali);
      	long luku = Long.parseLong(numero);
      	String x = naytto.getText();
      	if(x.charAt(0) == '0') {
      		naytto.clear();
      	//	sisalto1.add(0, "0");
      	}
     	onkoTulosInt(luku);
        lisaaNayttoon(luku);
    }
    
    public boolean onkoNayttoNolla() {
    	String x = naytto.getText();                                        //tätä voidaan kysyä vain silloin kun tiedetään että näytössä on vain yksi luku
      	if(x.charAt(0) == '0')return true;
      	return false;
    }
    
   
    public int indexOf(String[] luvut) {
    	for(int i = 0; i < luvut.length; i++) {
    		if(luvut[i].equals("."))return i;
    	}
      return 0;
    }
    
    
    public void onkoTulosInt(double luku) {
    	String muunnos = Double.toString(luku);
    	if(muunnos == null) {
    		desimaalitulos = false;
    		return;
    	}
	    String[] listattu = muunnos.split("");
	    int index = indexOf(listattu);
	    if(index == 0) {
	    	desimaalitulos = false;
	    	return;
	    }
		for(int i = index+1; i < listattu.length;i++) {
			if(listattu[i].equals("0")){
				continue;
			}else {
				desimaalitulos = true;
				return;
			}
		 }
	   desimaalitulos = false;
    }
    
    public String etsiMerkki() {
    	String s = naytto.getText();
    	StringBuffer sb = new StringBuffer();
    	sb.append(s);
    	for(int i = 0; i<sb.length();i++) {
    		if(sb.charAt(i) == '+'||sb.charAt(i) == '-'||sb.charAt(i) == '/'||sb.charAt(i) == 'x'){
    			return Character.toString(sb.charAt(i));
    		}
    	}
		return "";
    } 
    
    
    public int etsiMerkinPaikka() {
    	String s = naytto.getText();
    	StringBuffer sb = new StringBuffer();
    	sb.append(s);
    	for(int i = 0; i<sb.length();i++) {
    		if(sb.charAt(i) == '+'||sb.charAt(i) == '-'||sb.charAt(i) == '/'||sb.charAt(i) == 'x'){
    			return i;
    		}
    	}
		return 0;
    }
   

  	public void lisaaNayttoon(long luku) {
    	StringBuilder vali = new StringBuilder();
		long palautus = luku;
		if(desimaalitulos == true) {
			naytto.appendText(Long.toString(palautus));
		}else {
			String muunnos = Long.toString(palautus);
	    	if(muunnos == null)return;
		    String[] listattu = muunnos.split("");
		    for(int i = 0; i < listattu.length;i++) {
		    	if(listattu[i].equals("."))break;
		    	vali.append(listattu[i]);
		    }
		    String oikea = vali.toString();
		    naytto.appendText(oikea);
		}
		poistetut = 0;
	}
  	
  	
  	public void tyhjenna() {
  		sisalto1.clear();
  		sisalto2.clear();
  		laskutoimitus = false;
  		desimaalitulos = false;
  		naytto.clear();
  		lisaaNayttoon(0);
  	}
  
  
  	public void lisaa() {
  	if(laskutoimitus == true) {
  		String s = naytto.getText();
  		String[] sisalto = s.split("");
  		int paikka = etsiMerkinPaikka();
  		StringBuffer sb1 = new StringBuffer();
  		StringBuffer sb2 = new StringBuffer();
  		int i = 0;
  		while(i < paikka) {
  			sb1.append(sisalto[i]);
  			i++;
  		}
  		i = paikka+1;
  		while(i < sisalto.length) {
  			sb2.append(sisalto[i]);
  			i++;
  		}
  		String a = sb1.toString();
  		String b = sb2.toString();
  		long tulos = Long.parseLong(a) + Long.parseLong(b);
  		naytto.clear();
	  	onkoTulosInt(tulos);
	    lisaaNayttoon (tulos);
	  	laskutoimitus = false;
	  	return;
  	}
  	
  	naytto.appendText("+");
  	laskutoimitus = true;
  	}
  	
  	
  	public void vahenna() {
  	  	
  	  	}
  	
  	
  	public void kerro() {
  	  	
  	  	}
  	
  	
  	public void jaa() {
  	  	
  	}
  	
  	
  	public void poista(){
  		
  		
  	}
  	
  	
  	public void toteuta() {
  		String merkki = etsiMerkki();
  	    
  		switch(merkki) {
		case "+":
			lisaa();
			break;
		case "-":
			vahenna();
			break;
		case "x":
			kerro();
			break;
		case "/":
			jaa();
			break;
  		}
	
  	}
}
