
@Entity
class Item
{

    @Id
    private @GeneratedValue(strategy = GenerationType.IDENTITY) Id;
    //private
    private int Quantity;
    private float Amount;

    public Item(int quantity, float amount) {
        Quantity = quantity;
        Amount = amount;
    }

    public int getQuantity() {
        return Quantity;
    }

    public float getAmount() {
        return Amount;
    }
}