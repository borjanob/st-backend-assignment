class InvoiceService
{

    private final InvoiceRepository invoiceRepository;

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

    public void create(Invoice invoice)
    {
        invoiceRepository.insert(invoice);
    }

    public List<Invoice> getByClientName(String Name){
        List<Invoices> invoicesList = listAll();

        return invoicesList.stream()
                .filter(i -> i.getClient().getName() == Name).collect(Collectors.toList());
    }

    // SORT INVOICES BY TOTAL AMOUNT
    public List<Invoice> sortByTotalAmount()
    {
        List<Invoices> invoicesList = listAll();

        return invoicesList.stream()
                .sorted(Comparator.comparing(Invoice::getTotalAmount))
                .collect(Collectors.toList());
    }


}