
package robot;


public class Robot {
    
    private int numeroSerie;
    private int vida;

    public Robot() {
    }

    public Robot(int numeroSerie, int vida) {
        this.numeroSerie = numeroSerie;
        this.vida = vida;
    }

    public int getNumeroSerie() {
        return numeroSerie;
    }

    public void setNumeroSerie(int numeroSerie) {
        this.numeroSerie = numeroSerie;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + this.numeroSerie;
        hash = 41 * hash + this.vida;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Robot other = (Robot) obj;
        if (this.numeroSerie != other.numeroSerie) {
            return false;
        }
        return this.vida == other.vida;
    }

    @Override
    public String toString() {
        return "Robot: "+numeroSerie+" - Vida: "+vida;
    }
    
    
    
}
