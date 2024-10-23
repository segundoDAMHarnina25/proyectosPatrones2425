package factory.creators.concrete.persian;

import factory.creators.abstrac.ArmyFactory;
import factory.products.asbtrac.Archer;
import factory.products.asbtrac.Cavalry;
import factory.products.asbtrac.Infantry;
import factory.products.asbtrac.SiegeWeapon;
import factory.products.asbtrac.WarVehicle;
import factory.products.concrete.persian.PersianArcher;
import factory.products.concrete.persian.PersianCavalry;
import factory.products.concrete.persian.PersianInfantry;
import factory.products.concrete.persian.PersianSiegeWeapon;
import factory.products.concrete.persian.PersianWarVehicle;

//Persian factory
public class PersianArmyFactory implements ArmyFactory {
 public Infantry createInfantry() {
     return new PersianInfantry();
 }

 public Cavalry createCavalry() {
     return new PersianCavalry();
 }

 public Archer createArcher() {
     return new PersianArcher();
 }

 public WarVehicle createWarVehicle() {
     return new PersianWarVehicle();
 }

 public SiegeWeapon createSiegeWeapon() {
     return new PersianSiegeWeapon();
 }
}