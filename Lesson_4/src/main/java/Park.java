public class Park {
    public static class Attractions {
        private final String name;
        private final String time;
        private final double cost;

        public Attractions(String name, String time, double cost) {
            this.name = name;
            this.time = time;
            this.cost = cost;
        }

        public void getInfo() {
            System.out.println(
                    "Название аттракциона: " + name +
                            "\nВремя работы: " + time +
                            "\nСтоимость: " + cost);
        }
    }

    public static void main(String[] args) {
        Attractions[] attractions = new Attractions[3];
        attractions[0] = new Attractions("Колесо обозрения", "10:00-14:00", 100);
        attractions[1] = new Attractions("Американские гонки", "10:00-15:00", 200);
        attractions[2] = new Attractions("Паровозик", "10:00-16:00", 300);
        for (Attractions attraction : attractions) {
            attraction.getInfo();
            System.out.println();
        }
    }
}
