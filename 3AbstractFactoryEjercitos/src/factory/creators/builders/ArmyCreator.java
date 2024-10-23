package factory.creators.builders;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import factory.creators.abstrac.ArmyFactory;
import factory.products.asbtrac.Archer;
import factory.products.asbtrac.Army;
import factory.products.asbtrac.Cavalry;
import factory.products.asbtrac.Infantry;
import factory.products.asbtrac.SiegeWeapon;
import factory.products.asbtrac.WarVehicle;

public class ArmyCreator {
    private ArmyFactory factory;
    private ArmyComposition composition;

    public ArmyCreator(ArmyFactory factory, ArmyComposition composition) {
        this.factory = factory;
        this.composition = composition;
    }

    public Army createArmy() {
        List<Infantry> infantry = IntStream.range(0, composition.getInfantryCount())
                                           .mapToObj(i -> factory.createInfantry())
                                           .collect(Collectors.toList());

        List<Cavalry> cavalry = IntStream.range(0, composition.getCavalryCount())
                                         .mapToObj(i -> factory.createCavalry())
                                         .collect(Collectors.toList());

        List<Archer> archers = IntStream.range(0, composition.getArcherCount())
                                        .mapToObj(i -> factory.createArcher())
                                        .collect(Collectors.toList());

        List<WarVehicle> warVehicles = IntStream.range(0, composition.getWarVehicleCount())
                                                .mapToObj(i -> factory.createWarVehicle())
                                                .collect(Collectors.toList());

        List<SiegeWeapon> siegeWeapons = IntStream.range(0, composition.getSiegeWeaponCount())
                                                  .mapToObj(i -> factory.createSiegeWeapon())
                                                  .collect(Collectors.toList());

        return new Army(infantry, cavalry, archers, warVehicles, siegeWeapons);
    }
}
