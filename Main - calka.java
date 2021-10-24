
public class Main 
{
    public static void main(String[] args)
    {

        Prostokatow prostokat = new Prostokatow(3,5,3);	// Przedzial, ilosc
        Trapezow trapez = new Trapezow(3,5,3);
        Simpsona simpson = new Simpsona(3,5,3);

        prostokat.start();
        trapez.start();
        simpson.start();

        try {
            prostokat.join();
            trapez.join();
            simpson.join();
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Suma:" + (prostokat.suma + trapez.suma + simpson.suma));
    }
}
