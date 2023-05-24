import java.util.*;
public class Poste{
    static int counter = 0;
    static int count = 0;
    public static void main(String[] args){

        List<Lettre> listedeLettres = new ArrayList<>();
        List<Double> listedePrixLettres = new ArrayList<>();
        List<Publicite> listedePublicite = new ArrayList<>();
        List<Double> listedePrixPublicites = new ArrayList<>();
        List<Colis> listedeColis = new ArrayList<>();
        List<Double> listedePrixColis = new ArrayList<>();

        Scanner sc = new Scanner(System.in);
        String veuxEnvoyer = "oui";
        double prix = 0;
        String format = " ";
        String destination = " ";
        String express =" ";
        double poid;
        String a = " ";
        double vol;
        double prixTotal = 0;

        while(veuxEnvoyer.equals("oui")){ 
            a = " ";
            if(count == 0 ){
                System.out.println("\nvoulez vous envoyer quelque chose ?(oui/non) : ");
                veuxEnvoyer = " ";
                veuxEnvoyer = sc.nextLine();
                veuxEnvoyer = veuxEnvoyer.toLowerCase();
                while(!veuxEnvoyer.equals("non") && !veuxEnvoyer.equals("oui")){
                    System.out.println("veuillez sil vous plait entrer oui(si vous vous voulez envoyer quelque chose) ou non(au cas contraire) :");
                    veuxEnvoyer = sc.nextLine();
                    veuxEnvoyer = veuxEnvoyer.toLowerCase();
                }
                if(veuxEnvoyer.equals("oui")){
                    System.out.println("que voulez vous envoyer? (Lettre, publicite ou colis) : ");
                    a = sc.nextLine();
                    a = a.toLowerCase();
                }
            }

            if (count > 0){
                System.out.println("\nvoulez vous envoyer quelque chose dautre ?(oui/non) : ");
                veuxEnvoyer = sc.nextLine();
                veuxEnvoyer = veuxEnvoyer.toLowerCase();
                while(!veuxEnvoyer.equals("non") && !veuxEnvoyer.equals("oui")){
                    System.out.println("veuillez sil vous plait entrer oui(si vous vous voulez envoyer quelque chose dautre) ou non(au cas contraire) :");
                    veuxEnvoyer = sc.nextLine();
                    veuxEnvoyer = veuxEnvoyer.toLowerCase();
                }
                if(veuxEnvoyer.equals("oui")){
                    System.out.println("que voulez vous envoyer dautre? (Lettre, publicite ou colis) : ");
                    a = sc.nextLine();
                    a = a.toLowerCase();
                }

            }

            if(veuxEnvoyer.equals("oui")){
                while(!a.equals("lettre")  && !a.equals("publicite") && !a.equals("colis")){
                    System.out.print("veuillez sil vous plait bien entrer ce que vous voulez envoyer sans faire derreur sur lorthographe. \n\nveux tu envoyer lettre publicite ou colis? : ");
                    a = sc.nextLine();
                    a = a.toLowerCase();
                }
            }

            if(veuxEnvoyer.equals("oui")){
                count++;
                
            }

            if(a.equals("lettre")){
                System.out.println("entrez le poid de votre lettre (en gramme): ");
                poid = sc.nextDouble();
                sc.nextLine();
                System.out.println("voulez vous envoyer votre lettre express ? (oui/non)");
                express = sc.nextLine();
                express = express.toLowerCase();
                System.out.println("entrez la destination de votre lettre : ");
                destination = sc.nextLine();
                System.out.println("entrez le Format de votre lettre (A4 ou A3): ");
                format = sc.nextLine();

                Lettre w = new Lettre(poid, express, destination, format);
                listedeLettres.add(w);
                if(express.equals("oui")){
                    prix = w.prixPourEnvoieExpressLettre();
                    listedePrixLettres.add(prix);
                }
                else if (express.equals("non")){
                    prix = w.prixPourEnvoieNormalLettre();
                    listedePrixLettres.add(prix);
                }
            }

            if(a.equals("colis")){
                System.out.println("entrez le poid de votre colis (en gramme): ");
                poid = sc.nextDouble();
                sc.nextLine();
                System.out.println("voulez vous envoyer votre colis express ? (oui/non)");
                express = sc.nextLine();
                express = express.toLowerCase();
                System.out.println("entrez la destination de votre colis : ");
                destination = sc.nextLine();
                System.out.println("entrez le volume de votre colis(en litres): ");
                vol = sc.nextDouble();
                sc.nextLine();

                Colis col = new Colis(poid, express, destination, vol);
                listedeColis.add(col);
                if(express.equals("oui")){
                    prix = col.prixPourEnvoieExpressColis();
                    listedePrixColis.add(prix);
                }
                else if (express.equals("non")){
                    prix = col.prixPourEnvoieNormalColis();
                    listedePrixColis.add(prix);
                }
               
            }

            if(a.equals("publicite")){
                System.out.println("entrez le poid de votre publicite (en gramme): ");
                poid = sc.nextDouble();
                sc.nextLine();
                System.out.println("voulez vous envoyer votre colis express ? (oui/non)");
                express = sc.nextLine();
                express = express.toLowerCase();
                System.out.println("entrez la destination de votre publicite : ");
                destination = sc.nextLine();

                Publicite pub = new Publicite(poid, express, destination);
                listedePublicite.add(pub);
                if(express.equals("oui")){
                    prix = pub.prixPourEnvoieExpressPublicite();
                    listedePrixPublicites.add(prix);
                }
                else if (express.equals("non")){
                    prix = pub.prixPourEnvoieNormalPublicite();
                    listedePrixPublicites.add(prix);
                }
            }

            
        }
    
        for(int i = 0; i < listedePrixColis.size(); i++){
            prixTotal += listedePrixColis.get(i); 
        }
        for(int i = 0; i < listedePrixLettres.size(); i++){
            prixTotal += listedePrixLettres.get(i); 
        }
        for(int i = 0; i < listedePrixPublicites.size(); i++){
            prixTotal += listedePrixPublicites.get(i); 
        }

        System.out.println("====================================\n le montant total daffranchissement est de  : " + prixTotal + "euro\n");
        for(int i = 0; i< listedeLettres.size(); i++){
            System.out.println("Lettre ");
            listedeLettres.get(i).colisValideOuNon();
            System.out.println("\tpoids: " + listedeLettres.get(i).getPoid() + " grammes");
            System.out.println("\texpress : " + listedeLettres.get(i).getModeDexpedition());
            System.out.println("\tDestination : " + listedeLettres.get(i).getAdresseDeDestination());
            System.out.println("\tprix : " + listedePrixLettres.get(i) + " euro");
            System.out.println("\tFormat : " + listedeLettres.get(i).getFormat());
        }

        for(int i = 0; i< listedePublicite.size(); i++){
            System.out.println("Publicite ");
            listedePublicite.get(i).colisValideOuNon();
            System.out.println("\tpoids: " + listedePublicite.get(i).getPoid() + " grammes");
            System.out.println("\texpress : " + listedePublicite.get(i).getModeDexpedition());
            System.out.println("\tDestination : " + listedePublicite.get(i).getAdresseDeDestination());
            System.out.println("\tprix : " + listedePrixPublicites.get(i) + " euro");
        }

        for(int i = 0; i< listedeColis.size(); i++){
            System.out.println("Colis ");
            listedeColis.get(i).colisValideOuNon();
            System.out.println("\tpoids: " + listedeColis.get(i).getPoid() + " grammes");
            System.out.println("\texpress : " + listedeColis.get(i).getModeDexpedition());
            System.out.println("\tDestination : " + listedeColis.get(i).getAdresseDeDestination());
            System.out.println("\tprix : " + listedePrixColis.get(i) + " euro");
            System.out.println("\nvolume: " + listedeColis.get(i).getVolume() + " litres");
        }
        System.out.println("parmis les " + count + " couriers, la boite contient " + counter + " couriers invalides  " );

    }
}

 class Publicite{
    private double poid;
    private String modeDexpedition;
    private String adresseDeDestination;

    public Publicite(double poid, String modeDexpedition, String adresseDeDestination){
        this.adresseDeDestination = adresseDeDestination;
        this.modeDexpedition = modeDexpedition;
        this.poid = poid;
    }

    public double getPoid(){
        return this.poid;
    }

    public String getModeDexpedition(){
        return this.modeDexpedition;
    }

    public String getAdresseDeDestination(){
        return this.adresseDeDestination;
    }

    public double prixPourEnvoieNormalPublicite(){
        if(adresseDeDestination.isEmpty()){
            new Poste().counter++;
            return 0.0;
        }
        return 5 * this.getPoid()/1000;
    }

    public double prixPourEnvoieExpressPublicite(){
        if(adresseDeDestination.isEmpty()){
            new Poste().counter++;
            return 0.0;
        }
        return this.prixPourEnvoieNormalPublicite() * 2;
    }

    public void colisValideOuNon(){
        if(this.getAdresseDeDestination().isEmpty()){
            System.out.println("(courrier invalide)");
        }
    }
    

}

