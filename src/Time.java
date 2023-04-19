/**
 * La classe rappresenta e gestisce dati di tipo temporale
 * 
 * @author Giovanni Brussi
 */
public class Time {

    /**
     * numero di ore dell'oggetto Time
     */
    protected int ore;

    /**
     * 
     * numero di minuti dell'oggetto Time
     */
    protected int minuti;

    /**
     * numero di secondi dell'oggetto Time
     */
    protected int secondi;

    /**
     * Costruisce un oggetto Time dato in ingresso ore, minuti e secondi.
     * Se i parametri di ingresso non sono validi (es. minuti 78) allora l'oggetto
     * Time verrÃ inizializzato con tutti ore, minuti e secondi impostati a 0
     * 
     * @param ore     ore da assegnare al nuovo oggetto
     * @param minuti  minuti da assegnare al nuovo oggetto
     * @param secondi secondi da assegnare al nuovo oggetto
     */
    public Time(int ore, int minuti, int secondi) {
        if (controllo(ore, minuti, secondi)) {
            this.ore = ore;
            this.minuti = minuti;
            this.secondi = secondi;
        } else {
            this.ore = 0;
            this.minuti = 0;
            this.secondi = 0;
        }
    }

    /**
     * Costruisce un oggetto Time dato in ingresso il numero di secondi.
     * Vengono distribuite in automatico i secondi tra le ore, minuti e secondi.
     * Esempio: se in input viene passato 100 allora ora 0, minuti 1 e secondi 40
     * 
     * @param secondi secondi da assegnare al nuovo oggetto
     */
    public Time(int secondi) {
        int[] a = converti(secondi);
        this.ore = a[0];
        this.minuti = a[1];
        this.secondi = a[2];
    }

    private int[] converti(int secondi) {
        int o = secondi / 3600;
        int m = (secondi % 3600) / 60;
        int s = (secondi % 3600) % 60;
        int[] r = { o, m, s };
        return r;
    }

    private boolean controllo(int o, int m, int s) {
        if (m > 60 || s > 60 || o > 24 || m < 0 || s < 0 || o < 0)
            return false;
        return true;
    }

    /**
     * Restituisce il numero delle ore
     * 
     * @return il numero di ore dell'oggetto Time
     */
    public int getOre() {
        return ore;
    }

    /**
     * @deprecated
     * @param ore
     */
    public void setOre(int ore) {
        this.ore = ore;
    }

    /**
     * Restituisce il numero dei minuti
     * 
     * @return il numero dei minuti dell'oggetto Time
     */
    public int getMinuti() {
        return minuti;
    }

    /**
     * @deprecated
     * @param minuti
     */
    public void setMinuti(int minuti) {
        this.minuti = minuti;
    }

    /**
     * Restituisce il numero dei secondi
     * 
     * @return il numero dei secondi dell'oggetto Time
     */
    public int getSecondi() {
        return secondi;
    }

    /**
     * @deprecated
     * @param secondi
     */
    public void setSecondi(int secondi) {
        this.secondi = secondi;
    }

    /**
     * Esprime le ore, i minuti e i secondi dell'oggetto Time in secondi. Esempio. 1
     * ora, 20 min, 10 secondi -> 4810s
     * 
     * @return il numero totale dei secondi
     */
    public int convertiSecondi() {
        return ore * 3600 + minuti * 60 + secondi;
    }

    /**
     * Vengono addizionati il numero di secondi specificati. Il tempo viene
     * normalizzato in automatico.
     * 
     * @param secondi numero di secondi da aggiungere
     */
    public void addSecondi(int secondi) {
        int[] a = converti(secondi);
        this.ore += a[0];
        this.minuti += a[1];
        this.secondi += a[2];
    }

    /**
     * Restituisce una stringa che rappresenta l'oggetto
     * 
     * @return Rappresentazione testuale dell'oggetto Time {ore:minuti:secondi}
     */
    @Override
    public String toString() {
        return "{" + ore + ":" + minuti + ":" + secondi + "}";
    }

}
