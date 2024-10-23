package factory.creators.abstrac;

import factory.products.asbtrac.Archer;
import factory.products.asbtrac.Cavalry;
import factory.products.asbtrac.Infantry;
import factory.products.asbtrac.SiegeWeapon;
import factory.products.asbtrac.WarVehicle;

//Interface for ArmyFactory
public interface ArmyFactory {
 Infantry createInfantry();
 Cavalry createCavalry();
 Archer createArcher();
 WarVehicle createWarVehicle();
 SiegeWeapon createSiegeWeapon();
}

