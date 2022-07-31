package com.uistore;

import org.openqa.selenium.By;

public class SearchUI {

	public static By Searchbox=By.xpath("//input[@type='search']");
	public static By hygenic=By.xpath("//strong[text()='Original Scent']");
	public static By Popup=By.xpath("//a[@class='lilo3746-close-link lilo3746-close-icon']");
	public static By Findretailers=By.xpath("//*[@class='row tide-product-info']//*[text()='Find Retailers']");
	public static By Buy=By.xpath("//div[@data-retailer='Walmart']//small[text()='BUY']");
	public static By Addcart=By.xpath("//span[text()='Add to cart']");
	
}
