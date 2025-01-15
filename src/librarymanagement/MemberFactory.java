package librarymanagement;

public class MemberFactory {
    public static Member createMember(String name, String discountType, double discountValue) {
        PriceStrategy strategy = switch (discountType.toLowerCase()) {
            case "code" -> new CodeDiscountStrategy("CODE" + name.toUpperCase(), discountValue);
            case "fixed" -> new MemberDiscountStrategy(discountValue);
            default -> throw new IllegalArgumentException("Type de réduction inconnu");
        };
        return new Member(name, strategy);
    }
}
