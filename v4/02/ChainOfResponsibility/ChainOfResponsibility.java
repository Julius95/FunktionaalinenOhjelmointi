/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package chainofresponsibility;

import java.util.function.Function;
import java.util.function.UnaryOperator;

/**
 *
 * @author Simo
 */
public class ChainOfResponsibility {

    public static void main(String[] args) {
  
    
        UnaryOperator<Pyynto> johtajaKasittelee =
                (Pyynto p) -> 
                    {   if (!p.isKasitelty() && p.getKorotuspyynto()/p.getPalkka() <= 0.10){
                                    System.out.println("Johtaja hyväksyy");  
                                    p = new Pyynto(p.getPalkka()+p.getKorotuspyynto(), p.getKorotuspyynto());
                                    p.setKasitelty(true);
                        }
                        return p;
                    };
        
        UnaryOperator<Pyynto> paallikkoKasittelee =
                (Pyynto p) -> 
                    {   if (!p.isKasitelty() && p.getKorotuspyynto()/p.getPalkka() <= 0.05){
                            System.out.println("Paallikko hyväksyy");  
                            p = new Pyynto(p.getPalkka()+p.getKorotuspyynto(), p.getKorotuspyynto());
                            p.setKasitelty(true);
                        }
                        return p;
                    };
        
        UnaryOperator<Pyynto> esimiesKasittelee =
                (Pyynto p) -> 
                    {   if (p.getKorotuspyynto()/p.getPalkka() <= 0.02){
                            System.out.println("Esimies hyväksyy");  
                            p = new Pyynto(p.getPalkka()+p.getKorotuspyynto(), p.getKorotuspyynto());
                            p.setKasitelty(true);
                        }
                        return p;
                    };
        

        
        Function<Pyynto, Pyynto> ketju = esimiesKasittelee.andThen(paallikkoKasittelee).andThen(johtajaKasittelee); 
        
        Pyynto p = new Pyynto(1000, 100);
        
        p = ketju.apply(p);
        
        System.out.println(p.getPalkka());
        
        
        
    }
    
}
