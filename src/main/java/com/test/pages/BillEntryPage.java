package com.test.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.test.Utils.Functions;

public class BillEntryPage {
	WebDriver driver;

	//li[@folder-name="Bill Entry"]//a

	@FindBy(xpath="//input[contains(@id,'ItemSelectorText_')]")
	private List<WebElement> dropdownInputBoxes;

	@FindBy(xpath="//input[contains(@id,'SilverTextBox')]")
	private List<WebElement> silverInputBoxes;

	@FindBy(xpath="//input[@placeholder='<M/d/yyyy>']")
	private List<WebElement> dateInputBoxes;

	@FindBy(xpath="//div[contains(@id,'ItemSelectorArrowDiv_')]")
	private List<WebElement> itemSelectorArrow;

	@FindBy(xpath="//div[contains(@id,'ItemSelectorItemListDiv_')]")
	private List<WebElement> listUnderitemSelectorArrow;


	@FindBy(xpath="//button[contains(@id,'SilverButton_') and text()='Next']")  ////button[contains(@id,'SilverButton_') and text()='Next']
	private List<WebElement> nextButtonList;

	//Line Item page
	@FindBy(xpath="//input[contains(@id,'numBox')]")
	private List<WebElement> numBoxList;
	//numboxes = driver.findElements(By.xpath("//input[contains(@id,'numBox')]"));

	@FindBy(xpath="//img[@name='Image_Indicator_BillingTaxID_New' and @src='data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAABgAAAAYCAYAAADgdz34AAAAAXNSR0IArs4c6QAAAARnQU1BAACxjwv8YQUAAAUoSURBVEhLtVVbbBRlFP5mdmZn/713u2z30nbb3d7SQkoorWmgtGChJIJGrBKQQIgIFAM0SlTsAwoBggn4oomJT1zCiyZGI4H4YtRYItYEUYKUWwqlLAKWLnuZ3Zmd8czuBm1K+2I4m7Pnn3P5v3PmP+cfPG3iinJG2vbyLLs/Yv200i++AgHczZvqV9f+Gt909OjEw6LL/6ODu6tODA/16cqjQV0eP6MPn9ugHxoIf100z0imopyWPtgVbp8z2/dRW8cAl07egZIdh6ukHKmJP+uj1abBH87Grxddn0h8UU5HHGPakUWLX+PlZAy8KMIkMcipe2hta4PTzh8mnxmTnNG4f3d4bXtr087q+pVQMndhL/HBbBGRnrgGUWQw6X+XRSv1se8G478WQ6bQtBX09oIxQTvYtmAd5OQoROYCx41SV4zC4o5CVZOY09wIh92899XlHmcxbApNC9BcXfVW15JnK3WYAS0Oq92Sl9CSsLnc4HiVvDgsbC/3ResdA4WoqfREgP7XvYEyL//O7LkrkJVvw+zw0143AbOH2EseI7B5m5HLpRGtrUCFz7Kzv88XKURPpicCeFzW/d09vXY5fZ9yVMAcPG6NlmFH/3n09Z3DxYt+WJw5aLkbSDw4jQXPpCSXxD4shk+iKQDv9Qfm1VQ51wcr50FV7oG5Kkg7hlgsg1TiAYaGBnHq1DeAegbOsmbouQl4vOOoDUurdm+t6Cjs8i9NAbCJwuHu5etMcvI6TKIEM8sBOiBnHuLYsRME8DNsVpEiGZidwVIyG2pOo7NIcBYbf4S2mHQ7TALYszO0at7cui672wtNS1D2QTpU4za4BeQuQFHSeb+yACM9geTGURJ6DjynUhPE0dIozh/YWrE+71SkxwCNjTDbbPqhhYtfRCY5AkFyQzRTp+QuA9kLqImWFD2BSDWtdYFWIgRRByvtgKZraG2NG719YOlS2Aqe/wHo7Qlv71jQWcMLGQpOweoKAcp5yvQqPTMEKq1oafHluS7iJj0BcFSFJtNZLAPPcxAtMjrb9WBLdejt4raFSX5zc8AbmIUvVr602SKnb9BQ+SGxGGX/O1npdfA0C7RXZWUEtXUhtC+kts0lyEZ6MnAmHjrnhpIeRjCUw/BlNj8S5I4PXZTj+QpsFn5vz/LV7kz2GmWrgjntlL0x/TRcRpacgPh9N7bv+Anv7zmLOyN0jgYo6QtV6LB7usALDDqvoHuJZrM72AFjb37b+rKmaLl9U6RhDjTlISRHGLz2I5mkQrCRulnE6W/HcPXKJYyNjeDLU3QuQiH7POeB0mCe1dApwZqGBOqqxbVb1njaeJcN+5a9sFGUk7/R+AtgVuM6oG7hjWACMaQqorMjAoczBEFwoburiXwMAMNObEj6EjFHOxUWRE7TsKxH5a2CdIgP+aUV/vIGasskBFYKNX2W7vwsstkUcZKuihQUYp/7EiZiG5GN70IkfIXe9wTZiTNxZNU41MwjGszbMFmfp7HREAzLCPvFRdzHe8PKG++eFOJ3PyOnCwTwB5XLU29TUvTHkTTY6DeOBi4vSZGfJlIYa+OBM9ZGEGeiMDMkC4fD+8xZU1OtNVJqT82talgJXbtMk1sBs7Wcuqic1kG6/4lZAGaJ2ErfA8lPXeYl6aO2LCVbKc1LCfmRFF2QJCfNhoRfvjdhcEg5yW3ohMVb7//E7+HWOJ1epmtG1lQkdYbxo2opUXomNjI29AU7VfB4TdJ4pLXhm5AzSuyO9nlMjW0xCn2KBPwDyIG4Q+o2D+AAAAAASUVORK5CYII=']")
	private WebElement warningIcon;

