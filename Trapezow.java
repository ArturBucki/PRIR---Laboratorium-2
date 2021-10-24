
class Trapezow extends Thread
{
    double suma,a,b,n;

    public  Trapezow(double a, double b,double n)
    {
        this.a = a;
        this.b = b;
        this.n = n;
    }

    private static double calka(double x)
    {
        return x*x;
    }

    public void run()
    {
        double h;
        h = (b - a) / n;
        suma = 0;

        for(int i = 1; i < n ; i++)
        {
            suma = suma + calka(a + i * h);
        }
        
        suma = h * (suma + ((calka(a) + calka(b))) / 2);
        System.out.println("Metoda trapezow: " + suma);
    }
}