class Lettre extends Publicite{
    private String format;

    public Lettre(double poid, String modeDexpedition, String adresseDeDestination, String format){
        super( poid, modeDexpedition, adresseDeDestination);
        this.format = format;
    }

    public String getFormat(){
        return this.format;
    }

    public double prixPourEnvoieNormalLettre(){
        if(getAdresseDeDestination().isEmpty()){
            new Poste().counter++;
            return 0.0;
        }
        double tarifDeBase = 2.50;
        if(format.equals("A3")){
            tarifDeBase = 3.50;
        }
        return tarifDeBase + this.getPoid() /1000;
    }

    public double prixPourEnvoieExpressLettre(){
        if(getAdresseDeDestination().isEmpty()){
            new Poste().counter++;
            return 0.0;
        }
        return this.prixPourEnvoieNormalLettre() * 2;
    }
}

class Colis extends Publicite{
    private double volume;

    public Colis(double poid, String modeDexpedition, String adresseDeDestination, double volume){
        super( poid, modeDexpedition, adresseDeDestination);
        this.volume = volume;
    }

    public double getVolume(){
        return this.volume;
    }

    public double prixPourEnvoieNormalColis(){
        if(this.getAdresseDeDestination().isEmpty() || volume > 50){
            new Poste().counter++;
            return 0.0;
        }
        return 0.25 * this.volume + this.getPoid() /1000;
    }

    public double prixPourEnvoieExpressColis(){
        if(this.getAdresseDeDestination().isEmpty() || volume > 50){
            new Poste().counter++;
            return 0.0;
        }
        return this.prixPourEnvoieNormalColis() * 2;
    }


    public void colisValideOuNon(){
        if(this.getAdresseDeDestination().isEmpty() || volume > 50){
            System.out.println("(courrier invalide)");
        }
    }
}