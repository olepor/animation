



import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.Color;
import java.util.HashMap;




class Ani extends JPanel {
    
    
    //Justerbare verdier
    //Hastigheten på animasjonene (millisekunder)
    static double frames = 60;
    
    
    
    public static int dW = 1000;
    public static int dH = 500;
    
    
    public static JFrame frame = new JFrame();
    public static JPanel vindu = new JPanel();
    public static JPanel fig1 = new JPanel();
    
    
    //Posisjonen til de ulike objektene
    static HashMap<String, Integer> posX = new HashMap<>();
    static HashMap<String, Integer> posY = new HashMap<>();
    
    
    public static void main (String args[]) throws Exception {
        
        
        //Setter posisjonen til de ulike objektene
        posX.put("fig1",200);
        posY.put("fig1",200);
        
        
        
        //JPanel "fig1" egenskaper
        fig1.setSize(100,100);
        fig1.setLocation(posX.get("fig1"),posY.get("fig1"));
        fig1.setBackground(Color.WHITE);
        
        
        
        
        //JPanel "vindu" egenskaper
        vindu.setSize(dW, dH);
        vindu.setLayout(null);
        vindu.setBackground(Color.BLACK);
        vindu.add(fig1);
        
        
        
        
        //JFrame "frame" egenskaper
        frame.setSize(dW, dH);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(vindu);
        
        
        //Flytter elementet til ønsket posisjon
        animate(700,400,fig1,"fig1",true);
        
        
        
   
    }
    
    
    
    
    //Hjelpevariabel: Hvor mange piksler skal objektet bevege seg av gangen
    static int rateX = 0;
    static int rateY = 0;
    
    //Hjelpevariabel: Boolen som er true hvis objektet skal i positiv retning
    static boolean positivX = false;
    static boolean positivY = false;

    //Metode som flytter objektet til ønsket posisjon
    public static void animate (int x, int y, JPanel element, String navn, boolean first) throws Exception {
        
        //(A) Finner posisjonen elementet er i akkurat nå
        int nowX = posX.get(navn);
        int nowY = posY.get(navn);
        
        //(A) Oppretter variabler
        int avstandX = 0;
        int avstandY = 0;

        
        
        //(B) Finner ut om objektene er positivt orientert eller ikke (x-retning)
        if (nowX < x) { positivX = true;
        } else if (nowX > x) { positivX = false;
        } else { avstandX = 0; }
        
        //(B) Finner ut om objektene er positivt orientert eller ikke (y-retning)
        if (nowY < y) { positivY = true;
        } else if (nowY > y) { positivY = false;
        } else { avstandY = 0; }
        
            
        
        //(C) Finner avstanden som er igjen (x-retning)
        if (positivX) { avstandX = (x - nowX);
        } else if (!positivX) { avstandX = (nowX - x);
        } else { avstandX = 0; }
        
        //(C) Finner avstanden som er igjen (y-retning)
        if (positivY) { avstandY = (y - nowY);
        } else if (!positivY) { avstandY = (nowY - y);
        } else { avstandY = 0; }
        
        
        
        //(D) Hvis det er første gang metoden er kalt
        if (first == true) {
            rateX = (int) (avstandX/frames);
            rateY = (int) (avstandY/frames); }
        
        
        
        //(E) Sjekker om elementet er i posisjon, eventuelt setter det i posisjon eller flytter det (x-retning)
        if (avstandX < rateX) {
            element.setLocation(x, nowY);
            avstandX = 0;
        } else {
            if (positivX) {
                element.setLocation((nowX + rateX), nowY);
                posX.put(navn, (nowX + rateX));
            } else if (!positivX) {
                element.setLocation((nowX - rateX), nowY);
                posX.put(navn, (nowX - rateX));
            } }
        
        //(E) Sjekker om elementet er i posisjon, eventuelt setter det i posisjon eller flytter det (y-retning)
        if (avstandY < rateY) {
            element.setLocation(nowX, y);
            avstandY = 0;
        } else {
            if (positivY) {
                element.setLocation(nowX, (nowY + rateY));
                posY.put(navn, (nowY + rateY));
            } else if (!positivY) {
                element.setLocation(nowX, (nowY + rateY));
                posY.put(navn, (nowY + rateY));
            } }
       
    
        
        //Kodeflyten stopper her i 0.1 sekund
        Thread.sleep(30);
        
        
        //Hvis ikke objektet er i posisjon, fortsetter metoden å kalle seg selv
        if (!((avstandX == 0) && (avstandY == 0))) { animate(x,y,element,navn,false); }
        
    }//Avslutter metoden "animate"
    
    
    
    
    
}//Avslutter classen "Inter"


























