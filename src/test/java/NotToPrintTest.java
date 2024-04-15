import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class NotToPrintTest {
    String nameSurname;

    public NotToPrintTest(String nameSurname) {
        this.nameSurname = nameSurname;
    }

    @Parameterized.Parameters
    public static Object[][] getData() {
        return new Object[][]{
                {""}, //пустое поле
                {"СA"}, //2 символа
                {"Кораблестроитель Лия"}, //20 символов, включая пробел
                {"ИвановаЛия"}, //10 символов, без пробела в середине
                {" Иванова Лия"}, //12 символов, включая пробел вначале
                {"Иванова Лия "}, //12 символов, включая пробел в конце
                {"   "}, //3 символа, при этом все пробелы
        };
    }

    @Test
    @DisplayName("This name do not to print")
    @Description("Сheck parameters with which name cannot be printed a card")
    public void NotOkToPrint() {
        Account account = new Account(nameSurname);
        boolean mayBeToPrint = account.checkNameToEmboss();
        Assert.assertFalse(mayBeToPrint);
    }
}
