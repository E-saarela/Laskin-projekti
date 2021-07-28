package LaskinFx;

import java.util.ArrayList;


import fi.jyu.mit.ohj2.Mjonot;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;


public class laskinController {

    @FXML
    private TextArea naytto;
    @FXML
    private Button clear;
    @FXML
    private Button x2;
    @FXML
    private Button delete;
    @FXML
    private Button jaa;
    @FXML
    private Button num7;
    @FXML
    private Button num8;
    @FXML
    private Button num9;
    @FXML
    private Button kerro;
    @FXML
    private Button num4;
    @FXML
    private Button num5;
    @FXML
    private Button num6;
    @FXML
    private Button vahenna;
    @FXML
    private Button num1;
    @FXML
    private Button num2;
    @FXML
    private Button num3;
    @FXML
    private Button lisaa;
    @FXML
    private Button nega;
    @FXML
    private Button num0;
    @FXML
    private Button piste;
    @FXML
    private Button equals;

    
    
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

    }

    @FXML
    void handleKerro(ActionEvent event) {

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

 
  
    private void kasitteleNumerot(ActionEvent painettu) {
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

    
  	
  	public void toteuta() {
  		String merkki = sisalto1.get(index);
  	    
  		switch(merkki) {
		case "+":
			lisaa();
			break;
		case "-":
			vahenna();
			break;
  	}
	
}
}
