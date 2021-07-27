package LaskinFx;

import java.util.ArrayList;
import java.util.List;

import com.sun.javafx.css.StyleCacheEntry.Key;

import fi.jyu.mit.ohj2.Mjonot;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

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
    	
    }

    @FXML
    void handleEquals(ActionEvent event) {

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

    }

    @FXML
    void handleX2(ActionEvent event) {

    }
    
    
///////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////
    

      private ArrayList <String> sisalto = new ArrayList<String>();
      boolean laskutoimitus = false;
 
   /**
    public String venaa() {
    	boolean valmista = false;
    	while(valmista=false) {
    		String input = naytto.getText();
    		if
    	}
    	
       return null;
    }
  */  
    
    private void kasitteleNumerot(ActionEvent painettu) {
    	String s = painettu.toString();
    	sisalto.add(s);
    	StringBuffer sb = new StringBuffer();
    	sb.append(s);
    	char c =',';
    	String ss = Mjonot.erota(sb, c);
    	char vali = ss.charAt(ss.length()-1);
    	String numero  = Character.toString(vali);
        int luku = Integer.parseInt(numero);
        lisaaNayttoon(luku);
    }

	
    public void lisaaNayttoon(int lisattava) {
		Integer nolla = 0;
		if(naytto.textProperty().getValueSafe() == nolla.toString())naytto.clear();
		Integer palautus = lisattava; 
		naytto.appendText(palautus.toString());
	}
    
    
    public void lisaa() {
    if(laskutoimitus == true)return;
    laskutoimitus = true;
    String tuloste =  haeSisalto();
    naytto.appendText("+");
                                                    /// täytyy tehä action listeneri
    int x = 0;
   }

	private String haeSisalto() {
		StringBuffer sis = new StringBuffer();
		char c =',';
		for(int i = 0; i<sisalto.size();i++) {
			StringBuffer vali = new StringBuffer();
			vali.append(sisalto.get(i));
			String ss = Mjonot.erota(vali, c);
			char cc = ss.charAt(ss.length()-1);
	    	String numero  = Character.toString(cc);
			sis.append(numero);			
		}
		String palautus = sis.toString();
		return palautus;

	}
    

}

