

public interface ClientRepository extends JpaRepository<Client, Long> {

    Client getById(long id);
}