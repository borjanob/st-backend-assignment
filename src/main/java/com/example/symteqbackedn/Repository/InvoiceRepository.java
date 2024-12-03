

interface InvoiceRepository extends JpaRepository<Invoice, Long> {

    void delete(id);

    Invoice getById(long id);

    List<Invoice> getAll();

    void insert(Invoice invoice);


}