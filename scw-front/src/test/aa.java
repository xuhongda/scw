/**
 * @authorxuhongda on 2017/12/12
 * PACKAGE_NAME
 * scw-parent
 */
public class aa {
    public static void main(String[] args) {
        aa a = new aa();
        a.dd();
    }

    @AnotationTest(author = "aa",date = "2017",revision = 1,comments = "自定义注解")
    public void dd(){
        System.out.println("dd");
    }
}
