public class Order {
    private final String type; // Assiette, Sandwich
    private final String name; // Nom du repas
    private final String beverage; // Nom de la boisson
    private final String beverageSize; // Taille de la boisson
    private final String dessert; // Nom du dessert
    private final String dessertSize; // Taille du dessert
    private final String haveCoffee; // A commander un café

    public Order(String type, String name, String beverage, String beverageSize, String dessert, String dessertSize, String haveCoffee) {
        this.type = type;
        this.name = name;
        this.beverage = beverage;
        this.beverageSize = beverageSize;
        this.dessert = dessert;
        this.dessertSize = dessertSize;
        this.haveCoffee = haveCoffee;
    }

    // #region Price
    private int priceAssiette() {
        return 15;
    }

    private int priceSandwich() {
        return 10;
    }

    private int priceSmallBeverage() {
        return 2;
    }

    private int priceMediumBeverage() {
        return 3;
    }

    private int priceLargeBeverage() {
        return 4;
    }

    private int priceDessertNormal() {
        return 2;
    }

    private int priceDessertSpecial() {
        return 4;
    }

    private int priceAssietteFormulaStandard() {
        System.out.print("Prix Formule Standard appliquée ");
        return 18;
    }

    private int priceSandwichFormulaStandard() {
        System.out.print("Prix Formule Standard appliquée ");
        return 13;
    }

    private int priceAssietteFormulaMax() {
        System.out.print("Prix Formule Max appliquée ");
        return 21;
    }

    private int priceSandwichFormulaMax() {
        System.out.print("Prix Formule Max appliquée ");
        return 16;
    }
    // #endregion Price

    // #region Formula
    private boolean isAssietteFormulaStandard() {
        return type.equals("assiette") && beverageSize.equals("moyen") && dessertSize.equals("normal");
    }

    private boolean isAssietteFormulaMax() {
        return type.equals("assiette") && beverageSize.equals("grand") && dessertSize.equals("special");
    }

    private boolean isSandwichFormulaStandard() {
        return type.equals("sandwich") && beverageSize.equals("moyen") && dessertSize.equals("normal");
    }

    private boolean isSandwichFormulaMax() {
        return type.equals("sandwich") && beverageSize.equals("grand") && dessertSize.equals("special");
    }
    // #endregion Formula

    // calcule le prix payé par l'utilisateur dans le restaurant, en fonction de type de
    // repas qu'il prend (assiette ou sandwich), de la taille de la boisson (petit, moyen, grand), du dessert et
    // de son type (normal ou special) et si il prend un café ou pas (yes ou no).
    // les prix sont fixes pour chaque type de chose mais des réductions peuvent s'appliquer
    // si cela rentre dans une formule!
    public int getPrice() {
        // le type ne peut être vide car le client doit déclarer au moins un repas
        if (type == null || name == null || type.isEmpty() || name.isEmpty()) return -1;

        // prix total à payer pour le client
        int total = 0;

        // Assiette custom
        if (type.equals("assiette")) {
            total += priceAssiette();
        } else if (type.equals("sandwich")) {
            total += priceSandwich();
        }

        if (beverageSize.equals("petit")) {
            total += priceSmallBeverage();
        } else if (beverageSize.equals("moyen")) {
            total += priceMediumBeverage();
        } else if (beverageSize.equals("grand")) {
            total += priceLargeBeverage();
        }

        if (dessertSize.equals("normal")) {
            total += priceDessertNormal();
        }
        if (dessertSize.equals("special")) {
            total += priceDessertSpecial();
        }

        // Formule
        if (isAssietteFormulaStandard()) {
            total = priceAssietteFormulaStandard();
        }

        if (isAssietteFormulaMax()) {
            total = priceAssietteFormulaMax();
        }

        if (isSandwichFormulaStandard()) {
            total = priceSandwichFormulaStandard();
        }

        if (isSandwichFormulaMax()) {
            total = priceSandwichFormulaMax();
        }

        // Café
        if (isAssietteFormulaStandard() && haveCoffee.equals("yes")) {
            System.out.print(" avec café offert!");
            return total;
        }

        if (!haveCoffee.equals("yes")) {
            total += 1;
        }

        return total;
    }
}