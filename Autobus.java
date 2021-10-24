import java.util.Random;

public class Autobus extends Thread {
    
    static int CENTRALA = 1;
    static int START = 2;
    static int TRASA = 3;
    static int KONIEC_TRASY = 4;
    static int WYPADEK = 5;
    static int ILOSC_PALIWA = 1000;
    static int REZERWA = 500;

    int numer;
    int paliwo;
    int stan;
    Centrala l;
    Random rand;

    public Autobus(int numer, int paliwo, Centrala l)
    {
        this.numer = numer;
        this.paliwo = paliwo;
        this.stan = TRASA;
        this.l = l;
        rand = new Random();
    }

    public void run()
    {
        while(true)
        {
            if(stan == CENTRALA)
            {
                if(rand.nextInt(2) == 1)
                {
                    stan = START;
                    paliwo = ILOSC_PALIWA;
                    System.out.println("Prosze o pozwolenie na wyjazd z centrali " + numer);
                    stan = l.start(numer);
                }
                else
                {
                    System.out.println("Przerwa, odpoczynek");
                }
            }
            else if(stan == START)
            {
                System.out.println("Autobus " + numer + " wyjezdza");
                stan= TRASA;
            }
            else if(stan == TRASA)
            {
                paliwo -= rand.nextInt(500);
                System.out.println("Autobus " + numer + " w trasie");
                if(paliwo <= REZERWA)
                {
                    stan = KONIEC_TRASY;
                }
                else try
                {
                    sleep(rand.nextInt(1000));
                }
                catch (Exception e){}
            }
            else if(stan == KONIEC_TRASY)
            {
                System.out.println("Zjezdzam do centrali " + numer + " ilosc paliwa " + paliwo);
                stan = l.koniec();
                if(stan == KONIEC_TRASY)
                {
                    paliwo -= rand.nextInt(500);
                    System.out.println("REZERWA " + paliwo);
                    if(paliwo <= 0) stan = WYPADEK;
                }
            }
            else if(stan == WYPADEK)
            {
                System.out.println("WYPADEK autobus "+ numer);
                l.zmniejsz();
            }
        }
    }
}