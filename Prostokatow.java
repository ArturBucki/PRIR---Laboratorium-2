
class Prostokatow extends Thread
{
    double suma,a,b,n;

    public Prostokatow(double a, double b,double n)
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
        n = 3;
        h = (b - a) / n;
        suma = 0;
        for (int i = 1; i <= n; i++)
        {
            suma += calka(a + i * h);
        }
        suma *= h;
        System.out.println("Metoda prostokatow: " + suma);
    }
}
