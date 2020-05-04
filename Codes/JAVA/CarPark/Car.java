package CarPark;

public class Car 
{
    private
        String carBrand;
        String carType;
        String plateNumber;
    
    public

        Car(){}
        
        Car(String carBrand,String carType,String plateNumber)
        {
            this.carBrand = carBrand;
            this.carType = carType;
            this.plateNumber = plateNumber;
        }

        String getCarBrand()
        {
            return carBrand;
        }

        void setCarBrand(String carBrand)
        {
            this.carBrand = carBrand;
        }

        String getCarType()
        {
            return carType;
        }

        void setCarType(String carType)
        {
            this.carType = carType;
        }

        String getPlateNumber()
        {
            return plateNumber;
        }

        void setPlateNumber(String plateNumber)
        {
            this.plateNumber = plateNumber;
        }
    
    public String toString()
    {
        return "Car: " + carBrand + ", Type: " + carType + ", Plate: " + plateNumber;
    }

        

}