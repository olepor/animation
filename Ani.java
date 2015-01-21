


<<<<<<< HEAD
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.HashMap;
import java.util.Random;
=======

import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.Color;
import java.util.HashMap;

>>>>>>> f8d49fa48bbf2083f1c5779b062ad9e356a4e397



class Ani extends JPanel {
    
    
    //Justerbare verdier
    //Hastigheten på animasjonene (millisekunder)
    static double frames = 60;
    
<<<<<<< HEAD
    public static Dimension d;
    public static Random random = new Random();
=======
    
>>>>>>> f8d49fa48bbf2083f1c5779b062ad9e356a4e397
    
    public static int dW = 1000;
    public static int dH = 500;
    
    
    public static JFrame frame = new JFrame();
    public static JPanel vindu = new JPanel();
    public static JPanel fig1 = new JPanel();
<<<<<<< HEAD
    public static JPanel fig2 = new JPanel();
    public static JPanel p1 = new JPanel();
    public static JPanel p2 = new JPanel();
=======
>>>>>>> f8d49fa48bbf2083f1c5779b062ad9e356a4e397
    
    
    //Posisjonen til de ulike objektene
    static HashMap<String, Integer> posX = new HashMap<>();
    static HashMap<String, Integer> posY = new HashMap<>();
    
    
    public static void main (String args[]) throws Exception {
        
        
        //Setter posisjonen til de ulike objektene
        posX.put("fig1",200);
        posY.put("fig1",200);
<<<<<<< HEAD
	
        posX.put("fig2",500);
        posY.put("fig2",300);
        
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

	fig2.addComponentListener(new ComponentAdapter(){
            
            @Override
            public void componentResized(ComponentEvent e){
                Component c = (Component)e.getSource();
                d = c.getSize();
                System.out.println("Fig2: The sizes: " + d.getWidth() + " and " + d.getHeight());
            }
            @Override
            public void componentShown(ComponentEvent e){
                System.out.println("Fig2: The component is shown!");
            }
        });

	p1.addComponentListener(new ComponentAdapter(){
		
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
=======
        
        
>>>>>>> f8d49fa48bbf2083f1c5779b062ad9e356a4e397
        
        //JPanel "fig1" egenskaper
        fig1.setSize(100,100);
        fig1.setLocation(posX.get("fig1"),posY.get("fig1"));
        fig1.setBackground(Color.WHITE);
        
<<<<<<< HEAD
	//JPanel "fig2" egenskaper
        fig2.setSize(50,50);
        fig2.setLocation(posX.get("fig2"),posY.get("fig2"));
        fig2.setBackground(Color.WHITE);
	
	// Player one Panel
        p1.setSize(20,70);
	p1.setLocation(100, 200);
	p1.setBackground(Color.WHITE);


	// Player two panel
	p2.setSize(20, 70);
	p2.setLocation(900, 200);
	p2.setBackground(Color.WHITE);
=======
        
>>>>>>> f8d49fa48bbf2083f1c5779b062ad9e356a4e397
        
        
        //JPanel "vindu" egenskaper
        vindu.setSize(dW, dH);
        vindu.setLayout(null);
        vindu.setBackground(Color.BLACK);
<<<<<<< HEAD
	vindu.add(fig1);
	System.out.println("Adding player one");
	//vindu.add(fig2);
	vindu.add(p1);
	vindu.add(p2);
	
=======
        vindu.add(fig1);
>>>>>>> f8d49fa48bbf2083f1c5779b062ad9e356a4e397
        
        
        
        
        //JFrame "frame" egenskaper
        frame.setSize(dW, dH);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(vindu);
<<<<<<< HEAD

        


        //Flytter elementet til ønsket posisjon
	//  animate(700,400,fig1,"fig1",true);
	bounce(fig1, frame, d, -10,-5);
	System.out.println("The bounce method is finished now!");
=======
        
        
        //Flytter elementet til ønsket posisjon
        animate(700,400,fig1,"fig1",true);
>>>>>>> f8d49fa48bbf2083f1c5779b062ad9e356a4e397
        
        
        
   
    }
    
<<<<<<< HEAD
    // Simple collision detection where returns are:
    // 1 for vertical collisions
    // 2 for horisontal ones
    // and -1 if no collisions are detected
    private static int collision(double elementX, double elementY,double elementWidht, double elementHeight, int frameWidth, int frameHeight){
	double elementXRight = elementX + elementWidht;
	double elementYBottom = elementY + elementHeight;
	System.out.println("The elementY is: " + elementY);
	System.out.println("The elementX is: " + elementX);

	// Now check if there are any boundary collisions
	// Check the vertical
	if(elementX <= 0 || elementXRight >= frameWidth){
	    return 1;
	} else if(elementY <= 0 || elementYBottom >= frameHeight){
	    return 2;
	}

	return -1;
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

	int collisionId = collision(p.getX(), p.getY(), elementSizeX, elementSizeY, frameSizeX, frameSizeY);
	
	// if there is not a collision, keep the rectangle moving
	if(collisionId ==  -1){
	    // Use the point class to store the position of the element
	    // p.translate(dx, dy);
	    // System.out.println("Setting the new location!");
	    // element.setLocation((int)p.getX(), (int)p.getY());
	    // System.out.println("The new positions x: " + p.getX() + "and y: " + p.getY() );
	    // do nothing really

	    // Now sleep for 30 milliseconds
	    
	    
	} else if(collisionId == 1){
	    // Take care of the vertical collisions
	    System.out.println("A vertical collision was detected");
	    System.out.println("dx is: " + dx);
	    dx = -dx;
	    System.out.println("Now dx is: " + dx);
	    
	    
	} else if (collisionId == 2){
	    // The horisontal collision
	    System.out.println("A horisontal collision was detected");
	    dy = -dy;
	    
	}
	    
	p.translate(dx, dy);
	element.setLocation( (int)p.getX(), (int)p.getY());
	Thread.sleep(30);
	
	System.out.println("And lastly: " + dx);
	System.out.println("Iterating...");
	bounce(element, frame, elementSize, dx, dy);
	
	

    }

=======
>>>>>>> f8d49fa48bbf2083f1c5779b062ad9e356a4e397
    
    
    
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
    
<<<<<<< HEAD

    
=======
>>>>>>> f8d49fa48bbf2083f1c5779b062ad9e356a4e397
    
    
    
    
}//Avslutter classen "Inter"


























