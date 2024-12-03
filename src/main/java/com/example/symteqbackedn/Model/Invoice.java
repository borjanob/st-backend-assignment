
@Entity
@Data
class Invoice
{
    @Id
    private @GeneratedValue(strategy = GenerationType.IDENTITY) long Id;

    private @GeneratedValue(strategy = GenerationType.IDENTITY) long invoiceNumber

    @ManyToMany
    private List<Item> itemsList;

    @OneToMany
    private Client client;

    private float totalAmount;

    private Date dueDate;

    Invoice(List<Item> itemsList, Client client, float totalAmount, Date date)
    {
        this.itemsList = itemsList;
        this.client = client;
        this.totalAmount = totalAmount;
        this.dueDate = date;
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

    public Date getDueDate() {
        return dueDate;
    }

    public long getInvoiceNumber() {
        return invoiceNumber;
    }
}