package com.synerzip.college.controller;

import com.synerzip.college.exception.CarNotFoundException;
import com.synerzip.college.model.Car;
import com.synerzip.college.service.CarService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@RunWith(SpringRunner.class)
@WebMvcTest(CollegeController.class)
public class CollegeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    CarService service;

    @Test
    public void getCar_shouldReturnCar() throws  Exception {
        BDDMockito.given(service.getCarDetails(ArgumentMatchers.anyString())).willReturn(new Car(1l,"IIT", "central"));
        mockMvc.perform(MockMvcRequestBuilders.get("/colleges/IIT"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("name").value("IIT"))
                .andExpect(MockMvcResultMatchers.jsonPath("type").value("central"));
    }

    @Test
    public void getCar_notFound() throws  Exception {
        BDDMockito.given(service.getCarDetails(ArgumentMatchers.anyString())).willThrow(new CarNotFoundException());
        mockMvc.perform(MockMvcRequestBuilders.get("/colleges/IIT"))
                .andExpect(MockMvcResultMatchers.status().isNotFound());
    }


}
