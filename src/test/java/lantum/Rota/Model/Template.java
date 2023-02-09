package lantum.Rota.Model;

import lombok.Getter;
import lombok.Setter;

public class Template {
    @Getter @Setter
    public String Name;
    @Getter @Setter
    public String Site;
    @Getter @Setter
    public String Type;
    @Getter @Setter
    public String StaffType;
    @Getter @Setter
    public int NumberOfWeeks;

    public Template(String name, String site, String type, String staffType, int numberOfWeeks) {
        Name = name;
        Site = site;
        Type = type;
        StaffType = staffType;
        NumberOfWeeks = numberOfWeeks;
    }
}
