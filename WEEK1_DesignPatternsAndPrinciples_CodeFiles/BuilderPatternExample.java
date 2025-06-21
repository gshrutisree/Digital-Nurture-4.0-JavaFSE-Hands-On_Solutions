public class BuilderPatternExample {

    // Product class
    static class Computer {
        private String cpu;
        private String ram;
        private String storage;
        private String gpu;

        // Private constructor
        private Computer(Builder builder) {
            this.cpu = builder.cpu;
            this.ram = builder.ram;
            this.storage = builder.storage;
            this.gpu = builder.gpu;
        }

        public void displayConfig() {
            System.out.println("Computer Config:");
            System.out.println("CPU: " + cpu);
            System.out.println("RAM: " + ram);
            System.out.println("Storage: " + storage);
            System.out.println("GPU: " + gpu);
            System.out.println();
        }

        // Static nested Builder class
        public static class Builder {
            private String cpu;
            private String ram;
            private String storage;
            private String gpu;

            public Builder setCpu(String cpu) {
                this.cpu = cpu;
                return this;
            }

            public Builder setRam(String ram) {
                this.ram = ram;
                return this;
            }

            public Builder setStorage(String storage) {
                this.storage = storage;
                return this;
            }

            public Builder setGpu(String gpu) {
                this.gpu = gpu;
                return this;
            }

            public Computer build() {
                return new Computer(this);
            }
        }
    }
    public static void main(String[] args) {
        Computer basicPC = new Computer.Builder()
            .setCpu("Intel i3")
            .setRam("8GB")
            .setStorage("256GB SSD")
            .build();

        Computer gamingPC = new Computer.Builder()
            .setCpu("Intel i9")
            .setRam("32GB")
            .setStorage("1TB SSD")
            .setGpu("NVIDIA RTX 4090")
            .build();

        basicPC.displayConfig();
        gamingPC.displayConfig();
    }
}
