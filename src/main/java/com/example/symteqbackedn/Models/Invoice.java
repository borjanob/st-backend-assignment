
@Entity
class Invoice
{
    @Id
    private @GeneratedValue(strategy = GenerationType.IDENTITY) long Id;

    @ManyToMany
    private List<Item> itemsList;

    @OneToMany
    private Client client;

    private float totalAmount;

    Invoice(List<Item> itemsList, Client client, float totalAmount)
    {
        this.itemsList = itemsList;
        this.client = client;
        this.totalAmount = totalAmount;
    }

    public List<Item> getItemsList() {
        return itemsList;
    }

    public Client getClient() {
        return client;
    }

    public float getTotalAmount() {
        return totalAmount;
    }

    public long getId() {
        return Id;
    }
}