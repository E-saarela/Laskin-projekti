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
    private int index;
    int poistetut = 0;

 
  
    private void kasitteleNumerot(ActionEvent painettu) {
    int poistetut = 0;
  	String s = painettu.toString();
  	StringBuffer sb = new StringBuffer();
  	sb.append(s);
  	char c =',';
  	String ss = Mjonot.erota(sb, c);
  	char vali = ss.charAt(ss.length()-1);
  	String numero  = Character.toString(vali);
  	if(laskutoimitus == true) {
  		sisalto2.add(numero);
  	}else { 
  		sisalto1.add(numero);
  	}  
  	int luku = Integer.parseInt(numero);
  	String x = naytto.getText();
  	if(x.charAt(0) == '0') {
  		naytto.clear();
  		index = 1;
  		sisalto1.add(0, "0");
  	}
    lisaaNayttoon(luku);
    }

	
  	public void lisaaNayttoon(int lisattava) {
		Integer nolla = 0;
		if(naytto.textProperty().getValueSafe() == nolla.toString())naytto.clear();
		Integer palautus = lisattava; 
		naytto.appendText(palautus.toString());
	}
  	
  	
  	public void tyhjenna() {
  		sisalto1.clear();
  		sisalto2.clear();
  		laskutoimitus = false;
  		index = 0;
  		naytto.clear();
  		lisaaNayttoon(0);
  	}
  
  
  	public void lisaa() {
  	if(laskutoimitus == true) {
  		String a = new String();
  	  	StringBuffer sb = new StringBuffer();
  	  	String b = new String();
	  	StringBuffer sb2 = new StringBuffer();
  		for(int i = 0; i< sisalto1.size()-1;i++) {
  			sb.append(sisalto1.get(i));
  		}
  		for(int i = 0; i< sisalto2.size();i++) {
  			sb2.append(sisalto2.get(i));
  		}
  		a = sb.toString();
  		b = sb2.toString();
  		int n1 = Integer.parseInt(a);
  		int n2 = Integer.parseInt(b);
  		int tulos = n1+n2;
  		naytto.clear();
  		lisaaNayttoon (tulos);
  		laskutoimitus = false;
  		sisalto1.clear();
  		sisalto2.clear();
  		String[] uusi = String.valueOf(tulos).split("");
  		for(int i = 0; i < uusi.length;i++) {
  			sisalto1.add(uusi[i]);
  		}
  		return;
  	}
  	laskutoimitus = true;
  	naytto.appendText("+");
  	sisalto1.add("+");
  	index = sisalto1.size()-1;
  	}
  	
  	
  	public void vahenna() {
  	  	if(laskutoimitus == true) {
  	  		String a = new String();
  	  	  	StringBuffer sb = new StringBuffer();
  	  	  	String b = new String();
  		  	StringBuffer sb2 = new StringBuffer();
  	  		for(int i = 0; i< sisalto1.size()-1;i++) {
  	  			sb.append(sisalto1.get(i));
  	  		}
  	  		for(int i = 0; i< sisalto2.size();i++) {
  	  			sb2.append(sisalto2.get(i));
  	  		}
  	  		a = sb.toString();
  	  		b = sb2.toString();
  	  		int n1 = Integer.parseInt(a);
  	  		int n2 = Integer.parseInt(b);
  	  		int tulos = n1-n2;
  	  		naytto.clear();
  	  		lisaaNayttoon (tulos);
  	  		laskutoimitus = false;
  	  		sisalto1.clear();
  	  		sisalto2.clear();
  	  		String[] uusi = String.valueOf(tulos).split("");
  	  		for(int i = 0; i < uusi.length;i++) {
  	  			sisalto1.add(uusi[i]);
  	  		}
  	  		return;
  	  	}
  	  	laskutoimitus = true;
  	  	naytto.appendText("-");
  	  	sisalto1.add("-");
  	  	index = sisalto1.size()-1;
  	  	}
  	
  	
  	public void kerro() {
  	  	if(laskutoimitus == true) {
  	  		String a = new String();
  	  	  	StringBuffer sb = new StringBuffer();
  	  	  	String b = new String();
  		  	StringBuffer sb2 = new StringBuffer();
  	  		for(int i = 0; i< sisalto1.size()-1;i++) {
  	  			sb.append(sisalto1.get(i));
  	  		}
  	  		for(int i = 0; i< sisalto2.size();i++) {
  	  			sb2.append(sisalto2.get(i));
  	  		}
  	  		a = sb.toString();
  	  		b = sb2.toString();
  	  		int n1 = Integer.parseInt(a);
  	  		int n2 = Integer.parseInt(b);
  	  		int tulos = n1*n2;
  	  		naytto.clear();
  	  		lisaaNayttoon (tulos);
  	  		laskutoimitus = false;
  	  		sisalto1.clear();
  	  		sisalto2.clear();
  	  		String[] uusi = String.valueOf(tulos).split("");
  	  		for(int i = 0; i < uusi.length;i++) {
  	  			sisalto1.add(uusi[i]);
  	  		}
  	  		return;
  	  	}
  	  	laskutoimitus = true;
  	  	naytto.appendText("x");
  	  	sisalto1.add("x");
  	  	index = sisalto1.size()-1;
  	  	}
  	
  	
  	public void jaa() {
  	  	if(laskutoimitus == true) {
  	  		String a = new String();
  	  	  	StringBuffer sb = new StringBuffer();
  	  	  	String b = new String();
  		  	StringBuffer sb2 = new StringBuffer();
  	  		for(int i = 0; i< sisalto1.size()-1;i++) {
  	  			sb.append(sisalto1.get(i));
  	  		}
  	  		for(int i = 0; i< sisalto2.size();i++) {
  	  			sb2.append(sisalto2.get(i));
  	  		}
  	  		a = sb.toString();
  	  		b = sb2.toString();
  	  		int n1 = Integer.parseInt(a);
  	  		int n2 = Integer.parseInt(b);
  	  		if(n2 != 0) {
  	  		int tulos = n1/n2;
  	  		naytto.clear();
  	  		lisaaNayttoon (tulos);
  	  		laskutoimitus = false;
  	  		sisalto1.clear();
  	  		sisalto2.clear();
  	  		String[] uusi = String.valueOf(tulos).split("");
  	  		for(int i = 0; i < uusi.length;i++) {
  	  			sisalto1.add(uusi[i]);
  	  		}
  	  		}
  	  		return;
  	  	}
  	  	laskutoimitus = true;
  	  	naytto.appendText("/");
  	  	sisalto1.add("/");
  	  	index = sisalto1.size()-1;
  	}
  	
  	
  	public void poista(){
  		int maara = sisalto2.size();
  		StringBuffer yhdista = new StringBuffer();
  		for(int i = 0; i< sisalto1.size()-1;i++) {
	  			yhdista.append(sisalto1.get(i));
	  		}
  		for(int i = 0; i< sisalto2.size()-1;i++) {
  			yhdista.append(sisalto2.get(i));
  		}
  	yhdista.deleteCharAt(yhdista.length()-1);
  	poistetut++;
  	if(poistetut > maara)laskutoimitus = false;
  	}
  	
  	
  	public void toteuta() {
  		String merkki = sisalto1.get(index);
  	    
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
