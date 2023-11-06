package main;

import modell.Ing;
import modell.Mosoda;
import modell.Ruha;

public class MosodaProgram {

    private Mosoda mosoda;

    public static void main(String[] args) {
        new MosodaProgram();
    }
    
    public MosodaProgram() {
        mosoda = new Mosoda(4);
        mosoda.bevesz(new Ruha("Péter"));
        mosoda.bevesz(new Ruha("Pál"));
        mosoda.bevesz(new Ing("Petra"));
        mosoda.bevesz(new Ing("Piroska"));
        
        System.out.println("--- mosoda ruhái mosás ELŐTT:");
        mosodaRuhai();
        
        System.out.println("--- mosoda ruhái 1. mosás UTÁN:");
        mosoda.mos();
        mosodaRuhai();
        
        System.out.println("--- mosoda ruhái 2. mosás UTÁN:");
        mosoda.mos();
        mosodaRuhai();
        
        mosoda.kiad("Pál");
        mosoda.kiad("Petra");
        System.out.println("--- a mosodában maradt ruhák:");
        mosodaRuhai();
    }
    
    private void mosodaRuhai() {
        for (String ruha : mosoda.getRuhak()) {
            if(ruha != null){
                System.out.println(ruha);
            }
        }
    }

}
