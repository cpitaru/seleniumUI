package constants;

public enum UserMenuOptions {
    SUMAR_CONT("Sumar cont"),
    INFORMATII_CONT("Informatii cont"),
    ADRESE("Adrese"),
    COMENZILE_MELE("Comenzile mele"),
    REZERVARILE_MELE("Rezervarile mele"),
    VOUCHERE("Vouchere"),
    RETUR_PRODUSE("Retur produse"),
    WISHLIST("Wishlist"),
    DOUA_X_DIFERENTA("2x Diferenta"),
    PAY_U_CARDURI_DE_CREDIT_SALVATE("PayU - Carduri de credit salvate"),
    LOG_OUT("Iesi din cont");

    private String userMenuOption;

    UserMenuOptions(String userMenuOption) {
        this.userMenuOption = userMenuOption;
    }

    public String getUserMenuOption() {
        return this.userMenuOption;
    }
}
