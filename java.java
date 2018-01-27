
import java.util.LinkedList;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

class java {

    static int NiveauActuel = -1;
    static int EspaceActuel = -1;
    static final int centre = 3;

   
    // cette fonction permet de dessiner l'arbre a partir d'un root , le root de l'arbre c'est le sommet
    static void dessinerArbre(Noeud root) {
   
        setNiveaux(root, 0);

        LinkedList<Noeud> list = new LinkedList<Noeud>();
        list.add(root.getNoeudgauche());
        list.add(root.getNoeuddroit());

        root.setDrawPos((int) 2* centre);
        NiveauActuel = root.getNiveau();
        EspaceActuel = root.getDrawPos();
        // on dessine le root de l'arbre 
        System.out.print(espace(root.getDrawPos()) + root.getAttribut());
        // on va parcourir list des noeuds pour les dessiner 
        while (!list.isEmpty()) {

            Noeud noeude = list.pollFirst();
            dessinerNoeudRacine(noeude, list);
            if (noeude == null) {
                continue;
            }
            list.add(noeude.getNoeudgauche());
            list.add(noeude.getNoeuddroit());
        }
        System.out.println();
    }
    // fonction qui nous permet de dessiner un noeud , 

    static void dessinerNoeudRacine(Noeud noeude, LinkedList<Noeud> liste) {
        // si le noeud est null , rien faire
        if (noeude == null) {
            return;
        }

        // on fait cette comparaison pour savoir si on doit dessiner le noeud ou bien les racines ! 
        if (noeude.getNiveau() != NiveauActuel) {
            NiveauActuel = noeude.getNiveau();
            EspaceActuel = 0;
            System.out.println();

            int espacedessin = 0;
            if (noeude.parent.getNoeudgauche() != null) {
                // si le cas d'un fils gauche , on dessine la racine vers un fils gauche
                espacedessin = noeude.parent.getDrawPos() - 1;
                System.out.print(espace(espacedessin + 1) + "/");
            }
            if (noeude.parent.getNoeuddroit() != null) {
                // si le cas d'un fils droit , on dessine la racine vers un fils droit
                int espacedessin2 = noeude.parent.getDrawPos() + 1;
                System.out.print(espace(espacedessin2 - espacedessin - 1) + "\\");
                espacedessin = espacedessin2;
            }

            
            // le premier noeud a gauche dessine les racines pour tous les noeuds a droite , donc on les parcour un par un ! 
            Noeud parent_fini = noeude.parent;
            for (Noeud sameparent : liste) {
                if (sameparent == null) {
                    continue;
                }
                if (sameparent.parent == parent_fini) {
                    continue;
                }
                parent_fini = sameparent.parent;
                if (sameparent.parent.getNoeudgauche() != null) {
                    int espacedessin2 = sameparent.parent.getDrawPos() - 1;
                    System.out.print(espace(espacedessin2 - espacedessin + 1) + "/");
                    espacedessin = espacedessin2;
                }

                if (sameparent.parent.getNoeuddroit() != null) {
                    int espacedessin2 = sameparent.parent.getDrawPos() + 1;
                    System.out.print(espace(espacedessin2 - espacedessin - 2) + "\\");
                    espacedessin = espacedessin2;
                }
            }
            System.out.println();

        }
        // si le niveau de noeud egale au niveau actuel , donc on dessine le noeud 
        if (noeude.parent.getNoeudgauche() == noeude) {
            // s'il s'agit d'un noeud gauche on déminue la position de parent 
            noeude.setDrawPos(noeude.parent.getDrawPos() - 1);

        } else {
            // s'il s'agit d'un noeud droit on incremente la position de parent
            noeude.setDrawPos(noeude.parent.getDrawPos() + 1);

        }

        System.out.print(espace(noeude.getDrawPos() - EspaceActuel) + noeude.getAttribut());
        EspaceActuel = noeude.getDrawPos();
    }

    public static void main(String[] args) {

        // premierement on construit notre arbre : 
        Carre cinq = new Carre();
        Rond B = (Rond) new Rond();
        Rond a = (Rond) new Rond();
        a.setNoeuddroit(B);
        a.setNoeudgauche(cinq);
        a.setAttribut("A");

        Carre sept = new Carre();
        sept.setAttribut("7");

        Rond F = new Rond();
        F.setAttribut("F");
        Rond G = (Rond) new Rond();
        cinq.setNoeuddroit(sept);
        cinq.setAttribut("5");
        G.setAttribut("G");
        F.setNoeudgauche(G);
        cinq.setNoeudgauche(F);
        Rond C = new Rond();
        C.setAttribut("C");
        Carre huit = new Carre();
        huit.setAttribut("8");
        Carre tren_troi = new Carre();
        tren_troi.setAttribut("33");
        Rond E = new Rond();
        E.setAttribut("E");
        B.setNoeuddroit(C);
        B.setAttribut("B");
        C.setNoeudgauche(huit);
        C.setNoeuddroit(tren_troi);
        huit.setNoeudgauche(E);
        Carre douze = new Carre();
        douze.setAttribut("12");
        Rond D = new Rond();
        D.setAttribut("D");

        tren_troi.setNoeudgauche(douze);
        tren_troi.setNoeuddroit(D);
        cinq.setParent(a);
        B.setParent(a);
        C.setParent(B);
        huit.setParent(C);
        tren_troi.setParent(C);
        E.setParent(huit);
        douze.setParent(tren_troi);
        D.setParent(tren_troi);
        G.setParent(F);
        F.setParent(cinq);
        sept.setParent(cinq);

        // on appelle la fonction qui dessine l'arbre en passant le root comme paaramétre
        dessinerArbre(a);

    }
    

    // Une fonction qui permet de définir le niveu de chaque noeud dans l'arbre ,chaque ligne de l'arbre est considéré comme un niveau , on commence la numérotation de 0; 
    static void setNiveaux(Noeud n, int niveau) {
        if (n == null) {
            return;
        }
        n.setNiveau(niveau);
        setNiveaux(n.getNoeudgauche(), niveau + 1);
        setNiveaux(n.getNoeuddroit(), niveau + 1);
    }

    
    // Une mehode permet de nous donner une espace , sous form de chaine de caracteres 
    static String espace(int i) {
        String s = "";
        while (i > 0) {
            s = s+  " ";
            i--;
        }
        return s;
    }

}