	@FindBy(xpath="//img[@name='Flow: Image_Indicator_ServiceLocation' and @src='data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAABgAAAAYCAYAAADgdz34AAAAAXNSR0IArs4c6QAAAARnQU1BAACxjwv8YQUAAAUoSURBVEhLtVVbbBRlFP5mdmZn/713u2z30nbb3d7SQkoorWmgtGChJIJGrBKQQIgIFAM0SlTsAwoBggn4oomJT1zCiyZGI4H4YtRYItYEUYKUWwqlLAKWLnuZ3Zmd8czuBm1K+2I4m7Pnn3P5v3PmP+cfPG3iinJG2vbyLLs/Yv200i++AgHczZvqV9f+Gt909OjEw6LL/6ODu6tODA/16cqjQV0eP6MPn9ugHxoIf100z0imopyWPtgVbp8z2/dRW8cAl07egZIdh6ukHKmJP+uj1abBH87Grxddn0h8UU5HHGPakUWLX+PlZAy8KMIkMcipe2hta4PTzh8mnxmTnNG4f3d4bXtr087q+pVQMndhL/HBbBGRnrgGUWQw6X+XRSv1se8G478WQ6bQtBX09oIxQTvYtmAd5OQoROYCx41SV4zC4o5CVZOY09wIh92899XlHmcxbApNC9BcXfVW15JnK3WYAS0Oq92Sl9CSsLnc4HiVvDgsbC/3ResdA4WoqfREgP7XvYEyL//O7LkrkJVvw+zw0143AbOH2EseI7B5m5HLpRGtrUCFz7Kzv88XKURPpicCeFzW/d09vXY5fZ9yVMAcPG6NlmFH/3n09Z3DxYt+WJw5aLkbSDw4jQXPpCSXxD4shk+iKQDv9Qfm1VQ51wcr50FV7oG5Kkg7hlgsg1TiAYaGBnHq1DeAegbOsmbouQl4vOOoDUurdm+t6Cjs8i9NAbCJwuHu5etMcvI6TKIEM8sBOiBnHuLYsRME8DNsVpEiGZidwVIyG2pOo7NIcBYbf4S2mHQ7TALYszO0at7cui672wtNS1D2QTpU4za4BeQuQFHSeb+yACM9geTGURJ6DjynUhPE0dIozh/YWrE+71SkxwCNjTDbbPqhhYtfRCY5AkFyQzRTp+QuA9kLqImWFD2BSDWtdYFWIgRRByvtgKZraG2NG719YOlS2Aqe/wHo7Qlv71jQWcMLGQpOweoKAcp5yvQqPTMEKq1oafHluS7iJj0BcFSFJtNZLAPPcxAtMjrb9WBLdejt4raFSX5zc8AbmIUvVr602SKnb9BQ+SGxGGX/O1npdfA0C7RXZWUEtXUhtC+kts0lyEZ6MnAmHjrnhpIeRjCUw/BlNj8S5I4PXZTj+QpsFn5vz/LV7kz2GmWrgjntlL0x/TRcRpacgPh9N7bv+Anv7zmLOyN0jgYo6QtV6LB7usALDDqvoHuJZrM72AFjb37b+rKmaLl9U6RhDjTlISRHGLz2I5mkQrCRulnE6W/HcPXKJYyNjeDLU3QuQiH7POeB0mCe1dApwZqGBOqqxbVb1njaeJcN+5a9sFGUk7/R+AtgVuM6oG7hjWACMaQqorMjAoczBEFwoburiXwMAMNObEj6EjFHOxUWRE7TsKxH5a2CdIgP+aUV/vIGasskBFYKNX2W7vwsstkUcZKuihQUYp/7EiZiG5GN70IkfIXe9wTZiTNxZNU41MwjGszbMFmfp7HREAzLCPvFRdzHe8PKG++eFOJ3PyOnCwTwB5XLU29TUvTHkTTY6DeOBi4vSZGfJlIYa+OBM9ZGEGeiMDMkC4fD+8xZU1OtNVJqT82talgJXbtMk1sBs7Wcuqic1kG6/4lZAGaJ2ErfA8lPXeYl6aO2LCVbKc1LCfmRFF2QJCfNhoRfvjdhcEg5yW3ohMVb7//E7+HWOJ1epmtG1lQkdYbxo2opUXomNjI29AU7VfB4TdJ4pLXhm5AzSuyO9nlMjW0xCn2KBPwDyIG4Q+o2D+AAAAAASUVORK5CYII=']")
	private WebElement zipwarningIcon;

