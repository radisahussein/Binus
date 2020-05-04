package CarPark;

import java.util.ArrayList;
import java.util.List;

public class Parking 
{
    private
        List<Car> parkedCars;   

    public
        Parking()
        {
            this.parkedCars = new ArrayList<Car>();
        }

        int numberOfCars()
        {
            return parkedCars.size();
        }

        boolean isFull()
        {
            if(numberOfCars() == 20)
            {
                return true;
            }

            else
            {
                return false;
            }
        }

        void addCar(Car car)
        {
            parkedCars.add(car);
        }

        void removeCar(String plateNumber)
        {
            for(int i = 0; i < numberOfCars(); i++)
            {
                if(getCar(i).getPlateNumber().equals(plateNumber))
                {
                    parkedCars.remove(i);
                }
            }

        }

        Car getCar(int index)
        {
            return parkedCars.get(index);
        }

        void showAllCars()
        {
            for (int i = 0; i < numberOfCars(); i++)
            {
                System.out.println((i+1) + ". " + getCar(i));
            }
        }

      

        boolean checkPlate(String plateNumber)
        {
            for (int i = 0; i < numberOfCars(); i++)
            {
                if (getCar(i).getPlateNumber().equals(plateNumber))
                {
                    return true;
                }

                
            }

            return false;
        }


 


        
}