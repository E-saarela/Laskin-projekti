package LaskinFx;



import java.awt.event.KeyEvent;
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

    }

    @FXML
    void handleX2(ActionEvent event) {

    }
    
    
///////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////
    

      private ArrayList <String> sisalto1 = new ArrayList<String>();
      private ArrayList <String> sisalto2 = new ArrayList<String>();
      private boolean laskutoimitus = false;
      private String[] luvut = {"0", "1", "2", "3", "4", "5", "6",
    		  "7", "8", "9"};
 
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
  //  	if(laskutoimitus == true)sisalto2.add(s);
    	sisalto1.add(s);
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
    StringBuffer sb = new StringBuffer();
    String a = new String();
    ArrayList <String> tuloste =  haeSisalto();
    for(int i = 0;i < tuloste.size();i++) {
    	sb.append(tuloste.get(i));
    }
    a = sb.toString();
    naytto.appendText("+");
    sisalto1.add("+");
                                                  
    int x = 0;
   }

	private ArrayList <String> haeSisalto() {
	    ArrayList <String> sis = new ArrayList<String>();
		char c =',';
		for(int i = 0; i<sisalto1.size();i++) {
			StringBuffer vali = new StringBuffer();
			vali.append(sisalto1.get(i));
			String ss = Mjonot.erota(vali, c);
			char cc = ss.charAt(ss.length()-1);
	    	String numero  = Character.toString(cc);
			sis.add(numero);			
		}
		return sis;

	}
	
	public void toteuta() {
		boolean muuttuiko = false;
		ArrayList <String> sis = haeSisalto();
		StringBuffer numerot = new StringBuffer();                                      //sis.replaceAll("[^0-9]", "x");
		for(int i = 0; i < sis.size();i++) {
			for(int j = 0; j < luvut.length;j++) {
				if(sis.get(i).equals(luvut[j]) ) {
					numerot.append(luvut[j]);
					muuttuiko = true;
				}
			}
			if(muuttuiko = false && numerot.length() != 0)  numerot.append("X");
			muuttuiko = false;	
		}
		System.out.println(numerot);
	}

}