	@FindBy(xpath="//img[@name='Flow: Image_Indicator_ServiceLocation' and @src='data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAABAAAAAQCAYAAAAf8/9hAAAAAXNSR0IArs4c6QAAAARnQU1BAACxjwv8YQUAAALhSURBVDhPVVPvS1NRGH7Ovdu9c5ttIk0Ti0LXL8v6A0JwSCEkbM2sLUpBYx/8rn9KUUEwwiACib4GQr8UFD+kUi5TZ4UbTjLU7e5uu6fnzhH6wrnn8p73fd7ned9zVNSsB7h1Gpg5B/xcARZr7iMWAW63AXOXgB/fDsdcB+7EXC7r3diYHPZ6ZRQYpFscnB7YPSCW0DTrdSgkE7ouB4AHtl+1Kze63a9Gx8eFv74eHZ2dWJ2fD7eXSmss8cUOYmSsQdcnbvb0CMWycCoQQCaTiZyxrJQIATvjo6O+AJ3F3V1YpRLKhQImk0lsGsaQBpjHNW2it7sbxWIR5v4+yowp7e1hcmWlrJ4FVlcXFvo7gkEBHlQY4CiXcbGtDZupVNjjcEQjXV0QlQpkPg+L4IIxs+vr2JNypKqTmmONrBKPRqEJAWGacDDBZmT/K9wLuRwM7iZZzBHkN5B4DjyrTuErOxqsVFLp5eVoR2srXNTpIBs1m4VIp6GQrs1KJegsWWSlTDxlMlOt/2NkwxaDbEp6bS163u+HSooaK9Y5ndAdDlhk8mFnBxuWlXhUS7bzFPtz2BRWyi8tQefu1XUcc7ng1TQ4eSakhBso8ldWg2n/GdijahRi4gZH2eTzwcMkD6t7CKKrKjTuJxmXKRTCV4G1T7URVwHuMtnH5FBdHXgn4CJlN9cutSvUXe/xwCSjCn0tjP9VLIYvE2SGIGoYGPADL6/puvCxilNRqpoLbNabrS0sUneQTECfQbASz5s4qaxphtuB76KPmnpVVWsgTVurrVuh1ikmZixriJq3W4R429fcjBKB9tlMe+UNA5P5fFm9wIv0V8roCbsyV4kjnGL3c0x+DCSnWeUKH9B6oRBvJYsizw0CfCTDfeC+ugwsBKlnW8pIgNSmiZyTcohzSlJutdufbRAp5zYMI97MmPe8iX+kHHwCvLDPq9YPxLnMWPXhHX2JNRMPgd4RSh5m7IEL+AdjTE2UA6cIWgAAAABJRU5ErkJggg==']")
	private WebElement zipcrossIcon;
	
	@FindBy(xpath="//img[@name='Image_Indicator_BillingTaxID_New' and @src='data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAABAAAAAQCAYAAAAf8/9hAAAAB3RJTUUH2AQPDQ0kHi+LuwAAAAlwSFlzAAALEgAACxIB0t1+/AAAAARnQU1BAACxjwv8YQUAAAJsSURBVHjalZNNTBNRFIXPvJnH1JZ2plPaRoUQEDCGv4IQRTeisUExFdHEUONCWLDTlVvdiQtZmRg1URJ0oWjCyrULDS4AsQSNEghQJdBi/yht6bQzz0ICIcSEcpcv5zv35dx7gf0VJ9UWDEo1QkhpEE7vkwWker6v+moJ8z52M6WBxqzHhRY+X1iupzcscmH/lZ52LkFjMFUQMTgZ95C84BrawAh7frn7IhfKLiHKglATWTCNLe5pYC2DnNEy79u9bqNmSiFKglhfS2Pq3Z8AE9Id2wY2F0o3QtptoJn4F42tdeWOcglhsgSdavAN+tN8gd4ZGcfCpoHkEu4yns7lvjqEU6BbsKVO6LWVKJ3N5+oQ0H6D2HLwgB9ZVb8TGsuObGiIpZE/LxTQvq7bnZzjqPWaHBPe5t55czMqOcL1t3nPYCW7CGZLY/rDMmLzydeR8fSzrSa80SmMXOptNRstRjgqFaz8DR1jVCtFCj1nu04eMRULWDNGsBpMwvfSPx0lqgcBqDsM6E3BrjtNFTziahRSmYjVxZTLflgpafLUIoQlCDKHzw9+qbquXVj36Qs7M+KJUxsO/Yy38XbdYa82Q9cYlCozqurLkRSjoE4OEwNziC0k7kcmMkO7Q+YzASTIQX04PJnskMuMSlGlBYQQaGIaNNc5NBPHjzf+0fC3zK2cnu022JxCchLLEIl77OnMcjyQRqHDANFKQS0CRp/MqDCie2Oi/9uT7T2Ifl2f4ynzfHr4Pcl0BumQCb5X88iktEfhL5mpvA/GesJwvbRd1r0fW5jsEmdRjAN5w1tV1GS4Z2s0JJVm0b2X9h/XIOZvGyydWAAAAABJRU5ErkJggg==']")
	private WebElement tickIconBillingTxID;
	
	@FindBy(xpath="//img[@name='Flow: Image_Indicator_ServiceLocation' and @src='data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAABAAAAAQCAYAAAAf8/9hAAAAB3RJTUUH2AQPDQ0kHi+LuwAAAAlwSFlzAAALEgAACxIB0t1+/AAAAARnQU1BAACxjwv8YQUAAAJsSURBVHjalZNNTBNRFIXPvJnH1JZ2plPaRoUQEDCGv4IQRTeisUExFdHEUONCWLDTlVvdiQtZmRg1URJ0oWjCyrULDS4AsQSNEghQJdBi/yht6bQzz0ICIcSEcpcv5zv35dx7gf0VJ9UWDEo1QkhpEE7vkwWker6v+moJ8z52M6WBxqzHhRY+X1iupzcscmH/lZ52LkFjMFUQMTgZ95C84BrawAh7frn7IhfKLiHKglATWTCNLe5pYC2DnNEy79u9bqNmSiFKglhfS2Pq3Z8AE9Id2wY2F0o3QtptoJn4F42tdeWOcglhsgSdavAN+tN8gd4ZGcfCpoHkEu4yns7lvjqEU6BbsKVO6LWVKJ3N5+oQ0H6D2HLwgB9ZVb8TGsuObGiIpZE/LxTQvq7bnZzjqPWaHBPe5t55czMqOcL1t3nPYCW7CGZLY/rDMmLzydeR8fSzrSa80SmMXOptNRstRjgqFaz8DR1jVCtFCj1nu04eMRULWDNGsBpMwvfSPx0lqgcBqDsM6E3BrjtNFTziahRSmYjVxZTLflgpafLUIoQlCDKHzw9+qbquXVj36Qs7M+KJUxsO/Yy38XbdYa82Q9cYlCozqurLkRSjoE4OEwNziC0k7kcmMkO7Q+YzASTIQX04PJnskMuMSlGlBYQQaGIaNNc5NBPHjzf+0fC3zK2cnu022JxCchLLEIl77OnMcjyQRqHDANFKQS0CRp/MqDCie2Oi/9uT7T2Ifl2f4ynzfHr4Pcl0BumQCb5X88iktEfhL5mpvA/GesJwvbRd1r0fW5jsEmdRjAN5w1tV1GS4Z2s0JJVm0b2X9h/XIOZvGyydWAAAAABJRU5ErkJggg==']")
	private WebElement tickIconZip;
	

