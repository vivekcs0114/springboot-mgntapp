package com.synerzip.college.caching;

import com.synerzip.college.model.Car;
import com.synerzip.college.repository.CarRepository;
import com.synerzip.college.service.CarService;
import jdk.internal.org.objectweb.asm.util.CheckClassAdapter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@AutoConfigureTestDatabase
public class CachingTest {

    @Autowired
    CarService carService;

    @Autowired
    CarRepository carRepository;

    @Test
    public void caching() throws Exception {
        BDDMockito.given(carRepository.findByName(ArgumentMatchers.anyString())).willReturn(new Car(1l,"IIT", "central"));
        carService.getCarDetails("IIT");
        carService.getCarDetails("IIT");
        Mockito.verify(carRepository, Mockito.times(1)).findByName("IIT");
    }
}
