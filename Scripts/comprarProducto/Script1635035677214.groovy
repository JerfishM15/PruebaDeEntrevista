import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import utileria.accion as accion

//abrir navegador y maximizarlo
WebUI.openBrowser("http://opencart.abstracta.us/");
WebUI.maximizeWindow();

if (accion.present("//input[@name='search']")) {
	accion.setText("//input[@name='search']", "iphone");
	accion.click("//i[@class='fa fa-search']");
	
	
	//anadir producto
	if(accion.present("//span[contains(text(), 'Add to Cart')]")) {
		accion.click("//span[contains(text(), 'Add to Cart')]");
		
		//ir al carrito
		accion.click("//div[@id='cart']");
		
		//ir a la pag checkout
		accion.click("//strong[contains(text(), ' Checkout')]");
		
		//avanzar a la pag de checkout
		if(accion.present("//button[contains(text(), ' Advanced')]")) {
			accion.click("//button[contains(text(), ' Advanced')]");
			
			WebUI.delay(3)
			
			accion.click("//a[@id='proceed-link']");
		}
		
		//verificando que se anadio el producto
		if(accion.present("(//img[@title='iPhone'])[1]")) {
			accion.agregarPuntoDeVerificacion("Se agrego el producto a la canasta", true, true);
			
		}else {
			accion.agregarPuntoDeVerificacion("No se agrego el producto a la canasta", true, true);
		}
		
		//elegir opcion guest
		if(accion.present("//input[@value='guest']")) {
		accion.click("//input[@value='guest']");
		
		}
		if(accion.present("//input[@id='button-account']")) {
			
		//dar al btn "continue" y rellenar formulario
		accion.click("//input[@id='button-account']");
			
		//first name
		accion.setText("//input[@name='firstname']", "Manolo");
		
		//last name
		accion.setText("//input[@name='lastname']", "Dipre");
		
		//email 
		accion.setText("//input[@id='input-payment-email']", "manolodipre@gmail.com");
		
		//telephone
		accion.setText("//input[@name='telephone']", "8099990099");
		
		//adress
		accion.setText("//input[@name='address_1']", "sainagua");
		
		//city
		accion.setText("//input[@id='input-payment-city']", "San cristobal");
		
		//postal code
		accion.setText("//input[@id='input-payment-postcode']", "91000")
		
		//country
		accion.click("//select[@id='input-payment-country']");
		accion.click("//select[@id='input-payment-country']/option[@value='60']");
		
		//zone
		accion.click("//select[@id='input-payment-zone']");
		accion.click("//select[@id='input-payment-zone']/option[@value='958']");
		
		
		//continue
		accion.click("//input[@id='button-guest']");
		
		//continue
		accion.click("//input[@id='button-shipping-method']");
		
		//agree y continue
		accion.click("//input[@name='agree']");
		accion.click("//input[@id='button-payment-method']");
		
		//confirm
		accion.click("//input[@id='button-confirm']");
		
		if(accion.present("//h1[contains(text(), 'Your order has been placed!')]")) {
			accion.agregarPuntoDeVerificacion("Su compra fue exitosa", true, true);
			}
		}
	}
}