	@FindBy(xpath="//button[text()='Select Provider']")
	private WebElement selectProviderButton;

	@FindBy(xpath="//button[text()='Select Service Location']")
	private WebElement selectServiceLocButton;

	@FindBy(xpath="//button[contains(text(),'Create New Address')]")
	private WebElement createNewAddressButton;

	@FindBy(xpath="//button[contains(@id,'SilverButton_') and text()='Ok']")  ////button[contains(@id,'SilverButton_') and text()='Next']
	private WebElement okButtonForNewAddress;


	@FindBy(xpath="//img[@name='Image_Indicator_BillingTaxID_New' and @src='data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAABAAAAAQCAYAAAAf8/9hAAAAB3RJTUUH2AQPDQ0laSi7LQAAAAlwSFlzAAALEgAACxIB0t1+/AAAAARnQU1BAACxjwv8YQUAAALdSURBVHjabVPvS1NRGH7OvfPeuU03M9TEAsmVKIz+gBA0w4SKzWmyRSkk7IPf9U8JKvowwiACi74GQj9QcPghlXKacxk2U8Fwbvfuxz09VzYx6LDDOTvnfZ73ed73XBWVcRMYagcWrgLbG8AK/jNCwEgHkOgCvn87GzMAjEacTuv91JR85PHIIWCMx+Is+D4QiWma9bqvT8Z0XY4CD+1z1c58zuV6NTk9LXx1degOBLC5tBTsKBZTTPHFDiJbxKfrM7f7+4ViWbjU1IRfmUyo3bKS4gZwODU56W3ioXl0BKtYRCmfx2w8joxhjGtA4bymzQz29sI0TRSOj1FiTDGbxezGRkm9AmxuLi8Pd/v9ArwoM8BRKqHr8mXsJJNBl8MRDvX0QJTLkLkcLJILxixubSEr5cSJzzAlNjJLNByGJgREoQAHAbYie69wze/vw+BaoIoESXaA2HPgmWoTfGVF/eVyMr22Fu5ua4OTPh1Uo+7uQqTTUCjXVqWSdJEqdqWMPSWYUEutVnnFJmFR0qlUuNPng0qJGjPW1tRAdzhgUcnHw0NsW1bscQVs45SzrbL/KMyUW12FztWj66h3OuHRNNTYfZUStYDJraxiThXYrWoQYmaArWz2euEmyM3sbpLoqgqN60XGZfL54DUg9bnS4hOCCH/1BPfV1qLR5YKTkll9HNG7Qt91bjcKVFTmWSvjf5pmMECSBZKoQeCeD3h5XdeFl1lqFOXEc57Feru3hxX69lMJeGaQrMj7ZnYqUygE+QTWxV16uqWqWgNl2l5t3wq9zhH427LGncBBqxDv7rS0oEiiYxbTnjnDwJtcrqR28iH9kTJ8wc7MWWQL51j9A4JZ7fg8s9BzYiufj7ZRhcl7gwSfqDALPFDXgGVKSR1IGWqitHkycz/OPser1WbB1gNSJn4YRrSFMR/4Eg+lHHsCvDht4TAQHeG7j5x8eP9+iZUhJoBBTpMzWj38C2dRTZc15mQUAAAAAElFTkSuQmCC']")
	private WebElement crossIcon;

	@FindBy(xpath="//input[@value='Billing Tax ID:']")
	private WebElement billTaxIdLabel;

	@FindBy(xpath="//input[@value='Service Location ZIP:']")
	private WebElement zipLabel;



	@FindBy(css=".jqgfirstrow+tr")
	private WebElement firstRowSelectProvider;

	@FindBy(xpath="//button[contains(@id,'SilverEventButton_') and text()='Checksum']")
	private WebElement checksumButton;

	@FindBy(xpath="//button[contains(text(),'Price') and @class='buttonControl FullHeightAndWidth EnableControl']")
	private WebElement priceButton;

	@FindBy(xpath="//button[text()='Create Link']")
	private List<WebElement> createLinkButtons;

	@FindBy(xpath="//button[contains(@id,'SilverEventButton_') and text()='Query NPI Data']")
	private WebElement queryNPIButton;


	////------------------------------------New Xpaths......................................................

	@FindBy(xpath="//table[@class='SilverGrid validation-Holder  ']/tbody/tr/td[2]//div[text()=' Client:']/../../../../../../../../../td[3]//input[contains(@id,'ItemSelectorText')]")
	private WebElement clientInputBox;

	@FindBy(xpath="//table[@class='SilverGrid validation-Holder  ']/tbody/tr/td//input[@value='Claim #:']/../../../../../../../../../td[3]//input[contains(@id,'SilverTextBox')]")
	private WebElement claimInputBox;

