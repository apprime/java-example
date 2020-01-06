package com.javaexample.box;

import com.javaexample.infrastructure.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.Collection;

public class BoxService {

    @Autowired
    private Repository<Box> repository;

    public Box Create(Box box){
        box.setCost(BoxCostCalculator.Calculate(box));
        repository.Create(box);
        return box;
    }

    public Collection<Box> List() {
        Collection<Box> result = repository.Read();
        return result;
    }
}
