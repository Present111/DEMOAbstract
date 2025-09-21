// ====== Product ======
interface Transport { void deliver(); }

// ====== Concrete Products ======
class Truck implements Transport {
    public void deliver() { System.out.println("Deliver by land in a box"); }
}
class Ship implements Transport {
    public void deliver() { System.out.println("Deliver by sea in a container"); }
}

// ====== Creator (template + factory method) ======
abstract class Logistics {
    // Template method sử dụng Product nhưng không biết lớp cụ thể
    public void planDelivery() {
        System.out.println("== Planning delivery ==");
        Transport t = createTransport();   // <— Factory Method (đa hình)
        t.deliver();
        System.out.println("=======================");
    }
    protected abstract Transport createTransport(); // <— phải override
}

// ====== Concrete Creators ======
class RoadLogistics extends Logistics {
    protected Transport createTransport() { return new Truck(); }
}
class SeaLogistics extends Logistics {
    protected Transport createTransport() { return new Ship(); }
}

// ====== Main ======
public class FactoryMethodDemo {
    public static void main(String[] args) {
        // Chọn loại logistics qua tham số: "road" hoặc "sea"
        String type = (args.length > 0) ? args[0].toLowerCase() : "road";

        Logistics logistics;
        if ("sea".equals(type)) {
            logistics = new SeaLogistics();
        } else if ("road".equals(type)) {
            logistics = new RoadLogistics();
        } else {
            throw new IllegalArgumentException("Unknown type: " + type);
        }

        logistics.planDelivery();
    }
}
