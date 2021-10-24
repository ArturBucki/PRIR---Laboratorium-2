public class Centrala {

    static int CENTRALA = 1;
    static int START = 2;
    static int TRASA = 3;
    static int KONIEC_TRASY = 4;
    static int WYPADEK = 5;
    int iloscLinii;
    int iloscZajetych;
    int iloscAutobusow;

    Centrala(int iloscLinii,int iloscAutobusow)
    {
        this.iloscLinii = iloscLinii;
        this.iloscAutobusow = iloscAutobusow;
        this.iloscZajetych = 0;
    }

    synchronized int start(int numer)
    {
        iloscZajetych--;
        System.out.println("Pozwolenie na wyjazd z centrali " + numer);
        return START;
    }

    synchronized int koniec()
    {
        try
        {
            Thread.currentThread();
			Thread.sleep(1000);
        }
        catch(Exception ie)
        {
        }

        if(iloscZajetych < iloscLinii)
        {
            iloscZajetych++;
            System.out.println("Pozwolenie na zjazd na centrale "+ iloscZajetych);
            return CENTRALA;
        }
        else
        {
            return KONIEC_TRASY;
        }
    }

    synchronized void zmniejsz()
    {
        iloscAutobusow--;
        System.out.println("Wypadek");
        if(iloscAutobusow == iloscLinii) System.out.println("Ilosc autobusow jaka sama jak ilosc linii");
    }
}