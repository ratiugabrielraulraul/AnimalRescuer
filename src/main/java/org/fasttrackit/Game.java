package org.fasttrackit;

//import jdk.nashorn.internal.ir.RuntimeNode;
import org.fasttrackit.domain.Animal;
import org.fasttrackit.persistence.AnimalRepository;
//import org.fasttrackit.service.AnimalService;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.*;

public class Game {

    private Animal animal;
    private Adopter adopter;

    private List<Animal> availableAnimal = new ArrayList<>();
    private List<Food> availableFood = new ArrayList<>();

    private RecreationActivity[] recreationActivities = new RecreationActivity[2];
    private int animalNumber;
    private int foodNumber;
    private int recreationActivityNumber;
    private int i = 0;

    public void start() throws SQLException, IOException, ClassNotFoundException {
        initMessages();
        requireAnimal();
        nameAnimal();
        initRescuer();
        initFoods();
        initRecreationActivities();
        feedOrActivity();

    }
//fa ca si la initFoods , plus creaza o noua proprietate availableAnimals
    //dupa creaza o metoda noua requireAnimal in care sa iterezi peste availableAnimals si sa il lasi pe jucator sa aleaga
    //la finalul metodei ii vei atribuii this.animal animalul ales de jucator
    private void initAnimal() {
        this.animal = new Animal();
        this.animal.setAge(20);
        this.animal.setHealthStatus(10);
        this.animal.setHunger(10);
        this.animal.setMood(10);
        this.animal.setSpiritMood("good");
        this.animal.setFavoriteActivity("Being near a human");
        this.animal.setFavoriteFood("milk");
    }

