
@Service
class InvoiceService
{

    @Autowired
    private final InvoiceRepository invoiceRepository;

    //NOT NEEDED
    InvoiceService(InvoiceRepository invoiceRepository)
    {
        this.invoiceRepository = invoiceRepository;
    }

    public Invoice getInvoiceById(long id)
    {
        return invoiceRepository.getById(id)
    }

    public List<Invoice> listAll()
    {
        return invoiceRepository.getAll();
    }

    public void delete(long id)
    {
        invoiceRepository.delete(id)
    }

    public Invoice create(List<Item> itemList,Client client,float totalAmount,Date date)
    {
        Invoice invoice = new Invoice(itemList,client,totalAmount,date)
        invoiceRepository.insert(invoice);
        return invoice;
    }

    public List<Invoice> getByClientName(String Name){
        List<Invoices> invoicesList = listAll();

        return invoicesList.stream()
                .filter(i -> i.getClient().getName() == Name).collect(Collectors.toList());
    }

    public Invoice getByInvoiceNumber(long invoiceNumber){
        return invoiceRepository.getByInvoiceNumber(number);
    }

    // SORT INVOICES BY TOTAL AMOUNT, INVOICE NUMBER
    public List<Invoice> sortByTotalAmount()
    {
        List<Invoices> invoicesList = listAll();

        return invoicesList.stream()
                .sorted(Comparator.comparing(Invoice::getTotalAmount))
                .collect(Collectors.toList());
    }

    public List<Invoice> sortByNumber()
    {
        List<Invoices> invoicesList = listAll();

        return invoicesList.stream()
                .sorted(Comparator.comparing(Invoice::getId))
                .collect(Collectors.toList());
    }

    public List<Invoice> sortByDate()
    {
        List<Invoices> invoicesList = listAll();

        return invoicesList.stream()
                .sorted(Comparator.comparing(Invoice::getDueDate))
                .collect(Collectors.toList());
    }


}