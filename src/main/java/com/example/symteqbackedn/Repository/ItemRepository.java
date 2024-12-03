public interface ItemRepository extends JpaRepository<Item, Long> {
    
    Item getById(long id);
}