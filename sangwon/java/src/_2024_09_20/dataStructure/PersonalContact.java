package _2024_09_20.dataStructure;

public class PersonalContact extends Contact {
    String relationship;

    public PersonalContact(String name, String phoneNumber, String relationship) {
        super(name, phoneNumber);
        this.relationship = relationship;
    }

    public String getRelationship() {
        return relationship;
    }
}
