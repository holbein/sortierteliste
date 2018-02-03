public class Lukas {

     public static void main(String []args){
        System.out.println("Hello World");
        
        SORTIERTELISTE s = new SORTIERTELISTE();
        MITGLIED m1 = new MITGLIED("Lukas");
        MITGLIED m2 = new MITGLIED("Danylo");
        
        s.Einfuegen(m1);
        s.Einfuegen(m2);
        s.Drucken();
     }
}

class SORTIERTELISTE {
  LISTENELEM erster;
  
  SORTIERTELISTE() {
    this.erster = new ABSCHLUSS();
  }
  
  void Einfuegen(DATENELEM d) {
    this.erster = this.erster.Einfuegen(d);
  }
  
  void Loeschen(DATENELEM d) {
    this.erster = this.erster.Loeschen(d);
  }
  
  void Drucken() {
      this.erster.Drucken();
  }
}

abstract class LISTENELEM {
  abstract KNOTEN Einfuegen(DATENELEM d);
  abstract LISTENELEM Loeschen(DATENELEM d);
  abstract void Drucken();
}

class KNOTEN extends LISTENELEM {
  DATENELEM inhalt;
  LISTENELEM naechster;
  
  KNOTEN(DATENELEM inhalt, LISTENELEM naechster) {
   	this.inhalt = inhalt;
    this.naechster = naechster;
  }
  
  KNOTEN Einfuegen(DATENELEM d) {
    if (inhalt.istKleiner(d)) {
      naechster = this.naechster.Einfuegen(d);
      return this;
    } else {
     return new KNOTEN(d, this); 
    }
  }
  
  LISTENELEM Loeschen(DATENELEM d) {
      if (this.inhalt == d) {
          return this.naechster;
      } else {
        return this.naechster.Loeschen(d);
      }
  }
  
  void Drucken() {
    System.out.println(((MITGLIED)this.inhalt).name);
    this.naechster.Drucken();
  }
}

class ABSCHLUSS extends LISTENELEM {
  ABSCHLUSS() { }
  
  KNOTEN Einfuegen(DATENELEM d) { return new KNOTEN(d, this); }
  
  LISTENELEM Loeschen(DATENELEM d) {
      return this;
  }
  
  void Drucken() {
   System.out.println("ENDE");   
  }
}

abstract class DATENELEM {
  abstract boolean istKleiner(DATENELEM d);
}

class MITGLIED extends DATENELEM {
 String name;
  
  MITGLIED(String n) {
   this.name = n;
  }
  
  boolean istKleiner(DATENELEM d) {
	return true;
  }
}


