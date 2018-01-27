abstract class Noeud
{
  private String attribut;
   private Noeud noeuddroit;
   private Noeud noeudgauche;
   public Noeud parent;
      private int profondeur=0;
    private int niveau=0;
    private int drawPos=0;

    public int getProfondeur() {
        return profondeur;
    }

    public void setProfondeur(int profondeur) {
        this.profondeur = profondeur;
    }

    public int getNiveau() {
        return niveau;
    }

    public void setNiveau(int niveau) {
        this.niveau = niveau;
    }

    public int getDrawPos() {
        return drawPos;
    }

    public void setDrawPos(int drawPos) {
        this.drawPos = drawPos;
    }
   
    
   
 
 public String getAttribut() {
        return attribut;
    }

    public void setAttribut(String attribut) {
       this.attribut = attribut;
    }
   public Noeud getNoeuddroit() {
        return noeuddroit;
    }

    public void setNoeuddroit(Noeud noeuddroit) {
       this.noeuddroit = noeuddroit;
    }
   
    public Noeud getNoeudgauche() {
        return noeudgauche;
    }

    public void setNoeudgauche(Noeud noeudgauche) {
       this.noeudgauche = noeudgauche;
    }
    public Noeud getParent() {
        return parent;
    }

    public void setParent(Noeud parent) {
       this.parent = parent;
    }
}
