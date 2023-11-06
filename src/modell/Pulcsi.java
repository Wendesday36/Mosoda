/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modell;

/**
 *
 * @author berta.z.anna
 */
public class Pulcsi extends Ruha {

    public enum Meret {
        FELNOTT, TINI, GYEREK, BEBI
    };
    private Meret meret;

    public Pulcsi(String tulNev,Meret meret) {
        super(tulNev);
        this.meret = meret;
    }

    public void setMeret(Meret meret) {
        this.meret = meret;
    }

    public Meret getMeret() {
        return meret;
    }

    @Override
    public String toString() {
        return "Pulcsi{" + "meret=" + meret + '}';
    }
    
    
    

}