    private void initRescuer() {
        this.adopter = new Adopter();

        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Choose your name: ");
            while (!scanner.hasNext("[a-zA-Z]")) {
                System.out.println("That's not a name");
                scanner.next();
            }
            this.adopter.setName(scanner.nextLine());
            System.out.println("Adopter with the name of " + this.adopter.getName() + " has been created");
        } catch (IllegalStateException | NoSuchElementException e) {
            initRescuer();
        }
    }

    private void requireAnimal() throws SQLException, IOException, ClassNotFoundException {
        AnimalRepository animalRepository = new AnimalRepository();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the name of your animal: ");

        while (! scanner.hasNext("[a-zA-Z]")) {
            System.out.println("Please enter a valid name");
            scanner.next();
        }

        this.animal = animalRepository.getAnimal(scanner.nextLine());
        if (this.animal == null) {
            initAnimal();
            nameAnimal();
            animalRepository.createAnimal(this.animal.getName(), this.animal.getAge(), this.animal.getHealthStatus(),
                    this.animal.getHunger(), this.animal.getMood(), this.animal.getFavoriteActivity(),
                    this.animal.getFavoriteFood(), this.animal.getSpiritMood());
        }
        this.animal = animalRepository.getAnimal(animal.getName());
    }

    private void requireFeeding() {
        System.out.println("The types of food that we have are");
        int a = 0;
        for(Food food : this.availableFood) {
            System.out.println(a + " - " + food.getName());
            a++;
        }
        askForInput();
        Scanner scanner = new Scanner(System.in);
        try {
            this.foodNumber = scanner.nextInt();
            System.out.println("You have chosen " + this.availableFood.get(this.foodNumber).getName());
            this.adopter.feed(this.animal, this.availableFood.get(this.foodNumber));
        } catch (IllegalStateException | NoSuchElementException e) {
            this.foodNumber = -1;
            System.out.println("You have not chosen any food! Your animal will starve");
        }
    }

    private void askForInput() {
        System.out.println("Please choose one: ");
        System.out.println("To cancel please enter any letter: ");
    }

    private void requireActivity() {
        System.out.println("The types of recreation activities that we have are:  ");
        for (int i = 0; i< this.recreationActivities.length; i++) {
            System.out.println(i + " - " + this.recreationActivities[i].getName());
        }
        Scanner scanner = new Scanner(System.in);
        askForInput();
        try {
            this.recreationActivityNumber = scanner.nextInt();
            System.out.println("You have chosen " + this.recreationActivities[this.recreationActivityNumber].getName());
            this.adopter.play(this.recreationActivities[this.recreationActivityNumber], this.animal);
        } catch (IllegalStateException | NoSuchElementException e) {
            this.recreationActivityNumber = -1;
            System.out.println("You have not chosen any activity! Your animal won't be happy");
        }
    }

    private void initRecreationActivities() {
        RecreationActivity running = new RecreationActivity("running", "Hill");
        RecreationActivity ballCatching = new RecreationActivity("ball catching", "garden");

        this.recreationActivities[0] = running;
        this.recreationActivities[1] = ballCatching;
    }

    private void initFoods() {
        Food pedigree = new Food();
        pedigree.setExpirationDate(LocalDate.of((2019), (11), (3)));
        pedigree.setPrice(5.73);
        pedigree.setStock(true);
        pedigree.setQuantity(35);
        pedigree.setName("pedigree");

        Food seeds = new Food();
        seeds.setExpirationDate(LocalDate.of(2019, 11, 3));
        seeds.setPrice(3.50);
        seeds.setStock(true);
        seeds.setQuantity(54);
        seeds.setName("seeds");

        Food milk = new Food();
        milk.setExpirationDate(LocalDate.of(2019, 10, 14));
        milk.setPrice(5.50);
        milk.setStock(true);
        milk.setQuantity(100);
        milk.setName("Milk");

        this.availableFood.add(pedigree);
        this.availableFood.add(seeds);
        this.availableFood.add(milk);
    }

    private void nameAnimal()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please choose the name of the rescued animal: ");

        while (!scanner.hasNext("[a-zA-Z]")) {
            System.out.println("That's not a valid name");
            scanner.next();
        }
        this.animal.setName(scanner.nextLine());
    }


    private void feedOrActivity() throws SQLException, IOException, ClassNotFoundException {
        AnimalRepository animalRepository = new AnimalRepository();
        Animal animalRepo = animalRepository.getAnimal(this.animal.getName());
        Random random = new Random();
        for (; this.i <= 15; this.i++) {
            System.out.println("Round " + i + " starts out of 15");
            System.out.println("Your animal has: \n" +
                    "hunger:" + this.animal.getHunger() + "\n" +
                    "spirit_mood:" + this.animal.getSpiritMood() + "\n" +
                    "mood:" + this.animal.getMood() + "\n" );

            //if i is even
               if ((i & 1) == 0) {
                   requireFeeding();
                   //if number of the round is 2 do this
                   if (i == 2) {
                       int hunger = this.animal.getHunger() - random.nextInt(3);
                       animalRepository.updateAnimal(animalRepo.getId(), this.animal.getName(), hunger, this.animal.getMood());
                       this.animal.setHunger(hunger);
                   }
                   // if user has chosen a food then we decrease food level
                   if (this.foodNumber >= 0) {
                       animalRepository.updateAnimal(animalRepo.getId(),
                               this.animal.getName(),
                               this.animal.getHunger() - random.nextInt(3),
                               this.animal.getMood());
                       this.animal.setHunger(this.animal.getHunger() - random.nextInt(3));
                   } else {
                       animalRepository.updateAnimal(animalRepo.getId(),
                               this.animal.getName(),
                               this.animal.getHunger() + random.nextInt(4),
                               this.animal.getMood());
                       this.animal.setHunger(this.animal.getHunger() + random.nextInt(4));
                   }
               } else {
                   requireActivity();
                   if (i == 2) {
                       animalRepository.updateAnimal(animalRepo.getId(),
                               this.animal.getName(),
                               this.animal.getHunger(),
                               this.animal.getMood() - random.nextInt(3));
                       this.animal.setMood(this.animal.getMood() - random.nextInt(3));
                   }
                   //if user has chosen an activity we increase mood && we increase hunger
                   if (this.recreationActivityNumber >= 0) {
                       animalRepository.updateAnimal(animalRepo.getId(),
                               this.animal.getName(),
                               this.animal.getHunger() + random.nextInt(2),
                               this.animal.getMood() + random.nextInt(3));
                       this.animal.setMood(this.animal.getMood() + random.nextInt(3));
                       this.animal.setHunger(this.animal.getHunger() + random.nextInt(2));
                   } else {
                       animalRepository.updateAnimal(animalRepo.getId(),
                               this.animal.getName(),
                               this.animal.getHunger(),
                               this.animal.getMood() - random.nextInt(3));
                       this.animal.setMood(this.animal.getMood() - random.nextInt(2));
                   }
               }
               updateSpiritMood();
            if (checkIfGameIsEnded()) {
                break;
            }
        }
    }

    private boolean checkIfGameIsEnded() {
        if (this.animal.getHunger() >= 20) {
            System.out.println("This game has ended your animal reached mood " + this.animal.getMood() + " and food level " + this.animal.getHunger());
            return true;
        }
        if (this.animal.getMood() < 0) {
            System.out.println("This game has ended your animal reached mood " + this.animal.getMood() + " and food level " + this.animal.getHunger());
            return true;
        }
        return false;
    }

    private void updateSpiritMood(){

        if (this.animal.getMood() < 5) {
            this.animal.setSpiritMood("sad");

        }else if (this.animal.getMood()>7 && this.animal.getMood()<10) {
            this.animal.setSpiritMood("happy");
        }else {
            this.animal.setSpiritMood("very happy");
        }
    }

    private void initMessages() {
        System.out.println("Game has started");
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public Adopter getAdopter() {
        return adopter;
    }

    public void setAdopter(Adopter adopter) {
        this.adopter = adopter;
    }

    public RecreationActivity[] getRecreationActivities() {
        return recreationActivities;
    }

    public void setRecreationActivities(RecreationActivity[] recreationActivities) {
        this.recreationActivities = recreationActivities;
    }

}
