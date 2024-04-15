import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;


@RunWith(Parameterized.class)
public class ToPrintTest {
    String nameSurname;

    public ToPrintTest(String nameSurname) {
        this.nameSurname = nameSurname;
    }

    @Parameterized.Parameters
    public static Object[][] getData(){
        return new Object[][]{
                {"Я O"}, //3 символа, включая пробел
                {"Смиринов Константин"}, //19 символов, включая пробел
                {"Иванова Лия"} //11 символов, включая пробел
        };
    }
@Test
@DisplayName("This name may to print")
@Description("Check parameters name for to print on a card")
    public void okToPrint(){
        Account account = new Account(nameSurname);
        boolean mayBeToPrint = account.checkNameToEmboss();
    Assert.assertTrue(mayBeToPrint);
}
}
