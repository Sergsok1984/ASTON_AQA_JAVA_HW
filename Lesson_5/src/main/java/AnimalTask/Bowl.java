package AnimalTask;

public class Bowl {
    private static int volume = 45;

    public Bowl(int volume) {
        Bowl.volume = volume;
    }

    public static int getVolume() {
        return volume;
    }

    public static void setVolume(int volume) {
        Bowl.volume = volume;
    }
}
