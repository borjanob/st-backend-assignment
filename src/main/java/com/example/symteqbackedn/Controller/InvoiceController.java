// COULD NOT RESOLVE DEPENDENCIES DOWNLOAD DIDNT FINISH
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
        try{
            invoiceService.delete(id)
        }
        catch (Exception e)
        {
            System.out.println("Invoice with id: "+ id +" not present in db");
        }
    }


    // UNIQUE INVOICE ID IS AUTO GENERATED
    @PostMapping("/create")
    Invoice createInvoice(@RequestParam Client client, @RequestParam List<Item> itemList, @RequestParam float totalAmount,
                       @RequestParam Date date)
    {

        return invoiceService.create(itemList,client,totalAmount,date);
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
        catch (Exception e)
        {
            System.out.println("Invoice with id: "+ id +" not present in db");
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
        catch (Exception e)
        {
            System.out.println("No invoices for that client");
        }
        return invoiceList;

    }

    @GetMapping("/search/{invoice_number}")
    Invoice searchByInvoiceNumber(@PathVariable long invoiceNumber)
    {
        Invoice invoice = null;

        try{
            invoice = invoiceService.getByInvoiceNumber(name);
        }
        catch (Exception e)
        {
            System.out.println("No invoices with invoice number: " + invoiceNumber);
        }
        return invoice;

    }
}