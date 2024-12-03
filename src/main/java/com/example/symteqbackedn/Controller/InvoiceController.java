// COULD NOT RESOLVE DEPENDENCIES DOWNLOAD WAS TAKING TOO LONG
//

@RestController
class InvoiceController
{

    private final ClientService clientService;
    private final InvoiceService invoiceService;
    private final ItemService itemService;

    EmployeeController(lientService clientService,
            InvoiceService invoiceService,
            ItemService itemService)

    {
        this.clientService = clientService;
        this.invoiceService = invoiceService;
        this.itemService = itemService;
    }


    @GetMapping("/invoices")
    List<Invoice> listAllInvoices()
    {
        return invoiceService.listAll();
    }

    @DeleteMapping("/delete/{id}")
    void deleteInvoice(@PathVariable long id )
    {
        invoiceService.delete(id)
    }


    // UNIQUE INVOICE ID IS AUTO GENERATED
    @PostMapping("/create")
    Invoice createInvoice(@RequestParam Client client, @RequestParam List<Item> itemList, @RequestParam float totalAmount,
                       @RequestParam LocalDate date)
    {
        Invoice invoice = new Invoice(itemList,client,totalAmount);
        invoiceService.create(invoice);
        return invoice;
    }


    @PostMapping("/update/{id}")
    Invoice updateInvoice(@PathVariable long id,@RequestParam Client client, @RequestParam List<Item> itemList, @RequestParam float totalAmount,
                       @RequestParam LocalDate date)
    {

        Invoice invoice = null;

        try{
            invoice = invoiceService.get(id);
            invoiceService.update(id,client,itemList,totalAmount);
        }
        catch (e)
        {
            System.out.println("Invoice Id doesnt exist in db!");
        }
        return invoice;
    }

    @GetMapping("/search/{name}")
    List<Invoice> searchByClient(@PathVariable String name)
    {
        List<Invoice> invoiceList = null;

        try{
            invoiceList = invoiceService.getByClientName(name);
        }
        catch (e)
        {
            System.out.println("No invoices for that client");
        }
        return invoiceList;

    }


}