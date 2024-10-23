package factory.creators.builders;

import factory.creators.abstrac.ArmyFactory;
import factory.creators.concrete.asyrian.AssyrianArmyFactory;
import factory.creators.concrete.persian.PersianArmyFactory;
import factory.products.asbtrac.Army;

public class ArmyBuilder {
    public static Army createArmy(ArmyFactory factory, ArmyComposition composition) {
        ArmyCreator armyCreator = new ArmyCreator(factory, composition);
        return armyCreator.createArmy();
    }

    public static void main(String[] args) {
        // Definir la composición del ejército para los asirios y persas
        ArmyComposition assyrianComposition = new ArmyComposition(100, 50, 25, 10, 5);
        ArmyComposition persianComposition = new ArmyComposition(100, 50, 25, 10, 5);

        // Crear los ejércitos utilizando el ArmyCreator
        System.out.println("Assyrian Army:");
        Army assyrianArmy = createArmy(new AssyrianArmyFactory(), assyrianComposition);
        System.out.println(assyrianArmy);

        System.out.println("\nPersian Army:");
        Army persianArmy = createArmy(new PersianArmyFactory(), persianComposition);
        System.out.println(persianArmy);
    }
}
