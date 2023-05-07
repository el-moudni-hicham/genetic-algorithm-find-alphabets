package ma.enset.entites;

import java.util.Random;

public class Individual implements Comparable{

    // chromosome
    private char genes[] = new char[4];
    private int fitness;

    private String target = "sdia";

    private String alphabets = "abcdefghijklmnopqrstuvwxyz";

    public Individual() {
        for (int i=0 ; i < genes.length ; i++){
            genes[i] = alphabets.charAt(new Random().nextInt(alphabets.length()));
        }
    }


    public void calculateFitness(){
        fitness = 0;
        int fitnessValues[] = new int[4];
        int i = 0;
        for (int gene : genes) {
            int geneValueFromTarget = gene - target.charAt(i);
            if (geneValueFromTarget < 0) geneValueFromTarget = Math.abs(geneValueFromTarget);
            fitnessValues[i] = geneValueFromTarget;
            i ++;
        }
        for (int fv: fitnessValues) {
            fitness += fv;
        }
    }

    public int getFitness() {
        return fitness;
    }

    public char[] getGenes() {
        return genes;
    }


    @Override
    public int compareTo(Object o) {
        Individual individual = (Individual) o;
        if (this.getFitness() < ((Individual) o).getFitness()) return -1;
        else if (this.getFitness() > ((Individual) o).getFitness()) return 1;
        return 0;
    }
}
