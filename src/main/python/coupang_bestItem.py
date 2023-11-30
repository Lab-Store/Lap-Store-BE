from selenium import webdriver
from selenium.webdriver.support.ui import WebDriverWait

#셀레니움 웹 드라이버 생성
driver = webdriver.Chrome()

# Coupang 웹페이지 열기
url = "https://www.coupang.com/np/search?component=178155&q=%EB%A7%A5%EB%B6%81&channel=user"

options = webdriver.ChromeOptions()

driver = webdriver.Chrome()
driver.get(url)

