package AbstractFactoryDesignPattern;

// Abstract Factory interface
interface GUIFactory {
    Button createButton();
    Checkbox createCheckbox();
}

// Concrete factory for light theme
class LightFactory implements GUIFactory {
    public Button createButton() {
        return new LightButton();
    }

    public Checkbox createCheckbox() {
        return new LightCheckbox();
    }
}

// Concrete factory for dark theme
class DarkFactory implements GUIFactory {
    public Button createButton() {
        return new DarkButton();
    }

    public Checkbox createCheckbox() {
        return new DarkCheckbox();
    }
}

// Abstract product interface for button
interface Button {
    void render();
}

// Concrete product for light button
class LightButton implements Button {
    public void render() {
        System.out.println("Rendering light button...");
    }
}

// Concrete product for dark button
class DarkButton implements Button {
    public void render() {
        System.out.println("Rendering dark button...");
    }
}

// Abstract product interface for checkbox
interface Checkbox {
    void render();
}

// Concrete product for light checkbox
class LightCheckbox implements Checkbox {
    public void render() {
        System.out.println("Rendering light checkbox...");
    }
}

// Concrete product for dark checkbox
class DarkCheckbox implements Checkbox {
    public void render() {
        System.out.println("Rendering dark checkbox...");
    }
}

// Client code
public class Main {
    public static void main(String[] args) {
        // Create a light theme factory
        GUIFactory lightFactory = new LightFactory();

        // Create light theme button and checkbox
        Button lightButton = lightFactory.createButton();
        Checkbox lightCheckbox = lightFactory.createCheckbox();

        lightButton.render();
        lightCheckbox.render();

        // Create a dark theme factory
        GUIFactory darkFactory = new DarkFactory();

        // Create dark theme button and checkbox
        Button darkButton = darkFactory.createButton();
        Checkbox darkCheckbox = darkFactory.createCheckbox();

        darkButton.render();
        darkCheckbox.render();
    }
}
