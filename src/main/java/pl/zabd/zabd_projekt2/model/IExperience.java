package pl.zabd.zabd_projekt2.model;

public enum IExperience {
    BEGINNER("Beginner"),
    INTERMEDIATE("Intermediate"),
    ADVANCED("Advanced");

    private String label;

    IExperience(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    public static IExperience fromLabel(String label) {
        for (IExperience experience : IExperience.values()) {
            if (experience.getLabel().equalsIgnoreCase(label)) {
                return experience;
            }
        }
        throw new IllegalArgumentException("Invalid label: " + label);
    }
}
