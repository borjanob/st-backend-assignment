
@Service
class ClientService
{
    @Autowired
    private final ClientRepository clientRepository;

    ClientService(ClientRepository clientRepository) {

        this.clientRepository = clientRepository;
    }


    public Client getClientById(long id)
    {
        return clientRepository.getById(id);
    }

}

