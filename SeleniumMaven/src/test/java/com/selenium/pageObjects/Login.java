package com.selenium.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Login {
	
	private static WebElement element= null;
	
	public static WebElement username(WebDriver driver) {
		 element = driver.findElement(By.xpath(".//input[@id=\"username\"]"));
		return element;
	}
	public static WebElement password(WebDriver driver) {
		 element = driver.findElement(By.xpath(".//input[@id=\"password\"]"));
		return element;
	}
	public static WebElement signin(WebDriver driver) {
		element = driver.findElement(By.xpath(".//a[@class=\"nav__button-secondary\"]"));
		return element;
	}
	public static WebElement login_btn(WebDriver driver) {
		WebElement element = driver.findElement(By.xpath(".//button[@class=\"btn__primary--large from__button--floating\"]"));
		return element;
	}

//	public static WebElement next1(WebDriver driver) {
//		 element = driver.findElement(By.xpath("(.//span[text()=\"Next\"]//following::div[@class=\"VfPpkd-RLmnJb\"])[1]"));
//		return element;
//	}
//	
}
