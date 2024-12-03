

interface InvoiceRepository extends JpaRepository<Invoice, Long> {

    void delete(long id);

    Invoice getById(long id);

    List<Invoice> getAll();

    void insert(Invoice invoice);

    @Query("SELECT * FROM Invoice WHERE invoiceNumber = :number")
    Invoice getByInvoiceNumber(float number);

}