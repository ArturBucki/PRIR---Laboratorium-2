
class Simpsona extends Thread
{
    double suma,a,b,n;

    public  Simpsona(double a, double b,double n)
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
        double h, ti;
        h = (b - a) / n;
        suma = 0;
        ti = 0;

        for(int i = 1; i < n; i++)
        {
            ti = ti + calka((a + i * h) - h / 2);
            suma = suma + calka(a + i * h);
        }
        ti = ti + calka(b - h / 2);
        suma = (calka(a) + calka(b) + 2 * suma + 4 * ti) * (h / 6);
        System.out.println("Metoda Simpsona: " + suma);
    }
}