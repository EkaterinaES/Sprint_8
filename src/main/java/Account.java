public class Account {
    private final String nameSurname;

    public Account(String nameSurname) {
        this.nameSurname = nameSurname;
    }

    public boolean checkNameToEmboss() {
        if ((3 <= nameSurname.length())
                & (nameSurname.length() <= 19)
                & nameSurname.contains(" ")
                & !nameSurname.isBlank()
                & !nameSurname.startsWith(" ")
                & !nameSurname.endsWith(" ")) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return "Account{" +
                "nameSurname='" + nameSurname + '\'' +
                '}';
    }
}

