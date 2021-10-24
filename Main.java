public class Main 
{
    static int ilosc_autobusow = 100000;
    static int ilosc_linii = 5;
    static Centrala centrala;

    public static void main(String[] args) {

        centrala = new Centrala(ilosc_linii, ilosc_autobusow);

        for(int i = 0; i < ilosc_autobusow; i++)
        {
            new Autobus(i, 2000, centrala).start();
        }
    }
}