	@FindBy(xpath="//table[@class='SilverGrid validation-Holder  ']/tbody/tr/td[2]//div[text()='Reviewed State:']/../../../../../../../../../td[3]//input[contains(@id,'ItemSelectorText')]")
	private WebElement stateInputBox;

	@FindBy(xpath="//table[@class='SilverGrid validation-Holder  ']/tbody/tr/td[2]//div[text()='Pay Code:']/../../../../../../../../../td[3]//input[contains(@id,'ItemSelectorText')]")
	private WebElement paycodeInputBox;

	@FindBy(xpath="//table[@class='SilverGrid validation-Holder  ']/tbody/tr/td[2]//div[text()='Bill ID:']/../../../../../../../../../td[3]//input[contains(@id,'SilverTextBox')]")
	private WebElement billIDInputBox;

	@FindBy(xpath="//table[@class='SilverGrid validation-Holder  ']/tbody/tr/td//input[@value='Billing Tax ID:']/../../../../../../../../../td[3]//input[contains(@id,'SilverTextBox')]")
	private WebElement billTaxIDInputBox;

	@FindBy(xpath="//table[@class='SilverGrid validation-Holder  ']/tbody/tr/td[2]//div[text()='Billing NPI:']/../../../../../../../../../td[3]//input[contains(@id,'SilverTextBox')]")
	private WebElement billNPIInputBox;

	@FindBy(xpath="//table[@class='SilverGrid validation-Holder  ']/tbody/tr/td//input[@value='Rendering NPI:']/../../../../../../../../../td[3]//input[contains(@id,'SilverTextBox')]")
	private WebElement renderingNPIInputBox;

	@FindBy(xpath="//table[@class='SilverGrid validation-Holder  ']/tbody/tr/td//input[@value='Service Location ZIP:']/../../../../../../../../../td[3]//input[contains(@id,'SilverTextBox')]")
	private WebElement locationZIPIInputBox;

	@FindBy(xpath="//table[@class='SilverGrid validation-Holder  ']/tbody/tr/td[2]//div[text()='Provider Facility NPI:']/../../../../../../../../../td[3]//input[contains(@id,'SilverTextBox')]")
	private WebElement facilityNPIInputBox;

	@FindBy(xpath="//table[@class='SilverGrid validation-Holder  ']/tbody/tr/td[2]//div[text()='Bill Type:']/../../../../../../../../../td[3]//input[contains(@id,'ItemSelectorText')]")
	private WebElement billTypeInputBox;

	@FindBy(xpath="//table[@class='SilverGrid validation-Holder  ']/tbody/tr/td[2]//div[text()='Specialty:']/../../../../../../../../../td[3]//input[contains(@id,'ItemSelectorText')]")
	private WebElement specialtyeInputBox;

	@FindBy(xpath="//table[@class='SilverGrid validation-Holder  ']/tbody/tr/td[2]//div[text()='Patient ID:']/../../../../../../../../../td[3]//input[contains(@id,'SilverTextBox')]")
	private WebElement patientIDInputBox;

	@FindBy(xpath="//table[@class='SilverGrid validation-Holder  ']/tbody/tr/td//input[@value='ICD Procedure Codes:']/../../../../../../../../../td[3]//input[contains(@id,'SilverTextBox')]")
	private WebElement procedureCodeInputBox;

	@FindBy(xpath="//table[@class='SilverGrid validation-Holder  ']/tbody/tr/td[2]//div[text()='Type of Bill:']/../../../../../../../../../td[3]//input[contains(@id,'SilverTextBox')]")
	private WebElement typeOfBillInputBox;

	@FindBy(xpath="//table[@class='SilverGrid validation-Holder  ']/tbody/tr/td[2]//input[@value='Medicare Number:']/../../../../../../../../../td[8]//input")
	private WebElement medicareNoInputBox;

	@FindBy(xpath="//table[@class='SilverGrid validation-Holder  ']/tbody/tr/td[2]//div[text()='Admission Hour:']/../../../../../../../../../td//input[contains(@id,'SilverTextBox')]")
	private WebElement admissionHourInputBox;

	@FindBy(xpath="//table[@class='SilverGrid validation-Holder  ']/tbody/tr/td[2]//div[text()='Admission Type:']/../../../../../../../../../td//input[contains(@id,'ItemSelectorText')]")
	private WebElement admissionTypeInputBox;

	@FindBy(xpath="//table[@class='SilverGrid validation-Holder  ']/tbody/tr/td[2]//div[text()='Admission Source:']/../../../../../../../../../td//input[contains(@id,'ItemSelectorText')]")
	private WebElement admissionSrcInputBox;

	@FindBy(xpath="//table[@class='SilverGrid validation-Holder  ']/tbody/tr/td[2]//div[text()='Discharge Hour:']/../../../../../../../../../td//input[contains(@id,'SilverTextBox')]")
	private WebElement dischargenHourInputBox;

	@FindBy(xpath="//table[@class='SilverGrid validation-Holder  ']/tbody/tr/td[2]//div[text()='Discharge Status:']/../../../../../../../../../td//input[contains(@id,'SilverTextBox')]")
	private WebElement dischargenStatusInputBox;

	@FindBy(xpath="//table[@class='SilverGrid validation-Holder  ']/tbody/tr/td[2]//div[text()='Admitting Diagnosis:']/../../../../../../../../../td//input[contains(@id,'SilverTextBox')]")
	private WebElement admittingDiagnosisInputBox;

