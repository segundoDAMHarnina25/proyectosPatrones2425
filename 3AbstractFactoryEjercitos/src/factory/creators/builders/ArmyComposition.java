package factory.creators.builders;

//Class for ArmyComposition
public class ArmyComposition {
 private int infantryCount;
 private int cavalryCount;
 private int archerCount;
 private int warVehicleCount;
 private int siegeWeaponCount;

 public ArmyComposition(int infantryCount, int cavalryCount, int archerCount, 
                        int warVehicleCount, int siegeWeaponCount) {
     this.infantryCount = infantryCount;
     this.cavalryCount = cavalryCount;
     this.archerCount = archerCount;
     this.warVehicleCount = warVehicleCount;
     this.siegeWeaponCount = siegeWeaponCount;
 }

 public int getInfantryCount() {
     return infantryCount;
 }

 public int getCavalryCount() {
     return cavalryCount;
 }

 public int getArcherCount() {
     return archerCount;
 }

 public int getWarVehicleCount() {
     return warVehicleCount;
 }

 public int getSiegeWeaponCount() {
     return siegeWeaponCount;
 }
}