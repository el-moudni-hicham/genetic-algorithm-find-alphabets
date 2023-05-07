package ma.enset.entites;

import java.util.*;

public class Population {
    ArrayList<Individual> individuals = new ArrayList<>();
    Individual firstFitness;
    Individual secondFitness;
    private static int populaion = 20;
    private String target = "sdia";

    Random random = new Random();

    public void initializePopulation(){
        for (int i = 0; i < populaion ; i++) {
            individuals.add(new Individual());
        }
    }

    public void calculateIndividualFitnessValue(){
        for (int i = 0; i < populaion; i++) {
            individuals.get(i).calculateFitness();
        }
    }

    public void sortPoplation(){
        Collections.sort(individuals);
    }
    public void selection(){
        firstFitness = individuals.get(0);
        secondFitness = individuals.get(1);
    }


    public void crossover(){
        int crossoverPoint = 1 + new Random().nextInt(4);

        Individual individual1 = new Individual();
        Individual individual2 = new Individual();

        for (int i = 0; i < individual1.getGenes().length; i++) {
            individual1.getGenes()[i] = firstFitness.getGenes()[i];
            individual2.getGenes()[i] = secondFitness.getGenes()[i];
        }

        for (int i = 0; i < crossoverPoint; i++) {
            individual1.getGenes()[i] = secondFitness.getGenes()[i];
            individual2.getGenes()[i] = firstFitness.getGenes()[i];
        }

        individuals.set(0, individual1);
        individuals.set(1, individual2);

        //System.out.println("Crossover Point : " + crossoverPoint);
    }

    public void mutation(){
        int index = random.nextInt(4);
        for (int i = 0; i <target.length(); i++) {
            if(individuals.get(0).getGenes()[index] != target.charAt(i))
                individuals.get(0).getGenes()[index] = target.charAt(random.nextInt(4));

            index = random.nextInt(4);
            if(individuals.get(1).getGenes()[index] != target.charAt(i))
                individuals.get(1).getGenes()[index] = target.charAt(random.nextInt(4));
        }
    }

    public ArrayList<Individual> getIndividuals() {
        return individuals;
    }

    public Individual getBestIndividual(){
        return individuals.get(0);
    }
}
