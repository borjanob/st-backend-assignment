
@Entity
class Client
{

    @Id
    private @GeneratedValue(strategy = GenerationType.IDENTITY) long Id;
    private String Name;
    private String Address;
    private String Country;

    Client(String Name, String Address, String Country){
        this.Name = Name;
        this.Address = Address;
        this.Country = Country;
    }

    public long getId() {
        return Id;
    }

    public string getName()
    {
        return Name;

    }

    public string getCountry()
    {
        return Country;

    }

    public string getAddress()
    {
        return Address;

    }


}