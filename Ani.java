


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.HashMap;
import java.util.Random;



class Ani extends JPanel {
    
    
    //Justerbare verdier
    //Hastigheten på animasjonene (millisekunder)
    static double frames = 60;
    
    public static Dimension d;
    public static Random random = new Random();
    
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
	
        
        
	fig1.addComponentListener(new ComponentAdapter(){
		
		@Override
		public void componentResized(ComponentEvent e){
		    Component c = (Component)e.getSource();
		    d = c.getSize();
		    System.out.println("The sizes: " + d.getWidth() + " and " + d.getHeight());
		}
		@Override
		public void componentShown(ComponentEvent e){
		    System.out.println("The component is shown!");
		}
	    });
        
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
	//  animate(700,400,fig1,"fig1",true);
	bounce(fig1, frame, d, -10,-10);
	System.out.println("The bounce method is finished now!");
        
        
        
   
    }
    

    private static boolean collision(double elementX, double elementY,double elementWidht, double elementHeight, int frameWidth, int frameHeight){
	double elementXRight = elementX + elementWidht;
	double elementYBottom = elementY + elementHeight;
	System.out.println("The elementY is: " + elementY);

	// Now check if there are any boundary collisions
	// Check the vertical
	if(elementX < 0 || elementXRight >= frameWidth){
	    return true;
	} else if(elementY < 0 || elementYBottom >= frameHeight){
	    return true;
	}
	System.out.println("Collision method triggered true");
	return false;
    }
    
    public static void bounce(JPanel element, JFrame frame, Dimension elementSize, int dx, int dy) throws Exception {
	
	// Get the boundaries of the JFrame box.
	int frameSizeX = frame.getContentPane().getWidth();
	int frameSizeY = frame.getContentPane().getHeight();
	// System.out.println("The width is: " + frameSizeX);
	// System.out.println("And the height: " + frameSizeY);
	element.getLocation();
	// Now get the coordinates of the jFrame
	double elementSizeX = elementSize.getWidth();
	double elementSizeY = elementSize.getHeight();

	// The position
	Point p = element.getLocation();


	
	System.out.println(collision(p.getX(), p.getY(), elementSizeX, elementSizeY, frameSizeX, frameSizeY));
	
	// if there is not a collision, keep the rectangle moving
	if(!collision(p.getX(), p.getY(), elementSizeX, elementSizeY, frameSizeX, frameSizeY)){
	    // Use the point class to store the position of the element
	    p.translate(dx, dy);
	    System.out.println("Setting the new location!");
	    element.setLocation((int)p.getX(), (int)p.getY());
	    System.out.println("The new positions x: " + p.getX() + "and y: " + p.getY() );

	    // Now sleep for 30 milliseconds
	    Thread.sleep(30);
	    
	} else {
	    System.out.println("A collision was detected");
	    // Therefore, now set a new direction, in which to move
	    // dx = random.nextInt(20)-10;
	    // dy = random.nextInt(20)-10;
	    // p.translate(dx, dy);
	    dx = -dx;
	    dy = -dy;
	    p.translate(dx, dy);
	    element.setLocation((int)p.getX(), (int)p.getY());
	}
	
	System.out.println("Iterating...");
	bounce(element, frame, elementSize, dx, dy);
	
	

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


























