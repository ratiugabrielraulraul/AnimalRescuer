package org.fasttrackit.service;

import org.fasttrackit.domain.Animal;
import org.fasttrackit.transfer.UpdateAnimalRequest;
import org.fasttrackit.persistence.AnimalRepository;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class AnimalService {
    private AnimalRepository animalRepository = new AnimalRepository();

    public void createAnimal(Animal request) throws SQLException, IOException, ClassNotFoundException {
        System.out.println("Creating animal..." + request);
        animalRepository.createAnimal(request.getName(),request.getAge(), request.getHealthStatus(),
                request.getHunger(),request.getMood(),request.getFavoriteActivity(),request.getFavoriteFood(),request.getSpiritMood());
    }
    public List<Animal>getAnimal() throws SQLException, IOException, ClassNotFoundException {
        System.out.println("Retrieving animal...");
        return animalRepository .getAnimal();
    }

    public Animal getAnimal(String name) throws SQLException, IOException, ClassNotFoundException {
        System.out.println("Retrieving animal..." + name);
      return animalRepository.getAnimal(name);
        
    }
    public void UpdateAnimal(long id, UpdateAnimalRequest request) throws SQLException, IOException, ClassNotFoundException {
        System.out.println("Updating animal..." + id + "id" + request);
//        animalRepository.updateAnimal(id,request.getName());


    }
    public void deleteAnimal(long id) throws SQLException, IOException, ClassNotFoundException {
        System.out.println("Deleteting animal..." );
        animalRepository.deleteAnimal(id);
}


}
