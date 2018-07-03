package com.synerzip.college.repository;

import com.synerzip.college.model.Car;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace=AutoConfigureTestDatabase.Replace.NONE)
public class CarRepositoryTest {

    @Autowired
    private TestEntityManager testEntityManager;

    @Autowired
    CarRepository carRepository;

    @Test
    public void getCar_returnCarDetails() throws Exception {
        Car savedCar = testEntityManager.persistAndFlush(new Car(1l,"IIT","central"));
        Car car = carRepository.findByName("IIT");
        Assertions.assertThat(car.getName()).isEqualTo("IIT");
    }
}
