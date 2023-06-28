package lab6.model;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Dragon implements Serializable {
    private static final long serialVersionUID = 6529685098267757690L-1l;
    private Integer id;
    private String name;
    private Coordinates coordinates;
    private LocalDateTime creationDate;
    private Integer age;
    private String description;
    private Double wingspan;
    private DragonCharacter character;
    private DragonCave cave;
    private User owner;

    public Dragon() {
    }
    
    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public Dragon(
            Integer id,
            String name,
            Coordinates coordinates,
            LocalDateTime creationDate,
            Integer age,
            String description,
            Double wingspan,
            DragonCharacter character,
            DragonCave cave,
            User owner
    ) {
        validateParameters(id, name, coordinates, creationDate, age, description, wingspan, character, cave);

        this.id = id;
        this.name = name;
        this.coordinates = coordinates;
        this.creationDate = creationDate;
        this.age = age;
        this.description = description;
        this.wingspan = wingspan;
        this.character = character;
        this.cave = cave;
        this.owner = owner;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public Integer getAge() {
        return age;
    }

    public String getDescription() {
        return description;
    }

    public Double getWingspan() {
        return wingspan;
    }

    public DragonCharacter getCharacter() {
        return character;
    }

    public DragonCave getCave() {
        return cave;
    }

    private static void validateParameters(
            Integer id,
            String name,
            Coordinates coordinates,
            LocalDateTime creationDate,
            Integer age,
            String description,
            Double wingspan,
            DragonCharacter character,
            DragonCave cave
    ) {

        if (name == null) {
            throw new NullPointerException("Name cannot be null");
        }
        if (name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty string");
        }

        if (coordinates == null) {
            throw new NullPointerException("Coordinates cannot be null");
        }

        if (age == null) {
            throw new NullPointerException("Age cannot be null");
        }
        if (age <= 0) {
            throw new IllegalArgumentException("Age must be greater than 0");
        }

        if (description == null) {
            throw new NullPointerException("Description cannot be null");
        }

        if (wingspan == null) {
            throw new NullPointerException("Wingspan cannot be null");
        }
        if (wingspan <= 0) {
            throw new IllegalArgumentException("Wingspan must be greater than 0");
        }

        if (character == null) {
            throw new NullPointerException("Character cannot be null");
        }

        if (cave == null) {
            throw new NullPointerException("Cave cannot be null");
        }
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setWingspan(Double wingspan) {
        this.wingspan = wingspan;
    }

    public void setCharacter(DragonCharacter character) {
        this.character = character;
    }

    public void setCave(DragonCave cave) {
        this.cave = cave;
    }
    
}