	@FindBy(xpath="//table[@class='SilverGrid validation-Holder  ']/tbody/tr/td//input[@value='Principal Proc Codes:']/../../../../../../../../../td[8]//input[contains(@id,'SilverTextBox')]")
	private WebElement principalProcCodesInputBox;

	@FindBy(xpath="//table[@class='SilverGrid validation-Holder  ']/tbody/tr/td[2]//div[text()='Operating Prov NPI:']/../../../../../../../../../td//input[contains(@id,'SilverTextBox')]")
	private WebElement operatingProvNPIInputBox;

	@FindBy(xpath="//table[@class='SilverGrid validation-Holder  ']/tbody/tr/td[2]//div[text()='DRG:']/../../../../../../../../../td//input[contains(@id,'SilverTextBox')]")
	private WebElement DRGInputBox;




	////-----------------------------------------------------------------------------------------------------


	public BillEntryPage(WebDriver driver){
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}

	public void inputTextIntoClient(String client){
		Functions.inputText(driver,clientInputBox, client);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Functions.pressTabKey(clientInputBox);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void inputTextIntoClaim(String claim){
		Functions.inputText(driver, claimInputBox, claim);
	}

	public void inputTextIntoState(String state){
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("value: "+Functions.isEmpty(stateInputBox));
		if(Functions.isEmpty(stateInputBox))
			Functions.inputText(driver,stateInputBox, state);
	}

	public void inputTextIntoPaycode(String paycode){
		Functions.inputText(driver, paycodeInputBox, paycode);
	}


	public boolean isEmptyBillID(){
		return Functions.isEmpty(billIDInputBox);
	}

	public void inputTextIntoBillID(String billid){
		Functions.inputText(driver, billIDInputBox, billid);
	}

	public void inputTextIntoBillTaxID(String billtaxid){
		Functions.inputText(driver,billTaxIDInputBox, billtaxid);
	}

	public WebElement billTaxIDElement(){
		return billTaxIDInputBox;
	}

	public void inputTextIntoBillNPI(String billNPI){
		Functions.inputText(driver, billNPIInputBox, billNPI);
	}

	public void inputTextIntoRenderNPI(String renderNPI){
		Functions.inputText(driver, renderingNPIInputBox, renderNPI);
	}

	public void inputTextIntoLoczip(String loczip){
		Functions.inputText(driver, locationZIPIInputBox, loczip);
	}

	public void inputTextIntoFacilityNPI(String FacilityNPI){
		Functions.inputText(driver,facilityNPIInputBox , FacilityNPI);
	}



	public String getAttributeBillTypeText(){
		return Functions.getAttribute(billTypeInputBox, "value");
	}

	public String getAttributeSpecialtyText(){
		return Functions.getAttribute(specialtyeInputBox, "value");
	}

	public void inputTextDateIntoDOSFrm(String DOSFrm){
		Functions.inputText(driver, dateInputBoxes.get(1), DOSFrm);
	}

	//public void inputTextIntoDOSTO(String DOSTO){    //IF UB-04
	//	Functions.inputText(dateInputBoxes.get(2), DOSTO);
	//}



	public void inputTextIntoPatient(String Patient){
		Functions.inputText(driver, patientIDInputBox, Patient);
	}

	public void inputTextDateIntoBillDate(String BillDate){   //Provider Bill Date
		Functions.inputText(driver, dateInputBoxes.get(3), BillDate);
	}

	public void inputTextIntoProcedureCode(String ProcedureCode){
		Functions.inputText(driver, procedureCodeInputBox, ProcedureCode);
		Functions.pressTabKey(procedureCodeInputBox);
	}

	public void inputTextDateIntoClientRecvdDate(String ClientRecvdDate){
		Functions.inputText(driver, dateInputBoxes.get(4), ClientRecvdDate);
	}

	public void inputTextDateIntoBillRecvdDate(String BillRecvdDate){
		Functions.inputText(driver, dateInputBoxes.get(5), BillRecvdDate);
	}

	//  UB-04 Header fields

	public void inputTextIntoTypeofBill(String TypeofBill){
		Functions.inputText(driver, typeOfBillInputBox, TypeofBill);
	}

	public void inputTextIntoMedicareNO(String MedicareNO){
		Functions.inputText(driver, medicareNoInputBox, MedicareNO);
	}

	public void inputTextDateIntoADmDt(String ADmDt){
		Functions.inputText(driver, dateInputBoxes.get(7), ADmDt);
	}

	public void inputTextDateIntoDschgDt(String DschgDt){
		Functions.inputText(driver, dateInputBoxes.get(8), DschgDt);
	}

	public void inputTextIntoAdmsnHr(String AdmsnHr){
		Functions.inputText(driver, admissionHourInputBox, AdmsnHr);
	}

	public void inputTextIntoAdmissionType(String AdmissionType){
		Functions.inputText(driver, admissionTypeInputBox, AdmissionType);
	}

	public void inputTextIntoAdmissionSrc(String AdmissionSrc){
		Functions.inputText(driver, admissionSrcInputBox, AdmissionSrc);
	}

	public void inputTextIntoDischargeHr(String DischargeHr){
		Functions.inputText(driver, dischargenHourInputBox, DischargeHr);
	}

	public void inputTextIntoDischrgStatus(String DischrgStatus){
		Functions.inputText(driver, dischargenStatusInputBox, DischrgStatus);
	}

	public void inputTextIntoAdmittingDiag(String AdmittingDiag){
		Functions.inputText(driver, admittingDiagnosisInputBox, AdmittingDiag);
	}

	public void inputTextIntoPrinProcCDs(String PrinProcCDs){
		Functions.inputText(driver, principalProcCodesInputBox, PrinProcCDs);
	}

	public void inputTextIntoPrinProcDt(String PrinProcDt){
		Functions.inputText(driver, dateInputBoxes.get(9), PrinProcDt);
	}

	public void inputTextIntoOpProvNPI(String OpProvNPI){
		Functions.inputText(driver, operatingProvNPIInputBox, OpProvNPI);
	}

	public void inputTextIntoDrgcd(String Drgcd){
		Functions.inputText(driver, DRGInputBox, Drgcd);
	}


	//Next buttons	

	public void clickOnNextButton() {
		Functions.clickElement(driver, nextButtonList.get(0));
	}

	public void clickOnNextButtonUB04() {
		Functions.clickElement(driver, nextButtonList.get(nextButtonList.size()-1));
	}



	//Line Items   CMS
	//Line 1

	public void inputTextIntoPOS(String POS, int position){
		//POS 16 31 46 61
		//TOS 2 17 32 47 62
		// Billed Code 9 24 39 54 69 
		//Billed Mod  10 25 40 55 70
		//Reviewed Code 11 26 41 56 71
		//Daig  13 28 43 58 73

		//Numboxes
		//Days 5 16 27 38 49 60
		//Charges  6 17 28 39 50 61 
		//Fee Schedule Discount   7 18 29 40 51 62
		//Allowed  11 22 33 44 55 66

		int locator=Functions.newLocator(2, position, 10);
		Functions.inputText(driver, silverInputBoxes.get(locator), POS);
	}

	public void inputTextIntoTOS(String TOS, int position){
		int locator=Functions.newLocator(3, position, 10);
		Functions.inputText(driver, silverInputBoxes.get(locator), TOS);
	}

	public void inputTextIntoBilledCd(String BilledCd, int position){
		int locator=Functions.newLocator(5, position, 10);
		Functions.inputText(driver, silverInputBoxes.get(locator), BilledCd);
	}

	public void inputTextIntoBilledMd(String BilledMd, int position){
		int locator=Functions.newLocator(6, position, 10);
		Functions.inputText(driver, silverInputBoxes.get(locator), BilledMd);
	}

	public void inputTextIntoReviewCd(String ReviewCd, int position){
		int locator=Functions.newLocator(7, position, 10);
		Functions.inputText(driver, silverInputBoxes.get(locator), ReviewCd);
	}

	public void tabOutFromReviewCd(int position){
		int locator=Functions.newLocator(7, position, 10);
		Functions.tabOut(silverInputBoxes.get(locator));
	}

	public void inputTextIntoReviewMd(String ReviewMd, int position){
		int locator=Functions.newLocator(8, position, 10);
		Functions.inputText(driver, silverInputBoxes.get(locator), ReviewMd);
	}

	public void tabOutFromReviewMd(int position){
		int locator=Functions.newLocator(8, position, 10);
		Functions.tabOut(silverInputBoxes.get(locator));
	}


	public void inputTextIntoCMSDays(String Days, int position){
		int locator=Functions.newLocator(2, position, 9);
		Functions.inputText(driver, numBoxList.get(locator), Days);
	}

	public void inputTextIntoChrgs(String  Chrgs, int position){
		int locator=Functions.newLocator(5, position, 9);
		Functions.inputText(driver, numBoxList.get(locator), Chrgs);
	}

	public void inputTextIntoTotalCharges(String TotalCharges){
		numBoxList.get(0).clear();
		numBoxList.get(0).sendKeys(TotalCharges);
		if(!numBoxList.get(0).getAttribute("value").equals(TotalCharges)){
			numBoxList.get(0).clear();
			numBoxList.get(0).sendKeys(TotalCharges);
		}
		//Functions.inputText(driver, numBoxList.get(0), TotalCharges);
	}

	public void inputTextIntoDiag(String Diag, int position){
		int locator=Functions.newLocator(10, position, 10);
		Functions.inputText(driver, silverInputBoxes.get(locator), Diag);
	}

	public void tabOutFromDiag(int position){
		int locator=Functions.newLocator(10, position, 10);
		Functions.tabOut(silverInputBoxes.get(locator));
	}

	//Line Items   UB-04
	//Line 1

	public void inputTextIntoRevenueCd(String RevenueCd, int position){
		int locator=Functions.newLocator(4, position, 10);
		Functions.inputText(driver, silverInputBoxes.get(locator),RevenueCd);
	}
	//
	//	public void inputTextIntoReviewedCd(String ReviewedCd, int position){   // why do we need this, cant use from CMS line
	//		Functions.inputText(driver, silverInputBoxes.get(7), ReviewedCd);
	//	}
	////	
	//	public void tabOutFromReviewedCd(int position){
	//		int locator=Functions.newLocator(7, position, 10);
	//		Functions.tabOut(silverInputBoxes.get(locator));
	//	}
	//	
	//	//public void inputTextIntoMod(String Mod, int position){       // / why do we need this, cant use from CMS line
	//		int locator=Functions.newLocator(6, position, 10);
	//		Functions.inputText(driver, silverInputBoxes.get(locator), Mod);
	//	}
	//
	public void inputTextIntoUB04Days(String Days, int position){     //***days    
		int locator=Functions.newLocator(2, position, 9);
		Functions.inputText(driver, numBoxList.get(locator), Days);
	}


	//Line Items   RX
	//Line 1

	public void inputTextIntoBillNDCCd(String BillNDCCd, int position){
		int locator=Functions.newLocator(5, position, 10);
		Functions.inputText(driver, silverInputBoxes.get(locator), BillNDCCd);
	}

	public void inputTextIntoRewNDCCd(String RewNDCCd, int position){
		int locator=Functions.newLocator(7, position, 10);
		Functions.inputText(driver, silverInputBoxes.get(locator), RewNDCCd);
	}

	public void inputTextIntoRXNo(String RXNo, int position){
		int locator=Functions.newLocator(9, position, 10);
		Functions.inputText(driver, silverInputBoxes.get(locator), RXNo);
	}

	public void inputTextIntoQuantity(String Quantity, int position){
		int locator=Functions.newLocator(2, position, 9);
		Functions.inputText(driver, numBoxList.get(locator), Quantity);
	}

	public void inputTextIntoDaysupply(String Daysupply, int position){
		int locator=Functions.newLocator(3, position, 9);
		Functions.inputText(driver, numBoxList.get(locator), Daysupply);
	}

	public void inputTextIntoDAW(String DAW, int position){
		int locator=Functions.newLocator(4, position, 9);
		Functions.inputText(driver, numBoxList.get(locator), DAW);
	}


	//end of lines

	public boolean isDisplayedCrossIcon() {
		try {
			Thread.sleep(3000);
			return crossIcon.isDisplayed();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  
		catch (NoSuchElementException e1) {
			return  false;
			}
			return false;
	}

	public boolean isDisplayedWarningIcon() {
		try {
			Thread.sleep(3000);
			return warningIcon.isDisplayed();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		catch (NoSuchElementException e1) {
			return  false;
			}
			return false;
	}


	public void clickOnWarningIcon() {
		Functions.clickElement(driver, warningIcon);
	}

	public void clickOnCrossIcon() {
		Functions.clickElement(driver, crossIcon);
	}

	public boolean isDisplayedCrossIconZip() {
		try {
			Thread.sleep(3000);
			return  zipcrossIcon.isDisplayed();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (NoSuchElementException e1) {
			return  false;
			}
			return false;
		 

	}
	
	public boolean isDisplayedValidIconBillTxnID() {
		try {
			Thread.sleep(3000);
			return tickIconBillingTxID.isDisplayed();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (NoSuchElementException e1) {
			return  false;
			}
			return false;
	}
	
	public boolean isDisplayedValidIconZip() {
		try {
			Thread.sleep(3000);
			return tickIconZip.isDisplayed();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (NoSuchElementException e1) {
			return  false;
			}
			return false;
		 

	}


	public boolean isDisplayedWarningIconZip() {
		try {
			Thread.sleep(3000);
			return zipwarningIcon.isDisplayed();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (NoSuchElementException e1) {
		return  false;
		}
		return false;
	}


	public void clickOnWarningIconZip() {
		Functions.clickElement(driver, zipwarningIcon);
	}

	public void clickOnCrossIconZip() {
		Functions.clickElement(driver, zipcrossIcon);
	}


	public void clickOnFirstRowSelectProvider() {
		Functions.clickElement(driver, firstRowSelectProvider);
	}


	public void clickOnSelectProviderButton() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Functions.clickElement(driver, selectProviderButton);
	}

	public void clickOnSelectServiceLocButton() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Functions.clickElement(driver, selectServiceLocButton);
	}

	public void clickOnBillTaxIdLabel() {
		Functions.clickElement(driver, billTaxIdLabel);
	}

	public void clickOnZipLabel() {
		Functions.clickElement(driver, zipLabel);
	}


	public void clickOnCheckSumButton() {
		Functions.clickElement(driver, checksumButton);
	}

	public void clickOnPriceButton() {
		Functions.clickElement(driver, priceButton);
	}

	public String getTextFromFeeScheduleDis(int position){
		int locator=Functions.newLocator(6, position, 9);
		return Functions.getAttribute(numBoxList.get(locator),"value");
	}

	public void inputTextIntoRXDaysSupply(String Days, int position) {
		int locator=Functions.newLocator(2, position, 9);
		Functions.inputText(driver, numBoxList.get(locator), Days);

	}

	public void clickOnCreateLinks() {
		WebElement firstCreateLink=createLinkButtons.get(0);
		WebElement secondCreateLink=createLinkButtons.get(1);
		if(firstCreateLink.isDisplayed())
		{
			Functions.clickElement(driver, firstCreateLink);
		}
		if(secondCreateLink.isDisplayed())
		{
			Functions.clickElement(driver, secondCreateLink);
		}

	}

	public boolean isDisplayedSelectServiceLocButton() {
		if(selectServiceLocButton.isDisplayed())
			return true;
		else
			return false;
	}

	public void inputTextIntoServiceLocNPI(String npi){
		Functions.inputText(driver, silverInputBoxes.get(40), npi);
	}


	public void clickOnQueryNPIButton() {
		Functions.clickElement(driver, queryNPIButton);
	}
	public void clickOnCreateNewAddressButton() {
		Functions.clickElement(driver, createNewAddressButton);
	}
	public void clickOKButtonForNewAddress() {
		Functions.clickElement(driver, okButtonForNewAddress);
	}

	public String checkWhichIcon(String str) {
		if(str.equals("BillTxnID")){
			if(Functions.isDisplayedMatch(tickIconBillingTxID)){
				return "valid";
			}
			if(Functions.isDisplayedMatch(warningIcon)){
				return "warning";
			}
			if(Functions.isDisplayedMatch(crossIcon)){
				return "cross";
			}
		}
		if(str.equals("Zip")){
			if(Functions.isDisplayedMatch(tickIconZip)){
				return "valid";
			}
			if(Functions.isDisplayedMatch(zipwarningIcon)){
				return "warning";
			}
			if(Functions.isDisplayedMatch(zipcrossIcon)){
				return "cross";
			}
		}
		return "";
	}


	//	public void clickOnNextButton(){
	//		Functions.clickElement(submitButton);
	//	}


}
