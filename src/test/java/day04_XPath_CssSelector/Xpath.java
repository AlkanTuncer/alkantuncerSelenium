package day04_XPath_CssSelector;

public class Xpath {

    // Absolut XPath - Parent/Child ilişkisi
    // Relative XPath - tag name/attribute/value -> Bu 3 web element ile unique sonuc veren xpath yazılır.
    // Relative XPath - //tagName[@attributeAdı="attributeValue"] -> yazımı bu şekildedir.

    /*
      Attribute'e bağlı olmadan sadece web element içinde bulunan text için xpath oluşturma
        By.xpath("//tagname[.="text name"]")
        By.xpath("//*[.="text name"]")
        By.xpath("//*[text()='exact text with extra space and all']")
        By.xpath("//*[contains(text(),'piece of text')]")

      Tek attribute ile UNIQUE bir sonuca ulaşamazsak birden fazla attribute yazabiliriz.
        By.xpath("//div[@id='logo' or class='flex-col logo']")
        By.xpath("//div[@id='logo' and class='flex-col logo']")
     */
}