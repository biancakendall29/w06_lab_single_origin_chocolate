package com.bnta.chocolate.components;

import com.bnta.chocolate.models.Chocolate;
import com.bnta.chocolate.models.Estate;
import com.bnta.chocolate.repositories.ChocolateRepository;
import com.bnta.chocolate.repositories.EstateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class Dataloader implements ApplicationRunner {

    @Autowired
    ChocolateRepository chocolateRepository;

    @Autowired
    EstateRepository estateRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        Estate estate1 = new Estate("Lindt", "Switzerland");
        estateRepository.save(estate1);
        Estate estate2 = new Estate("Cadbury", "England");
        estateRepository.save(estate2);
        Estate estate3 = new Estate("Hershey's", "USA");
        estateRepository.save(estate3);

        Chocolate choc1 = new Chocolate("Excellence Dark Sea Salt", 47, estate1);
        chocolateRepository.save(choc1);
        Chocolate choc2 = new Chocolate("Excellence Dark 90% Cocoa", 90, estate1);
        chocolateRepository.save(choc2);
        Chocolate choc3 = new Chocolate("Dairy Milk Top Deck", 20, estate2);
        chocolateRepository.save(choc3);
        Chocolate choc4 = new Chocolate("Hershey's Milk Chocolate", 30, estate3);
        chocolateRepository.save(choc4);
        Chocolate choc5 = new Chocolate("Hershey's Extra Dark", 60, estate3);
        chocolateRepository.save(choc5);

    }
}
