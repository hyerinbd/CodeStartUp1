package codestartup.bookorder.domain;

public class Book {
    private int id;
    private String name;
    private String category;
    private int origin_price;
    private int discount_price; // 할인금액
    // TODO: pay_method가 왜 Boolean인지?
    private Boolean pay_method;  // 결제 방법
    private int pay_amount; // 현금일 경우 지불 금액
    private  int change_amount; // 현금일 경우 거스름돈

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public int getOrigin_price() {
        return origin_price;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setOrigin_price(int origin_price) {
        this.origin_price = origin_price;
    }

    public int getDiscount_price() {
        return discount_price;
    }

    public void setDiscount_price(int discount_price) {
        this.discount_price = discount_price;
    }

    public Boolean getPay_method() {
        return pay_method;
    }

    public void setPay_method(Boolean pay_method) {
        this.pay_method = pay_method;
    }

    public int getPay_amount() {
        return pay_amount;
    }

    public void setPay_amount(int pay_amount) {
        this.pay_amount = pay_amount;
    }

    public int getChange_amount() {
        return change_amount;
    }

    public void setChange_amount(int change_amount) {
        this.change_amount = change_amount;
    }
}
