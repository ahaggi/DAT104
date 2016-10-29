package no.hib.dat104.lph;


import static net.sourceforge.jwebunit.junit.JWebUnit.*;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class BmiCalculatorFuncTest {
    
    private static final String HOST = "localhost";
    private static final String PORT = "8080";
    private static final String CONTEXT_ROOT = "f19";
    private static final String BASE_URL 
            = "http://" + HOST + ":" + PORT + "/" + CONTEXT_ROOT;
    
    @Before
    public void setup() {
        setBaseUrl(BASE_URL);
    }

    @Test
    /** 
     * Test1: At siden med skjemaet vises ved foresp�rsel til "roten" av 
     * applikasjonen.
     */
    public void rotUrlSkalGiSkjemasiden() {
    }
    
    @Test
    /** 
     * Test2: At inntasting av gyldige data og trykk p� Beregn gir 
     * resultatsiden.
     */
    public void gyldigInputOgBeregnSkalGiResultatsiden() {
    	//Testinnput + output 
    	//i test output kan vi sette span-tag id for deler som vi vil teste , og bruker 
    	//en assertMatchInElement('navn p� span', "value p� output") "l�reren har testet p� siden-titel"
    	//test vil retunere true for output 23,42 hvis testen er 32,4, s� kn vi bruke RExp assertMatchInElement('navn p� span', "^23,4$")
    	//oppdater fra itslerning
    	//pga at jsp siden har en span tag "feilMelding" vil den blir i siden selvom feilmelding vil v�re tom,, 
    	//� teste om feilmelding er p� stedet, er ikke sterk nok .vi m� teste p� innholdet.  
    }
    
    
    @Test
    /** 
     * Test3: At resultatsiden inneholder korrekt utregnet BMI avrundet til 
     * �n desimal ved gyldig input.
     */
    public void resultatSkalVaereKorrektOgAvrundetTilEnDesimal() {
    }
    
    @Test
    /**
     * Test4: At trykk p� Beregn uten � gi inn data gir skjemasiden med 
     * feilmeldingen "Du m� oppgi h�yde og vekt!"
     */
    public void manglendeInputSkalGiSkjemasidenMedFeilmelding() {
    	
    }
}
