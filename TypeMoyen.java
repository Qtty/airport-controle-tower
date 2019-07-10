
public enum TypeMoyen
{
    VOI("VOI"),
    CAM("CAM"),
    BUS("BUS"),
    AVI("AVI");

    private String type = "";

    TypeMoyen(String type)
    {
        this.type = type;
    }

    public String toString()
    {
        return type;
    }
}