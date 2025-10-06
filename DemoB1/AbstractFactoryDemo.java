package DemoB1;
// ====== Abstract Products ======
interface Button { void paint(); }
interface Checkbox { void render(); }

// ====== Concrete Products (family: Win) ======
class WinButton implements Button {
    public void paint() { System.out.println("Windows Button"); }
}
class WinCheckbox implements Checkbox {
    public void render() { System.out.println("Windows Checkbox"); }
}

// ====== Concrete Products (family: Mac) ======
class MacButton implements Button {
    public void paint() { System.out.println("Mac Button"); }
}
class MacCheckbox implements Checkbox {
    public void render() { System.out.println("Mac Checkbox"); }
}

// ====== Abstract Factory ======
interface GUIFactory {
    Button createButton();
    Checkbox createCheckbox();
}

// ====== Concrete Factories ======
class WinFactory implements GUIFactory {
    public Button createButton() { return new WinButton(); }
    public Checkbox createCheckbox() { return new WinCheckbox(); }
}
class MacFactory implements GUIFactory {
    public Button createButton() { return new MacButton(); }
    public Checkbox createCheckbox() { return new MacCheckbox(); }
}

// ====== Client/App ======
class Application {
    private final Button button;
    private final Checkbox checkbox;

    public Application(GUIFactory factory) {
        this.button = factory.createButton();
        this.checkbox = factory.createCheckbox();
    }

    public void drawUI() {
        System.out.println("== Rendering UI ==");
        button.paint();
        checkbox.render();
        System.out.println("==================");
    }
}

// ====== Main ======
public class AbstractFactoryDemo {
    public static void main(String[] args) {
        // Chọn theme qua tham số dòng lệnh: "win" hoặc "mac"
        String theme = (args.length > 0) ? args[0].toLowerCase() : "win";

        GUIFactory factory;
        if ("mac".equals(theme)) {
            factory = new MacFactory();
        } else if ("win".equals(theme)) {
            factory = new WinFactory();
        } else {
            throw new IllegalArgumentException("Unknown theme: " + theme);
        }

        Application app = new Application(factory);
        app.drawUI();
    }
}
