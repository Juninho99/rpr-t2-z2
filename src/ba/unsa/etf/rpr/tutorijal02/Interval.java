package ba.unsa.etf.rpr.tutorijal02;

public class Interval {
    private double pocetnaTacka;
    private double krajnjaTacka;
    private boolean ukljucujePocetak;
    private boolean ukljucujeKraj;

    public Interval(double pocetnaTacka, double krajnjaTacka, boolean ukljucujePocetak, boolean ukljucujeKraj) throws IllegalArgumentException {
        this.pocetnaTacka = pocetnaTacka;
        this.krajnjaTacka = krajnjaTacka;
        this.ukljucujePocetak = ukljucujePocetak;
        this.ukljucujeKraj = ukljucujeKraj;

        if(this.pocetnaTacka > this.krajnjaTacka) throw new IllegalArgumentException();
    }

    public Interval() {
        this.pocetnaTacka = 0;
        this.krajnjaTacka = 0;
        this.ukljucujePocetak = false;
        this.ukljucujeKraj = false;
    }

    public static Interval intersect(Interval i1, Interval i2) {
        Interval i = new Interval();

        if(i1.getPocetnaTacka() > i2.getPocetnaTacka()) {
            i.setPocetnaTacka(i1.getPocetnaTacka());
            i.setUkljucujePocetak(i1.isUkljucujePocetak());
        }
        else {
            i.setPocetnaTacka(i2.getPocetnaTacka());
            i.setUkljucujePocetak(i2.isUkljucujePocetak());
        }

        if(i1.getKrajnjaTacka() < i2.getKrajnjaTacka()) {
            i.setKrajnjaTacka(i1.getKrajnjaTacka());
            i.setUkljucujeKraj(i1.isUkljucujeKraj());
        }
        else {
            i.setKrajnjaTacka(i2.getKrajnjaTacka());
            i.setUkljucujeKraj(i2.isUkljucujeKraj());
        }
        return i;
    }

    public double getPocetnaTacka() {
        return pocetnaTacka;
    }

    public void setPocetnaTacka(double pocetnaTacka) {
        this.pocetnaTacka = pocetnaTacka;
    }

    public double getKrajnjaTacka() {
        return krajnjaTacka;
    }

    public void setKrajnjaTacka(double krajnjaTacka) {
        this.krajnjaTacka = krajnjaTacka;
    }

    public boolean isUkljucujePocetak() {
        return ukljucujePocetak;
    }

    public void setUkljucujePocetak(boolean ukljucujePocetak) {
        this.ukljucujePocetak = ukljucujePocetak;
    }

    public boolean isUkljucujeKraj() {
        return ukljucujeKraj;
    }

    public void setUkljucujeKraj(boolean ukljucujeKraj) {
        this.ukljucujeKraj = ukljucujeKraj;
    }


    public boolean isIn(double tacka) {
        if(!isUkljucujePocetak()) {
            if(!isUkljucujeKraj()) {
                if(tacka > getPocetnaTacka() && tacka < getKrajnjaTacka())  return true;
            }
        }

        if(isUkljucujePocetak()) {
            if(!isUkljucujeKraj()) {
                if(tacka >= getPocetnaTacka() && tacka < getKrajnjaTacka())  return true;
            }
        }

        if(!isUkljucujePocetak()) {
            if(isUkljucujeKraj()) {
                if(tacka > getPocetnaTacka() && tacka <= getKrajnjaTacka())  return true;
            }
        }

        if(isUkljucujePocetak()) {
            if(isUkljucujeKraj()) {
                if(tacka >= getPocetnaTacka() && tacka <= getKrajnjaTacka())  return true;
            }
        }

        return false;
    }

    public boolean isNull() {
        return getKrajnjaTacka() == 0 && getPocetnaTacka() == 0;
    }

    public Interval intersect(Interval interval) {
        Interval i = new Interval();

        if(interval.getPocetnaTacka() > this.getPocetnaTacka()) {
            i.setPocetnaTacka(interval.getPocetnaTacka());
            i.setUkljucujePocetak(interval.isUkljucujePocetak());
        }
        else {
            i.setPocetnaTacka(this.getPocetnaTacka());
            i.setUkljucujePocetak(this.isUkljucujePocetak());
        }

        if(interval.getKrajnjaTacka() < this.getKrajnjaTacka()) {
            i.setKrajnjaTacka(interval.getKrajnjaTacka());
            i.setUkljucujeKraj(interval.isUkljucujeKraj());
        }
        else {
            i.setKrajnjaTacka(this.getKrajnjaTacka());
            i.setUkljucujeKraj(this.isUkljucujeKraj());
        }
        return i;
    }

    @Override
    public String toString() {
        String s = "";

        if(isUkljucujePocetak())    s = s + "[";
        else                        s = s + "(";

        if(getPocetnaTacka() != 0 && getKrajnjaTacka() != 0)
        s = s + getPocetnaTacka() + "," + getKrajnjaTacka();

        if(isUkljucujeKraj())       s = s + "]";
        else                        s = s + ")";

        return s;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Interval)) return false;
        Interval interval = (Interval) o;
        return Double.compare(interval.getPocetnaTacka(), getPocetnaTacka()) == 0 &&
                Double.compare(interval.getKrajnjaTacka(), getKrajnjaTacka()) == 0 &&
                isUkljucujePocetak() == interval.isUkljucujePocetak() &&
                isUkljucujeKraj() == interval.isUkljucujeKraj();
    }

}
