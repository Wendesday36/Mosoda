package modell;

public class Mosoda {

    private Ruha[] ruhak;
    private int ruhaDb;
    private boolean uzemel;

    private enum UzemelesiAllapot {
        UZEMEL, NEM_UZEMEL, LEEGETT
    };
    private UzemelesiAllapot allapot;

    public Mosoda() {
        this(5);
    }

    public Mosoda(int db) {
        ruhaDb = 0;
        ruhak = new Ruha[db];
        uzemel = true;
        allapot = UzemelesiAllapot.UZEMEL;

    }

    public void leeg() {
        uzemel = false;
        allapot = UzemelesiAllapot.LEEGETT;
    }

    public void bevesz(Ruha ruha) {
        //if (uzemel) {
        if (allapot == UzemelesiAllapot.UZEMEL) {
            if (ruhaDb < ruhak.length) {
                ruhak[ruhaDb++] = ruha;
            } else {
                System.out.println("A mosoda megtelt!");
            }
        } else {
            nemUzemel();
        }
    }

    public void alltalanosMosas() {
        //if (uzemel) {
        if (allapot == UzemelesiAllapot.UZEMEL) {
            for (Ruha ruha : ruhak) {
                if (ruha != null) {
                    if (ruha instanceof Ing) {
                        Ing ing = (Ing) ruha;
                        ing.setSzin(ing.getSzin() * 0.97);
                    } else if (ruha instanceof Pulcsi) {
                        Pulcsi pulcsi = (Pulcsi) ruha;
                        switch (pulcsi.getMeret()) {
                            case FELNOTT:
                                pulcsi.setMeret(Pulcsi.Meret.TINI);
                                break;

                            case TINI:
                                pulcsi.setMeret(Pulcsi.Meret.GYEREK);
                                break;
                            case GYEREK:
                                pulcsi.setMeret(Pulcsi.Meret.BEBI);
                                break;
                            
                        }
                       
                    }
                    ruha.setTiszta(true);
                }
            }
        } else {
            nemUzemel();
        }
    }

    public void kimeloMosas() {
        //if (uzemel) {
        if (allapot == UzemelesiAllapot.UZEMEL) {
            for (Ruha ruha : ruhak) {
                if (ruha != null) {
                    if (ruha instanceof Ing) {
                        Ing ing = (Ing) ruha;
                        ing.setSzin(ing.getSzin() * 0.145);
                    }
                    if (ruha instanceof Pulcsi) {
                        Pulcsi pulcsi = (Pulcsi) ruha;
                         pulcsi.setMeret(pulcsi.getMeret());
                    }
                    ruha.setTiszta(true);
                }
            }
        } else {
            nemUzemel();
        }
    }

    public Ruha kiad(String tulNeve) {
        Ruha kiadottRuha = null;
        //if (uzemel) {
        if (allapot == UzemelesiAllapot.UZEMEL) {
            int i = 0;
            while (ruhak[i] == null || i < ruhaDb && !(ruhak[i].getTulNev().equals(tulNeve))) {
                i++;
            }
            if (i < ruhaDb) {
                String tipus = ruhak[i] instanceof Ruha ? "pulcsija" : "inge";
                System.out.println("Kiadva %s %s!".formatted(tulNeve, tipus));
                kiadottRuha = ruhak[i];
                ruhak[i] = null;
            } else {
                System.out.println("Nincs ilyen ruha a mosodában!");
            }
        } else {
            nemUzemel();
        }

        return kiadottRuha;
    }

    public String[] getRuhak() {
        //if (uzemel) {
        if (allapot == UzemelesiAllapot.UZEMEL) {
            String[] ruhak = new String[this.ruhak.length];
            for (int i = 0; i < ruhaDb; i++) {
                Ruha r = this.ruhak[i];
                if (r != null) {
                    ruhak[i] = r.getTulNev();

                    //ruhak[i] += r instanceof Ing ? " ingje " : " ruhája ";
                    String szinIntenzitas = "";
                    String meret = "";
                    if (r instanceof Ing) {
                        ruhak[i] += " inge ";
                        szinIntenzitas = " színe " + ((Ing) r).getSzin() + "%";
                    } else if (r instanceof Pulcsi){
                        ruhak[i] += " pulcsija ";
                        meret = ", meret " + ((Pulcsi) r).getMeret();
                    }
                    ruhak[i] += r.isTiszta() ? "tiszta" : "koszos";
                    ruhak[i] += szinIntenzitas;
                    ruhak[i] += meret;
                }
            }
            return ruhak;
        } else {
            nemUzemel();
            return new String[0];
        }
    }

    private void nemUzemel() {
        if (allapot == UzemelesiAllapot.NEM_UZEMEL) {
            System.out.println("A mosoda nem üzemel!");
        } else if (allapot == UzemelesiAllapot.LEEGETT) {
            System.out.println("A mosoda leégett!");
        }
    }
}
