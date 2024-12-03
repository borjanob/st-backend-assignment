
@Service
class ItemService{

    @Autowired
    private final ItemRepository itemRepository;

    ClientService(ItemRepository itemRepository) {

        this.itemRepository = itemRepository;
    }


    public Item getItemById(int id)
    {
        return itemRepository.getById(id);
    }

}