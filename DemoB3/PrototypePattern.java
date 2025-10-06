// Interface Prototype
interface Prototype {
    Prototype cloneObject();
}

// Lớp cụ thể BanVeNha
class BanVeNha implements Prototype {
    private int soTang;
    private String mauSon;

    public BanVeNha(int soTang, String mauSon) {
        this.soTang = soTang;
        this.mauSon = mauSon;
    }

    @Override
    public Prototype cloneObject() {
        return new BanVeNha(this.soTang, this.mauSon);
    }

    public void setMauSon(String mauSon) {
        this.mauSon = mauSon;
    }

    @Override
    public String toString() {
        return "Nhà " + soTang + " tầng, sơn màu " + mauSon;
    }
}

// Class public chính — phải trùng tên file!
public class PrototypePattern {
    public static void main(String[] args) {
        // Tạo prototype gốc
        BanVeNha mauBietThu = new BanVeNha(2, "trắng");

        // Clone ra nhà mới
        BanVeNha nha1 = (BanVeNha) mauBietThu.cloneObject();
        nha1.setMauSon("xanh nhạt");

        BanVeNha nha2 = (BanVeNha) mauBietThu.cloneObject();
        nha2.setMauSon("vàng kem");

        System.out.println(mauBietThu);
        System.out.println(nha1);
        System.out.println(nha2);
    }
}
