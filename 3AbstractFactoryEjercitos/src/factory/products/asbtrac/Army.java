package factory.products.asbtrac;

import java.util.List;
import java.util.Optional;

public class Army {
    private List<Infantry> infantry;
    private List<Cavalry> cavalry;
    private List<Archer> archers;
    private List<WarVehicle> warVehicles;
    private Optional<List<SiegeWeapon>> siegeWeapons;

    public Army(List<Infantry> infantry, List<Cavalry> cavalry, List<Archer> archers, 
                List<WarVehicle> warVehicles, List<SiegeWeapon> siegeWeapons) {
        this.infantry = infantry;
        this.cavalry = cavalry;
        this.archers = archers;
        this.warVehicles = warVehicles;
        this.siegeWeapons = siegeWeapons;
    }

    public List<Infantry> getInfantry() {
        return infantry;
    }

    public List<Cavalry> getCavalry() {
        return cavalry;
    }

    public List<Archer> getArchers() {
        return archers;
    }

    public List<WarVehicle> getWarVehicles() {
        return warVehicles;
    }

    public List<SiegeWeapon> getSiegeWeapons() {
        return siegeWeapons;
    }

    @Override
    public String toString() {
        return "Army: " + infantry.size() + " Infantry, " + cavalry.size() + " Cavalry, " + 
               archers.size() + " Archers, " + warVehicles.size() + " War Vehicles, " + 
               siegeWeapons.size() + " Siege Weapons";
    }
}
