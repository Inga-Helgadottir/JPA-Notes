package dtos;
import entities.ManySide;
import entities.OneSide;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ManySideDTO {
    private int id;
    private String name;
    private OneSide oneSide;
    private List<OtherManySideDTO> otherManySides = new ArrayList<>();

    public ManySideDTO(String name) {
        this.name = name;
    }

    public static List<ManySideDTO> getDtos(List<ManySide> manySides){
        List<ManySideDTO> msdtos = new ArrayList<>();
        manySides.forEach(manySide -> msdtos.add(new ManySideDTO(manySide)));
        return msdtos;
    }

    public ManySideDTO(ManySide ms){
        if(ms != null){
            this.id = ms.getId();
            this.name = ms.getName();
            this.otherManySides = OtherManySideDTO.getDtos(ms.getOtherManySides());
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public OneSide getOneSide() {
        return oneSide;
    }

    public void setOneSide(OneSide oneSide) {
        this.oneSide = oneSide;
    }

    public List<OtherManySideDTO> getOtherManySides() {
        return otherManySides;
    }

    public void setOtherManySides(List<OtherManySideDTO> otherManySides) {
        this.otherManySides = otherManySides;
    }

    public void addToOtherManySides(OtherManySideDTO otherManySide) {
        this.otherManySides.add(otherManySide);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ManySideDTO that = (ManySideDTO) o;
        return id == that.id && name.equals(that.name) && oneSide.equals(that.oneSide) && otherManySides.equals(that.otherManySides);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, oneSide, otherManySides);
    }

    @Override
    public String toString() {
        return "ManySideDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", oneSide=" + oneSide +
                ", otherManySides=" + otherManySides +
                '}';
    }
}
