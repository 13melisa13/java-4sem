package flyweight;

public class Star {
    private SpectralType spectralType;

    public Star() {
        this.spectralType = SpectralType.G;
        System.out.println("New star created with type " + this.spectralType);
    }

    public Star setSpectralType(SpectralType spectralType) {
        this.spectralType = spectralType;
        return this;
    }
}
