package hu.petrik.eloadasproject;

public class Eloadas {
    private boolean[][] foglalasok;

    public Eloadas(int sorokSzama, int helyekSzama) {
        if (sorokSzama < 1) {
            throw new IllegalArgumentException("A 'sorokSzama' paraméternek pozitítívnak kell lennie");
        }
        if (helyekSzama < 1) {
            throw new IllegalArgumentException("A 'helyekSzama' paraméternek pozitítívnak kell lennie");
        }
        this.foglalasok = new boolean[sorokSzama][helyekSzama];
    }

    public boolean lefoglal() {
        boolean sikerult = false;
        int i = 0;
        while (!sikerult && i < foglalasok.length) {
            int j = 0;
            while (!sikerult && j < foglalasok[i].length) {
                if (foglalasok[i][j]) {
                    j++;
                } else {
                    foglalasok[i][j] = true;
                    sikerult = true;
                }
            }
            if (!sikerult) {
                i++;
            }
        }
        return sikerult;
    }

    public int getSzabadHelyek() {
        int szabadhelyek = 0;
        for (boolean[] sor : foglalasok) {
            for (boolean hely : sor) {
                if (!hely) {
                    szabadhelyek++;
                }
            }
        }
        return szabadhelyek;
    }

    public boolean getTeli() {
        int i = 0;
        int j = 0;
        while (i < this.foglalasok.length && this.foglalasok[i][j]) {
            j = 0;
            while (j < this.foglalasok[i].length && this.foglalasok[i][j]) {
                j++;
            }
            if (j == this.foglalasok[i].length) {
                i++;
                j = 0;
            }
        }
        return i == this.foglalasok.length;
    }

    public boolean foglalt(int sorSzam, int helySzam) {
        if (sorSzam < 1) {
            throw new IllegalArgumentException("A 'sorSzam' paraméternek pozitítívnak kell lennie");
        }
        if (sorSzam > this.foglalasok.length) {
            throw new IllegalArgumentException("A 'sorSzam' paraméter nem lehet nagyobb a sorok számánál");
        }
        if (helySzam < 1) {
            throw new IllegalArgumentException("A 'helySzam' paraméternek pozitítívnak kell lennie");
        }
        if (helySzam > this.foglalasok[sorSzam - 1].length) {
            throw new IllegalArgumentException("A 'helySzam' paraméter nem lehet nagyobb az adott sorban lévő helyek számánál");
        }
        return this.foglalasok[sorSzam - 1][helySzam - 1];
    }
}
