package factory.creators.concrete.asyrian;

import factory.creators.abstrac.ArmyFactory;
import factory.products.asbtrac.Archer;
import factory.products.asbtrac.Cavalry;
import factory.products.asbtrac.Infantry;
import factory.products.asbtrac.SiegeWeapon;
import factory.products.asbtrac.WarVehicle;
import factory.products.concrete.asyrian.AssyrianArcher;
import factory.products.concrete.asyrian.AssyrianCavalry;
import factory.products.concrete.asyrian.AssyrianInfantry;
import factory.products.concrete.asyrian.AssyrianSiegeWeapon;
import factory.products.concrete.asyrian.AssyrianWarVehicle;

//Assyrian factory
public class AssyrianArmyFactory implements ArmyFactory {
 public Infantry createInfantry() {
     return new AssyrianInfantry();
 }

 public Cavalry createCavalry() {
     return new AssyrianCavalry();
 }

 public Archer createArcher() {
     return new AssyrianArcher();
 }

 public WarVehicle createWarVehicle() {
     return new AssyrianWarVehicle();
 }

 public SiegeWeapon createSiegeWeapon() {
     return new AssyrianSiegeWeapon();
 }
}