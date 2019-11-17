package com.example.CarRental;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class CarRentalService {

    private List<Car> cars = new ArrayList<>();

    public CarRentalService() {
        cars.add(new Car("11AA22", 4, 1000));
        cars.add(new Car("33BB44", 3, 2222));
    }

    @RequestMapping(value = "/cars", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<Car> getCars() {
        return cars;
    }

    @RequestMapping(value = "/cars", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public void addCar(@RequestBody Car car) {
        cars.add(car);
    }




    @RequestMapping(value = "/cars/{plateNumber}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<Car> rentCar(@PathVariable String plateNumber) {
        Optional<Car> found = cars.stream()
                .filter(car -> car.getPlateNumber().equalsIgnoreCase(plateNumber))
                .findFirst();

        return found.isPresent() && found.get().rentCar() ?
                ResponseEntity.ok(found.get()) : ResponseEntity.notFound().build();
    }
    
    /*
    @RequestMapping(value = "/cars/{plateNumber}", method = RequestMethod.PUT)
	@ResponseStatus(HttpStatus.OK)
	public void rent(@PathVariable("plateNumber") String plateNumber) throws Exception{
			for(Car car: cars){
			if(car.getPlateNumber().equals(plateNumber)){
				car.setRent(true);
			}
		}
		return;
	}
	
	@RequestMapping(value = "/cars/{plateNumber}", method = RequestMethod.PUT)
	@ResponseStatus(HttpStatus.OK) 
	public void	rentAndGetBack(@PathVariable("plateNumber") String plateNumber,
	@RequestParam(value="rent", required = true)boolean rent) throws Exception{
		for(Car car: cars){
			if(car.getPlateNumber().equals(plateNumber)){
				car.setRent(rent);
				break;
			}
		}
		return;
		
	}
	
	@RequestMapping(value = "/cars/{plateNumber}", method = RequestMethod.PUT)
	public void rent(@PathVariable("plateNumber") String plateNumber, @RequestParam(value="rent",
	required = true)boolean rent, @RequestBody String dates){
		for(Car car: cars){
			if(car.getPlateNumber().equals(plateNumber)){
				car.setRent(rent);
			}
		}
		Rent rent1 = new Rent(plateNumber, dates, dates);
		System.out.println(rent1);
		rents.add(rent1);
	}
	*/
}