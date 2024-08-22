package Common;

import org.openqa.selenium.By;

public class LocatorFile {

    public By signButton = By.id("nav-link-accountList");
    public By emailField = By.id("ap_email_login");
    public By passwordField = By.id("ap_password");
    public By continueButtonForEmail = By.id("continue");
    public By signInButtonForPassword = By.id("signInSubmit");
    public By searchBox = By.id("twotabsearchtextbox");
    public By searchIcon = By.id("nav-search-submit-button");
    public By addToCartButton = By.id("add-to-cart-button");
    public By addToCartIcon = By.className("nav-cart-icon nav-sprite");
    public By product = By.xpath("//*[@id=\"search\"]/div[1]/div[1]/div/span[1]/div[1]/div[3]/div/div/div/div/span/div/div/div[1]/div");
    public By quantityDropdown =By.cssSelector("#native_dropdown_selected_size_name");
    public By buyButton = By.name("proceedToRetailCheckout");
}
