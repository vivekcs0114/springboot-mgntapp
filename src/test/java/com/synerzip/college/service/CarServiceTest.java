package com.synerzip.college.service;

import com.synerzip.college.exception.CarNotFoundException;
import com.synerzip.college.model.Car;
import com.synerzip.college.repository.CarRepository;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class CarServiceTest {

    @Mock
    private CarRepository carRepository;

    private CarService carService;

    @Before
    public void setup()throws Exception {
        carService = new CarService(carRepository);
    }

    @Test
    public void getCar_shouldReturnCar() throws  Exception {
        BDDMockito.given(carRepository.findByName("IIT")).willReturn(new Car(1l,"IIT", "central"));

        Car car = carService.getCarDetails("IIT");
        Assertions.assertThat(car.getName()).isEqualTo("IIT");
        Assertions.assertThat(car.getType()).isEqualTo("central");
    }

    @Test(expected = CarNotFoundException.class)
    public void getCarDetails_whenCarNotFound() throws  Exception {
        BDDMockito.given(carRepository.findByName("IIT")).willReturn(null);
        carService.getCarDetails("IIT");
    }
}
